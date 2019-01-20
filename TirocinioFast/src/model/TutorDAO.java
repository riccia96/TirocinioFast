package model;

import bean.TutorBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TutorDAO extends AbstractDAO <TutorBean> {

  /**
   * Il TABLE_NAME in cui vengono eseguite le query
   */
  private static final String TABLE_NAME = "tutor";

  /**
   * Salva il tutor nel database
   * @param tutor che si vuole salvare
   * @return result risultato della query appena eseguita
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized int doSave(TutorBean tutor) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    String querySql = "INSERT INTO " + TutorDAO.TABLE_NAME 
        + " (nome, cognome, matricola, email, username, password, domanda)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, tutor.getNome());
      preparedStatement.setString(2, tutor.getCognome());
      preparedStatement.setString(3, tutor.getMatricola());
      preparedStatement.setString(4, tutor.getEmail());
      preparedStatement.setString(5, tutor.getUsername());
      preparedStatement.setString(6, tutor.getPassword());
      preparedStatement.setString(7, tutor.getDomanda());

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
   * Cerca il tutor nel database in base all'username
   * @param tutor che si vuole recuperare
   * @return tutor ricercata nel database   
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized TutorBean doRetrieveByKey(TutorBean tutor) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    TutorBean t = new TutorBean();

    String querySql = "SELECT * FROM " + TutorDAO.TABLE_NAME + " WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, tutor.getUsername());

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        t.setNome(result.getString("nome"));
        t.setCognome(result.getString("cognome"));
        t.setMatricola(result.getString("matricola"));
        t.setEmail(result.getString("email"));
        t.setUsername(result.getString("username"));
        t.setPassword(result.getString("password"));
        t.setDomanda(result.getString("domanda"));

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
   * Cerca tutti i tutor nel database
   * @param order parametro di ordinamento
   * @return ArrayList tutor la lista dei tutor
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized List<TutorBean> doRetrieveAll(String order) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    List<TutorBean> tutor = new ArrayList<TutorBean>();

    String querySql = "SELECT * FROM " + TutorDAO.TABLE_NAME;

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

        TutorBean t = new TutorBean();

        t.setNome(result.getString("nome"));
        t.setCognome(result.getString("cognome"));
        t.setMatricola(result.getString("matricola"));
        t.setEmail(result.getString("email"));
        t.setUsername(result.getString("username"));
        t.setPassword(result.getString("password"));
        t.setDomanda(result.getString("domanda"));

        tutor.add(t);
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

    return tutor;
  }

  /**
   * Aggiorna il tutor nel database
   * @param tutor da aggiornare con i campi modificati
   * @return true, false valore boolean che descrivono il successo o il fallimento del doUpdate
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doUpdate(TutorBean tutor) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "UPDATE " + TutorDAO.TABLE_NAME 
        + " SET nome = ?, cognome = ?, matricola = ?, email = ?, username = ?, password = ?, "
        + "domanda = ? WHERE  username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, tutor.getNome());
      preparedStatement.setString(2, tutor.getCognome());
      preparedStatement.setString(3, tutor.getMatricola());
      preparedStatement.setString(4, tutor.getEmail());
      preparedStatement.setString(5, tutor.getUsername());
      preparedStatement.setString(6, tutor.getPassword());
      preparedStatement.setString(7, tutor.getDomanda());

      preparedStatement.setString(8, tutor.getUsername());

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
   * Elimina il tutor dal database
   * @param tutor da eliminare
   * @return true, false valori boolean che descrivono il successo o il fallimento del doDelete
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doDelete(TutorBean tutor) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "DELETE FROM " + TutorDAO.TABLE_NAME + " WHERE username = ?";

    try {
      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, tutor.getUsername());

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
