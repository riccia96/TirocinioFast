package control;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import bean.AziendaBean;
import bean.ImpiegatoBean;
import bean.StudenteBean;
import bean.TutorBean;
import control.ManagerUtente;

public class ManagerUtenteTest {
	
	private static ManagerUtente classUnderTest;
	private static StudenteBean studente;
	private static String username;
	
	@Before
	static void setUp() throws Exception {
		classUnderTest = new ManagerUtente();
		username = "riccia96";
		
		assertNotNull(classUnderTest);
		
	}
	/**
	 * Testa il metodo getStudente con uno studente già presente nel database.
	 *  @throws SQLException
	 */
	@Test
	public void testGetStudentePresenteInDB() throws SQLException {
		
		System.out.println("doRetrieveByKey di getStudente");
		
		studente.setUsername(username);
		studente = classUnderTest.getStudente(studente);
		
		assertNotNull(studente);
		assertEquals(username, studente.getUsername());
		
	}

	/**
	 * Testa il metodo getStudente con uno studente non presente nel database.
	 *  @throws Exception
	 */
	@Test
	public void testGetStudenteNonInDB() throws SQLException {
		
		System.out.println("doRetrieveByKey di getStudente");
		
		studente.setUsername("mancante");
		studente = classUnderTest.getStudente(studente);
		
		assertNotNull(studente);
		
	}
	
	/**
	 * Testa il metodo salvaStudente con uno studente non presente nel database.
	 * @throws SQLException
	 */
	
	@Test
	public void testSalvaStudenteNonInDB() throws SQLException {
		
		System.out.println("doSave di salvaStudente");
		
		studente = new StudenteBean();
		studente.setNome("Anna");
		studente.setCognome("Riccio");
		studente.setLuogoNascita("Napoli");
		studente.setDataNascita("04/09/1996");
		studente.setIndirizzo("Via Scotola n° 86");
		studente.setCitta("Pomigliano d'Arco");
		studente.setCodiceFiscale("rccnmr96py44kr7y");
		studente.setMatricola("0512103799");
		studente.setEmail("a.riccio26@studenti.unisa.it");
		studente.setTelefono("328 49 569 48");
		studente.setUsername("riccia");
		studente.setPassword("riccia");
		studente.setDomanda("riccia");
		
		classUnderTest.eliminaStudente(studente);
		classUnderTest.salvaStudente(studente);
		StudenteBean result = classUnderTest.getStudente(studente);
		
		assertNotNull(result);
		assertEquals("a.riccio26@studenti.unisa.it", result.getUsername());
	}

	/**
	 * Testa il metodo salvaStudente con uno studente già presente nel database.
	 * @throws SQLException
	 */
	
	@Test
	public void testSalvaStudentePresenteInDB() throws SQLException {
		
		System.out.println("doSave di salvaStudente");

		studente = new StudenteBean();
		studente.setNome("Anna");
		studente.setCognome("Riccio");
		studente.setLuogoNascita("Napoli");
		studente.setDataNascita("04/09/1996");
		studente.setIndirizzo("Via Scotola n° 86");
		studente.setCitta("Pomigliano d'Arco");
		studente.setCodiceFiscale("rccnmr96py44kr7y");
		studente.setMatricola("0512103799");
		studente.setEmail("a.riccio26@studenti.unisa.it");
		studente.setTelefono("328 49 569 48");
		studente.setUsername("riccia");
		studente.setPassword("riccia");
		studente.setDomanda("riccia");
		
		boolean exc = false;
		try {
			classUnderTest.salvaStudente(studente);
		} catch (SQLException e) {
			exc = true;
		}
	
		assertTrue(exc);
		
	}
	
/**
	 * Testa il metodo salvaStudente con dati sullo studente non completi.
	 * @throws SQLException
	 */
	
	@Test
	public void testSalvaStudenteNonCompleto() throws SQLException {
		
		System.out.println("doSave di salvaStudente");

		studente = new StudenteBean();
		studente.setNome("Anna");
		studente.setCognome("Riccio");
		studente.setLuogoNascita("Napoli");
		studente.setDataNascita("04/09/1996");
		studente.setIndirizzo("Via Scotola n° 86");
		studente.setCitta("Pomigliano d'Arco");
		// manca codice fiscale
		studente.setMatricola("0512103799");
		studente.setEmail("a.riccio26@studenti.unisa.it");
		studente.setTelefono("328 49 569 48");
		studente.setUsername("riccia");
		studente.setPassword("riccia");
		studente.setDomanda("riccia");
		
		boolean exc = false;
		try {
			classUnderTest.salvaStudente(studente);
		} catch (SQLException e) {
			exc = true;
		}
	
		assertTrue(exc);
		
	}

	
	/**
	 * Testa il metodo aggiornaStudente con uno studente già presente nel database.
	 * @throws SQLException
	 */
	
	@Test
	public void testAggiornaStudentePresenteInDB() throws SQLException {
		fail("Not yet implemented");
	}


	/**
	 * Testa il metodo aggiornaStudente con uno studente già presente nel database.
	 * @throws SQLException
	 */
	
	@Test
	public void testAggiornaStudenteNonInDB() throws SQLException {
		fail("Not yet implemented");
	}
	
	/**
	 * Testa il metodo getStudenti 
	 * @throws SQLException
	 */
	
	@Test
	public void testGetStudenti() throws SQLException {
		fail("Not yet implemented");
	}

	/**
	 * Testa il metodo eliminaStudente con uno studente già presente nel database.
	 */
	@Test
	public void testEliminaStudentePresenteInDB() throws SQLException {
		fail("Not yet implemented");
	}


	/**
	 * Testa il metodo eliminaStudente con uno studente non presente nel database.
	 */
	@Test
	public void testEliminaStudenteNonInDB() throws SQLException {
		fail("Not yet implemented");
	}
	

}
