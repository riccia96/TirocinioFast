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
	
}
