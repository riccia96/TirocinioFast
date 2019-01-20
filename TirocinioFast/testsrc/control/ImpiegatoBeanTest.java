package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import bean.ImpiegatoBean;

public class ImpiegatoBeanTest {
	
	private static ImpiegatoBean impiegato;
	
	@Before
	public void setUp() {
		
		impiegato = new ImpiegatoBean();
		
		impiegato.setNome("giorgio");
		impiegato.setCognome("esposito");
		impiegato.setMatricola("0000000002");
		impiegato.setEmail("gioesp@gmail.com");
		impiegato.setUsername("gio.esp");
		impiegato.setPassword("giorgioesposito");
		impiegato.setDomanda("il mondo nuovo");
	}
	
	 @AfterClass
	    public static void tearDown() {
	        impiegato = null;
	    }

	    @Test
	    public void testGetNome() {
	        assertEquals("giorgio", impiegato.getNome());
	    }
	    
	    @Test
	    public void testSetNome() {
	    		impiegato.setNome("Emanuele");
	    		
	    		assertEquals("Emanuele", impiegato.getNome());
	    }
	    
	    @Test
	    public void testGetCognome() {
	        assertEquals("esposito", impiegato.getCognome());
	    }
	    
	    @Test
	    public void testSetCognome() {
	    		impiegato.setCognome("Di Mauro");
	    		
	    		assertEquals("Di Mauro", impiegato.getCognome());
	    }
	    
	    @Test
	    public void testGetMatricola() {
	        assertEquals("0000000002", impiegato.getMatricola());
	    }
	    
	    @Test
	    public void testSetMatricola() {
	    		impiegato.setMatricola("0000000003");
	    		
	    		assertEquals("0000000003", impiegato.getMatricola());
	    }
	    
	    @Test
	    public void testGetEmail() {
	        assertEquals("gioesp@gmail.com", impiegato.getEmail());
	    }
	    
	    @Test
	    public void testSetEmail() {
	    		impiegato.setEmail("manudima@gmail.com");
	    		
	    		assertEquals("manudima@gmail.com", impiegato.getEmail());
	    }
	    
	    @Test
	    public void testGetUsername() {
	        assertEquals("gio.esp", impiegato.getUsername());
	    }
	    
	    @Test
	    public void testSetUsername() {
	    		impiegato.setUsername("dima");
	    		
	    		assertEquals("dima", impiegato.getUsername());
	    }
	    
	    @Test
	    public void testGetPassword() {
	        assertEquals("giorgioesposito", impiegato.getPassword());
	    }
	    
	    @Test
	    public void testSetPassword() {
	    		impiegato.setPassword("manuDi");
	    		
	    		assertEquals("manuDi", impiegato.getPassword());
	    }
	    
	    @Test
	    public void testGetDomanda() {
	        assertEquals("il mondo nuovo", impiegato.getDomanda());
	    }
	    
	    @Test
	    public void testSetdomanda() {
	    		impiegato.setDomanda("lessy");
	    		
	    		assertEquals("lessy", impiegato.getDomanda());
	    }
	    
}
