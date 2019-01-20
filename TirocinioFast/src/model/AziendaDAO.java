package model;

import bean.AziendaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AziendaDAO extends AbstractDAO <AziendaBean> {

  /**
   * Il TABLE_NAME in cui vengono eseguite le query
   */
  private static final String TABLE_NAME = "azienda";

  /**
   * Salva l'azienda nel database
   * @param azienda che si vuole salvare
   * @return result risultato della query appena eseguita
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized int doSave(AziendaBean azienda) throws SQLException {
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;

    String querySql = "INSERT INTO " + AziendaDAO.TABLE_NAME 
        + " (nome, partitaIva, ceo, indirizzo, email, telefono, "
        + "username, password, domanda, descrizione, logo) " 
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, azienda.getNome());
      preparedStatement.setString(2, azienda.getPartitaIva());
      preparedStatement.setString(3, azienda.getCeo());
      preparedStatement.setString(4, azienda.getIndirizzo());
      preparedStatement.setString(5, azienda.getEmail());
      preparedStatement.setString(6, azienda.getTelefono());
      preparedStatement.setString(7, azienda.getUsername());
      preparedStatement.setString(8, azienda.getPassword());
      preparedStatement.setString(9, azienda.getDomanda());
      preparedStatement.setString(10, azienda.getDescrizione());
      preparedStatement.setString(11, azienda.getLogo());

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
   * Cerca l'azienda nel database in base all'username
   * @param azienda che si vuole recuperare
   * @return azienda ricercata nel database   
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized AziendaBean doRetrieveByKey(AziendaBean azienda) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    AziendaBean a = new AziendaBean();

    String querySql = "SELECT * FROM " + AziendaDAO.TABLE_NAME + " WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, azienda.getUsername());

      preparedStatement.execute();
      result = preparedStatement.getResultSet();

      while (result.next()) {

        a.setNome(result.getString("nome"));
        a.setPartitaIva(result.getString("partitaIva"));
        a.setCeo(result.getString("ceo"));
        a.setIndirizzo(result.getString("indirizzo"));
        a.setEmail(result.getString("email"));
        a.setTelefono(result.getString("telefono"));
        a.setUsername(result.getString("username"));
        a.setPassword(result.getString("password"));
        a.setDomanda(result.getString("domanda"));
        a.setDescrizione(result.getString("descrizione"));
        a.setLogo(result.getString("logo"));

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

    return a;
  }

  /**
   * Cerca tutte le aziende nel database
   * @param order parametro di ordinamento
   * @return ArrayList aziende la lista delle delle aziende
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized List<AziendaBean> doRetrieveAll(String order) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet result = null;
    List<AziendaBean> aziende = new ArrayList<AziendaBean>();

    String querySql = "SELECT * FROM " + AziendaDAO.TABLE_NAME;

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

        AziendaBean a = new AziendaBean();

        a.setNome(result.getString("nome"));
        a.setPartitaIva(result.getString("partitaIva"));
        a.setCeo(result.getString("ceo"));
        a.setIndirizzo(result.getString("indirizzo"));
        a.setEmail(result.getString("email"));
        a.setTelefono(result.getString("telefono"));
        a.setUsername(result.getString("username"));
        a.setPassword(result.getString("password"));
        a.setDomanda(result.getString("domanda"));
        a.setDescrizione(result.getString("descrizione"));
        a.setLogo(result.getString("logo"));

        aziende.add(a);
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

    return aziende;
  }

  /**
   * Aggiorna l'azienda nel database
   * @param azienda da aggiornare con i campi modificati
   * @return true, false valore boolean che descrivono il successo o il fallimento del doUpdate
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doUpdate(AziendaBean azienda) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "UPDATE " + AziendaDAO.TABLE_NAME + " SET CEO = ?, indirizzo = ?, email = ?, "
        + "telefono = ?, password = ?, domanda = ?, descrizione = ?, logo = ? WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, azienda.getCeo());
      preparedStatement.setString(2, azienda.getIndirizzo());
      preparedStatement.setString(3, azienda.getEmail());
      preparedStatement.setString(4, azienda.getTelefono());
      preparedStatement.setString(5, azienda.getPassword());
      preparedStatement.setString(6, azienda.getDomanda());
      preparedStatement.setString(7, azienda.getDescrizione());
      preparedStatement.setString(8, azienda.getLogo());

      preparedStatement.setString(9, azienda.getUsername());

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
   * Elimina l'azienda dal database
   * @param azienda da eliminare
   * @return true, false valori boolean che descrivono il successo o il fallimento del doDelete
   * @throws SQLException eccezione che può verificarsi
   */
  @Override
  public synchronized boolean doDelete(AziendaBean azienda) throws SQLException {

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    String querySql = "DELETE FROM " + AziendaDAO.TABLE_NAME + " WHERE username = ?";

    try {

      Connessione con = new Connessione();
      connection = con.getConnection();
      preparedStatement = connection.prepareStatement(querySql);

      preparedStatement.setString(1, azienda.getUsername());

      preparedStatement.execute();

      return true;
    } catch  (SQLException e) {
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
