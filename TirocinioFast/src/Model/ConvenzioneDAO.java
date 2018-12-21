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
	
	private static final String TABLE_NAME = "Convenzione";

	@Override
	public synchronized int doSave(ConvenzioneBean convenzione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		String querySQL = "INSERT INTO " + ConvenzioneDAO.TABLE_NAME + " (allegato, url, azienda, tutorAccademico, convalida)" +
				"VALUES (?, ?, ?, ?, ?)";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, convenzione.getAllegato());
			preparedStatement.setString(2, convenzione.getUrl());
			preparedStatement.setInt(3, convenzione.getAzienda());
			preparedStatement.setInt(4, convenzione.getTutorAccademico());
			preparedStatement.setBoolean(5, convenzione.isConvalida());
			
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

			preparedStatement.setInt(1, convenzione.getAzienda());

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
				c.setAllegato(result.getString("allegato"));
				c.setUrl(result.getString("url"));
				c.setAzienda(result.getInt("azienda"));
				c.setTutorAccademico(result.getInt("tutorAccademico"));
				c.setConvalida(result.getBoolean("convalida"));
				
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
				
				c.setAllegato(result.getString("allegato"));
				c.setUrl(result.getString("url"));
				c.setAzienda(result.getInt("azienda"));
				c.setTutorAccademico(result.getInt("tutorAccademico"));
				c.setConvalida(result.getBoolean("convalida"));
				
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
				" SET allegato = ?, url = ?, azienda = ?, tutorAccademico = ?, convalida = ?";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, convenzione.getAllegato());
			preparedStatement.setString(2, convenzione.getUrl());
			preparedStatement.setInt(3, convenzione.getAzienda());
			preparedStatement.setInt(4, convenzione.getTutorAccademico());
			preparedStatement.setBoolean(5, convenzione.isConvalida());
			
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
			
			preparedStatement.setInt(1, convenzione.getAzienda());
			
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
