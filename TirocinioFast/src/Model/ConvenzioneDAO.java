package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.ConvenzioneBean;

public class ConvenzioneDAO extends AbstractDAO<ConvenzioneBean>{
	
private static DataSource ds;
	
	static {
		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/TirocinioFast");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	private static final String TABLE_NAME = "convenzione";

	@Override
	public synchronized int doSave(ConvenzioneBean convenzione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		String querySQL = "INSERT INTO " + ConvenzioneDAO.TABLE_NAME + " (azienda, tutorAccademico, impiegato,"
				+ " luogoNascitaCeo, dataNascitaCeo, numeroDipendenti, referente, telefonoReferente, emailReferente,"
				+ " convalida, url)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, convenzione.getAzienda());
			preparedStatement.setString(2, convenzione.getTutorAccademico());
			preparedStatement.setString(3, convenzione.getImpiegato());
			preparedStatement.setString(4, convenzione.getLuogoNascitaCeo());
			preparedStatement.setString(5, convenzione.getDataNascitaCeo());
			preparedStatement.setInt(6, convenzione.getNumeroDipendenti());
			preparedStatement.setString(7, convenzione.getReferente());
			preparedStatement.setString(8, convenzione.getTelefonoReferente());
			preparedStatement.setString(9, convenzione.getEmailReferente());
			preparedStatement.setString(10, convenzione.getAttivita());
			preparedStatement.setBoolean(11, convenzione.isConvalida());
			preparedStatement.setString(12, convenzione.getUrl());
			
			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			if(result.next() && result != null){
				return result.getInt(1);
			}else{
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
	public synchronized ConvenzioneBean doRetrieveByKey(ConvenzioneBean convenzione) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		ConvenzioneBean c = new ConvenzioneBean();
		
		String querySQL = "SELECT * FROM " + ConvenzioneDAO.TABLE_NAME + " WHERE azienda = ?";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setString(1, convenzione.getAzienda());

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
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

	@Override
	public synchronized List<ConvenzioneBean> doRetrieveAll() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<ConvenzioneBean> convenzioni = new ArrayList<ConvenzioneBean>();
		ConvenzioneBean c = new ConvenzioneBean();
		
		String querySQL = "SELECT * FROM " + ConvenzioneDAO.TABLE_NAME;
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
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

	@Override
	public synchronized boolean doUpdate(ConvenzioneBean convenzione) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "UPDATE " + ConvenzioneDAO.TABLE_NAME + 
				" SET tutorAccademico = ?, impiegato = ?" +
				"luogoNascitaCeo = ?, dataNascitaCeo = ?, numeroDipendenti = ?, referente = ?, "
				+ "telefonoReferente = ?, emailReferente = ?, attivita = ?, convalida = ?, url = ? WHERE azienda = ?";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
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
			
			preparedStatement.setString(12, convenzione.getAzienda());
			
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
	public synchronized boolean doDelete(ConvenzioneBean convenzione) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "DELETE FROM " + ConvenzioneDAO.TABLE_NAME + " WHERE azienda = ?";
		
		try{
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, convenzione.getAzienda());
			
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
