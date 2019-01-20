package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import bean.TutorBean;

public class TutorBeanTest {
	
	private static TutorBean tutor;
	
	@Before
	public void setUp() {
		
		tutor = new TutorBean();
		
		tutor.setNome("Carmine");
		tutor.setCognome("Carrelli");
		tutor.setMatricola("0000050005");
		tutor.setEmail("carmcar@gmail.com");
		tutor.setUsername("carcar");
		tutor.setPassword("minecar");
		tutor.setDomanda("ring");
	}
	
	 @AfterClass
	    public static void tearDown() {
	        tutor = null;
	    }

	    @Test
	    public void testGetNome() {
	        assertEquals("Carmine", tutor.getNome());
	    }
	    
	    @Test
	    public void testSetNome() {
	    		tutor.setNome("Umberto");
	    		
	    		assertEquals("Umberto", tutor.getNome());
	    }
	    
	    @Test
	    public void testGetCognome() {
	        assertEquals("Carrelli", tutor.getCognome());
	    }
	    
	    @Test
	    public void testSetCognome() {
	    		tutor.setCognome("Picariello");
	    		
	    		assertEquals("Picariello", tutor.getCognome());
	    }
	    
	    @Test
	    public void testGetMatricola() {
	        assertEquals("0000050005", tutor.getMatricola());
	    }
	    
	    @Test
	    public void testSetMatricola() {
	    		tutor.setMatricola("0000000008");
	    		
	    		assertEquals("0000000008", tutor.getMatricola());
	    }
	    
	    @Test
	    public void testGetEmail() {
	        assertEquals("carmcar@gmail.com", tutor.getEmail());
	    }
	    
	    @Test
	    public void testSetEmail() {
	    		tutor.setEmail("umbypica@gmail.com");
	    		
	    		assertEquals("umbypica@gmail.com", tutor.getEmail());
	    }
	    
	    @Test
	    public void testGetUsername() {
	        assertEquals("carcar", tutor.getUsername());
	    }
	    
	    @Test
	    public void testSetUsername() {
	    		tutor.setUsername("picaUmb");
	    		
	    		assertEquals("picaUmb", tutor.getUsername());
	    }
	    
	    @Test
	    public void testGetPassword() {
	        assertEquals("minecar", tutor.getPassword());
	    }
	    
	    @Test
	    public void testSetPassword() {
	    		tutor.setPassword("picapica");
	    		
	    		assertEquals("picapica", tutor.getPassword());
	    }
	    
	    @Test
	    public void testGetDomanda() {
	        assertEquals("ring", tutor.getDomanda());
	    }
	    
	    @Test
	    public void testSetdomanda() {
	    		tutor.setDomanda("barbie");
	    		
	    		assertEquals("barbie", tutor.getDomanda());
	    }
	    
}
