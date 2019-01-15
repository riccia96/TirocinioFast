package control;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.TirocinioBean;
import control.ManagerDocumento;

public class ManagerDocumentoTest {
	
	private static ManagerDocumento classUnderTest;
	private static TirocinioBean tirocinio;
	private static int id;
	
	@BeforeClass
	public static void setUp() throws SQLException{
		classUnderTest = new ManagerDocumento();
		id = 0;
		tirocinio = new TirocinioBean();
	}

	/**
	 * Testa il metodo getTirocinio con un tirocinio già presente nel database.
	 * @throws SQLException
	 */
	
	@Test
	public void testGetTirocinioPresenteInDB() throws SQLException {
		
		System.out.println("doRetrieveByKey di getTirocinio");
		
		tirocinio.setId(id);
		tirocinio = classUnderTest.getTirocinio(tirocinio);
		
		assertNotNull(tirocinio);		
	}
	
//	/**
//	 * Testa il metodo getTirocinio con un tirocinio non presente nel database.
//	 * @throws SQLException
//	 */
//	
//	@test
//	public void testGetTirocinioNonPresenteInDB() throws SQLException {
//		
//		System.out.println("doRetrieveByKey di getTirocinio");
//		
//		tirocinio.setId(-8);
//		tirocinio = classUnderTest.getTirocinio(tirocinio);
//		
//		assertNotNull(tirocinio);
//	}
//	
//	/**
//	 * Testa il metodo salvaTirocinio con un tirocinio non presente nel database.
//	 * @throws SQLException
//	 */
//	
//	@test
//	public void testSalvaTirocinioNonInDB() throws SQLException {
//		
//		System.out.println("doSave di tirocinio");
//		
//		tirocinio = new TirocinioBean();
//		tirocinio.setId(id);
//		tirocinio.setStudente("riccia");
//		tirocinio.setAzienda("deloitte");
//		tirocinio.setTutorAccademico("vaccaro");
//		tirocinio.setImpiegato("giostorti");
//		tirocinio.setAnnoAccademico("2019");
//		tirocinio.setCfu(6);
//		tirocinio.setHandicap(false);
//		tirocinio.setSedeTirocinio("napoli");
//		tirocinio.setAccessoLocali("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al venerdi");
//		tirocinio.setPeriodoTirocinio("3 mesi");
//		tirocinio.setObiettivoTirocinio("completare un sistema di rete telefonica innovativo gia avviato");
//		tirocinio.setFacilitazioni("rimborso delle spese di trasporto");
//		tirocinio.setConvalidaAzienda(true);
//		tirocinio.setConvalidaStudente(true);
//		tirocinio.setConvalidaTutor(true);
//		tirocinio.setConvalidaAttivita(true);
//		tirocinio.setRegistroOre("pdf/aRiccioRegistroOre.pdf");
//		tirocinio.setQuestionarioStudente(2);
//		tirocinio.setQuestionarioAzienda(2);
//		tirocinio.setUrl("pdf/aRiccioTirocinio.pdf");
//		
//		classUnderTest.eliminaTirocinio(tirocinio);
//		classUnderTest.salvaTirocinio(tirocinio);
//		TirocinioBean result = classUnderTest.getTirocinio(tirocinio);
//		
//		assertNotNull(result);
//		assertEquals("riccia", result.getStudente());
//	}
//	
//	/**
//	 * Testa il metodo salvaTirocinio con un tirocinio già presente nel database.
//	 * @throws SQLException
//	 */
//	
//	@test
//	public void testSalvaTirocinioPresenteInDB() throws SQLException {
//
//		System.out.println("doSave di tirocinio");
//		
//		tirocinio = new TirocinioBean();
//		tirocinio.setStudente("riccia");
//		tirocinio.setAzienda("deloitte");
//		tirocinio.setTutorAccademico("vaccaro");
//		tirocinio.setImpiegato("giostorti");
//		tirocinio.setAnnoAccademico("2019");
//		tirocinio.setCfu(6);
//		tirocinio.setHandicap(false);
//		tirocinio.setSedeTirocinio("napoli");
//		tirocinio.setAccessoLocali("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al venerdi");
//		tirocinio.setPeriodoTirocinio("3 mesi");
//		tirocinio.setObiettivoTirocinio("completare un sistema di rete telefonica innovativo gia avviato");
//		tirocinio.setFacilitazioni("rimborso delle spese di trasporto");
//		tirocinio.setConvalidaAzienda(true);
//		tirocinio.setConvalidaStudente(true);
//		tirocinio.setConvalidaTutor(true);
//		tirocinio.setConvalidaAttivita(true);
//		tirocinio.setRegistroOre("pdf/aRiccioRegistroOre.pdf");
//		tirocinio.setQuestionarioStudente(2);
//		tirocinio.setQuestionarioAzienda(2);
//		tirocinio.setUrl("pdf/aRiccioTirocinio.pdf");
//		
//		boolean exc = false;
//		
//		try {
//			classUnderTest.salvaTirocinio(tirocinio);
//		} catch (SQLException e) {
//			exc = true;
//		}
//		
//		assertTrue(exc);
//	}
//	
//	/**
//	 * Testa il metodo salvaTirocinio con dati sul tirocinio non completi
//	 * @throws SQLException
//	 */
//	
//	@test
//	public void testSalvaTirocinioNonCompleto() throws SQLException {
//		 
//		System.out.println("doSave di salvaTirocino");
//		
//		tirocinio = new TirocinioBean();
//		tirocinio.setStudente("riccia");
//		tirocinio.setAzienda("deloitte");
//		tirocinio.setTutorAccademico("vaccaro");
//		tirocinio.setImpiegato("giostorti");
//		tirocinio.setAnnoAccademico("2019");
//		tirocinio.setCfu(6);
//		tirocinio.setHandicap(false);
//		tirocinio.setSedeTirocinio("napoli");
//		// manca titolo tirocinio
//		tirocinio.setPeriodoTirocinio("3 mesi");
//		tirocinio.setObiettivoTirocinio("completare un sistema di rete telefonica innovativo gia avviato");
//		tirocinio.setFacilitazioni("rimborso delle spese di trasporto");
//		tirocinio.setConvalidaAzienda(true);
//		tirocinio.setConvalidaStudente(true);
//		tirocinio.setConvalidaTutor(true);
//		tirocinio.setConvalidaAttivita(true);
//		tirocinio.setRegistroOre("pdf/aRiccioRegistroOre.pdf");
//		tirocinio.setQuestionarioStudente(2);
//		tirocinio.setQuestionarioAzienda(2);
//		tirocinio.setUrl("pdf/aRiccioTirocinio.pdf");
//		
//		boolean exc = false;
//		
//		try {
//			classUnderTest.salvaTirocinio(tirocinio);
//		} catch (SQLException e) {
//			exc = true;
//		}
//		
//		assertTrue(exc);
//	}
//	/**
//	 * Testa il metodo aggiornaTirocinio con dati completi e un tirocinio già presente nel database
//	 * @throws SQLException 
//	 */
//	
//	@test
//	public void testAggiornaTirocinioPresenteInDB() throws SQLException {
//		
//		System.out.println("doUpdate di aggiornaTirocinio");
//		
//		tirocinio.setId(id);
//		tirocinio = classUnderTest.getTirocinio(tirocinio);
//		
//		tirocinio.setAnnoAccademico("2018");
//		tirocinio.setCfu(3);
//		
//		classUnderTest.aggiornaTirocinio(tirocinio);
//		
//		tirocinio = classUnderTest.getTirocinio(tirocinio);
//		
//		assertEquals("2018", tirocinio.getAnnoAccademico());
//		
//	}
//	
//	/**
//	 * Testa il metodo aggiornaTirocinio con dati non completi e un tirocinio già presente nel database.
//	 * @throws SQLException
//	 */
//	
//	@test
//	public void testAggiornaTirocinioPresenteInDBNonCompleto() throws SQLException {
//		
//		System.out.println("doUpdate di aggiornaTirocinio");
//		
//		tirocinio = new TirocinioBean();
//		
//		tirocinio.setAnnoAccademico("2019");
//		tirocinio.setFacilitazioni("buoni pasto utilizzabili in mensa");
//		tirocinio.setId(id);
//		
//		boolean exc = false;
//		
//		try {
//			classUnderTest.aggiornaTirocinio(tirocinio);
//		} catch (SQLException e) {
//			exc = true;
//		}
//		
//		assertTrue(exc);
//		
//	}
//	
//	/**
//	 * Testa il metodo getTirocini
//	 * @throws SQLException
//	 */
//	
//	@test
//	public void testGetTirocini() throws SQLException {
//		
//		System.out.println("doRetrieveAll di getTirocini");
//		
//		ArrayList<TirocinioBean> list = (ArrayList<TirocinioBean>) classUnderTest.getTirocini("id ASC");
//		
//		assertNotNull(list);
//		
//	}
//	
//	/**
//	 * Testa il metodo eliminaTirocinio con un tirocinio già presente nel database.
//	 * @throws SQLException
//	 */
//	
//	@test
//	public void testEliminaTirocinioPresenteInDB() throws SQLException {
//		
//		System.out.println("doDelete di eliminaTirocinio");
//		
//		tirocinio = new TirocinioBean();
//		
//		tirocinio.setId(id);
//		tirocinio.setStudente("riccia");
//		tirocinio.setAzienda("deloitte");
//		tirocinio.setTutorAccademico("vaccaro");
//		tirocinio.setImpiegato("giostorti");
//		tirocinio.setAnnoAccademico("2019");
//		tirocinio.setCfu(6);
//		tirocinio.setHandicap(false);
//		tirocinio.setSedeTirocinio("napoli");
//		tirocinio.setAccessoLocali("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al venerdi");
//		tirocinio.setPeriodoTirocinio("3 mesi");
//		tirocinio.setObiettivoTirocinio("completare un sistema di rete telefonica innovativo gia avviato");
//		tirocinio.setFacilitazioni("rimborso delle spese di trasporto");
//		tirocinio.setConvalidaAzienda(true);
//		tirocinio.setConvalidaStudente(true);
//		tirocinio.setConvalidaTutor(true);
//		tirocinio.setConvalidaAttivita(true);
//		tirocinio.setRegistroOre("pdf/aRiccioRegistroOre.pdf");
//		tirocinio.setQuestionarioStudente(2);
//		tirocinio.setQuestionarioAzienda(2);
//		tirocinio.setUrl("pdf/aRiccioTirocinio.pdf");
//		
//		classUnderTest.salvaTirocinio(tirocinio);
//		
//		boolean deleted = classUnderTest.eliminaTirocinio(tirocinio);
//		
//		assertTrue(deleted);
//		
//	}
//	
//	/**
//	 * Testa il metodo eliminaTirocinio con un tirocinio non presente nel database.
//	 * @throws SQLException
//	 */
//	
//	@test
//	public void testEliminaTirocinioNonPresenteInDB() throws SQLException {
//		
//		System.out.println("doDelete di eliminaTirocinio");
//		
//		tirocinio = new TirocinioBean();
//		
//		tirocinio.setId(10);
//		tirocinio.setStudente("sesposito");
//		tirocinio.setAzienda("deloitte");
//		tirocinio.setTutorAccademico("deprisco");
//		tirocinio.setImpiegato("giostorti");
//		tirocinio.setAnnoAccademico("2020");
//		tirocinio.setCfu(12);
//		tirocinio.setHandicap(false);
//		tirocinio.setSedeTirocinio("milano");
//		tirocinio.setAccessoLocali("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al venerdi");
//		tirocinio.setPeriodoTirocinio("6 mesi");
//		tirocinio.setObiettivoTirocinio("completare un sistema di rete telefonica innovativo gia avviato");
//		tirocinio.setFacilitazioni("buoni pasto da consumare nella mensa della ditta");
//		tirocinio.setConvalidaAzienda(true);
//		tirocinio.setConvalidaStudente(true);
//		tirocinio.setConvalidaTutor(true);
//		tirocinio.setConvalidaAttivita(true);
//		tirocinio.setRegistroOre("pdf/sEspositoRegistroOre.pdf");
//		tirocinio.setQuestionarioStudente(10);
//		tirocinio.setQuestionarioAzienda(10);
//		tirocinio.setUrl("pdf/sEspositoTirocinio.pdf");
//		
//		boolean deleted = classUnderTest.eliminaTirocinio(tirocinio);
//		
//		assertTrue(deleted);
//		
//	}	
	
}
