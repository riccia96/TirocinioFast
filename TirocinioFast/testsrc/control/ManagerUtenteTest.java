package control;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import bean.AziendaBean;
import bean.ImpiegatoBean;
import bean.StudenteBean;
import bean.TutorBean;

public class ManagerUtenteTest {

  private ManagerUtente classUnderTest;
  
  private StudenteBean studente;
  private AziendaBean azienda;
  private TutorBean tutor;
  private ImpiegatoBean impiegato;
  
  private String usernameS;
  private String usernameA;
  private String usernameT;
  private String usernameI;

  
  /**
   * Setta classUnderTest e bean.
   * @throws Exception
   */
  
  @Before
  public void setUp() throws Exception{

    classUnderTest = new ManagerUtente();
    studente = new StudenteBean();
    azienda = new AziendaBean();
    tutor = new TutorBean();
    impiegato = new ImpiegatoBean();
    
    usernameS = "riccia96";
    usernameA = "tech";
    usernameT = "ferrucci";
    usernameI = "derosa";
    
  }
  
  
  /**
   * Testa il metodo getStudente con uno studente già presente nel database.
   *  @throws SQLException
   */
  
  @Test
  public void testGetStudentePresenteInDB() throws SQLException {

    System.out.println("doRetrieveByKey di getStudente");

    studente.setUsername(usernameS);
    
    studente = classUnderTest.getStudente(studente);

    assertNotNull(studente);
    assertEquals(usernameS, studente.getUsername());

  }
  
  
  /**
   * Testa il metodo getAzienda con un'azienda già presente nel database.
   *  @throws SQLException
   */
  
  @Test
  public void testGetAziendaPresenteInDB() throws SQLException{
    
    System.out.println("doRetrieveByKey di getAzienda");
    
    azienda.setUsername(usernameA);
    
    azienda = classUnderTest.getAzienda(azienda);
    
    assertNotNull(azienda);
    assertEquals(usernameA, azienda.getUsername());
  }
  
  
  /**
   * Testa il metodo getTutor con un tutor già presente nel database.
   *  @throws SQLException
   */
  
  @Test
  public void testGetTutorPresenteInDB() throws SQLException{
    
    System.out.println("doRetrieveByKey di getTutor");
    
    tutor.setUsername(usernameT);
    
    tutor = classUnderTest.getTutor(tutor);
    
    assertNotNull(tutor);
    assertEquals(usernameT, tutor.getUsername());
  }
  

  /**
   * Testa il metodo getImpiegato con un impiegato già presente nel database.
   *  @throws SQLException
   */
  
  @Test
  public void testGetImpiegatoPresenteInDB() throws SQLException{
    
    System.out.println("doRetrieveByKey di getImpiegato");
    
    impiegato.setUsername(usernameI);
    
    impiegato = classUnderTest.getImpiegato(impiegato);
    
    assertNotNull(impiegato);
    assertEquals(usernameI, impiegato.getUsername());
  }
  
  
  /**
   * Testa il metodo getStudente con uno studente non presente nel database.
   *  @throws Exception
   */
  
  @Test
  public void testGetStudenteNonPresenteInDB() throws SQLException {

    System.out.println("doRetrieveByKey di getStudente");

    studente.setUsername("mancante");
    studente = classUnderTest.getStudente(studente);

    assertNotNull(studente);

  }
  
  
  /**
   * Testa il metodo getAzienda con un'azienda non presente nel database.
   *  @throws SQLException
   */
  
  @Test
  public void testGetAziendaNonPresenteInDB() throws SQLException{
    
    System.out.println("doRetrieveByKey di getAzienda");
    
    azienda.setUsername("mancante");
    
    azienda = classUnderTest.getAzienda(azienda);
    
    assertNotNull(azienda);
  }
  
  
  /**
   * Testa il metodo getTutor con un tutor non presente nel database.
   *  @throws SQLException
   */
  
  @Test
  public void testGetTutorNonPresenteInDB() throws SQLException{
    
    System.out.println("doRetrieveByKey di getTutor");
    
    tutor.setUsername("mancante");
    
    tutor = classUnderTest.getTutor(tutor);
    
    assertNotNull(tutor);
  }
  
  
  /**
   * Testa il metodo getImpiegato con un impiegato non presente nel database.
   *  @throws SQLException
   */
  
  @Test
  public void testGetImpiegatoNonPresenteInDB() throws SQLException{
    
    System.out.println("doRetrieveByKey di getImpiegato");
    
    impiegato.setUsername("mancante");
    
    impiegato = classUnderTest.getImpiegato(impiegato);
    
    assertNotNull(impiegato);
  }

  
  /**
   * Testa il metodo salvaStudente con uno studente non presente nel database.
   * @throws SQLException
   */

  @Test
  public void testSalvaStudenteNonPresenteInDB() throws SQLException {

    System.out.println("doSave di salvaStudente");

    studente = new StudenteBean();
    studente.setNome("Anna");
    studente.setCognome("Riccio");
    studente.setLuogoNascita("Napoli");
    studente.setDataNascita("04/09/1996");
    studente.setIndirizzo("Via Scotola n° 86");
    studente.setCitta("Pomigliano d'Arco");
    studente.setCodiceFiscale("rccnmr96py44kr7y");
    studente.setMatricola("0512103799");
    studente.setEmail("a.riccio26@studenti.unisa.it");
    studente.setTelefono("3284956948");
    studente.setUsername("riccia");
    studente.setPassword("riccia");
    studente.setDomanda("riccia");

    classUnderTest.eliminaStudente(studente);
    classUnderTest.salvaStudente(studente);
    StudenteBean result = classUnderTest.getStudente(studente);

    assertNotNull(result);
    assertEquals("riccia", result.getUsername());
  }
  
  
  /**
   *  Testa il metodo salvaAzienda con un'azienda non presente nel database.
   * @throws SQLException
   */
  
  @Test
  public void testSalvaAziendaNonPresenteInDB() throws SQLException {
    
    System.out.println("doSave di salvaAzienda");
    
    azienda.setNome("rc solution");
    azienda.setPartitaIva("20512345687");
    azienda.setCeo("giuseppe esposito");
    azienda.setIndirizzo("via roma n 35");
    azienda.setEmail("rcsolution@gmail.com");
    azienda.setTelefono("0815684867");
    azienda.setUsername("rcsolution");
    azienda.setPassword("rcsolution");
    azienda.setDomanda("il signore degli anelli");
    azienda.setDescrizione("relaizzazione e manutenzione sistemi informativi per le banche");
    azienda.setLogo("img/tre.jpeg");
    
    classUnderTest.salvaAzienda(azienda);
    
    AziendaBean result = classUnderTest.getAzienda(azienda);
    
    assertNotNull(result);
    assertEquals("rcsolution", result.getUsername());
  }
  
  /**
   *  Testa il metodo salvaTutor con un tutor non presente nel database.
   * @throws SQLException
   */
  @Test
  public void testSalvaTutorNonPresenteInDB() throws SQLException{
    
    System.out.println("doSave di salvaTutor");
    
    tutor.setNome("roberto");
    tutor.setCognome("de prisco");
    tutor.setMatricola("0542300032");
    tutor.setEmail("rob.dep@gmail.com");
    tutor.setUsername("robdep");
    tutor.setPassword("robdeprisco");
    tutor.setDomanda("il mondo nuovo");
    
    classUnderTest.salvaTutor(tutor);
    
    TutorBean result = classUnderTest.getTutor(tutor);
    
    assertNotNull(result);
    assertEquals("robdep", result.getUsername());
  }
  
  /**
   *  Testa il metodo salvaImpiegato con un impiegato non presente nel database.
   * @throws SQLException
   */
  @Test
  public void testSalvaImpiegatoNonPresenteInDB() throws SQLException{
    
    System.out.println("doSave di salvaImpiegato");
    
    impiegato.setNome("giorgio");
    impiegato.setCognome("esposito");
    impiegato.setMatricola("0000000002");
    impiegato.setEmail("gioesp@gmail.com");
    impiegato.setUsername("gio.esp");
    impiegato.setPassword("giorgioesposito");
    impiegato.setDomanda("il mondo nuovo");
    
    classUnderTest.salvaImpiegato(impiegato);
    
    ImpiegatoBean result = classUnderTest.getImpiegato(impiegato);
    
    assertNotNull(result);
    assertEquals("gio.esp", result.getUsername());
  }
  
  /**
   * Testa il metodo salvaStudente con uno studente già presente nel database.
   * @throws SQLException
   */

  @Test
  public void testSalvaStudentePresenteInDB() throws SQLException {

    System.out.println("doSave di salvaStudente");

    studente = new StudenteBean();
    studente.setNome("Anna");
    studente.setCognome("Riccio");
    studente.setLuogoNascita("Napoli");
    studente.setDataNascita("04/09/1996");
    studente.setIndirizzo("Via Scotola n° 86");
    studente.setCitta("Pomigliano d'Arco");
    studente.setCodiceFiscale("rccnmr96py44kr7y");
    studente.setMatricola("0512103799");
    studente.setEmail("a.riccio26@studenti.unisa.it");
    studente.setTelefono("3284956948");
    studente.setUsername("riccia");
    studente.setPassword("riccia");
    studente.setDomanda("riccia");

    boolean exc = false;
    try {
      classUnderTest.salvaStudente(studente);
    } catch (SQLException e) {
      exc = true;
    }

    assertTrue(exc);

  }
  
  /**
   *  Testa il metodo salvaAzienda con un'azienda gi� presente nel database.
   * @throws SQLException
   */
  @Test
  public void testSalvaAziendaPresenteInDB() throws SQLException {
    
    System.out.println("doSave di salvaAzienda");
    
    azienda.setNome("rc solution");
    azienda.setPartitaIva("20512345687");
    azienda.setCeo("giuseppe esposito");
    azienda.setIndirizzo("via roma n 35");
    azienda.setEmail("rcsolution@gmail.com");
    azienda.setTelefono("0815684867");
    azienda.setUsername("rcsolution");
    azienda.setPassword("rcsolution");
    azienda.setDomanda("il signore degli anelli");
    azienda.setDescrizione("relaizzazione e manutenzione sistemi informativi per le banche");
    azienda.setLogo("img/tre.jpeg");
    
    boolean exc = false;
    try{
      classUnderTest.salvaAzienda(azienda);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);  
  }
  
  /**
   *  Testa il metodo salvaTutor con un tutor gi� presente nel database.
   * @throws SQLException
   */
  @Test
  public void testSalvaTutorPresenteInDB() throws SQLException{
    
    System.out.println("doSave di salvaTutor");
    
    tutor.setNome("roberto");
    tutor.setCognome("de prisco");
    tutor.setMatricola("0542300032");
    tutor.setEmail("rob.dep@gmail.com");
    tutor.setUsername("robdep");
    tutor.setPassword("robdeprisco");
    tutor.setDomanda("il mondo nuovo");
    
    boolean exc = false;
    try{
      classUnderTest.salvaTutor(tutor);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   *  Testa il metodo salvaImpiegato con un impiegato gi� presente nel database.
   * @throws SQLException
   */
  @Test
  public void testSalvaImpiegatoPresenteInDB() throws SQLException{
    
    System.out.println("doSave di salvaImpiegato");
    
    impiegato.setNome("giorgio");
    impiegato.setCognome("esposito");
    impiegato.setMatricola("0000000002");
    impiegato.setEmail("gioesp@gmail.com");
    impiegato.setUsername("gio.esp");
    impiegato.setPassword("giorgioesposito");
    impiegato.setDomanda("il mondo nuovo");
    
    boolean exc = false;
    try{
      classUnderTest.salvaImpiegato(impiegato);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }

  /**
   * Testa il metodo salvaStudente con dati sullo studente non completi.
   * @throws SQLException
   */

  @Test
  public void testSalvaStudenteNonCompleto() throws SQLException {

    System.out.println("doSave di salvaStudente");

    studente = new StudenteBean();
    studente.setNome("Anna");
    studente.setCognome("Riccio");
    studente.setLuogoNascita("Napoli");
    studente.setDataNascita("04/09/1996");
    studente.setIndirizzo("Via Scotola n° 20");
    studente.setCitta("Pomigliano d'Arco");
    // manca codice fiscale
    studente.setMatricola("0512103799");
    studente.setEmail("a.riccio26@studenti.unisa.it");
    studente.setTelefono("3284956948");
    studente.setUsername("AnnaRiccio");
    studente.setPassword("AnnaRiccio");
    studente.setDomanda("Naruto");

    boolean exc = false;
    try {
      classUnderTest.salvaStudente(studente);
    } catch (SQLException e) {
      exc = true;
    }

    assertTrue(exc);

  }
  
  /**
   *  Testa il metodo salvaAzienda con dati sull'azienda non completi.
   * @throws SQLException
   */
  @Test
  public void testSalvaAziendaNonCompleto() throws SQLException {
    
    System.out.println("doSave di salvaAzienda");
    
    azienda.setNome("rc solution");
    azienda.setPartitaIva("20512345687");
    azienda.setCeo("giuseppe esposito");
    azienda.setIndirizzo("via roma n 35");
    azienda.setEmail("rcsolution@gmail.com");
    azienda.setTelefono("0815684867");
    //username mancante
    azienda.setPassword("rcsolution");
    azienda.setDomanda("il signore degli anelli");
    azienda.setDescrizione("relaizzazione e manutenzione sistemi informativi per le banche");
    azienda.setLogo("img/tre.jpeg");
    
    boolean exc = false;
    try{
      classUnderTest.salvaAzienda(azienda);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }

  /**
   *  Testa il metodo salvaTutor con dati sul tutor incompleti.
   * @throws SQLException
   */
  @Test
  public void testSalvaTutorNonCompleto() throws SQLException{
    
    System.out.println("doSave di salvaTutor");
    
    tutor.setNome("roberto");
    tutor.setCognome("de prisco");
    tutor.setMatricola("0542300032");
    tutor.setEmail("rob.dep@gmail.com");
    //username mancante
    tutor.setPassword("robdeprisco");
    tutor.setDomanda("il mondo nuovo");
    
    boolean exc = false;
    try{
      classUnderTest.salvaTutor(tutor);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }
  
  /**
   *  Testa il metodo salvaImpiegato con dati sull'impiegato incompleti.
   * @throws SQLException
   */
  @Test
  public void testSalvaImpiegatoNonCompleto() throws SQLException{
    
    System.out.println("doSave di salvaImpiegato");
    
    impiegato.setNome("giorgio");
    impiegato.setCognome("esposito");
    impiegato.setMatricola("0000000002");
    impiegato.setEmail("gioesp@gmail.com");
    //username mancante
    impiegato.setPassword("giorgioesposito");
    impiegato.setDomanda("il mondo nuovo");
    
    boolean exc = false;
    try{
      classUnderTest.salvaImpiegato(impiegato);
    } catch (SQLException e) {
      exc = true;
    }
    
    assertTrue(exc);
  }

  /**
   * Testa il metodo aggiornaStudente con dati completi e uno studente già presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAggiornaStudentePresenteInDBCompleto() throws SQLException {

    System.out.println("doUpdate di aggiornaStudente");

    studente.setUsername(usernameS);
    studente = classUnderTest.getStudente(studente);

    studente.setNome("Anna Maria");
    studente.setCitta("Somma Vesuviana");

    classUnderTest.aggiornaStudente(studente);
    studente = classUnderTest.getStudente(studente);

    assertEquals("Anna Maria", studente.getNome());

  }

  /**
   * Testa il metodo aggiornaAzienda con dati completi e un'azienda già presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAggiornaAziendaPresenteInDBCompleto() throws SQLException {

    System.out.println("doUpdate di aggiornaAzienda");

    azienda.setUsername(usernameA);
    azienda = classUnderTest.getAzienda(azienda);

    azienda.setNome("Expedio");
    azienda.setIndirizzo("via napoli n 54");

    classUnderTest.aggiornaAzienda(azienda);
    azienda = classUnderTest.getAzienda(azienda);

    assertEquals("Expedio", azienda.getNome());

  }
  
  /**
   * Testa il metodo aggiornaTutor con dati completi e un tutor già presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAggiornaTutorPresenteInDBCompleto() throws SQLException {

    System.out.println("doUpdate di aggiornaTutor");

    tutor.setUsername(usernameT);
    tutor = classUnderTest.getTutor(tutor);

    tutor.setNome("marco");
    tutor.setCognome("serino");

    classUnderTest.aggiornaTutor(tutor);
    tutor = classUnderTest.getTutor(tutor);

    assertEquals("marco", tutor.getNome());

  }
  
  /**
   * Testa il metodo aggiornaImpiegato con dati completi e un impiegato già presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAggiornaImpiegatoPresenteInDBCompleto() throws SQLException {

    System.out.println("doUpdate di aggiornaImpiegato");

    impiegato.setUsername(usernameI);
    impiegato = classUnderTest.getImpiegato(impiegato);

    impiegato.setNome("serena");
    impiegato.setCognome("di martino");

    classUnderTest.aggiornaImpiegato(impiegato);
    impiegato = classUnderTest.getImpiegato(impiegato);

    assertEquals("marco", impiegato.getNome());

  }

  /**
   * Testa il metodo aggiornaStudente con dati non completi e uno studente già presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAggiornaStudentePresenteInDBNonCompleto() throws SQLException {
    
    System.out.println("doUpdate di aggiornaStudente");

    studente = new StudenteBean();

    studente.setNome("Anna Maria");
    studente.setCitta("Somma Vesuviana");
    studente.setUsername(usernameS);

    boolean exc = false;
    try {
      classUnderTest.aggiornaStudente(studente);
    } catch (SQLException e) {
      exc = true;
    }
    assertTrue(exc);

  }
  
  /**
   * Testa il metodo aggiornaAzienda con dati completi e un'azienda non� presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAggiornaAziendaPresenteInDBNonCompleto() throws SQLException {

    System.out.println("doUpdate di aggiornaAzienda");

    azienda = new AziendaBean();

    azienda.setNome("Expedio");
    azienda.setIndirizzo("via napoli n 54");

    boolean exc = false;
    try {
      classUnderTest.aggiornaAzienda(azienda);
    } catch (SQLException e) {
      exc = true;
    }
    assertTrue(exc);

  }
  
  /**
   * Testa il metodo aggiornaTutor con dati completi e un tutor non� presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAggiornaTutorPresenteInDBNonCompleto() throws SQLException {

    System.out.println("doUpdate di aggiornaTutor");

    tutor = new TutorBean();

    tutor.setNome("marco");
    tutor.setCognome("serino");

    boolean exc = false;
    try {
      classUnderTest.aggiornaTutor(tutor);
    } catch (SQLException e) {
      exc = true;
    }
    assertTrue(exc);

  }
  
  /**
   * Testa il metodo aggiornaImpiegato con dati completi e un impiegato non� presente nel database.
   * @throws SQLException
   */

  @Test
  public void testAggiornaImpiegatoPresenteInDBNonCompleto() throws SQLException {

    System.out.println("doUpdate di aggiornaImpiegato");

    impiegato = new ImpiegatoBean();

    impiegato.setNome("serena");
    impiegato.setCognome("di martino");

    boolean exc = false;
    try {
      classUnderTest.aggiornaImpiegato(impiegato);
    } catch (SQLException e) {
      exc = true;
    }
    assertTrue(exc);

  }

  /** 
   * Testa il metodo getStudenti senza order 
   * @throws SQLException
   */

  @Test
  public void testGetStudentiSenzaOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getStudenti");
    
    ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudenti(null);
    
    assertNotNull(list);
  }
  
  /** 
   * Testa il metodo getAziende senza order 
   * @throws SQLException
   */

  @Test
  public void testGetAziendeSenzaOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getAziende");
    
    ArrayList<AziendaBean> list = (ArrayList<AziendaBean>) classUnderTest.getAziende(null);
    
    assertNotNull(list);
  }
  
  /** 
   * Testa il metodo getTutorAccademici senza order 
   * @throws SQLException
   */

  @Test
  public void testGetTutorAccademiciSenzaOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getTutorAccademici");
    
    ArrayList<TutorBean> list = (ArrayList<TutorBean>) classUnderTest.getTutorAccademici(null);
    
    assertNotNull(list);
  }
  
  /** 
   * Testa il metodo getImpiegati senza order 
   * @throws SQLException
   */

  @Test
  public void testGetImpiegatiSenzaOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getAziende");
    
    ArrayList<ImpiegatoBean> list = (ArrayList<ImpiegatoBean>) classUnderTest.getImpiegati(null);
    
    assertNotNull(list);
  }
  
  /** 
   * Testa il metodo getStudenti con order 
   * @throws SQLException
   */

  @Test
  public void testGetStudentiConOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getStudenti");
    
    ArrayList<StudenteBean> list = (ArrayList<StudenteBean>) classUnderTest.getStudenti("usernameS ASC");
    
    assertNotNull(list);
  }
  
  /** 
   * Testa il metodo getAziende con order 
   * @throws SQLException
   */

  @Test
  public void testGetAziendeConOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getAziende");
    
    ArrayList<AziendaBean> list = (ArrayList<AziendaBean>) classUnderTest.getAziende("usernameS ASC");
    
    assertNotNull(list);
  }
  
  /** 
   * Testa il metodo getTutorAccademici con order 
   * @throws SQLException
   */

  @Test
  public void testGetTutorAccademiciConOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getTutorAccademici");
    
    ArrayList<TutorBean> list = (ArrayList<TutorBean>) classUnderTest.getTutorAccademici("usernameS ASC");
    
    assertNotNull(list);
  }
  
  /** 
   * Testa il metodo getImpiegati con order 
   * @throws SQLException
   */

  @Test
  public void testGetImpiegatiConOrder() throws SQLException {
    
    System.out.println("doRetrieveAll di getAziende");
    
    ArrayList<ImpiegatoBean> list = (ArrayList<ImpiegatoBean>) classUnderTest.getImpiegati("usernameS ASC");
    
    assertNotNull(list);
  }

  /**
   * Testa il metodo eliminaStudente con uno studente già presente nel database.
   */
  @Test
  public void testEliminaStudentePresenteInDB() throws SQLException {
    
    System.out.println("doDelete di eliminaStudente");
    
    studente = new StudenteBean();
    
    studente.setNome("Mario");
    studente.setCognome("Franco");
    studente.setLuogoNascita("Napoli");
    studente.setDataNascita("14/12/1994");
    studente.setIndirizzo("Piazza Sant'Antonio n° 5");
    studente.setCitta("Brusciano");
    studente.setCodiceFiscale("mrofrc94mg20tr3x");
    studente.setMatricola("0512108743");
    studente.setEmail("m.franco14@studenti.unisa.it");
    studente.setTelefono("3335622354");
    studente.setUsername("MarioFranco");
    studente.setPassword("MarioFranco");
    studente.setDomanda("Naruto");
    
    classUnderTest.salvaStudente(studente);
    
    boolean deleted = classUnderTest.eliminaStudente(studente);
    
    assertTrue(deleted);
    
  }
  
  /**
   *  Testa il metodo eliminaAzienda con un'azienda gi� presente nel database.
   * @throws SQLException
   */
  @Test
  public void testEliminaAziendaPresenteInDB() throws SQLException {
    
    System.out.println("doDelete di eliminaAzienda");
    
    azienda.setNome("rc solution");
    azienda.setPartitaIva("20512345687");
    azienda.setCeo("giuseppe esposito");
    azienda.setIndirizzo("via roma n 35");
    azienda.setEmail("rcsolution@gmail.com");
    azienda.setTelefono("0815684867");
    azienda.setUsername("rcsolution");
    azienda.setPassword("rcsolution");
    azienda.setDomanda("il signore degli anelli");
    azienda.setDescrizione("relaizzazione e manutenzione sistemi informativi per le banche");
    azienda.setLogo("img/tre.jpeg");
    
    classUnderTest.salvaAzienda(azienda);
    boolean deleted = classUnderTest.eliminaAzienda(azienda);
    
    assertTrue(deleted);
  }
  
  /**
   *  Testa il metodo eliminaTutor con un tutor gi� presente nel database.
   * @throws SQLException
   */
  @Test
  public void testEliminaTutorPresenteInDB() throws SQLException{
    
    System.out.println("doDelete di eliminaTutor");
    
    tutor.setNome("roberto");
    tutor.setCognome("de prisco");
    tutor.setMatricola("0542300032");
    tutor.setEmail("rob.dep@gmail.com");
    tutor.setUsername("robdep");
    tutor.setPassword("robdeprisco");
    tutor.setDomanda("il mondo nuovo");
    
    classUnderTest.salvaTutor(tutor);
    boolean deleted = classUnderTest.eliminaTutor(tutor);
    
    assertTrue(deleted);
  }
  
  /**
   *  Testa il metodo EliminaImpiegato con un impiegato gi� presente nel database.
   * @throws SQLException
   */
  @Test
  public void testEliminaImpiegatoPresenteInDB() throws SQLException{
    
    System.out.println("doDelete di eliminaImpiegato");
    
    impiegato.setNome("giorgio");
    impiegato.setCognome("esposito");
    impiegato.setMatricola("0000000002");
    impiegato.setEmail("gioesp@gmail.com");
    impiegato.setUsername("gio.esp");
    impiegato.setPassword("giorgioesposito");
    impiegato.setDomanda("il mondo nuovo");
    
    classUnderTest.salvaImpiegato(impiegato);
    boolean deleted = classUnderTest.eliminaImpiegato(impiegato);
    
    assertTrue(deleted);
  }

  
  /**
   * Testa il metodo eliminaStudente con uno studente non presente nel database.
   */
  @Test
  public void testEliminaStudenteNonPresenteInDB() throws SQLException {

    System.out.println("doDelete di eliminaStudente");
    
    studente = new StudenteBean();
    
    studente.setNome("Giovanni");
    studente.setCognome("Porcelli");
    studente.setLuogoNascita("Napoli");
    studente.setDataNascita("27/01/1995");
    studente.setIndirizzo("Via Sant'Anna n°20");
    studente.setCitta("Nola");
    studente.setCodiceFiscale("gvnprc23pg78dj7f");
    studente.setMatricola("0512103943");
    studente.setEmail("g.porcelli23@studenti.unisa.it");
    studente.setTelefono("3334658346");
    studente.setUsername("GiovanniPorcelli");
    studente.setPassword("GiovanniPorcelli");
    studente.setDomanda("Bichio");
    
    boolean deleted = classUnderTest.eliminaStudente(studente);
    
    assertTrue(deleted);
  }
  
  /**
   *  Testa il metodo eliminaAzienda con un'azienda non presente nel database.
   * @throws SQLException
   */
  @Test
  public void testEliminaAziendaNonPresenteInDB() throws SQLException {
    
    System.out.println("doDelete di eliminaAzienda");
    
    azienda.setNome("rc solution");
    azienda.setPartitaIva("20512345687");
    azienda.setCeo("giuseppe esposito");
    azienda.setIndirizzo("via roma n 35");
    azienda.setEmail("rcsolution@gmail.com");
    azienda.setTelefono("0815684867");
    azienda.setUsername("rcsolution");
    azienda.setPassword("rcsolution");
    azienda.setDomanda("il signore degli anelli");
    azienda.setDescrizione("relaizzazione e manutenzione sistemi informativi per le banche");
    azienda.setLogo("img/tre.jpeg");
    
    boolean deleted = classUnderTest.eliminaAzienda(azienda);
    
    assertTrue(deleted);
  }
  
  /**
   *  Testa il metodo eliminaTutor con un tutor non presente nel database.
   * @throws SQLException
   */
  @Test
  public void testEliminaTutorNonPresenteInDB() throws SQLException{
    
    System.out.println("doDelete di eliminaTutor");
    
    tutor.setNome("roberto");
    tutor.setCognome("de prisco");
    tutor.setMatricola("0542300032");
    tutor.setEmail("rob.dep@gmail.com");
    tutor.setUsername("robdep");
    tutor.setPassword("robdeprisco");
    tutor.setDomanda("il mondo nuovo");
    
    boolean deleted = classUnderTest.eliminaTutor(tutor);
    
    assertTrue(deleted);
  }

  /**
   *  Testa il metodo EliminaImpiegato con un impiegato non presente nel database.
   * @throws SQLException
   */
  @Test
  public void testEliminaImpiegatoNonPresenteInDB() throws SQLException{
    
    System.out.println("doDelete di salvaImpiegato");
    
    impiegato.setNome("giorgio");
    impiegato.setCognome("esposito");
    impiegato.setMatricola("0000000002");
    impiegato.setEmail("gioesp@gmail.com");
    impiegato.setUsername("gio.esp");
    impiegato.setPassword("giorgioesposito");
    impiegato.setDomanda("il mondo nuovo");
    
    boolean deleted = classUnderTest.eliminaImpiegato(impiegato);
    
    assertTrue(deleted);
  }

}
