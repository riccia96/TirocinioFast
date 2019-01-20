package control;

import bean.AziendaBean;
import bean.ImpiegatoBean;
import bean.StudenteBean;
import bean.TutorBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AziendaDAO;
import model.ImpiegatoDAO;
import model.StudenteDAO;
import model.TutorDAO;

public class ManagerUtente {

  private StudenteDAO sDao = new StudenteDAO();
  private AziendaDAO aDao = new AziendaDAO();
  private TutorDAO tDao = new TutorDAO();
  private ImpiegatoDAO iDao = new ImpiegatoDAO();
  private List<StudenteBean> studenti = new ArrayList<StudenteBean>();
  private List<AziendaBean> aziende = new ArrayList<AziendaBean>();
  private List<TutorBean> tutorAccademici = new ArrayList<TutorBean>();
  private List<ImpiegatoBean> impiegati = new ArrayList<ImpiegatoBean>();

  public StudenteBean getStudente(StudenteBean studente) throws SQLException {
    return sDao.doRetrieveByKey(studente);
  }

  public AziendaBean getAzienda(AziendaBean azienda) throws SQLException {
    return aDao.doRetrieveByKey(azienda);
  }

  public TutorBean getTutor(TutorBean tutor) throws SQLException {
    return tDao.doRetrieveByKey(tutor);
  }

  public ImpiegatoBean getImpiegato(ImpiegatoBean impiegato) throws SQLException {
    return iDao.doRetrieveByKey(impiegato);
  }

  public int salvaStudente(StudenteBean studente) throws SQLException {
    return sDao.doSave(studente);
  }

  public int salvaAzienda(AziendaBean azienda) throws SQLException {
    return aDao.doSave(azienda);
  }

  public int salvaTutor(TutorBean tutor) throws SQLException {
    return tDao.doSave(tutor);
  }

  public int salvaImpiegato(ImpiegatoBean impiegato) throws SQLException {
    return iDao.doSave(impiegato);
  }
  
  public boolean aggiornaStudente(StudenteBean studente) throws SQLException {
    return sDao.doUpdate(studente);
  }

  public boolean aggiornaAzienda(AziendaBean azienda) throws SQLException {
    return aDao.doUpdate(azienda);
  }

  public boolean aggiornaTutor(TutorBean tutor) throws SQLException {
    return tDao.doUpdate(tutor);
  }

  public boolean aggiornaImpiegato(ImpiegatoBean impiegato) throws SQLException {
    return iDao.doUpdate(impiegato);
  }

  public boolean eliminaStudente(StudenteBean studente) throws SQLException {
    return sDao.doDelete(studente);
  }

  public boolean eliminaAzienda(AziendaBean azienda) throws SQLException {
    return aDao.doDelete(azienda);
  }

  public boolean eliminaTutor(TutorBean tutor) throws SQLException {
    return tDao.doDelete(tutor);
  }

  public boolean eliminaImpiegato(ImpiegatoBean impiegato) throws SQLException {
    return iDao.doDelete(impiegato);
  }

  public List<StudenteBean> getStudenti(String order) throws SQLException {
    studenti.addAll(sDao.doRetrieveAll(order));
    return studenti;
  }

  public List<AziendaBean> getAziende(String order) throws SQLException {
    aziende.addAll(aDao.doRetrieveAll(order));
    return aziende;
  }

  public List<TutorBean> getTutorAccademici(String order) 
       throws SQLException {
    tutorAccademici.addAll(tDao.doRetrieveAll(order));

    return tutorAccademici;
  }

  public List<ImpiegatoBean> getImpiegati(String order) 
       throws SQLException {
    impiegati.addAll(iDao.doRetrieveAll(order));

    return impiegati;
  }

}
