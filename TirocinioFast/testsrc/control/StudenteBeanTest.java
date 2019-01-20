package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import bean.StudenteBean;

public class StudenteBeanTest {
	
	private static StudenteBean studente;
	
	@Before
	public void setUp() {
		studente = new StudenteBean();
		studente.setNome("mario");
		studente.setCognome("greco");
		studente.setLuogoNascita("nocera inferiore");
		studente.setDataNascita("20/12/1993");
		studente.setIndirizzo("via rione e. calenda n 35");
		studente.setCitta("nocera inferiore");
		studente.setCodiceFiscale("grcmra93t20f912a");
		studente.setMatricola("0512102415");
		studente.setEmail("mariog@hotmail.it");
		studente.setTelefono("3491953867");
		studente.setUsername("mariog93");
		studente.setPassword("201293");
		studente.setDomanda("300");
	}

	@AfterClass
	public static void tearDown(){
		studente = null;
	}

	@Test
	public void testGetNome() {		
		assertEquals("Mario", studente.getNome());
	}

	@Test
	public void testSetNome() {
		studente.setNome("Giovanni");
		
		assertEquals("Giovanni", studente.getNome());
	}

	@Test
	public void testGetCognome() {
		assertEquals("greco", studente.getCognome());
	}

	@Test
	public void testSetCognome() {
		studente.setCognome("de cicco");
		
		assertEquals("de cicco", studente.getCognome());
	}

	@Test
	public void testGetLuogoNascita() {
		assertEquals("nocera inferiore", studente.getLuogoNascita());
	}

	@Test
	public void testSetLuogoNascita() {
		studente.setLuogoNascita("salerno");
		
		assertEquals("salerno", studente.getLuogoNascita());
	}

	@Test
	public void testGetDataNascita() {
		assertEquals("20/12/1993", studente.getDataNascita());
	}

	@Test
	public void testSetDataNascita() {
		studente.setDataNascita("18/03/1990");
		
		assertEquals("18/03/1990", studente.getDataNascita());
	}

	@Test
	public void testGetIndirizzo() {
		assertEquals("via rione e. calenda n 35", studente.getIndirizzo());
	}

	@Test
	public void testSetIndirizzo() {
		studente.setIndirizzo("via roma n 40");
		
		assertEquals("via roma n 40", studente.getIndirizzo());
	}

	@Test
	public void testGetCitta() {
		assertEquals("nocera inferiore", studente.getCitta());
	}

	@Test
	public void testSetCitta() {
		studente.setCitta("salerno");
		
		assertEquals("salerno", studente.getCitta());
	}

	@Test
	public void testGetCodiceFiscale() {
		assertEquals("grcmra93t20f912a", studente.getCodiceFiscale());
	}

	@Test
	public void testSetCodiceFiscale() {
		studente.setCodiceFiscale("gramra93t20f913k");
		
		assertEquals("gramra93t20f913k", studente.getCodiceFiscale());
	}

	@Test
	public void testGetMatricola() {
		assertEquals("0512102415", studente.getCodiceFiscale());
	}

	@Test
	public void testSetMatricola() {
		studente.setMatricola("0512102568");
		
		assertEquals("0512102568", studente.getCodiceFiscale());
	}

	@Test
	public void testGetEmail() {
		assertEquals("mariog@hotmail.it", studente.getCodiceFiscale());
	}

	@Test
	public void testSetEmail() {
		studente.setEmail("m.greco@gmail.it");
		
		assertEquals("m.greco@gmail.it", studente.getCodiceFiscale());
	}

	@Test
	public void testGetTelefono() {
		assertEquals("3491953867", studente.getCodiceFiscale());
	}

	@Test
	public void testSetTelefono() {
		studente.setTelefono("3457865894");
		
		assertEquals("3457865894", studente.getCodiceFiscale());
	}

	@Test
	public void testGetUsername() {
		assertEquals("mariog93", studente.getCodiceFiscale());
	}

	@Test
	public void testSetUsername() {
		studente.setUsername("m.greco");
		
		assertEquals("m.greco", studente.getCodiceFiscale());
	}

	@Test
	public void testGetPassword() {
		assertEquals("201293", studente.getCodiceFiscale());
	}

	@Test
	public void testSetPassword() {
		studente.setPassword("20121993");
		
		assertEquals("20121993", studente.getCodiceFiscale());
	}

	@Test
	public void testGetDomanda() {
		assertEquals("300", studente.getCodiceFiscale());
	}

	@Test
	public void testSetDomanda() {
		studente.setDomanda("resident evil");
		assertEquals("resident evil", studente.getCodiceFiscale());
	}

}
