package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import bean.QuestionarioAziendaBean;
import bean.QuestionarioStudenteBean;

public class QuestionarioStudenteBeanTest {
	
private static QuestionarioStudenteBean qs;
	
	@Before
	public void setUp() {
		
		qs = new QuestionarioStudenteBean();
		
		qs.setId(6);
		qs.setStudente("riccia96");
		qs.setAzienda("tech");
		qs.setTutorAccademico("gravino");
		qs.setImpiegato("ciacci");
		qs.setPeriodo("20/10/2018 20/01/2019");
		qs.setTitolo("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
		qs.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
		qs.setConvalida(true);
		qs.setUrl("pdf/questionarioStudenteRiccia.pdf");
		
	}

	@AfterClass
	public static void tearDown() {
		qs = null;
	}
	
	@Test
	public void testGetId() {
		assertEquals(6, qs.getId());
	}
	
	@Test
	public void testSetId() {
		qs.setId(3);
		
		assertEquals(3, qs.getId());
	}
	
	@Test
	public void testGetStudente() {
		assertEquals("riccia96", qs.getId());
	}
	
	@Test
	public void testSetStudente() {
		qs.setStudente("decicco96");
		
		assertEquals("decicco96", qs.getStudente());
	}
	
	@Test
	public void testGetAzienda() {
		assertEquals("tech", qs.getAzienda());
	}
	
	@Test
	public void testSetAzienda() {
		qs.setAzienda("Namirial");
		
		assertEquals("Namirial", qs.getAzienda());
	}
	
	@Test
	public void testGetTutorAccademico() {
		assertEquals("gravino", qs.getTutorAccademico());
	}
	
	@Test
	public void testSetTutorAccademico() {
		qs.setTutorAccademico("Ferrucci");
		
		assertEquals("Ferrucci", qs.getTutorAccademico());
	}
	
	@Test
	public void testGetImpiegato() {
		assertEquals("ciacci", qs.getImpiegato());
	}
	
	@Test
	public void testSetImpiegato() {
		qs.setImpiegato("de rosa");
		
		assertEquals("de rosa", qs.getImpiegato());
	}
	
	@Test
	public void testGetPeriodoTirocinio() {
		assertEquals("20/10/2018 20/01/2019", qs.getPeriodo());
	}
	
	@Test
	public void testSetPeriodoTirocinio() {
		qs.setPeriodo("20/11/2018 - 20/12/2018");
		
		assertEquals("20/11/2018 - 20/12/2018", qs.getPeriodo());
	}
	
	@Test
	public void testGetTitoloTirocinio() {
		assertEquals("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC", qs.getTitolo());
	}
	
	@Test
	public void testSetTitoloTirocinio() {
		qs.setTitolo("Creazione di un web server WordPress con Fabrik e accesso tramite ODBC");
		
		assertEquals("Creazione di un web server WordPress con Fabrik e accesso tramite ODBC", qs.getTitolo());
	}
	
	@Test
	public void testGetScelte() {
		assertEquals("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**", qs.getScelte());
	}
	
	@Test
	public void testSetScelte() {
		qs.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*due**");
		
		assertEquals("uno*uno*uno*uno*uno*uno*uno*uno*uno*due**", qs.getScelte());
	}
	
	@Test
	public void testIsConvalida() {
		assertEquals(true, qs.isConvalida());
	}
	
	@Test
	public void testSetConvalida() {
		qs.setConvalida(false);
		
		assertEquals(false, qs.isConvalida());
	}
	
	@Test
	public void testGetUrl() {
		assertEquals("pdf/questionarioStudenteRiccia.pdf", qs.getUrl());
	}
	
	@Test
	public void testSetUrl() {
		qs.setUrl("pdf/questionarioStudenteDeCicco.pdf");
		
		assertEquals("pdf/questionarioStudenteDeCicco.pdf", qs.getUrl());
	}
	

}
