package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterClass;

import bean.AziendaBean;

public class AziendaBeanTest {

    private static AziendaBean azienda;

    @Before
    public void setUp() {

        azienda = new AziendaBean();

        azienda.setNome("InfoSolution");
		azienda.setPartitaIva("20512345687");
		azienda.setCeo("giuseppe esposito");
		azienda.setIndirizzo("via roma n 35");
		azienda.setEmail("rcsolution@gmail.com");
		azienda.setTelefono("0815684867");
		azienda.setUsername("rcsolution");
		azienda.setPassword("rcsolution");
		azienda.setDomanda("il signore degli anelli");
		azienda.setDescrizione("relizzazione e manutenzione sistemi informativi per le banche");
		azienda.setLogo("img/tre.jpeg");
    }

    @AfterClass
    public static void tearDown() {
        azienda = null;
    }

    @Test
    public void testGetNome() {
        assertEquals("InfoSolution", azienda.getNome());
    }

    @Test
    public void testSetNome() {
        azienda.setNome("InfSol");

        assertEquals("InfSol", azienda.getNome());
    }

    @Test
    public void testGetPartitaIva() {
        assertEquals("20512345687", azienda.getPartitaIva());
    }
    
    @Test
    public void testSetPartitaIva() {
        azienda.setPartitaIva("23452345677");

        assertEquals("23452345677", azienda.getPartitaIva());
    }

    @Test
    public void testGetCeo() {
        assertEquals("giuseppe esposito", azienda.getCeo());
    }
    
    @Test
    public void testSetCeo() {
        azienda.setCeo("Gennaro Sposito");

        assertEquals("Gennaro Sposito", azienda.getCeo());
    }
    @Test
    public void testGetIndirizzo() {
        assertEquals("via roma n 35", azienda.getIndirizzo());
    }
    
    @Test
    public void testSetIndirizzo() {
        azienda.setIndirizzo("via Lombardi n 98");

        assertEquals("via Lombardi n 98", azienda.getIndirizzo());
    }

    @Test
    public void testGetEmail() {
        assertEquals("rcsolution@gmail.com", azienda.getEmail());
    }
    
    @Test
    public void testSetEmail() {
        azienda.setEmail("infSolution@gmail.com");

        assertEquals("infSolution@gmail.com", azienda.getEmail());
    }

    @Test
    public void testGetTelefono() {
        assertEquals("0815684867", azienda.getTelefono());
    }
    
    @Test
    public void testSetTelefono() {
        azienda.setTelefono("0818938657");

        assertEquals("0818938657", azienda.getTelefono());
    }

    @Test
    public void testGetUsername() {
        assertEquals("rcsolution", azienda.getUsername());
    }
    
    @Test
    public void testSetUsername() {
        azienda.setUsername("InfoSolution");

        assertEquals("InfoSolution", azienda.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("rcsolution", azienda.getPassword());
    }
    
    @Test
    public void testSetPassword() {
        azienda.setPassword("infosolution");

        assertEquals("infosolution", azienda.getPassword());
    }

    @Test
    public void testGetDomanda() {
        assertEquals("il signore degli anelli", azienda.getDomanda());
    }
    
    @Test
    public void testSetDomanda() {
        azienda.setDomanda("pirati dei caraibi");

        assertEquals("pirati dei caraibi", azienda.getDomanda());
    }

    @Test
    public void testGetDescrizione() {
        assertEquals("relizzazione e manutenzione sistemi informativi per le banche", azienda.getDescrizione());
    }
    
    @Test
    public void testSetDescrizione() {
        azienda.setDescrizione("programmazione front-end");

        assertEquals("programmazione front-end", azienda.getDescrizione());
    }

    @Test
    public void testGetLogo() {
        assertEquals("img/tre.jpeg", azienda.getLogo());
    }
    
    @Test
    public void testSetLogo() {
        azienda.setLogo("img/logo.jpeg");

        assertEquals("img/logo.jpeg", azienda.getLogo());
    }

} 