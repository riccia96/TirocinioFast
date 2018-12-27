package Control;

import java.sql.SQLException;

import Bean.AziendaBean;
import Bean.ImpiegatoBean;
import Bean.StudenteBean;
import Bean.TutorBean;
import Model.AziendaDAO;
import Model.ImpiegatoDAO;
import Model.StudenteDAO;
import Model.TutorAccademicoDAO;

public class ManagerUtente {

	public StudenteBean getStudenteDaUsername(String username) throws SQLException{
		StudenteDAO sDAO = new StudenteDAO();
		return sDAO.doRetrieveByKey(username);
		}
	
	public AziendaBean getAziendaDaUsername(String username) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doRetrieveByKey(username);
	}
	
	public ImpiegatoBean getImpiegatoDaUsername(String username) throws SQLException{
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		return iDAO.doRetrieveByKey(username);
	}
	
	public TutorBean getTutorDaUsername(String username) throws SQLException{
		TutorAccademicoDAO tDAO = new TutorAccademicoDAO();
		return tDAO.doRetrieveByKey(username);
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
	
	public boolean impostaPasswordImpiegato(ImpiegatoBean impiegato) throws SQLException{
		ImpiegatoDAO iDAO = new ImpiegatoDAO();
		return iDAO.doUpdate(impiegato);
	}
	
	public boolean impostaPasswordTutor(TutorBean tutor) throws SQLException{
		TutorAccademicoDAO tDAO = new TutorAccademicoDAO();
		return tDAO.doUpdate(tutor);
	}
	
	public boolean completaSchedaAzienda(AziendaBean azienda) throws SQLException{
		AziendaDAO aDAO = new AziendaDAO();
		return aDAO.doUpdate(azienda);
	}
	
	public boolean reimpostaPasswordStudente(String username, String domanda) throws SQLException{
		StudenteBean sDAO = this.getStudenteDaUsername(username);
		return sDAO.getDomanda().equals(domanda);
	}
	
	public boolean reimpostaPasswordAzienda(String username, String domanda) throws SQLException{
		AziendaBean aDAO = this.getAziendaDaUsername(username);
		return aDAO.getDomanda().equals(domanda);
	}
	
	public boolean reimpostaPasswordTutor(String username, String domanda) throws SQLException{
		TutorBean tDAO = this.getTutorDaUsername(username);
		return tDAO.getDomanda().equals(domanda);
	}
	
	public boolean reimpostaPasswordImpiegato(String username, String domanda) throws SQLException{
		ImpiegatoBean iDAO = this.getImpiegatoDaUsername(username);
		return iDAO.getDomanda().equals(domanda);
	}
	
}
