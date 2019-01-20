package model;

import bean.ImpiegatoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImpiegatoDAO extends AbstractDAO<ImpiegatoBean>{

  /**
   * Il TABLE_NAME in cui vengono eseguite le query
   */
  private static final String TABLE_NAME = "impiegato";

  /**
   * Salva l'impiegato nel database
   * @param impiegato che si vuole salvare
   * @return result risultato della query appena eseguita
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized int doSave(ImpiegatoBean impiegato) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    String querySql = "INSERT INTO " + ImpiegatoDAO.TABLE_NAME 
        + " (nome, cognome, matricola, email, username, password, domanda)" 
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, impiegato.getNome());
      preparedStatement.setString(2, impiegato.getCognome());
      preparedStatement.setString(3, impiegato.getMatricola());
      preparedStatement.setString(4, impiegato.getEmail());
      preparedStatement.setString(5, impiegato.getUsername());
      preparedStatement.setString(6, impiegato.getPassword());
      preparedStatement.setString(7, impiegato.getDomanda());

      preparedStatement.execute();
      result = preparedStatement.getGeneratedKeys();

      if (result.next() && result != null) {
        return result.getInt(1);
      } else{
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
   * Cerca l'impiegato nel database in base all'username
   * @param impiegato che si vuole recuperare
   * @return impiegato ricercato nel database   
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized ImpiegatoBean doRetrieveByKey(ImpiegatoBean impiegato) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    ImpiegatoBean i = new ImpiegatoBean();

    String querySql = "SELECT * FROM " + ImpiegatoDAO.TABLE_NAME + " WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, impiegato.getUsername());

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        i.setNome(result.getString("nome"));
        i.setCognome(result.getString("cognome"));
        i.setMatricola(result.getString("matricola"));
        i.setEmail(result.getString("email"));
        i.setUsername(result.getString("username"));
        i.setPassword(result.getString("password"));
        i.setDomanda(result.getString("domanda"));

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

    return i;
  }

  /**
   * Cerca tutti gli impiegati nel database
   * @param order è l'ordine in cui si ragruppano tutti gli impiegati
   * @return ArrayList impiegati la lista degli impiegati contenuti nel database
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized List<ImpiegatoBean> doRetrieveAll(String order) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    List<ImpiegatoBean> impiegati = new ArrayList<ImpiegatoBean>();

    String querySql = "SELECT * FROM " + ImpiegatoDAO.TABLE_NAME;

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

        ImpiegatoBean i = new ImpiegatoBean();

        i.setNome(result.getString("nome"));
        i.setCognome(result.getString("cognome"));
        i.setMatricola(result.getString("matricola"));
        i.setEmail(result.getString("email"));
        i.setUsername(result.getString("username"));
        i.setPassword(result.getString("password"));
        i.setDomanda(result.getString("domanda"));

        impiegati.add(i);
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

    return impiegati;
  }

  /**
   * Aggiorna l'impiegato nel database
   * @param impiegato da aggiornare con i campi modificati
   * @return true, false valore boolean che descrivono il successo o il fallimento del doUpdate
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doUpdate(ImpiegatoBean impiegato) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "UPDATE " + ImpiegatoDAO.TABLE_NAME 
        + " SET nome = ?, cognome = ?, matricola = ?, email = ?, username = ?,"
        + " password = ?, domanda = ? WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, impiegato.getNome());
      preparedStatement.setString(2, impiegato.getCognome());
      preparedStatement.setString(3, impiegato.getMatricola());
      preparedStatement.setString(4, impiegato.getEmail());
      preparedStatement.setString(5, impiegato.getUsername());
      preparedStatement.setString(6, impiegato.getPassword());
      preparedStatement.setString(7, impiegato.getDomanda());

      preparedStatement.setString(8, impiegato.getUsername());

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
   * Elimina l'impiegato dal database
   * @param impiegato da eliminare
   * @return true, false valori boolean che descrivono il successo o il fallimento del doDelete
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doDelete(ImpiegatoBean impiegato) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "DELETE FROM " + ImpiegatoDAO.TABLE_NAME + " WHERE username = ?";

    try {
      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, impiegato.getUsername());

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
