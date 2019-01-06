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

import Bean.QuestionarioStudenteBean;

public class QuestionarioStudenteDAO extends AbstractDAO<QuestionarioStudenteBean>{
	
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
	
	private static final String TABLE_NAME = "questionarioStudente";
	
	public synchronized int generaCodice() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT COUNT(*) AS TOTAL FROM "+ QuestionarioStudenteDAO.TABLE_NAME;
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
	public synchronized int doSave(QuestionarioStudenteBean questionarioStudente) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		String querySQL = "INSERT INTO " + QuestionarioStudenteDAO.TABLE_NAME + " (id, studente, azienda, tutorAccademico, impiegato, periodoTirocinio, "
				+ "titoloTirocinio, scelte, convalida, url)" +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS);
			
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
	public synchronized QuestionarioStudenteBean doRetrieveByKey(QuestionarioStudenteBean questionarioStudente) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		QuestionarioStudenteBean qs = new QuestionarioStudenteBean();
		
		String querySQL = "SELECT * FROM " + QuestionarioStudenteDAO.TABLE_NAME + " WHERE id = ? ";
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.setInt(1, questionarioStudente.getId());

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
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

	@Override
	public synchronized List<QuestionarioStudenteBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		List<QuestionarioStudenteBean> questionariStudente = new ArrayList<QuestionarioStudenteBean>();
		
		String querySQL = "SELECT * FROM " + QuestionarioStudenteDAO.TABLE_NAME;
		
		try {

			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);

			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			
			while(result.next()){
				
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

	@Override
	public synchronized boolean doUpdate(QuestionarioStudenteBean questionarioStudente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "UPDATE " + QuestionarioStudenteDAO.TABLE_NAME + " SET studente = ?, azienda = ?, tutorAccademico = ?,"
				+ " impiegato = ?, periodoTirocinio = ?, titoloTirocinio = ?, convalida = ?, url = ? WHERE id = ? ";
		
		try{
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
			preparedStatement.setString(1, questionarioStudente.getStudente());
			preparedStatement.setString(2, questionarioStudente.getAzienda());
			preparedStatement.setString(3, questionarioStudente.getTutorAccademico());
			preparedStatement.setString(4, questionarioStudente.getImpiegato());
			preparedStatement.setString(5, questionarioStudente.getPeriodo());
			preparedStatement.setString(6, questionarioStudente.getTitolo());
			preparedStatement.setString(7, questionarioStudente.getScelte());
			preparedStatement.setBoolean(8, questionarioStudente.isConvalida());
			preparedStatement.setString(9, questionarioStudente.getUrl());
			
			preparedStatement.setInt(9, questionarioStudente.getId());
			
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
	public synchronized boolean doDelete(QuestionarioStudenteBean questionarioStudente) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String querySQL = "DELETE FROM " + QuestionarioStudenteDAO.TABLE_NAME + " WHERE id = ? ";
		
		try{
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(querySQL);
			
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
