package model;

import bean.TirocinioBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TirocinioDAO extends AbstractDAO<TirocinioBean>{

  /**
   * Il TABLE_NAME in cui vengono eseguite le query
   */
  private static final String TABLE_NAME = "tirocinio";

  /**
   * Metodo che genera l'id del tirocinio
   * @return rowCount il totale delle righe nella tabella
   * @throws SQLException eccezione che può verificarsi
   */
  public synchronized int generaCodice() throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String sql = "SELECT COUNT(*) AS TOTAL FROM " + TirocinioDAO.TABLE_NAME;
    Connessione con = new Connessione();
    connection = con.getConnection();
    preparedStatement = connection.prepareStatement(sql);
    ResultSet rs = preparedStatement.executeQuery();
    int rowCount = 0;
    try {
      while (rs.next()) {
        rowCount = rs.getInt("total");
      }
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
        if (connection != null) {
          connection.close();
        }
      }
    }

    return rowCount;
  }

  /**
   * Salva il tirocinio nel database
   * @param tirocinio che si vuole salvare
   * @return result risultato della query appena eseguita
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized int doSave(TirocinioBean tirocinio) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    String querySql = "INSERT INTO " + TirocinioDAO.TABLE_NAME
        + " (id, studente, azienda, tutorAccademico, impiegato, "
        + "annoAccademico, cfu, handicap, sedeTirocinio, accessoLocali, periodoTirocinio, "
        + "obiettivoTirocinio, facilitazioni, convalidaAzienda, convalidaTutor, "
        + "convalidaStudente, convalidaRichiesta, convalidaAttivita, registroOre, "
        + "questionarioStudente, questionarioAzienda, url) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setInt(1, generaCodice());
      preparedStatement.setString(2, tirocinio.getStudente());
      preparedStatement.setString(3, tirocinio.getAzienda());
      preparedStatement.setString(4, tirocinio.getTutorAccademico());
      preparedStatement.setString(5, tirocinio.getImpiegato());
      preparedStatement.setString(6, tirocinio.getAnnoAccademico());
      preparedStatement.setInt(7, tirocinio.getCfu());
      preparedStatement.setBoolean(8, tirocinio.isHandicap());
      preparedStatement.setString(9, tirocinio.getSedeTirocinio());
      preparedStatement.setString(10, tirocinio.getAccessoLocali());
      preparedStatement.setString(11, tirocinio.getPeriodoTirocinio());
      preparedStatement.setString(12, tirocinio.getObiettivoTirocinio());
      preparedStatement.setString(13, tirocinio.getFacilitazioni());
      preparedStatement.setBoolean(14, tirocinio.isConvalidaAzienda());
      preparedStatement.setBoolean(15, tirocinio.isConvalidaTutor());
      preparedStatement.setBoolean(16, tirocinio.isConvalidaStudente());
      preparedStatement.setBoolean(17, tirocinio.isConvalidaRichiesta());
      preparedStatement.setBoolean(18, tirocinio.isConvalidaAttivita());
      preparedStatement.setString(19, tirocinio.getRegistroOre());
      preparedStatement.setInt(20, tirocinio.getQuestionarioStudente());
      preparedStatement.setInt(21, tirocinio.getQuestionarioAzienda());
      preparedStatement.setString(22, tirocinio.getUrl());

      preparedStatement.execute();
      result = preparedStatement.getGeneratedKeys();

      if (result.next() && result != null) {
        return result.getInt(1);
      } else {
        return -1;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        result.close();
      } catch (Exception rse) {
        rse.printStackTrace();
      }
      try {
        preparedStatement.close();
      } catch (Exception sse) {
        sse.printStackTrace();
      }
      try {
        connection.close();
      } catch (Exception cse) {
        cse.printStackTrace();
      }
    }

    return -1;
  }

  /**
   * Cerca lo studente nel database in base all'id
   * @param tirocinio che si vuole recuperare
   * @return studente ricercato nel database
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized TirocinioBean doRetrieveByKey(TirocinioBean tirocinio) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    TirocinioBean t = new TirocinioBean();

    String querySql = "SELECT * FROM " + TirocinioDAO.TABLE_NAME + " WHERE id = ?";

    try {
      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setInt(1, tirocinio.getId());

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        t.setId(result.getInt("id"));
        t.setStudente(result.getString("studente"));
        t.setAzienda(result.getString("azienda"));
        t.setTutorAccademico(result.getString("tutorAccademico"));
        t.setImpiegato(result.getString("impiegato"));
        t.setAnnoAccademico(result.getString("annoAccademico"));
        t.setCfu(result.getInt("cfu"));
        t.setHandicap(result.getBoolean("handicap"));
        t.setSedeTirocinio(result.getString("sedeTirocinio"));
        t.setAccessoLocali(result.getString("accessoLocali"));
        t.setPeriodoTirocinio(result.getString("periodoTirocinio"));
        t.setObiettivoTirocinio(result.getString("obiettivoTirocinio"));
        t.setFacilitazioni(result.getString("facilitazioni"));
        t.setConvalidaAzienda(result.getBoolean("convalidaAzienda"));
        t.setConvalidaTutor(result.getBoolean("convalidaTutor"));
        t.setConvalidaStudente(result.getBoolean("convalidaStudente"));
        t.setConvalidaRichiesta(result.getBoolean("convalidaRichiesta"));
        t.setConvalidaAttivita(result.getBoolean("convalidaAttivita"));
        t.setRegistroOre(result.getString("registroOre"));
        t.setQuestionarioStudente(result.getInt("questionarioStudente"));
        t.setQuestionarioAzienda(result.getInt("questionarioAzienda"));
        t.setUrl(result.getString("url"));

      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        preparedStatement.close();
      } catch (Exception sse) {
        sse.printStackTrace();
      }
      try {
        connection.close();
      } catch (Exception cse) {
        cse.printStackTrace();
      }
    }

    return t;
  }

  /**
   * Cerca tutti gli studenti nel database
   * @param order parametro di ordinamento
   * @return ArrayList studenti la lista degli studenti
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized List<TirocinioBean> doRetrieveAll(String order) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();

    String querySql = "SELECT * FROM " + TirocinioDAO.TABLE_NAME; 

    if (order != null && !order.equals("")) {
      querySql += " ORDER BY " + order;
    }

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        TirocinioBean t = new TirocinioBean();

        t.setId(result.getInt("id"));
        t.setStudente(result.getString("studente"));
        t.setAzienda(result.getString("azienda"));
        t.setTutorAccademico(result.getString("tutorAccademico"));
        t.setImpiegato(result.getString("impiegato"));
        t.setAnnoAccademico(result.getString("annoAccademico"));
        t.setCfu(result.getInt("cfu"));
        t.setHandicap(result.getBoolean("handicap"));
        t.setSedeTirocinio(result.getString("sedeTirocinio"));
        t.setAccessoLocali(result.getString("accessoLocali"));
        t.setPeriodoTirocinio(result.getString("periodoTirocinio"));
        t.setObiettivoTirocinio(result.getString("obiettivoTirocinio"));
        t.setFacilitazioni(result.getString("facilitazioni"));
        t.setConvalidaAzienda(result.getBoolean("convalidaAzienda"));
        t.setConvalidaTutor(result.getBoolean("convalidaTutor"));
        t.setConvalidaStudente(result.getBoolean("convalidaStudente"));
        t.setConvalidaRichiesta(result.getBoolean("convalidaRichiesta"));
        t.setConvalidaAttivita(result.getBoolean("convalidaAttivita"));
        t.setRegistroOre(result.getString("registroOre"));
        t.setQuestionarioStudente(result.getInt("questionarioStudente"));
        t.setQuestionarioAzienda(result.getInt("questionarioAzienda"));
        t.setUrl(result.getString("url"));

        tirocini.add(t);

      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        preparedStatement.close();
      } catch (Exception sse) {
        sse.printStackTrace();
      }
      try {
        connection.close();
      } catch (Exception cse) {
        cse.printStackTrace();
      }
    }

    return tirocini;
  }

  /**
   * Aggiorna il tirocinio nel database
   * @param tirocinio da aggiornare con i campi modificati
   * @return true, false valore boolean che descrivono il successo o il fallimento del doUpdate
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doUpdate(TirocinioBean tirocinio) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "UPDATE " + TirocinioDAO.TABLE_NAME 
        + " SET studente = ?, azienda = ?, tutorAccademico = ?, impiegato = ?,"
        + " annoAccademico = ?, cfu = ?, handicap = ?, sedeTirocinio = ?, "
        + "accessoLocali = ?, periodoTirocinio = ?, obiettivoTirocinio = ?, "
        + "facilitazioni = ?, convalidaAzienda = ?, convalidaTutor = ?, "
        + "convalidaStudente = ?, convalidaRichiesta = ?, convalidaAttivita = ?, "
        + "registroOre = ?, questionarioStudente = ?, questionarioAzienda = ?, "
        + "url = ? WHERE id = ? ";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, tirocinio.getStudente());
      preparedStatement.setString(2, tirocinio.getAzienda());
      preparedStatement.setString(3, tirocinio.getTutorAccademico());
      preparedStatement.setString(4, tirocinio.getImpiegato());
      preparedStatement.setString(5, tirocinio.getAnnoAccademico());
      preparedStatement.setInt(6, tirocinio.getCfu());
      preparedStatement.setBoolean(7, tirocinio.isHandicap());
      preparedStatement.setString(8, tirocinio.getSedeTirocinio());
      preparedStatement.setString(9, tirocinio.getAccessoLocali());
      preparedStatement.setString(10, tirocinio.getPeriodoTirocinio());
      preparedStatement.setString(11, tirocinio.getObiettivoTirocinio());
      preparedStatement.setString(12, tirocinio.getFacilitazioni());
      preparedStatement.setBoolean(13, tirocinio.isConvalidaAzienda());
      preparedStatement.setBoolean(14, tirocinio.isConvalidaTutor());
      preparedStatement.setBoolean(15, tirocinio.isConvalidaStudente());
      preparedStatement.setBoolean(16, tirocinio.isConvalidaRichiesta());
      preparedStatement.setBoolean(17, tirocinio.isConvalidaAttivita());
      preparedStatement.setString(18, tirocinio.getRegistroOre());
      preparedStatement.setInt(19, tirocinio.getQuestionarioStudente());
      preparedStatement.setInt(20, tirocinio.getQuestionarioAzienda());
      preparedStatement.setString(21, tirocinio.getUrl());

      preparedStatement.setInt(22, tirocinio.getId());

      preparedStatement.execute();
      return true;

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        preparedStatement.close();
      } catch (Exception sse) {
        sse.printStackTrace();
      }
      try {
        connection.close();
      } catch (Exception cse) {
        cse.printStackTrace();
      }
    }

    return false;
  }

  /**
   * Elimina il tirocinio dal database
   * @param tirocinio da eliminare
   * @return true, false valori boolean che descrivono il successo o il fallimento del doDelete
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public boolean doDelete(TirocinioBean tirocinio) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "DELETE FROM " + TirocinioDAO.TABLE_NAME + " WHERE id = ? ";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setInt(1, tirocinio.getId());

      preparedStatement.execute();

      return true;

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        preparedStatement.close();
      } catch (Exception sse) {
        sse.printStackTrace();
      }
      try {
        connection.close();
      } catch (Exception cse) {
        cse.printStackTrace();
      }
    }

    return false;
  }

}
