package model;

import bean.QuestionarioAziendaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionarioAziendaDAO extends AbstractDAO<QuestionarioAziendaBean>{

  /**
   * Il TABLE_NAME in cui vengono eseguite le query
   */
  private static final String TABLE_NAME = "questionarioAzienda";

  /**
   * Metodo che genera l'id del questionarioAzienda
   * @return rowCount il totale delle righe nella tabella
   * @throws SQLException eccezione che può verificarsi
   */
  public synchronized int generaCodice() throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String sql = "SELECT COUNT(*) AS TOTAL FROM " + QuestionarioAziendaDAO.TABLE_NAME;
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
   * Salva il questionario azienda nel database
   * @param questionarioAzienda che si vuole salvare
   * @return result risultato della query appena eseguita
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized int doSave(QuestionarioAziendaBean questionarioAzienda) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    String querySql = "INSERT INTO " + QuestionarioAziendaDAO.TABLE_NAME 
        + " (id, studente, azienda, tutorAccademico, impiegato, "
        + "periodoTirocinio, titoloTirocinio, posizioneRicoperta, scelte, convalida, url)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setInt(1, generaCodice());
      preparedStatement.setString(2, questionarioAzienda.getStudente());
      preparedStatement.setString(3, questionarioAzienda.getAzienda());
      preparedStatement.setString(4, questionarioAzienda.getTutorAccademico());
      preparedStatement.setString(5, questionarioAzienda.getImpiegato());
      preparedStatement.setString(6, questionarioAzienda.getPeriodoTirocinio());
      preparedStatement.setString(7, questionarioAzienda.getTitoloTirocinio());
      preparedStatement.setString(8, questionarioAzienda.getPosizioneRicoperta());
      preparedStatement.setString(9, questionarioAzienda.getScelte());
      preparedStatement.setBoolean(10, questionarioAzienda.isConvalida());
      preparedStatement.setString(11, questionarioAzienda.getUrl());

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
   * Cerca il questionario azienda nel database in base all'id
   * @param questionarioAzienda che si vuole recuperare
   * @return questionarioAzienda ricercato nel database
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized QuestionarioAziendaBean doRetrieveByKey(QuestionarioAziendaBean
      questionarioAzienda) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    QuestionarioAziendaBean qa = new QuestionarioAziendaBean();

    String querySql = "SELECT * FROM " + QuestionarioAziendaDAO.TABLE_NAME + " WHERE id = ? ";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setInt(1, questionarioAzienda.getId());

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        qa.setId(result.getInt("id"));
        qa.setStudente(result.getString("studente"));
        qa.setAzienda(result.getString("azienda"));
        qa.setTutorAccademico(result.getString("tutorAccademico"));
        qa.setImpiegato(result.getString("impiegato"));
        qa.setPeriodoTirocinio(result.getString("periodoTirocinio"));
        qa.setTitoloTirocinio(result.getString("titoloTirocinio"));
        qa.setPosizioneRicoperta(result.getString("posizioneRicoperta"));
        qa.setScelte(result.getString("scelte"));
        qa.setConvalida(result.getBoolean("convalida"));
        qa.setUrl(result.getString("url"));

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

    return qa;
  }

  /**
   * Cerca tutti questionari nel database
   * @param order è l'ordine in cui si ragruppano tutti i questionari
   * @return ArrayList questionariAzienda la lista dei questionari contenuti nel database
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized List<QuestionarioAziendaBean> doRetrieveAll(String order)
      throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    List<QuestionarioAziendaBean> questionariAzienda = new ArrayList<QuestionarioAziendaBean>();

    String querySql = "SELECT * FROM " + QuestionarioAziendaDAO.TABLE_NAME;

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

        QuestionarioAziendaBean qa = new QuestionarioAziendaBean();

        qa.setId(result.getInt("id"));
        qa.setStudente(result.getString("studente"));
        qa.setAzienda(result.getString("azienda"));
        qa.setTutorAccademico(result.getString("tutorAccademico"));
        qa.setImpiegato(result.getString("impiegato"));
        qa.setPeriodoTirocinio(result.getString("periodoTirocinio"));
        qa.setTitoloTirocinio(result.getString("titoloTirocinio"));
        qa.setPosizioneRicoperta(result.getString("posizioneRicoperta"));
        qa.setScelte(result.getString("scelte"));
        qa.setConvalida(result.getBoolean("convalida"));
        qa.setUrl(result.getString("url"));

        questionariAzienda.add(qa);
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

    return questionariAzienda;
  }

  /**
   * Aggiorna il questionario nel database
   * @param questionarioAzienda da aggiornare con i campi modificati
   * @return true, false valore boolean che descrivono il successo o il fallimento del doUpdate
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doUpdate(QuestionarioAziendaBean questionarioAzienda)
        throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "UPDATE " + QuestionarioAziendaDAO.TABLE_NAME 
        + " SET studente = ?, azienda = ?, tutorAccademico = ?,"
        + " impiegato = ?, periodoTirocinio = ?, titoloTirocinio = ?, posizioneRicoperta = ?, "
        + "scelte = ?, convalida = ?, url = ? WHERE id = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, questionarioAzienda.getStudente());
      preparedStatement.setString(2, questionarioAzienda.getAzienda());
      preparedStatement.setString(3, questionarioAzienda.getTutorAccademico());
      preparedStatement.setString(4, questionarioAzienda.getImpiegato());
      preparedStatement.setString(5, questionarioAzienda.getPeriodoTirocinio());
      preparedStatement.setString(6, questionarioAzienda.getTitoloTirocinio());
      preparedStatement.setString(7, questionarioAzienda.getPosizioneRicoperta());
      preparedStatement.setString(8, questionarioAzienda.getScelte());
      preparedStatement.setBoolean(9, questionarioAzienda.isConvalida());
      preparedStatement.setString(10, questionarioAzienda.getUrl());

      preparedStatement.setInt(11, questionarioAzienda.getId());

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
   * Elimina il questionario dal database
   * @param questionarioAzienda da eliminare
   * @return true, false valori boolean che descrivono il successo o il fallimento del doDelete
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doDelete(QuestionarioAziendaBean questionarioAzienda)
        throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "DELETE FROM " + QuestionarioAziendaDAO.TABLE_NAME + " WHERE id = ? ";

    try {
      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setInt(1, questionarioAzienda.getId());

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
