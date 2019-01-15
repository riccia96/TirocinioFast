package control;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.*;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import com.mysql.jdbc.Connection;





public class ConnessioneDatabaseTest extends DBTestCase{

	private Connection jdbcConnection;
	public DatabaseConnection ConnessioneDatabaseTest(String name) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		jdbcConnection = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tirociniofast?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC", "root", "root.123");
		return new DatabaseConnection(jdbcConnection);
	}
	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream("tirociniofast.xml"));
	}

	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.REFRESH;

	}

	protected DatabaseOperation getTearDownOperation() throws Exception { 
		return DatabaseOperation.NONE;
	}
	
	protected IDatabaseConnection getConnessione() throws Exception {
		return this.getConnection();
	}

//	@test
//	public void testById() throws SQLException {
//		String username = "riccia96";// get user id from database
//		StudenteBean studente = new StudenteBean();
//		ManagerUtente classUnderTest = new ManagerUtente();
//		studente.setUsername(username);
//		studente = classUnderTest.getStudente(studente);
//		assertEquals(studente, username);
//	}
}