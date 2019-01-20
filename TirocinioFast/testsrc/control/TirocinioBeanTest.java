package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import bean.TirocinioBean;

public class TirocinioBeanTest {
	
	private static TirocinioBean tirocinio;
	
	@Before
	public void setUp() {
		
		tirocinio = new TirocinioBean();
		
		tirocinio.setId(4);
		tirocinio.setStudente("riccia");
		tirocinio.setAzienda("deloitte");
		tirocinio.setTutorAccademico("vaccaro");
		tirocinio.setImpiegato("ciacci");
		tirocinio.setAnnoAccademico("2019");
		tirocinio.setCfu(6);
		tirocinio.setHandicap(false);
		tirocinio.setSedeTirocinio("napoli");
		tirocinio.setAccessoLocali("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al venerdi");
		tirocinio.setPeriodoTirocinio("3 mesi");
		tirocinio.setObiettivoTirocinio("completare un sistema di rete telefonica innovativo gia avviato");
		tirocinio.setFacilitazioni("rimborso delle spese di trasporto");
		tirocinio.setConvalidaAzienda(true);
		tirocinio.setConvalidaStudente(true);
		tirocinio.setConvalidaTutor(true);
		tirocinio.setConvalidaAttivita(true);
		tirocinio.setRegistroOre("pdf/aRiccioRegistroOre.pdf");
		tirocinio.setQuestionarioStudente(2);
		tirocinio.setQuestionarioAzienda(2);
		tirocinio.setUrl("pdf/aRiccioTirocinio.pdf");
		
	}

	@AfterClass
	public static void tearDown() {
		tirocinio = null;
	}
	
	@Test
	public void testGetId() {
		assertEquals(4, tirocinio.getId());
	}
	
	@Test
	public void testSetId() {
		tirocinio.setId(3);
		
		assertEquals(3, tirocinio.getId());
	}
	
	@Test
	public void testGetStudente() {
		assertEquals("riccia", tirocinio.getStudente());
	}
	
	@Test
	public void testSetStudente() {
		tirocinio.setStudente("de cicco");
		
		assertEquals("de cicco", tirocinio.getStudente());
	}
	
	@Test
	public void testGetAzienda() {
		assertEquals("deloitte", tirocinio.getAzienda());
	}
	
	@Test
	public void testSetAzienda() {
		tirocinio.setAzienda("Namirial");
		
		assertEquals("Namirial", tirocinio.getAzienda());
	}
	
	@Test
	public void testGetTutorAccademico() {
		assertEquals("vaccaro", tirocinio.getTutorAccademico());
	}
	
	@Test
	public void testSetTutorAccademico() {
		tirocinio.setTutorAccademico("Gravino");
		
		assertEquals("Gravino", tirocinio.getTutorAccademico());
	}
	
	@Test
	public void testGetImpiegato() {
		assertEquals("ciacci", tirocinio.getImpiegato());
	}
	
	@Test
	public void testSetImpiegato() {
		tirocinio.setImpiegato("de rosa");
		
		assertEquals("de rosa", tirocinio.getImpiegato());
	}
	
	@Test
	public void testGetCfu() {
		assertEquals(6, tirocinio.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		tirocinio.setId(12);
		
		assertEquals(12, tirocinio.getCfu());
	}
	
	@Test
	public void testIsHandicap() {
		assertEquals(false, tirocinio.isHandicap());
	}
	
	@Test
	public void testSetHandicap() {
		tirocinio.setHandicap(true);
		
		assertEquals(true, tirocinio.isHandicap());
	}
	
	@Test
	public void testGetSedeTirocinio() {
		assertEquals("napoli", tirocinio.getSedeTirocinio());
	}
	
	@Test
	public void testSetSedeTirocinio() {
		tirocinio.setSedeTirocinio("Salerno");
		
		assertEquals("Salerno", tirocinio.getSedeTirocinio());
	}
	
	@Test
	public void testGetAccessoLocali() {
		assertEquals("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al venerdi", tirocinio.getAccessoLocali());
	}
	
	@Test
	public void testSetAccessoLocali() {
		tirocinio.setAccessoLocali("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al sabato");
		
		assertEquals("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al sabato", tirocinio.getAccessoLocali());
	}
	
	@Test
	public void testGetPeriodoTirocinio() {
		assertEquals("3 mesi", tirocinio.getPeriodoTirocinio());
	}
	
	@Test
	public void testSetPeriodoTirocinio() {
		tirocinio.setPeriodoTirocinio("1 mese");
		
		assertEquals("1 mese", tirocinio.getPeriodoTirocinio());
	}
	
	@Test
	public void testGetObiettivoTirocinio() {
		assertEquals("completare un sistema di rete telefonica innovativo gia avviato", tirocinio.getObiettivoTirocinio());
	}
	
	@Test
	public void testSetObiettivoTirocinio() {
		tirocinio.setObiettivoTirocinio("completare un sistema di rete telefonica innovativo ancora da avviare");
		
		assertEquals("completare un sistema di rete telefonica innovativo ancora da avviare", tirocinio.getObiettivoTirocinio());
	}
	
	@Test
	public void testGetFacilitazioni() {
		assertEquals("rimborso delle spese di trasporto", tirocinio.getFacilitazioni());
	}
	
	@Test
	public void testSetFacilitazioni() {
		tirocinio.setFacilitazioni("Rimborso spese per la mensa");
		
		assertEquals("Rimborso spese per la mensa", tirocinio.getFacilitazioni());
	}
	
	@Test
	public void testIsConvalidaAzienda() {
		assertEquals(true, tirocinio.isConvalidaAzienda());
	}
	
	@Test
	public void testSetConvalidaAzienda() {
		tirocinio.setConvalidaAzienda(false);
		
		assertEquals(false, tirocinio.isConvalidaAzienda());
	}
	
	@Test
	public void testIsConvalidaStudente() {
		assertEquals(true, tirocinio.isConvalidaStudente());
	}
	
	@Test
	public void testSetConvalidaStudente() {
		tirocinio.setConvalidaStudente(false);
		
		assertEquals(false, tirocinio.isConvalidaStudente());
	}
	
	@Test
	public void testIsConvalidaTutor() {
		assertEquals(true, tirocinio.isConvalidaTutor());
	}
	
	@Test
	public void testSetConvalidaTutor() {
		tirocinio.setConvalidaTutor(false);
		
		assertEquals(false, tirocinio.isConvalidaTutor());
	}
	
	@Test
	public void testIsConvalidaAttivita() {
		assertEquals(true, tirocinio.isConvalidaAttivita());
	}
	
	@Test
	public void testSetConvalidaAttivita() {
		tirocinio.setConvalidaAttivita(false);
		
		assertEquals(false, tirocinio.isConvalidaAttivita());
	}
	
	@Test
	public void testGetRegistroOre() {
		assertEquals("pdf/aRiccioRegistroOre.pdf", tirocinio.getRegistroOre());
	}
	
	@Test
	public void testSetRegistroOre() {
		tirocinio.setRegistroOre("pdf/mDeCiccoRegistroOre.pdf");
		
		assertEquals("pdf/mDeCiccoRegistroOre.pdf", tirocinio.getRegistroOre());
	}
	
	@Test
	public void testGetQuestionarioStudente() {
		assertEquals(2, tirocinio.getQuestionarioStudente());
	}
	
	@Test
	public void testSetQuestiorioStudente() {
		tirocinio.setQuestionarioStudente(3);
		
		assertEquals(3, tirocinio.getQuestionarioStudente());
	}
	
	@Test
	public void testGetQuestionarioAzienda() {
		assertEquals(2, tirocinio.getQuestionarioAzienda());
	}
	
	@Test
	public void testSetQuestionarioAzienda() {
		tirocinio.setQuestionarioAzienda(3);
		
		assertEquals(3, tirocinio.getQuestionarioAzienda());
	}
	
	@Test
	public void testGetUrl() {
		assertEquals("pdf/aRiccioTirocinio.pdf", tirocinio.getUrl());
	}
	
	@Test
	public void testSetUrl() {
		tirocinio.setUrl("pdf/mDeCiccoTirocinio.pdf");
		
		assertEquals("pdf/mDeCiccoTirocinio.pdf", tirocinio.getUrl());
	}
}
