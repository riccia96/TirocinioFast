package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.AziendaBean;
import Bean.ImpiegatoBean;
import Bean.StudenteBean;
import Bean.TutorBean;
import Model.AziendaDAO;
import Model.ImpiegatoDAO;
import Model.StudenteDAO;
import Model.TutorDAO;

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
	
	public int registraStudente(StudenteBean studente) throws SQLException{
		StudenteDAO sDAO = new StudenteDAO();
		return sDAO.doSave(studente);
	}
	
	public int registraAzienda(AziendaBean azienda) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doSave(azienda);
	}
	
	public boolean impostaPasswordStudente(StudenteBean studente) throws SQLException{
		StudenteDAO sDAO = new StudenteDAO();
		return sDAO.doUpdate(studente);
	}
	
	public boolean impostaPasswordAzienda(AziendaBean azienda) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doUpdate(azienda);
	}

	public boolean impostaPasswordTutor(TutorBean tutor) throws SQLException{
		TutorDAO tDAO = new TutorDAO();
		return tDAO.doUpdate(tutor);
	}
	
	public boolean impostaPasswordImpiegato(ImpiegatoBean impiegato) throws SQLException{
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		return iDAO.doUpdate(impiegato);
	}
	
	public boolean completaSchedaAzienda(AziendaBean azienda) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doUpdate(azienda);
	}
	
	public List<StudenteBean> getStudenti(){
		StudenteDAO sDAO = new StudenteDAO();
		List<StudenteBean> studenti = new ArrayList<StudenteBean>();
		try {
			studenti.addAll(sDAO.doRetrieveAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studenti;
	}
	
	public List<AziendaBean> getAziende(){
		AziendaDAO aDAO = new AziendaDAO();
		List<AziendaBean> aziende = new ArrayList<AziendaBean>();
		try {
			aziende.addAll(aDAO.doRetrieveAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aziende;
	}
	
	public List<ImpiegatoBean> getImpiegati(){
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		List<ImpiegatoBean> impiegati = new ArrayList<ImpiegatoBean>();
		try {
			impiegati.addAll(iDAO.doRetrieveAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return impiegati;
	}
	
	public List<TutorBean> getTutorAccademici(){
		TutorDAO tDAO = new TutorDAO();
		List<TutorBean> tutorAccademici = new ArrayList<TutorBean>();
		try {
			tutorAccademici.addAll(tDAO.doRetrieveAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tutorAccademici;
	}
}
