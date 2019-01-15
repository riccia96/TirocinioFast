package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AziendaBean;
import bean.ImpiegatoBean;
import bean.StudenteBean;
import bean.TutorBean;
import model.AziendaDAO;
import model.ImpiegatoDAO;
import model.StudenteDAO;
import model.TutorDAO;

public class ManagerUtente {
	
	private StudenteDAO sDAO = new StudenteDAO();
	private AziendaDAO aDAO = new AziendaDAO();
	private TutorDAO tDAO = new TutorDAO();
	private ImpiegatoDAO iDAO = new ImpiegatoDAO();
	private List<StudenteBean> studenti = new ArrayList<StudenteBean>();
	private List<AziendaBean> aziende = new ArrayList<AziendaBean>();
	private List<TutorBean> tutorAccademici = new ArrayList<TutorBean>();
	private List<ImpiegatoBean> impiegati = new ArrayList<ImpiegatoBean>();

	public StudenteBean getStudente(StudenteBean studente) throws SQLException{
		return sDAO.doRetrieveByKey(studente);
	}
	
	public AziendaBean getAzienda(AziendaBean azienda) throws SQLException{
		return aDAO.doRetrieveByKey(azienda);
	}
	
	public TutorBean getTutor(TutorBean tutor) throws SQLException{
		return tDAO.doRetrieveByKey(tutor);
	}
	
	public ImpiegatoBean getImpiegato(ImpiegatoBean impiegato) throws SQLException{
		return iDAO.doRetrieveByKey(impiegato);
	}
	
	public int salvaStudente(StudenteBean studente) throws SQLException{
		return sDAO.doSave(studente);
	}
	
	public int salvaAzienda(AziendaBean azienda) throws SQLException{
		return aDAO.doSave(azienda);
	}
	
	public int salvaTutor(TutorBean tutor) throws SQLException{
		return tDAO.doSave(tutor);
	}
	
	public int salvaImpiegato(ImpiegatoBean impiegato) throws SQLException{
		return iDAO.doSave(impiegato);
	}
	public boolean aggiornaStudente(StudenteBean studente) throws SQLException{
		return sDAO.doUpdate(studente);
	}
	
	public boolean aggiornaAzienda(AziendaBean azienda) throws SQLException{
		return aDAO.doUpdate(azienda);
	}

	public boolean aggiornaTutor(TutorBean tutor) throws SQLException{
		return tDAO.doUpdate(tutor);
	}
	
	public boolean aggiornaImpiegato(ImpiegatoBean impiegato) throws SQLException{
		return iDAO.doUpdate(impiegato);
	}
	
	public boolean eliminaStudente(StudenteBean studente) throws SQLException{
		return sDAO.doDelete(studente);
	}
	
	public boolean eliminaAzienda(AziendaBean azienda) throws SQLException{
		return aDAO.doDelete(azienda);
	}
	
	public boolean eliminaTutor(TutorBean tutor) throws SQLException{
		return tDAO.doDelete(tutor);
	}
	
	public boolean eliminaImpiegato(ImpiegatoBean impiegato) throws SQLException{
		return iDAO.doDelete(impiegato);
	}
	
	public List<StudenteBean> getStudenti(String order) throws SQLException{
		studenti.addAll(sDAO.doRetrieveAll(order));
		return studenti;
	}
	
	public List<AziendaBean> getAziende(String order) throws SQLException{
		aziende.addAll(aDAO.doRetrieveAll(order));
		return aziende;
	}
	
	public List<TutorBean> getTutorAccademici(String order) throws SQLException{
		tutorAccademici.addAll(tDAO.doRetrieveAll(order));
		
		return tutorAccademici;
	}
	
	public List<ImpiegatoBean> getImpiegati(String order) throws SQLException{
	    impiegati.addAll(iDAO.doRetrieveAll(order));
		
		return impiegati;
	}
	
}
