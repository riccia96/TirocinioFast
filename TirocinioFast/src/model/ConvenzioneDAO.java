package model;

import bean.ConvenzioneBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConvenzioneDAO extends AbstractDAO <ConvenzioneBean> {

  /**
   * Il TABLE_NAME in cui vengono eseguite le query
   */
  private static final String TABLE_NAME = "convenzione";

  /**
   * Metodo che genera l'id della convenzione
   * @return rowCount il totale delle righe nella tabella
   * @throws SQLException eccezione che può verificarsi
   */
  public synchronized int generaCodice() throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String sql = "SELECT COUNT(*) AS TOTAL FROM " + ConvenzioneDAO.TABLE_NAME;
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
   * Salva la convenzione nel database
   * @param convenzione che si vuole salvare
   * @return result risultato della query appena eseguita
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized int doSave(ConvenzioneBean convenzione) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    String querySql = "INSERT INTO " + ConvenzioneDAO.TABLE_NAME 
        + " (id, azienda, tutorAccademico, impiegato,"
        + " luogoNascitaCeo, dataNascitaCeo, numeroDipendenti, referente, telefonoReferente,"
        + " emailReferente, attivita, convalida, url)" 
        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setInt(1, convenzione.getId());
      preparedStatement.setString(2, convenzione.getAzienda());
      preparedStatement.setString(3, convenzione.getTutorAccademico());
      preparedStatement.setString(4, convenzione.getImpiegato());
      preparedStatement.setString(5, convenzione.getLuogoNascitaCeo());
      preparedStatement.setString(6, convenzione.getDataNascitaCeo());
      preparedStatement.setInt(7, convenzione.getNumeroDipendenti());
      preparedStatement.setString(8, convenzione.getReferente());
      preparedStatement.setString(9, convenzione.getTelefonoReferente());
      preparedStatement.setString(10, convenzione.getEmailReferente());
      preparedStatement.setString(11, convenzione.getAttivita());
      preparedStatement.setBoolean(12, convenzione.isConvalida());
      preparedStatement.setString(13, convenzione.getUrl());

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
   * Cerca la convenzione nel database in base all'id
   * @param convenzione che si vuole recuperare
   * @return convenzione trovata nel database
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized ConvenzioneBean doRetrieveByKey(ConvenzioneBean convenzione) 
      throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    ConvenzioneBean c = new ConvenzioneBean();

    String querySql = "SELECT * FROM " + ConvenzioneDAO.TABLE_NAME + " WHERE id = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setInt(1, convenzione.getId());

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        c.setId(result.getInt("id"));
        c.setAzienda(result.getString("azienda"));
        c.setTutorAccademico(result.getString("tutorAccademico"));
        c.setImpiegato(result.getString("impiegato"));
        c.setLuogoNascitaCeo(result.getString("luogoNascitaCEO"));
        c.setDataNascitaCeo(result.getString("dataNascitaCEO"));
        c.setNumeroDipendenti(result.getInt("numeroDipendenti"));
        c.setReferente(result.getString("referente"));
        c.setTelefonoReferente(result.getString("telefonoReferente"));
        c.setEmailReferente(result.getString("emailReferente"));
        c.setAttivita(result.getString("attivita"));
        c.setConvalida(result.getBoolean("convalida"));
        c.setUrl(result.getString("url"));

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

    return c;    
  }

  /**
   * Cerca tutte le convenzioni nel database
   * @param order parametro di ordinamento
   * @return ArrayList convenzioni la lista delle convenzioni
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized List<ConvenzioneBean> doRetrieveAll(String order) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    List<ConvenzioneBean> convenzioni = new ArrayList<ConvenzioneBean>();

    String querySql = "SELECT * FROM " + ConvenzioneDAO.TABLE_NAME;

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

        ConvenzioneBean c = new ConvenzioneBean();

        c.setId(result.getInt("id"));
        c.setAzienda(result.getString("azienda"));
        c.setTutorAccademico(result.getString("tutorAccademico"));
        c.setImpiegato(result.getString("impiegato"));
        c.setLuogoNascitaCeo(result.getString("luogoNascitaCEO"));
        c.setDataNascitaCeo(result.getString("dataNascitaCEO"));
        c.setNumeroDipendenti(result.getInt("numeroDipendenti"));
        c.setReferente(result.getString("referente"));
        c.setTelefonoReferente(result.getString("telefonoReferente"));
        c.setEmailReferente(result.getString("emailReferente"));
        c.setAttivita(result.getString("attivita"));
        c.setConvalida(result.getBoolean("convalida"));
        c.setUrl(result.getString("url"));

        convenzioni.add(c);
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

    return convenzioni;
  }

  /**
   * Aggiorna la convenzione nel database
   * @param convenzione da aggiornare con i campi modificati
   * @return true, false valore boolean che descrivono il successo o il fallimento del doUpdate
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doUpdate(ConvenzioneBean convenzione) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "UPDATE " + ConvenzioneDAO.TABLE_NAME 
        + " SET tutorAccademico = ?, impiegato = ?,"
        + " luogoNascitaCeo = ?, dataNascitaCeo = ?, numeroDipendenti = ?, referente = ?,"
        + " telefonoReferente = ?, emailReferente = ?, attivita = ?,"
        + " convalida = ?, url = ? WHERE id = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, convenzione.getTutorAccademico());
      preparedStatement.setString(2, convenzione.getImpiegato());
      preparedStatement.setString(3, convenzione.getLuogoNascitaCeo());
      preparedStatement.setString(4, convenzione.getDataNascitaCeo());
      preparedStatement.setInt(5, convenzione.getNumeroDipendenti());
      preparedStatement.setString(6, convenzione.getReferente());
      preparedStatement.setString(7, convenzione.getTelefonoReferente());
      preparedStatement.setString(8, convenzione.getEmailReferente());
      preparedStatement.setString(9, convenzione.getAttivita());
      preparedStatement.setBoolean(10, convenzione.isConvalida());
      preparedStatement.setString(11, convenzione.getUrl());

      preparedStatement.setInt(12, convenzione.getId());

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
   * Elimina la convenzione dal database
   * @param convenzione da eliminare
   * @return true, false valori boolean che descrivono il successo o il fallimento del doDelete
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doDelete(ConvenzioneBean convenzione) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "DELETE FROM " + ConvenzioneDAO.TABLE_NAME + " WHERE id = ?";

    try {
      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setInt(1, convenzione.getId());

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
