package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import bean.ConvenzioneBean;

public class ConvenzioneBeanTest {
	
	private static ConvenzioneBean convenzione;
	
	@Before
	public void setUp() {
		
		convenzione = new ConvenzioneBean();
		
		convenzione.setId(6);
		convenzione.setAzienda("tech");
		convenzione.setTutorAccademico("gravino");
		convenzione.setImpiegato("ciacci");
		convenzione.getLuogoNascitaCeo();
		convenzione.getDataNascitaCeo();
		convenzione.getNumeroDipendenti();
		convenzione.getReferente();
		convenzione.setTelefonoReferente("328 56 78 569");
		convenzione.getEmailReferente();
		convenzione.getAttivita();
		convenzione.isConvalida();
		convenzione.getUrl();
	}
	
	@AfterClass
	public static void tearDown() {
		convenzione = null;
	}
	
	@Test
	public void testGetId() {
		assertEquals(6, convenzione.getId());
	}
	
	@Test
	public void testSetId() {
		convenzione.setId(4);
		
		assertEquals(4, convenzione.getId());
	}
	
	@Test
	public void testGetAzienda() {
		assertEquals("tech", convenzione.getAzienda());
	}
	
	@Test
	public void testSetAzienda() {
		convenzione.setAzienda("Namirial");
		
		assertEquals("Namirial", convenzione.getAzienda());
	}
	
	@Test
	public void testGetTutorAccademico() {
		assertEquals("gravino", convenzione.getTutorAccademico());
	}
	
	@Test
	public void testSetTutorAccademico() {
		convenzione.setTutorAccademico("Ferrucci");
		
		assertEquals("Ferrucci", convenzione.getTutorAccademico());
	}
	
	@Test
	public void testGetImpiegato() {
		assertEquals("ciacci", convenzione.getImpiegato());
	}
	
	@Test
	public void testSetImpiegato() {
		convenzione.setImpiegato("de rosa");
		
		assertEquals("de rosa", convenzione.getImpiegato());
	}
	
	@Test
	public void testGetTelefonoReferente() {
		assertEquals("328 56 78 569", convenzione.getTelefonoReferente());
	}
	
	@Test
	public void testSetTelefonoReferente() {
		convenzione.setTelefonoReferente("321 35 36 958");
		
		assertEquals("321 35 36 958", convenzione.getTelefonoReferente());
	}
	
}
