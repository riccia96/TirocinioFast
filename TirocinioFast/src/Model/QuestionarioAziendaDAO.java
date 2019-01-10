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

import Bean.QuestionarioAziendaBean;

public class QuestionarioAziendaDAO extends AbstractDAO<QuestionarioAziendaBean>{
	
	private static DataSource ds;
	
	static {
		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/tirociniofast");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	private static final String TABLE_NAME = "questionarioAzienda";
	
	public synchronized int generaCodice() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT COUNT(*) AS TOTAL FROM "+ QuestionarioAziendaDAO.TABLE_NAME;
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		int rowCount = 0;
		try{
			while(rs.next()){
				rowCount = rs.getInt("total");
			}
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}

		return rowCount;
	}

	@Override
	public synchronized int doSave(QuestionarioAziendaBean questionarioAzienda) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		String querySQL = "INSERT INTO " + QuestionarioAziendaDAO.TABLE_NAME + " (id, studente, azienda, tutorAccademico, impiegato, "
				+ "periodoTirocinio, titoloTirocinio, posizioneRicoperta, scelte, convalida, url)" +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, generaCodice());
			preparedStatement.setString(2, questionarioAzienda.getStudente());
			preparedStatement.setString(3, questionarioAzienda.getAzienda());
			preparedStatement.setString(4, questionarioAzienda.getTutorAccademico());
			preparedStatement.setString(5, questionarioAzienda.getImpiegato());
			preparedStatement.setString(6, questionarioAzienda.getPeriodoTirocinio());
			preparedStatement.setString(7, questionarioAzienda.getTitoloTirocinio());
			preparedStatement.setString(8, questionarioAzienda.getPosizioneRicoperta());
			preparedStatement.setString(9, questionarioAzienda.getScelte());
			preparedStatement.setBoolean(10, questionarioAzienda.isConvalida());
			preparedStatement.setString(11, questionarioAzienda.getUrl());
			
			preparedStatement.execute();
			result = preparedStatement.getGeneratedKeys();
			
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
	public synchronized QuestionarioAziendaBean doRetrieveByKey(QuestionarioAziendaBean questionarioAzienda) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		QuestionarioAziendaBean qa = new QuestionarioAziendaBean();
		
		String querySQL = "SELECT * FROM " + QuestionarioAziendaDAO.TABLE_NAME + " WHERE id = ? ";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setInt(1, questionarioAzienda.getId());

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
				qa.setId(result.getInt("id"));
				qa.setStudente(result.getString("studente"));
				qa.setAzienda(result.getString("azienda"));
				qa.setTutorAccademico(result.getString("tutorAccademico"));
				qa.setImpiegato(result.getString("impiegato"));
				qa.setPeriodoTirocinio(result.getString("periodoTirocinio"));
				qa.setTitoloTirocinio(result.getString("titoloTirocinio"));
				qa.setPosizioneRicoperta(result.getString("posizioneRicoperta"));
				qa.setScelte(result.getString("scelte"));
				qa.setConvalida(result.getBoolean("convalida"));
				qa.setUrl(result.getString("url"));
				
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

		return qa;
	}

	@Override
	public synchronized List<QuestionarioAziendaBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<QuestionarioAziendaBean> questionariAzienda = new ArrayList<QuestionarioAziendaBean>();
		
		String querySQL = "SELECT * FROM " + QuestionarioAziendaDAO.TABLE_NAME;
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
				QuestionarioAziendaBean qa = new QuestionarioAziendaBean();
				
				qa.setId(result.getInt("id"));
				qa.setStudente(result.getString("studente"));
				qa.setAzienda(result.getString("azienda"));
				qa.setTutorAccademico(result.getString("tutorAccademico"));
				qa.setImpiegato(result.getString("impiegato"));
				qa.setPeriodoTirocinio(result.getString("periodoTirocinio"));
				qa.setTitoloTirocinio(result.getString("titoloTirocinio"));
				qa.setPosizioneRicoperta(result.getString("posizioneRicoperta"));
				qa.setScelte(result.getString("scelte"));
				qa.setConvalida(result.getBoolean("convalida"));
				qa.setUrl(result.getString("url"));
								
				questionariAzienda.add(qa);
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

		return questionariAzienda;
	}

	@Override
	public synchronized boolean doUpdate(QuestionarioAziendaBean questionarioAzienda) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "UPDATE " + QuestionarioAziendaDAO.TABLE_NAME + " SET studente = ?, azienda = ?, tutorAccademico = ?,"
				+ " impiegato = ?, periodoTirocinio = ?, titoloTirocinio = ?, posizioneRicoperta = ?, convalida = ?, url = ? WHERE id = ? ";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, questionarioAzienda.getStudente());
			preparedStatement.setString(2, questionarioAzienda.getAzienda());
			preparedStatement.setString(3, questionarioAzienda.getTutorAccademico());
			preparedStatement.setString(4, questionarioAzienda.getImpiegato());
			preparedStatement.setString(5, questionarioAzienda.getPeriodoTirocinio());
			preparedStatement.setString(6, questionarioAzienda.getTitoloTirocinio());
			preparedStatement.setString(4, questionarioAzienda.getImpiegato());
			preparedStatement.setString(5, questionarioAzienda.getPeriodoTirocinio());
			preparedStatement.setString(6, questionarioAzienda.getTitoloTirocinio());
			preparedStatement.setString(7, questionarioAzienda.getPosizioneRicoperta());
			preparedStatement.setString(8, questionarioAzienda.getScelte());
			preparedStatement.setBoolean(9, questionarioAzienda.isConvalida());
			preparedStatement.setString(10, questionarioAzienda.getUrl());
			
			preparedStatement.setInt(10, questionarioAzienda.getId());
			
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
	public synchronized boolean doDelete(QuestionarioAziendaBean questionarioAzienda) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "DELETE FROM " + QuestionarioAziendaDAO.TABLE_NAME + " WHERE id = ? ";
		
		try{
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setInt(1, questionarioAzienda.getId());
			
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
