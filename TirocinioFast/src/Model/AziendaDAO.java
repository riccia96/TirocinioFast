package Model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import Bean.AziendaBean;

public class AziendaDAO extends AbstractDAO<AziendaBean>{
	
	private static DataSource ds;
	
	static{
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			ds = (DataSource) envCtx.lookup("jdbc/TirocinioFast");
		}catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	private static final String TABLE_NAME = "azienda";
	
	@Override
	public synchronized int doSave(AziendaBean azienda) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		String querySQL = "INSERT INTO " + AziendaDAO.TABLE_NAME + " (nome, partitaIva, ceo, indirizzo, email, telefono, username, password, domanda, descrizione, logo) " + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
			
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
			
			if(result.next() && result != null){
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

	@Override
	public synchronized AziendaBean doRetrieveByKey(AziendaBean azienda) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		AziendaBean a = new AziendaBean();
		
		String querySQL = "SELECT * FROM " + AziendaDAO.TABLE_NAME + " WHERE username = ?";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, azienda.getUsername());
			
			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
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

	@Override
	public synchronized List<AziendaBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<AziendaBean> aziende = new ArrayList<AziendaBean>();
		AziendaBean a = new AziendaBean();
		
		String querySQL = "SELECT * FROM " + AziendaDAO.TABLE_NAME;
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

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

	@Override
	public synchronized boolean doUpdate(AziendaBean azienda) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "UPDATE " + AziendaDAO.TABLE_NAME + " SET CEO = ?, sede = ?, email = ?, "
				+ "telefono = ?, username = ?, password = ?, domanda = ?, descrizione = ?, logo = ? WHERE username = ?";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, azienda.getCeo());
			preparedStatement.setString(2, azienda.getIndirizzo());
			preparedStatement.setString(3, azienda.getEmail());
			preparedStatement.setString(4, azienda.getTelefono());
			preparedStatement.setString(6, azienda.getPassword());
			preparedStatement.setString(7, azienda.getDomanda());
			preparedStatement.setString(8, azienda.getDescrizione());
			preparedStatement.setString(9, azienda.getLogo());
			
			preparedStatement.setString(10, azienda.getUsername());

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

	@Override
	public synchronized boolean doDelete(AziendaBean azienda) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "DELETE FROM " + AziendaDAO.TABLE_NAME + " WHERE username = ?";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

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
