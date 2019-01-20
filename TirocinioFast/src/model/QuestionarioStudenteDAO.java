package model;

import bean.QuestionarioStudenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionarioStudenteDAO extends AbstractDAO<QuestionarioStudenteBean>{

  /**
   * Il TABLE_NAME in cui vengono eseguite le query
   */
  private static final String TABLE_NAME = "questionarioStudente";

  /**
   * Metodo che genera l'id del questionarioStudente
   * @return rowCount il totale delle righe nella tabella
   * @throws SQLException eccezione che può verificarsi
   */
  public synchronized int generaCodice() throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String sql = "SELECT COUNT(*) AS TOTAL FROM " + QuestionarioStudenteDAO.TABLE_NAME;
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
   * Salva il questionarioStudente nel database
   * @param questionarioStudente che si vuole salvare
   * @return result risultato della query appena eseguita
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized int doSave(QuestionarioStudenteBean questionarioStudente) 
        throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    String querySql = "INSERT INTO " + QuestionarioStudenteDAO.TABLE_NAME 
        + " (id, studente, azienda, tutorAccademico, impiegato, periodoTirocinio, "
        + "titoloTirocinio, scelte, convalida, url)" 
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setInt(1, generaCodice());
      preparedStatement.setString(2, questionarioStudente.getStudente());
      preparedStatement.setString(3, questionarioStudente.getAzienda());
      preparedStatement.setString(4, questionarioStudente.getTutorAccademico());
      preparedStatement.setString(5, questionarioStudente.getImpiegato());
      preparedStatement.setString(6, questionarioStudente.getPeriodo());
      preparedStatement.setString(7, questionarioStudente.getTitolo());
      preparedStatement.setString(8, questionarioStudente.getScelte());
      preparedStatement.setBoolean(9, questionarioStudente.isConvalida());
      preparedStatement.setString(10, questionarioStudente.getUrl());

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
   * Cerca il questionario nel database in base all'id
   * @param questionarioStudente che si vuole recuperare
   * @return questionarioStudente ricercato nel database
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized QuestionarioStudenteBean doRetrieveByKey(QuestionarioStudenteBean 
        questionarioStudente) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    QuestionarioStudenteBean qs = new QuestionarioStudenteBean();

    String querySql = "SELECT * FROM " + QuestionarioStudenteDAO.TABLE_NAME + " WHERE id = ? ";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setInt(1, questionarioStudente.getId());

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        qs.setId(result.getInt("id"));
        qs.setStudente(result.getString("studente"));
        qs.setAzienda(result.getString("azienda"));
        qs.setTutorAccademico(result.getString("tutorAccademico"));
        qs.setImpiegato(result.getString("impiegato"));
        qs.setPeriodo(result.getString("periodoTirocinio"));
        qs.setTitolo(result.getString("titoloTirocinio"));
        qs.setScelte(result.getString("scelte"));
        qs.setConvalida(result.getBoolean("convalida"));
        qs.setUrl(result.getString("url"));

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

    return qs;
  }

  /**
   * Cerca tutti questionari nel database
   * @param order è l'ordine in cui si ragruppano tutti i questionari
   * @return ArrayList questionariStudente la lista dei questionari contenute nel database
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized List<QuestionarioStudenteBean> doRetrieveAll(String order)
        throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    List<QuestionarioStudenteBean> questionariStudente = new ArrayList<QuestionarioStudenteBean>();

    String querySql = "SELECT * FROM " + QuestionarioStudenteDAO.TABLE_NAME;

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

        QuestionarioStudenteBean qs = new QuestionarioStudenteBean();

        qs.setId(result.getInt("id"));
        qs.setStudente(result.getString("studente"));
        qs.setAzienda(result.getString("azienda"));
        qs.setTutorAccademico(result.getString("tutorAccademico"));
        qs.setImpiegato(result.getString("impiegato"));
        qs.setPeriodo(result.getString("periodoTirocinio"));
        qs.setTitolo(result.getString("titoloTirocinio"));
        qs.setScelte(result.getString("scelte"));
        qs.setConvalida(result.getBoolean("convalida"));
        qs.setUrl(result.getString("url"));

        questionariStudente.add(qs);
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

    return questionariStudente;
  }

  /**
   * Aggiorna i questionari nel database
   * @param questionarioStudente da aggiornare con i campi modificati
   * @return true, false valore boolean che descrivono il successo o il fallimento del doUpdate
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doUpdate(QuestionarioStudenteBean questionarioStudente)
        throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "UPDATE " + QuestionarioStudenteDAO.TABLE_NAME 
        + " SET studente = ?, azienda = ?, tutorAccademico = ?,"
        + " impiegato = ?, periodoTirocinio = ?, titoloTirocinio = ?, "
        + "scelte = ?, convalida = ?, url = ? WHERE id = ? ";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, questionarioStudente.getStudente());
      preparedStatement.setString(2, questionarioStudente.getAzienda());
      preparedStatement.setString(3, questionarioStudente.getTutorAccademico());
      preparedStatement.setString(4, questionarioStudente.getImpiegato());
      preparedStatement.setString(5, questionarioStudente.getPeriodo());
      preparedStatement.setString(6, questionarioStudente.getTitolo());
      preparedStatement.setString(7, questionarioStudente.getScelte());
      preparedStatement.setBoolean(8, questionarioStudente.isConvalida());
      preparedStatement.setString(9, questionarioStudente.getUrl());

      preparedStatement.setInt(10, questionarioStudente.getId());

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
   * @param questionarioStudente da eliminare
   * @return true, false valori boolean che descrivono il successo o il fallimento del doDelete
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doDelete(QuestionarioStudenteBean questionarioStudente)
        throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "DELETE FROM " + QuestionarioStudenteDAO.TABLE_NAME + " WHERE id = ? ";

    try {
      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setInt(1, questionarioStudente.getId());

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
