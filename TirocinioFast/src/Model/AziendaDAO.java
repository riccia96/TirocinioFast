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
		
		String querySQL = "INSERT INTO " + AziendaDAO.TABLE_NAME + " (nome, partitaIva, CEO, sede, email, telefono, username, password, domanda, " + 
				"luogoNascitaCEO, dataNascitaCEO, numeroDipendenti, referente, telefonoReferente, emailReferente, Attivita) " + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, azienda.getNome());
			preparedStatement.setString(2, azienda.getPartitaIva());
			preparedStatement.setString(3, azienda.getCEO());
			preparedStatement.setString(4, azienda.getSede());
			preparedStatement.setString(5, azienda.getEmail());
			preparedStatement.setString(6, azienda.getTelefono());
			preparedStatement.setString(7, azienda.getUsername());
			preparedStatement.setString(8, azienda.getPassword());
			preparedStatement.setString(9, azienda.getDomanda());
			preparedStatement.setString(10, azienda.getLuogoNascitaCEO());
			preparedStatement.setDate(11, azienda.getDataNascitaCEO());
			preparedStatement.setInt(12, azienda.getNumeroDipendenti());
			preparedStatement.setString(13, azienda.getReferente());
			preparedStatement.setString(14, azienda.getTelefonoReferente());
			preparedStatement.setString(15, azienda.getEmailReferente());
			preparedStatement.setString(16, azienda.getAttivita());
			
			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
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
		
		String querySQL = "SELECT * FROM " + AziendaDAO.TABLE_NAME + " WHERE partitaIva = ?";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, azienda.getPartitaIva());
			
			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
				a.setNome(result.getString("nome"));
				a.setPartitaIva(result.getString("partitaIva"));
				a.setCEO(result.getString("CEO"));
				a.setSede(result.getString("sede"));
				a.setEmail(result.getString("email"));
				a.setTelefono(result.getString("telefono"));
				a.setUsername(result.getString("username"));
				a.setPassword(result.getString("password"));
				a.setDomanda(result.getString("domanda"));
				a.setLuogoNascitaCEO(result.getString("luogoNascitaCEO"));
				a.setDataNascitaCEO(result.getDate("dataNascitaCEO"));
				a.setNumeroDipendenti(result.getInt("numeroDipendenti"));
				a.setReferente(result.getString("referente"));
				a.setTelefonoReferente(result.getString("telefonoReferente"));
				a.setEmailReferente(result.getString("emailReferente"));
				a.setAttivita(result.getString("attivita"));
				
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
				a.setCEO(result.getString("CEO"));
				a.setSede(result.getString("sede"));
				a.setEmail(result.getString("email"));
				a.setTelefono(result.getString("telefono"));
				a.setUsername(result.getString("username"));
				a.setPassword(result.getString("password"));
				a.setDomanda(result.getString("domanda"));
				a.setLuogoNascitaCEO(result.getString("luogoNascitaCEO"));
				a.setDataNascitaCEO(result.getDate("dataNascitaCEO"));
				a.setNumeroDipendenti(result.getInt("numeroDipendenti"));
				a.setReferente(result.getString("referente"));
				a.setTelefonoReferente(result.getString("telefonoReferente"));
				a.setEmailReferente(result.getString("emailReferente"));
				a.setAttivita(result.getString("attivita"));
				
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
		
		String querySQL = "UPDATE " + AziendaDAO.TABLE_NAME + " SET nome = ?, partitaIva = ?, CEO = ?, sede = ?, email = ?, telefono = ?, username = ?, password = ?, domanda = ?, " +
				 "luogoNascitaCEO = ?, dataNascitaCEO = ?, numeroDipendenti = ?, referente = ?, telefonoReferente = ?, emailReferente = ?, attivita = ?";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setString(1, azienda.getPartitaIva());

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
		
		String querySQL = "DELETE FROM " + AziendaDAO.TABLE_NAME + " WHERE partitaIva = ?";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setString(1, azienda.getPartitaIva());
			
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
