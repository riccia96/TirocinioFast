package model;

import bean.StudenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudenteDAO extends AbstractDAO<StudenteBean>{

  /**
   * Il TABLE_NAME in cui vengono eseguite le query
   */
  private static final String TABLE_NAME = "studente";

  /**
   * Salva lo studente nel database
   * @param studente che si vuole salvare
   * @return result risultato della query appena eseguita
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized int doSave(StudenteBean studente) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    String querySql = "INSERT INTO " + StudenteDAO.TABLE_NAME
        + " (nome, cognome, luogoNascita, dataNascita, "
        + "indirizzo, citta, codiceFiscale, matricola, email, telefono, "
        + "username, password, domanda) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, studente.getNome());
      preparedStatement.setString(2, studente.getCognome());
      preparedStatement.setString(3, studente.getLuogoNascita());
      preparedStatement.setString(4, studente.getDataNascita());
      preparedStatement.setString(5, studente.getIndirizzo());
      preparedStatement.setString(6, studente.getCitta());
      preparedStatement.setString(7, studente.getCodiceFiscale());
      preparedStatement.setString(8, studente.getMatricola());
      preparedStatement.setString(9, studente.getEmail());
      preparedStatement.setString(10, studente.getTelefono());
      preparedStatement.setString(11, studente.getUsername());
      preparedStatement.setString(12, studente.getPassword());
      preparedStatement.setString(13, studente.getDomanda());

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
   * Cerca lo studente nel database in base all'username
   * @param studente che si vuole recuperare
   * @return studente ricercata nel database   
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized StudenteBean doRetrieveByKey(StudenteBean studente) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    StudenteBean s = new StudenteBean();

    String querySql = "SELECT * FROM " + StudenteDAO.TABLE_NAME + " WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, studente.getUsername());

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        s.setNome(result.getString("nome"));
        s.setCognome(result.getString("cognome"));
        s.setLuogoNascita(result.getString("luogoNascita"));
        s.setDataNascita(result.getString("dataNascita"));
        s.setIndirizzo(result.getString("indirizzo"));
        s.setCitta(result.getString("citta"));
        s.setCodiceFiscale(result.getString("codiceFiscale"));
        s.setMatricola(result.getString("matricola"));
        s.setEmail(result.getString("email"));
        s.setTelefono(result.getString("telefono"));
        s.setUsername(result.getString("username"));
        s.setPassword(result.getString("password"));
        s.setDomanda(result.getString("domanda"));

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

    return s;

  }

  /**
   * Cerca tutti gli studenti nel database
   * @param order è l'ordine in cui si ragruppano tutti gli studenti
   * @return ArrayList studenti la lista dei studenti contenuti nel database
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized List<StudenteBean> doRetrieveAll(String order) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    List<StudenteBean> studenti = new ArrayList<StudenteBean>();

    String querySql = "SELECT * FROM " + StudenteDAO.TABLE_NAME; 

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

        StudenteBean s = new StudenteBean();

        s.setNome(result.getString("nome"));
        s.setCognome(result.getString("cognome"));
        s.setLuogoNascita(result.getString("luogoNascita"));
        s.setDataNascita(result.getString("dataNascita"));
        s.setIndirizzo(result.getString("indirizzo"));
        s.setCitta(result.getString("citta"));
        s.setCodiceFiscale(result.getString("codiceFiscale"));
        s.setMatricola(result.getString("matricola"));
        s.setEmail(result.getString("email"));
        s.setTelefono(result.getString("telefono"));
        s.setUsername(result.getString("username"));
        s.setPassword(result.getString("password"));
        s.setDomanda(result.getString("domanda"));

        studenti.add(s);

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

    return studenti;
  }

  /**
   * Aggiorna lo studente nel database
   * @param studente da aggiornare con i campi modificati
   * @return true, false valore boolean che descrivono il successo o il fallimento del doUpdate
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doUpdate(StudenteBean studente) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "UPDATE " + StudenteDAO.TABLE_NAME 
        + " SET nome = ?, cognome = ?, luogoNascita = ?, dataNascita = ?,"
        + " indirizzo = ?, citta = ?, telefono = ?, password = ?, domanda = ? WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, studente.getNome());
      preparedStatement.setString(2, studente.getCognome());
      preparedStatement.setString(3, studente.getLuogoNascita());
      preparedStatement.setString(4, studente.getDataNascita());
      preparedStatement.setString(5, studente.getIndirizzo());
      preparedStatement.setString(6, studente.getCitta());
      preparedStatement.setString(7, studente.getTelefono());
      preparedStatement.setString(8, studente.getPassword());
      preparedStatement.setString(9, studente.getDomanda());

      preparedStatement.setString(10, studente.getUsername());

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
   * Elimina lo studente dal database
   * @param studente da eliminare
   * @return true, false valori boolean che descrivono il successo o il fallimento del doDelete
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public boolean doDelete(StudenteBean studente) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "DELETE FROM " + StudenteDAO.TABLE_NAME + " WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, studente.getUsername());

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
