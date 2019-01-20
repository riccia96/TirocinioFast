package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connessione {
  
  private Connection connessione;
  
  /**
   * Esecuzione della connessione al database
   * @throws SQLException eccezzione che può verificarsi
   */
  public Connessione() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/tirociniofast?serverTimezone = EST5EDT";
    String utente = "root";
    String password = "root.123";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    
    connessione = DriverManager.getConnection(url, utente, password);
  }
  
  /**
   * Metodo che recupera la connessione al database
   * @return connessione ritorna una variabile Connection
   */
  public Connection getConnection() {
    return connessione;
  }
}
