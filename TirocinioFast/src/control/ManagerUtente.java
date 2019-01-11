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

	public StudenteBean getStudente(StudenteBean studente) throws SQLException{
		StudenteDAO sDAO = new StudenteDAO();
		return sDAO.doRetrieveByKey(studente);
	}
	
	public AziendaBean getAzienda(AziendaBean azienda) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doRetrieveByKey(azienda);
	}
	
	public TutorBean getTutor(TutorBean tutor) throws SQLException{
		TutorDAO tDAO = new TutorDAO();
		return tDAO.doRetrieveByKey(tutor);
	}
	
	public ImpiegatoBean getImpiegato(ImpiegatoBean impiegato) throws SQLException{
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		return iDAO.doRetrieveByKey(impiegato);
	}
	
	public int salvaStudente(StudenteBean studente) throws SQLException{
		StudenteDAO sDAO = new StudenteDAO();
		return sDAO.doSave(studente);
	}
	
	public int salvaAzienda(AziendaBean azienda) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doSave(azienda);
	}
	
	public int salvaTutor(TutorBean tutor) throws SQLException{
		TutorDAO tDAO = new TutorDAO();
		return tDAO.doSave(tutor);
	}
	
	public int salvaImpiegato(ImpiegatoBean impiegato) throws SQLException{
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		return iDAO.doSave(impiegato);
	}
	
	public boolean eliminaStudente(StudenteBean studente) throws SQLException{
		StudenteDAO sDAO = new StudenteDAO();
		return sDAO.doDelete(studente);
	}
	
	public boolean eliminaAzienda(AziendaBean azienda) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doDelete(azienda);
	}
	
	public boolean eliminaTutor(TutorBean tutor) throws SQLException{
		TutorDAO tDAO = new TutorDAO();
		return tDAO.doDelete(tutor);
	}
	
	public boolean eliminaImpiegato(ImpiegatoBean impiegato) throws SQLException{
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		return iDAO.doDelete(impiegato);
	}
	
	public boolean aggiornaStudente(StudenteBean studente) throws SQLException{
		StudenteDAO sDAO = new StudenteDAO();
		return sDAO.doUpdate(studente);
	}
	
	public boolean aggiornaAzienda(AziendaBean azienda) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doUpdate(azienda);
	}

	public boolean aggiornaTutor(TutorBean tutor) throws SQLException{
		TutorDAO tDAO = new TutorDAO();
		return tDAO.doUpdate(tutor);
	}
	
	public boolean aggiornaImpiegato(ImpiegatoBean impiegato) throws SQLException{
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		return iDAO.doUpdate(impiegato);
	}
	
	public List<StudenteBean> getStudenti() throws SQLException{
		StudenteDAO sDAO = new StudenteDAO();
		List<StudenteBean> studenti = new ArrayList<StudenteBean>();
		studenti.addAll(sDAO.doRetrieveAll());
		return studenti;
	}
	
	public List<AziendaBean> getAziende() throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		List<AziendaBean> aziende = new ArrayList<AziendaBean>();
		aziende.addAll(aDAO.doRetrieveAll());
		return aziende;
	}
	
	public List<TutorBean> getTutorAccademici() throws SQLException{
		TutorDAO tDAO = new TutorDAO();
		List<TutorBean> tutorAccademici = new ArrayList<TutorBean>();
		tutorAccademici.addAll(tDAO.doRetrieveAll());
		
		return tutorAccademici;
	}
	
	public List<ImpiegatoBean> getImpiegati() throws SQLException{
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		List<ImpiegatoBean> impiegati = new ArrayList<ImpiegatoBean>();
	    impiegati.addAll(iDAO.doRetrieveAll());
		
		return impiegati;
	}
	
}