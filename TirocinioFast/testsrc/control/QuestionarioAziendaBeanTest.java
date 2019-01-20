package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import bean.QuestionarioAziendaBean;

public class QuestionarioAziendaBeanTest {
	
private static QuestionarioAziendaBean qa;
	
	@Before
	public void setUp() {
		
		qa = new QuestionarioAziendaBean();
		
		qa.setId(6);
		qa.setStudente("riccia96");
		qa.setAzienda("tech");
		qa.setTutorAccademico("gravino");
		qa.setImpiegato("ciacci");
		qa.setPeriodoTirocinio("20/10/2018 20/01/2019");
		qa.setTitoloTirocinio("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
		qa.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
		qa.setConvalida(true);
		qa.setUrl("pdf/questionarioAziendaTechRiccia.pdf");
		qa.setPosizioneRicoperta ("direttore reparto 3");
		
	}

	@AfterClass
	public static void tearDown() {
		qa = null;
	}
	
	@Test
	public void testGetId() {
		assertEquals(6, qa.getId());
	}
	
	@Test
	public void testSetId() {
		qa.setId(3);
		
		assertEquals(3, qa.getId());
	}
	
	@Test
	public void testGetStudente() {
		assertEquals("riccia96", qa.getId());
	}
	
	@Test
	public void testSetStudente() {
		qa.setStudente("decicco96");
		
		assertEquals("decicco96", qa.getStudente());
	}
	
	@Test
	public void testGetAzienda() {
		assertEquals("tech", qa.getAzienda());
	}
	
	@Test
	public void testSetAzienda() {
		qa.setAzienda("Namirial");
		
		assertEquals("Namirial", qa.getAzienda());
	}
	
	@Test
	public void testGetTutorAccademico() {
		assertEquals("gravino", qa.getTutorAccademico());
	}
	
	@Test
	public void testSetTutorAccademico() {
		qa.setTutorAccademico("Ferrucci");
		
		assertEquals("Ferrucci", qa.getTutorAccademico());
	}
	
	@Test
	public void testGetImpiegato() {
		assertEquals("ciacci", qa.getImpiegato());
	}
	
	@Test
	public void testSetImpiegato() {
		qa.setImpiegato("de rosa");
		
		assertEquals("de rosa", qa.getImpiegato());
	}
	
	@Test
	public void testGetPeriodoTirocinio() {
		assertEquals("20/10/2018 20/01/2019", qa.getPeriodoTirocinio());
	}
	
	@Test
	public void testSetPeriodoTirocinio() {
		qa.setPeriodoTirocinio("20/11/2018 - 20/12/2018");
		
		assertEquals("20/11/2018 - 20/12/2018", qa.getPeriodoTirocinio());
	}
	
	@Test
	public void testGetTitoloTirocinio() {
		assertEquals("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC", qa.getTitoloTirocinio());
	}
	
	@Test
	public void testSetTitoloTirocinio() {
		qa.setTitoloTirocinio("Creazione di un web server WordPress con Fabrik e accesso tramite ODBC");
		
		assertEquals("Creazione di un web server WordPress con Fabrik e accesso tramite ODBC", qa.getTitoloTirocinio());
	}
	
	@Test
	public void testGetScelte() {
		assertEquals("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**", qa.getScelte());
	}
	
	@Test
	public void testSetScelte() {
		qa.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*due**");
		
		assertEquals("uno*uno*uno*uno*uno*uno*uno*uno*uno*due**", qa.getScelte());
	}
	
	@Test
	public void testIsConvalida() {
		assertEquals(true, qa.isConvalida());
	}
	
	@Test
	public void testSetConvalida() {
		qa.setConvalida(false);
		
		assertEquals(false, qa.isConvalida());
	}
	
	@Test
	public void testGetUrl() {
		assertEquals("pdf/questionarioAziendaTechRiccia.pdf", qa.getUrl());
	}
	
	@Test
	public void testSetUrl() {
		qa.setUrl("pdf/questionarioAziendaNamirialDeCicco.pdf");
		
		assertEquals("pdf/questionarioAziendaNamirialDeCicco.pdf", qa.getUrl());
	}
	
	@Test
	public void testGetPosizioneRicoperta() {
		assertEquals("direttore reparto 3" , qa.getPosizioneRicoperta());
	}
	
	@Test
	public void testSetPosizioneRicoperta() {
		qa.setPosizioneRicoperta("direttore reparto 2");
		
		assertEquals("direttore reparto 2", qa.getPosizioneRicoperta());
	}
	

}
