package control;

import static org.junit.Assert.*;

import bean.ConvenzioneBean;
import bean.QuestionarioAziendaBean;
import bean.QuestionarioStudenteBean;
import bean.TirocinioBean;
import control.ManagerDocumento;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;



public class ManagerDocumentoTest {

  private ManagerDocumento classUnderTest;

  private TirocinioBean tirocinio;
  private ConvenzioneBean convenzione;
  private QuestionarioStudenteBean questionarioStudente;
  private QuestionarioAziendaBean questionarioAzienda;
  
  private int idT;
  private int idC;
  private int idQS;
  private int idQA;
  
  /**
   * Setta classUnderTest e bean.
   * @throws Exception
   */
  
  @Before
  public void setUp() throws Exception {
    
    classUnderTest = new ManagerDocumento();
    tirocinio = new TirocinioBean();
    convenzione = new ConvenzioneBean();
    questionarioStudente = new QuestionarioStudenteBean();
    questionarioAzienda = new QuestionarioAziendaBean();
    
    idT = 1;
    idC = 1;
    idQS = 1;
    idQA = 1;
    
  }
  
  
  /**
   * Testa il metodo getTirocinio con un tirocinio gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testGetTirocinioPresenteInDB() throws SQLException {
    
    System.out.println("doRetrieveByKey di getTirocinio");
    
    tirocinio.setId(idT);
    TirocinioBean result = classUnderTest.getTirocinio(tirocinio);
    
    assertNotNull(result);  
    assertEquals(idT, result.getId());
    
  }

  
  /**
   * Testa il metodo getConvenzione con una convenzione gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testGetConvenzionePresenteInDB() throws SQLException {
    
    System.out.println("doRetrieveByKey di getConvenzione");
    
    convenzione.setId(idC);
    convenzione = classUnderTest.getConvenzione(convenzione);
    
    assertNotNull(convenzione);  
    assertEquals(idT, convenzione.getId());
    
  }
  
  
  /**
   * Testa il metodo getQuestionarioStudente con un questionario di uno studente gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testGetQuestionarioStudentePresenteInDB() throws SQLException {
    
    System.out.println("doRetrieveByKey di getQuestionarioStudente");
    
    questionarioStudente.setId(idQS);
    questionarioStudente = classUnderTest.getQuestionarioStudente(questionarioStudente);
    
    assertNotNull(questionarioStudente);  
    assertEquals(idT, questionarioStudente.getId());
    
  }
  
  
  /**
   * Testa il metodo getQuestionarioAzienda con un questionario di un'azienda gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testGetQuestionarioAziendaPresenteInDB() throws SQLException {
    
    System.out.println("doRetrieveByKey di getQuestionarioAzienda");
    
    questionarioAzienda.setId(idQA);
    questionarioAzienda = classUnderTest.getQuestionarioAzienda(questionarioAzienda);
    
    assertNotNull(questionarioAzienda);  
    assertEquals(idT, questionarioAzienda.getId());
    
  }
  

  /**
   * Testa il metodo getTirocinio con un tirocinio non presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testGetTirocinioNonPresenteInDB() throws SQLException {
    
    System.out.println("doRetrieveByKey di getTirocinio");
    
    tirocinio.setId(-8);
    tirocinio = classUnderTest.getTirocinio(tirocinio);
    
    assertNotNull(tirocinio);
  }
  
  
  /**
   * Testa il metodo getConvenzione con un convenzione non presente nel database.
   * @throws SQLException
   */

  @Test
  public void testGetConvenzioneNonPresenteInDB() throws SQLException {
    
    System.out.println("doRetrieveByKey di getConvenzione");
    
    convenzione.setId(-8);
    convenzione = classUnderTest.getConvenzione(convenzione);
    
    assertNotNull(convenzione);
  }
  
  
  /**
   * Testa il metodo getQuestionarioStudente con un questionario di uno studente non presente nel database.
   * @throws SQLException
   */

  @Test
  public void testGetQuestionarioStudenteNonPresenteInDB() throws SQLException {
    
    System.out.println("doRetrieveByKey di getQuestionarioStudente");
    
    questionarioStudente.setId(-8);
    questionarioStudente = classUnderTest.getQuestionarioStudente(questionarioStudente);
    
    assertNotNull(questionarioStudente);
  }
  
  /**
   * Testa il metodo getQuestionarioAzienda con un questionario di uno azienda non presente nel database.
   * @throws SQLException
   */

  @Test
  public void testGetQuestionarioAziendaNonPresenteInDB() throws SQLException {
    
    System.out.println("doRetrieveByKey di getQuestionarioAzienda");
    
    questionarioAzienda.setId(-8);
    questionarioAzienda = classUnderTest.getQuestionarioAzienda(questionarioAzienda);
    
    assertNotNull(questionarioAzienda);
  }
  
  
  /**
   * Testa il metodo salvaTirocinio con un tirocinio non presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaTirocinioNonInDB() throws SQLException {
    
    System.out.println("doSave di salvatirocinio");
    
    tirocinio = new TirocinioBean();
    tirocinio.setId(idT);
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
    
    classUnderTest.eliminaTirocinio(tirocinio);
    classUnderTest.salvaTirocinio(tirocinio);
    TirocinioBean result = classUnderTest.getTirocinio(tirocinio);
    
    assertNotNull(result);
    assertEquals("riccia", result.getStudente());
  }
  
  
  /**
   * Testa il metodo salvaConvenzione con una convenzione non presente nel database.
   * @throws SQLException
   */

  @Test
  public void testSalvaConvenzioneNonInDB() throws SQLException {
    
    System.out.println("doSave di salvaConvenzione");
    
    convenzione = new ConvenzioneBean();
    convenzione.setId(idC);
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
    
    classUnderTest.eliminaConvenzione(convenzione);
    classUnderTest.salvaConvenzione(convenzione);
    ConvenzioneBean result = classUnderTest.getConvenzione(convenzione);
    
    assertNotNull(result);
    assertEquals("tech", result.getAzienda());
  }
  
  /**
   *  Testa il metodo salvaQuestionarioStudente con un questionario non presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaQuestionarioStudenteNonInDB() throws SQLException {
    
    System.out.println("doSave di salvaQuestionarioStudente");
    
    questionarioStudente = new QuestionarioStudenteBean();
    
    questionarioStudente.setId(idQS);
    questionarioStudente.setStudente("riccia96");
    questionarioStudente.setAzienda("tech");
    questionarioStudente.setTutorAccademico("gravino");
    questionarioStudente.setImpiegato("ciacci");
    questionarioStudente.setPeriodo("20/10/2018 20/01/2019");
    questionarioStudente.setTitolo("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
    questionarioStudente.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioStudente.setConvalida(true);
    questionarioStudente.setUrl("pdf/questionarioStudenteRiccia.pdf");
    
    classUnderTest.eliminaQuestionarioStudente(questionarioStudente);
    classUnderTest.salvaQuestionarioStudente(questionarioStudente);
    
    QuestionarioStudenteBean result = classUnderTest.getQuestionarioStudente(questionarioStudente);
    
    assertNotNull(result);
    assertEquals("riccia96", result.getStudente());
  }
  
  /**
   *  Testa il metodo salvaQuestionarioAzienda con un questionario non presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaQuestionarioAziendaNonInDB() throws SQLException {
    
    System.out.println("doSave di salvaQuestionarioAzienda");
    
    questionarioAzienda = new QuestionarioAziendaBean();
    
    questionarioAzienda.setId(idQS);
    questionarioAzienda.setStudente("riccia96");
    questionarioAzienda.setAzienda("tech");
    questionarioAzienda.setTutorAccademico("gravino");
    questionarioAzienda.setImpiegato("ciacci");
    questionarioAzienda.setPeriodoTirocinio("20/10/2018 20/01/2019");
    questionarioAzienda.setTitoloTirocinio("Creazione di un web server "
          + "Joomla con Fabrik e accesso tramite ODBC");
    questionarioAzienda.setPosizioneRicoperta("direttore reparto 3");
    questionarioAzienda.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioAzienda.setConvalida(true);
    questionarioAzienda.setUrl("pdf/questionarioAziendaTechRiccia.pdf");
    
    classUnderTest.eliminaQuestionarioAzienda(questionarioAzienda);
    classUnderTest.salvaQuestionarioAzienda(questionarioAzienda);
    QuestionarioAziendaBean result = classUnderTest.getQuestionarioAzienda(questionarioAzienda);
    
    assertNotNull(result);
    assertEquals("tech", result.getAzienda());
  }
  
  /**
   * Testa il metodo salvaTirocinio con un tirocinio gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaTirocinioPresenteInDB() throws SQLException {

    System.out.println("doSave di tirocinio");
    
    tirocinio = new TirocinioBean();
    tirocinio.setStudente("riccia");
    tirocinio.setAzienda("deloitte");
    tirocinio.setTutorAccademico("vaccaro");
    tirocinio.setImpiegato("giostorti");
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
    
    boolean exc = false;
    
    try {
      classUnderTest.salvaTirocinio(tirocinio);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   * Testa il metodo salvaConvenzione con una convenzione gia presente nel database.
   * @throws SQLException
   */

  @Test
  public void testSalvaConvenzionePresenteInDB() throws SQLException {
    
    System.out.println("doSave di salvaConvenzione");
    
    convenzione = new ConvenzioneBean();
    convenzione.setId(idC);
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
    
    boolean exc = false;
    try{
      classUnderTest.salvaConvenzione(convenzione);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   *  Testa il metodo salvaQuestionarioStudente con un questionario gia presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaQuestionarioStudentePresenteInDB() throws SQLException {
    
    System.out.println("doSave di salvaQuestionarioStudente");
    
    questionarioStudente = new QuestionarioStudenteBean();
    
    questionarioStudente.setId(idQS);
    questionarioStudente.setStudente("riccia96");
    questionarioStudente.setAzienda("tech");
    questionarioStudente.setTutorAccademico("gravino");
    questionarioStudente.setImpiegato("ciacci");
    questionarioStudente.setPeriodo("20/10/2018 20/01/2019");
    questionarioStudente.setTitolo("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
    questionarioStudente.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioStudente.setConvalida(true);
    questionarioStudente.setUrl("pdf/questionarioStudenteRiccia.pdf");
    
    boolean exc = false;
    
    try{
      classUnderTest.salvaQuestionarioStudente(questionarioStudente);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   *  Testa il metodo salvaQuestionarioAzienda con un questionario gia presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaQuestionarioAziendaPresenteInDB() throws SQLException {
    
    System.out.println("doSave di salvaQuestionarioAzienda");
    
    questionarioAzienda = new QuestionarioAziendaBean();
    
    questionarioAzienda.setId(idQS);
    questionarioAzienda.setStudente("riccia96");
    questionarioAzienda.setAzienda("tech");
    questionarioAzienda.setTutorAccademico("gravino");
    questionarioAzienda.setImpiegato("ciacci");
    questionarioAzienda.setPeriodoTirocinio("20/10/2018 20/01/2019");
    questionarioAzienda.setTitoloTirocinio("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
    questionarioAzienda.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioAzienda.setConvalida(true);
    questionarioAzienda.setUrl("pdf/questionarioAziendaTechRiccia.pdf");
    
    boolean exc = false;
    
    try{
      classUnderTest.salvaQuestionarioAzienda(questionarioAzienda);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   * Testa il metodo salvaTirocinio con dati sul tirocinio non completi
   * @throws SQLException
   */
  
  @Test
  public void testSalvaTirocinioNonCompleto() throws SQLException {
     
    System.out.println("doSave di salvaTirocino");
    
    tirocinio = new TirocinioBean();
    tirocinio.setStudente("riccia");
    tirocinio.setAzienda("deloitte");
    tirocinio.setTutorAccademico("vaccaro");
    tirocinio.setImpiegato("giostorti");
    tirocinio.setAnnoAccademico("2019");
    tirocinio.setCfu(6);
    tirocinio.setHandicap(false);
    tirocinio.setSedeTirocinio("napoli");
    //manca titolo tirocinio
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
    
    boolean exc = false;
    
    try {
      classUnderTest.salvaTirocinio(tirocinio);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   * Testa il metodo salvaConvenzione con dati sulla convenzione non completi.
   * @throws SQLException
   */

  @Test
  public void testSalvaConvenzioneNonCompleto() throws SQLException {
    
    System.out.println("doSave di salvaConvenzione");
    
    convenzione = new ConvenzioneBean();
    convenzione.setId(idC);
    convenzione.setAzienda("tech");
    convenzione.setTutorAccademico("gravino");
    convenzione.setImpiegato("ciacci");
    convenzione.getLuogoNascitaCeo();
    convenzione.getDataNascitaCeo();
    //manca il numero di dipendenti
    convenzione.getReferente();
    convenzione.setTelefonoReferente("328 56 78 569");
    convenzione.getEmailReferente();
    convenzione.getAttivita();
    convenzione.isConvalida();
    convenzione.getUrl();
    
    boolean exc = false;
    try{
      classUnderTest.salvaConvenzione(convenzione);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   *  Testa il metodo salvaQuestionarioStudente con dati sul questionario non completi.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaQuestionarioStudenteNonCompleto() throws SQLException {
    
    System.out.println("doSave di salvaQuestionarioStudente");
    
    questionarioStudente = new QuestionarioStudenteBean();
    
    questionarioStudente.setId(idQS);
    questionarioStudente.setStudente("riccia96");
    questionarioStudente.setAzienda("tech");
    questionarioStudente.setTutorAccademico("gravino");
    questionarioStudente.setImpiegato("ciacci");
    //manca il periodo del tirocinio
    questionarioStudente.setTitolo("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
    questionarioStudente.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioStudente.setConvalida(true);
    questionarioStudente.setUrl("pdf/questionarioStudenteRiccia.pdf");
    
    boolean exc = false;
    
    try{
      classUnderTest.salvaQuestionarioStudente(questionarioStudente);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   *  Testa il metodo salvaQuestionarioAzienda con dati sul questionario non completi.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaQuestionarioAziendaNonCompleto() throws SQLException {
    
    System.out.println("doSave di salvaQuestionarioAzienda");
    
    questionarioAzienda = new QuestionarioAziendaBean();
    
    questionarioAzienda.setId(idQS);
    questionarioAzienda.setStudente("riccia96");
    questionarioAzienda.setAzienda("tech");
    questionarioAzienda.setTutorAccademico("gravino");
    questionarioAzienda.setImpiegato("ciacci");
    //manca il periodo del tirocinio
    questionarioAzienda.setTitoloTirocinio("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
    questionarioAzienda.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioAzienda.setConvalida(true);
    questionarioAzienda.setUrl("pdf/questionarioAziendaTechRiccia.pdf");
    
    boolean exc = false;
    
    try{
      classUnderTest.salvaQuestionarioAzienda(questionarioAzienda);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   * Testa il metodo aggiornaTirocinio con dati completi e un tirocinio gi� presente nel database
   * @throws SQLException 
   */
  
  @Test
  public void testAggiornaTirocinioPresenteInDB() throws SQLException {
    
    System.out.println("doUpdate di aggiornaTirocinio");
    
    tirocinio.setId(idT);
    tirocinio = classUnderTest.getTirocinio(tirocinio);
    
    tirocinio.setAnnoAccademico("2018");
    tirocinio.setCfu(3);
    
    classUnderTest.aggiornaTirocinio(tirocinio);
    
    tirocinio = classUnderTest.getTirocinio(tirocinio);
    
    assertEquals("2018", tirocinio.getAnnoAccademico());
    
  }
  
  /**
   * Testa il metodo aggiornaConvenzione con dati completi e una convenzione gi� presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAgiornaConvenzionePresenteInDB() throws SQLException {
    
    System.out.println("doUpdate di aggiornaConvenzione");
    
    convenzione.setId(idC);
    convenzione = classUnderTest.getConvenzione(convenzione);
    
    convenzione.setNumeroDipendenti(45);
    convenzione.setTelefonoReferente("3385962486");
    convenzione.setConvalida(true);
    
    classUnderTest.aggiornaConvenzione(convenzione);
    
    ConvenzioneBean result = classUnderTest.getConvenzione(convenzione);
    
    assertEquals(45, result.getNumeroDipendenti());
  }
  
  /**
   *  Testa il metodo aggiornaQuestionarioStudente con dati completi e un questionario gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testAgiornaQuestionarioStudentePresenteInDB() throws SQLException {
    
    System.out.println("doUpdate di aggiornaQuestionarioStudente");
    
    questionarioStudente.setId(idQS);
    questionarioStudente = classUnderTest.getQuestionarioStudente(questionarioStudente);
    
    questionarioStudente.setPeriodo("18/02/2019 18/08/2019");
    questionarioStudente.setConvalida(true);
    
    classUnderTest.aggiornaQuestionarioStudente(questionarioStudente);
    
    QuestionarioStudenteBean result = classUnderTest.getQuestionarioStudente(questionarioStudente);
    
    assertEquals("18/02/2019 18/08/2019", result.getPeriodo());
  }
  
  /**
   *  Testa il metodo aggiornaQuestionarioAzienda con dati completi e un questionario gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testAgiornaQuestionarioAziendaPresenteInDB() throws SQLException {
    
    System.out.println("doUpdate di aggiornaQuestionarioAzienda");
        
    questionarioAzienda.setId(idQS);
    questionarioAzienda = classUnderTest.getQuestionarioAzienda(questionarioAzienda);
    
    questionarioAzienda.setPeriodoTirocinio("18/02/2019 18/08/2019");
    questionarioAzienda.setConvalida(true);
    
    classUnderTest.aggiornaQuestionarioAzienda(questionarioAzienda);
    
    QuestionarioAziendaBean result = classUnderTest.getQuestionarioAzienda(questionarioAzienda);
    
    assertEquals("18/02/2019 18/08/2019", result.getPeriodoTirocinio());
    
  }
  
  /**
   * Testa il metodo aggiornaTirocinio con dati non completi e un tirocinio gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testAggiornaTirocinioPresenteInDBNonCompleto() throws SQLException {
    
    System.out.println("doUpdate di aggiornaTirocinio");
    
    tirocinio = new TirocinioBean();
    
    tirocinio.setAnnoAccademico("2019");
    tirocinio.setFacilitazioni("buoni pasto utilizzabili in mensa");
    tirocinio.setId(idT);
    
    boolean exc = false;
    
    try {
      classUnderTest.aggiornaTirocinio(tirocinio);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
    
  }
  
  /**
   * Testa il metodo aggiornaConvenzione con dati non completi e una convenzione gi� presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAgiornaConvenzionePresenteInDBNonCompleto() throws SQLException {
    
    System.out.println("doUpdate di aggiornaConvenzione");
    
    convenzione.setId(idC);    
    convenzione.setNumeroDipendenti(45);
    convenzione.setTelefonoReferente("3385962486");
    convenzione.setConvalida(true);
    
    boolean exc = false;
    
    try {
    classUnderTest.aggiornaConvenzione(convenzione);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
    
  }
  
  /**
   *  Testa il metodo aggiornaQuestionarioStudente con dati non completi e un questionario gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testAgiornaQuestionarioStudentePresenteInDBNonCompleto() throws SQLException {
    
    System.out.println("doUpdate di aggiornaQuestionarioStudente");
    
    questionarioStudente.setId(idQS);
    questionarioStudente.setPeriodo("18/02/2019 18/08/2019");
    questionarioStudente.setConvalida(true);
    
    boolean exc = false;
    
    try {
    classUnderTest.aggiornaQuestionarioStudente(questionarioStudente);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
    
  }
  
  /**
   *  Testa il metodo aggiornaQuestionarioAzienda con dati non completi e un questionario gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testAgiornaQuestionarioAziendaPresenteInDBNonCompleto() throws SQLException {
    
    System.out.println("doUpdate di aggiornaQuestionarioAzienda");
        
    questionarioAzienda.setId(idQS);    
    questionarioAzienda.setPeriodoTirocinio("18/02/2019 18/08/2019");
    questionarioAzienda.setConvalida(true);
    
    boolean exc = false;
    
    try {
    classUnderTest.aggiornaQuestionarioAzienda(questionarioAzienda);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
    
  }
  
  /**
   * Testa il metodo getTirocini senza order
   * @throws SQLException
   */
  
  @Test
  public void testGetTirociniSenzaOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getTirocini");
    
    ArrayList<TirocinioBean> list = (ArrayList<TirocinioBean>) classUnderTest.getTirocini(null);
    
    assertNotNull(list);
    
  }
  
  /**
   * Testa il metodo getConvenzioni senza order
   * @throws SQLException
   */
  
  @Test
  public void testGetConvenzioniSenzaOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getConvenzioni");
    
    ArrayList<ConvenzioneBean> list = (ArrayList<ConvenzioneBean>) classUnderTest.getConvenzioni(null);
    
    assertNotNull(list);
    
  }
  
  /**
   * Testa il metodo getQuestionariStudente senza order
   * @throws SQLException
   */
  
  @Test
  public void testGetQuestionariStudentiSenzaOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getQuestionariStudente");
    
    ArrayList<QuestionarioStudenteBean> list = (ArrayList<QuestionarioStudenteBean>) classUnderTest.getQuestionariStudente(null);
    
    assertNotNull(list);
    
  }
  
  /**
   * Testa il metodo getQuestionariAzienda senza order
   * @throws SQLException
   */
  
  @Test
  public void testGetQuestionariAziendaSenzaOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getQuestionariAzienda");
    
    ArrayList<QuestionarioAziendaBean> list = (ArrayList<QuestionarioAziendaBean>) classUnderTest.getQuestionariAzienda(null);
    
    assertNotNull(list);
    
  }
  
  /**
   * Testa il metodo getTirocini con order
   * @throws SQLException
   */
  
  @Test
  public void testGetTirociniConOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getTirocini");
    
    ArrayList<TirocinioBean> list = (ArrayList<TirocinioBean>) classUnderTest.getTirocini("id ASC");
    
    assertNotNull(list);
    
  }
  
  /**
   * Testa il metodo getConvenzioni con order
   * @throws SQLException
   */
  
  @Test
  public void testGetConvenzioniConOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getConvenzioni");
    
    ArrayList<ConvenzioneBean> list = (ArrayList<ConvenzioneBean>) classUnderTest.getConvenzioni("id ASC");
    
    assertNotNull(list);
    
  }
  
  /**
   * Testa il metodo getQuestionariStudente con order
   * @throws SQLException
   */
  
  @Test
  public void testGetQuestionariStudentiConOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getQuestionariStudente");
    
    ArrayList<QuestionarioStudenteBean> list = (ArrayList<QuestionarioStudenteBean>) classUnderTest.getQuestionariStudente("id ASC");
    
    assertNotNull(list);
    
  }
  
  /**
   * Testa il metodo getQuestionariAzienda con order
   * @throws SQLException
   */
  
  @Test
  public void testGetQuestionariAziendaConOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getQuestionariAzienda");
    
    ArrayList<QuestionarioAziendaBean> list = (ArrayList<QuestionarioAziendaBean>) classUnderTest.getQuestionariAzienda("id ASC");
    
    assertNotNull(list);
    
  }
  
  /**
   * Testa il metodo eliminaTirocinio con un tirocinio gi� presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testEliminaTirocinioPresenteInDB() throws SQLException {
    
    System.out.println("doDelete di eliminaTirocinio");
    
    tirocinio = new TirocinioBean();
    
    tirocinio.setId(idT);
    tirocinio.setStudente("riccia");
    tirocinio.setAzienda("deloitte");
    tirocinio.setTutorAccademico("vaccaro");
    tirocinio.setImpiegato("giostorti");
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
    
    classUnderTest.salvaTirocinio(tirocinio);
    
    boolean deleted = classUnderTest.eliminaTirocinio(tirocinio);
    
    assertTrue(deleted);
    
  }
  
  /**
   * Testa il metodo eliminaConvenzione con una convenzione presente nel database
   * @throws SQLException
   */
  
  @Test
  public void testEliminaConvenzionePresenteInDB() throws SQLException {
    
    System.out.println("doDelete di eliminaConvenzione");
    
    convenzione = new ConvenzioneBean();
    convenzione.setId(idC);
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
    
    classUnderTest.salvaConvenzione(convenzione);
    
    boolean deleted = classUnderTest.eliminaConvenzione(convenzione);
    
    assertNotNull(deleted);
    
  }
  
  /**
   * Testa il metodo eliminaQuestionarioStudente con un questionario presente nel database
   * @throws SQLException
   */
  
  @Test
  public void testEliminaQuestionarioStudentePresenteInDB() throws SQLException {
    
    System.out.println("doDeleted di salvaQuestionarioStudente");
    
    questionarioStudente = new QuestionarioStudenteBean();
    
    questionarioStudente.setId(idQS);
    questionarioStudente.setStudente("riccia96");
    questionarioStudente.setAzienda("tech");
    questionarioStudente.setTutorAccademico("gravino");
    questionarioStudente.setImpiegato("ciacci");
    questionarioStudente.setPeriodo("20/10/2018 20/01/2019");
    questionarioStudente.setTitolo("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
    questionarioStudente.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioStudente.setConvalida(true);
    questionarioStudente.setUrl("pdf/questionarioStudenteRiccia.pdf");
    
    classUnderTest.salvaQuestionarioStudente(questionarioStudente);
    
    boolean deleted = classUnderTest.eliminaQuestionarioStudente(questionarioStudente);
    
    assertNotNull(deleted);
    
  }
  
  /**
   * Testa il metodo eliminaQuestionarioAzienda con un questionario presente nel database
   * @throws SQLException
   */
  
  @Test
  public void testEliminaQuestionarioAziendaPresenteInDB() throws SQLException {
    
    System.out.println("doDelete di eliminaQuestionarioAzienda");
    
    questionarioAzienda = new QuestionarioAziendaBean();
    
    questionarioAzienda.setId(idQS);
    questionarioAzienda.setStudente("riccia96");
    questionarioAzienda.setAzienda("tech");
    questionarioAzienda.setTutorAccademico("gravino");
    questionarioAzienda.setImpiegato("ciacci");
    questionarioAzienda.setPeriodoTirocinio("20/10/2018 20/01/2019");
    questionarioAzienda.setTitoloTirocinio("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
    questionarioAzienda.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioAzienda.setConvalida(true);
    questionarioAzienda.setUrl("pdf/questionarioAziendaTechRiccia.pdf");
    
    classUnderTest.salvaQuestionarioAzienda(questionarioAzienda);
    
    boolean deleted = classUnderTest.eliminaQuestionarioAzienda(questionarioAzienda);
    
    assertTrue(deleted);
  }
  
  /**
   * Testa il metodo eliminaTirocinio con un tirocinio non presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testEliminaTirocinioNonPresenteInDB() throws SQLException {
    
    System.out.println("doDelete di eliminaTirocinio");
    
    tirocinio = new TirocinioBean();
    
    tirocinio.setId(10);
    tirocinio.setStudente("sesposito");
    tirocinio.setAzienda("deloitte");
    tirocinio.setTutorAccademico("deprisco");
    tirocinio.setImpiegato("giostorti");
    tirocinio.setAnnoAccademico("2020");
    tirocinio.setCfu(12);
    tirocinio.setHandicap(false);
    tirocinio.setSedeTirocinio("milano");
    tirocinio.setAccessoLocali("dalle 8 alle 13 e dalle 14 alle 19 dal lunedi al venerdi");
    tirocinio.setPeriodoTirocinio("6 mesi");
    tirocinio.setObiettivoTirocinio("completare un sistema di rete telefonica innovativo gia avviato");
    tirocinio.setFacilitazioni("buoni pasto da consumare nella mensa della ditta");
    tirocinio.setConvalidaAzienda(true);
    tirocinio.setConvalidaStudente(true);
    tirocinio.setConvalidaTutor(true);
    tirocinio.setConvalidaAttivita(true);
    tirocinio.setRegistroOre("pdf/sEspositoRegistroOre.pdf");
    tirocinio.setQuestionarioStudente(10);
    tirocinio.setQuestionarioAzienda(10);
    tirocinio.setUrl("pdf/sEspositoTirocinio.pdf");
    
    boolean deleted = classUnderTest.eliminaTirocinio(tirocinio);
    
    assertTrue(deleted);
    
  }
  
  /**
   * Testa il metodo eliminaConvenzione con una convenzione non presente nel database
   * @throws SQLException
   */
  
  @Test
  public void testEliminaConvenzioneNonPresenteInDB() throws SQLException {
    
    System.out.println("doDelete di eliminaConvenzione");
    
    convenzione = new ConvenzioneBean();
    convenzione.setId(10);
    convenzione.setAzienda("deloitte");
    convenzione.setTutorAccademico("deprisco");
    convenzione.setImpiegato("giostorti");
    convenzione.getLuogoNascitaCeo();
    convenzione.getDataNascitaCeo();
    convenzione.getNumeroDipendenti();
    convenzione.getReferente();
    convenzione.setTelefonoReferente("328 56 78 569");
    convenzione.getEmailReferente();
    convenzione.getAttivita();
    convenzione.isConvalida();
    convenzione.getUrl();
        
    boolean deleted = classUnderTest.eliminaConvenzione(convenzione);
    
    assertNotNull(deleted);
    
  }
  
  /**
   * Testa il metodo eliminaQuestionarioStudente con un questionario non presente nel database
   * @throws SQLException
   */
  
  @Test
  public void testEliminaQuestionarioStudenteNonPresenteInDB() throws SQLException {
    
    System.out.println("doDeleted di salvaQuestionarioStudente");
    
    questionarioStudente = new QuestionarioStudenteBean();
    
    questionarioStudente.setId(10);
    questionarioStudente.setStudente("sesposito");
    questionarioStudente.setAzienda("deloitte");
    questionarioStudente.setTutorAccademico("deprisco");
    questionarioStudente.setImpiegato("giostorti");
    questionarioStudente.setPeriodo("20/10/2018 20/01/2019");
    questionarioStudente.setTitolo("Creazione di un web server Joomla con Fabrik e accesso tramite ODBC");
    questionarioStudente.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioStudente.setConvalida(true);
    questionarioStudente.setUrl("pdf/questionarioStudenteRiccia.pdf");
        
    boolean deleted = classUnderTest.eliminaQuestionarioStudente(questionarioStudente);
    
    assertNotNull(deleted);
    
  }
  
  /**
   * Testa il metodo eliminaQuestionarioAzienda con un questionario non presente nel database
   * @throws SQLException
   */
  
  @Test
  public void testEliminaQuestionarioAziendaNonPresenteInDataBase() throws SQLException {
    
    System.out.println("doDelete di eliminaQuestionarioAzienda");
    
    questionarioAzienda = new QuestionarioAziendaBean();
    
    questionarioAzienda.setId(10);
    questionarioAzienda.setStudente("sesposito");
    questionarioAzienda.setAzienda("deloitte");
    questionarioAzienda.setTutorAccademico("deprisco");
    questionarioAzienda.setImpiegato("giostorti");
    questionarioAzienda.setPeriodoTirocinio("20/10/2018 20/01/2019");
    questionarioAzienda.setTitoloTirocinio("Creazione di un web server Joomla con Fabrik"
        + " e accesso tramite ODBC");
    questionarioAzienda.setScelte("uno*uno*uno*uno*uno*uno*uno*uno*uno*uno**");
    questionarioAzienda.setConvalida(true);
    questionarioAzienda.setUrl("pdf/questionarioAziendaTechRiccia.pdf");
        
    boolean deleted = classUnderTest.eliminaQuestionarioAzienda(questionarioAzienda);
    
    assertTrue(deleted);
  }
}
