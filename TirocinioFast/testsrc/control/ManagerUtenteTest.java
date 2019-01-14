package control;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import bean.StudenteBean;

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
		studente.setTelefono("3284956948");
		studente.setUsername("riccia");
		studente.setPassword("riccia");
		studente.setDomanda("riccia");

		classUnderTest.eliminaStudente(studente);
		classUnderTest.salvaStudente(studente);
		StudenteBean result = classUnderTest.getStudente(studente);

		assertNotNull(result);
		assertEquals("riccia", result.getUsername());
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
		studente.setTelefono("3284956948");
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
		studente.setIndirizzo("Via Scotola n° 20");
		studente.setCitta("Pomigliano d'Arco");
		// manca codice fiscale
		studente.setMatricola("0512103799");
		studente.setEmail("a.riccio26@studenti.unisa.it");
		studente.setTelefono("3284956948");
		studente.setUsername("AnnaRiccio");
		studente.setPassword("AnnaRiccio");
		studente.setDomanda("Naruto");

		boolean exc = false;
		try {
			classUnderTest.salvaStudente(studente);
		} catch (SQLException e) {
			exc = true;
		}

		assertTrue(exc);

	}


	/**
	 * Testa il metodo aggiornaStudente con dati completi e uno studente già presente nel database.
	 * @throws SQLException
	 */

	@Test
	public void testAggiornaStudentePresenteInDBCompleto() throws SQLException {

		System.out.println("doUpdate di aggiornaStudente");

		studente.setUsername(username);
		studente = classUnderTest.getStudente(studente);

		studente.setNome("Anna Maria");
		studente.setCitta("Somma Vesuviana");

		classUnderTest.aggiornaStudente(studente);
		studente = classUnderTest.getStudente(studente);

		assertEquals("Anna Maria", studente.getNome());

	}


	/**
	 * Testa il metodo aggiornaStudente con dati non completi e uno studente già presente nel database.
	 * @throws SQLException
	 */

	@Test
	public void testAggiornaStudentePresenteInDBNonCompleto() throws SQLException {
		
		System.out.println("doUpdate di aggiornaStudente");

		studente = new StudenteBean();

		studente.setNome("Anna Maria");
		studente.setCitta("Somma Vesuviana");
		studente.setUsername(username);

		boolean exc = false;
		try {
			classUnderTest.aggiornaStudente(studente);
		} catch (SQLException e) {
			exc = true;
		}
		assertTrue(exc);

	}

	/** 
	 * Testa il metodo getStudenti senza order 
	 * @throws SQLException
	 */

	@Test
	public void testGetStudentiSenzaOrder() throws SQLException {
		
		System.out.println("doRetrieveAll di getStudenti");
		
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudenti(null);
		
		assertNotNull(list);
	}
	
	/** 
	 * Testa il metodo getStudenti con order 
	 * @throws SQLException
	 */

	@Test
	public void testGetStudentiConOrder() throws SQLException {
		
		System.out.println("doRetrieveAll di getStudenti");
		
		ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudenti("username ASC");
		
		assertNotNull(list);
	}

	/**
	 * Testa il metodo eliminaStudente con uno studente già presente nel database.
	 */
	@Test
	public void testEliminaStudentePresenteInDB() throws SQLException {
		
		System.out.println("doDelete di eliminaStudente");
		
		studente = new StudenteBean();
		
		studente.setNome("Mario");
		studente.setCognome("Franco");
		studente.setLuogoNascita("Napoli");
		studente.setDataNascita("14/12/1994");
		studente.setIndirizzo("Piazza Sant'Antonio n° 5");
		studente.setCitta("Brusciano");
		studente.setCodiceFiscale("mrofrc94mg20tr3x");
		studente.setMatricola("0512108743");
		studente.setEmail("m.franco14@studenti.unisa.it");
		studente.setTelefono("3335622354");
		studente.setUsername("MarioFranco");
		studente.setPassword("MarioFranco");
		studente.setDomanda("Naruto");
		
		classUnderTest.salvaStudente(studente);
		
		boolean deleted = classUnderTest.eliminaStudente(studente);
		
		assertTrue(deleted);
		
	}

	
	/**
	 * Testa il metodo eliminaStudente con uno studente non presente nel database.
	 */
	@Test
	public void testEliminaStudenteNonInDB() throws SQLException {

		System.out.println("doDelete di eliminaStudente");
		
		studente = new StudenteBean();
		
		studente.setNome("Giovanni");
		studente.setCognome("Porcelli");
		studente.setLuogoNascita("Napoli");
		studente.setDataNascita("27/01/1995");
		studente.setIndirizzo("Via Sant'Anna n°20");
		studente.setCitta("Nola");
		studente.setCodiceFiscale("gvnprc23pg78dj7f");
		studente.setMatricola("0512103943");
		studente.setEmail("g.porcelli23@studenti.unisa.it");
		studente.setTelefono("3334658346");
		studente.setUsername("GiovanniPorcelli");
		studente.setPassword("GiovanniPorcelli");
		studente.setDomanda("Bichio");
		
		boolean deleted = classUnderTest.eliminaStudente(studente);
		
		assertTrue(deleted);
	}


}
