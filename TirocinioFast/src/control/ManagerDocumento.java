package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ConvenzioneBean;
import bean.QuestionarioAziendaBean;
import bean.QuestionarioStudenteBean;
import bean.TirocinioBean;
import model.ConvenzioneDAO;
import model.QuestionarioAziendaDAO;
import model.QuestionarioStudenteDAO;
import model.TirocinioDAO;


public class ManagerDocumento {
	
	public int generaCodiceTirocinio() throws SQLException {
		TirocinioDAO tirocinio = new TirocinioDAO();
		return tirocinio.generaCodice();
	}
	
	public int generaCodiceConvenzione() throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.generaCodice();
	}
	
	public int generaCodiceQuestionarioStudente() throws SQLException{
		QuestionarioStudenteDAO questionario = new QuestionarioStudenteDAO();
		return questionario.generaCodice();
	}
	
	public int generaCodiceQuestionarioAzienda() throws SQLException{
		QuestionarioAziendaDAO questionario = new QuestionarioAziendaDAO();
		return questionario.generaCodice();
	}
	
	public TirocinioBean getTirocinio(TirocinioBean tirocinio) throws SQLException {
		TirocinioDAO tDAO = new TirocinioDAO();
		return tDAO.doRetrieveByKey(tirocinio);
	}

	public ConvenzioneBean getConvenzione(ConvenzioneBean convenzione) throws SQLException {
		ConvenzioneDAO cDAO = new ConvenzioneDAO();
		return cDAO.doRetrieveByKey(convenzione);
	}
	
	public QuestionarioStudenteBean getQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		QuestionarioStudenteDAO qDAO = new QuestionarioStudenteDAO();
		return qDAO.doRetrieveByKey(questionario);
	}
	
	public QuestionarioAziendaBean getQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		QuestionarioAziendaDAO qDAO = new QuestionarioAziendaDAO();
		return qDAO.doRetrieveByKey(questionario);
	}
	
	public int salvaTirocinio(TirocinioBean tirocinio) throws SQLException {
		TirocinioDAO tDAO = new TirocinioDAO();
		return tDAO.doSave(tirocinio);
	}
	
	public int salvaConvenzione(ConvenzioneBean convenzione) throws SQLException {
		ConvenzioneDAO cDAO = new ConvenzioneDAO();
		return cDAO.doSave(convenzione);
	}

	public int salvaQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		QuestionarioStudenteDAO qDAO = new QuestionarioStudenteDAO();
		return qDAO.doSave(questionario);
	}

	public int salvaQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		QuestionarioAziendaDAO qDAO = new QuestionarioAziendaDAO();
		return qDAO.doSave(questionario);
	}

	
	public boolean aggiornaTirocinio(TirocinioBean tirocinio) throws SQLException {
		TirocinioDAO tirocinioDAO = new TirocinioDAO();
		return tirocinioDAO.doUpdate(tirocinio);
	}

	public boolean aggiornaConvenzione(ConvenzioneBean convenzione) throws SQLException {
		ConvenzioneDAO cDAO = new ConvenzioneDAO();
		return cDAO.doUpdate(convenzione);
	}

	public boolean aggiornaQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		QuestionarioStudenteDAO qDAO = new QuestionarioStudenteDAO();
		return qDAO.doUpdate(questionario);
	}
	
	
	public boolean aggiornaQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		QuestionarioAziendaDAO qDAO = new QuestionarioAziendaDAO();
		return qDAO.doUpdate(questionario);
	}
	
	public boolean eliminaTirocinnio(TirocinioBean tirocinio) throws SQLException{
		TirocinioDAO tDAO = new TirocinioDAO();
		return tDAO.doDelete(tirocinio);
	}
	
	public boolean eliminaConvenzione(ConvenzioneBean convenzione) throws SQLException{
		ConvenzioneDAO cDAO = new ConvenzioneDAO();
		return cDAO.doDelete(convenzione);
	}
	
	public boolean eliminaQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException{
		QuestionarioStudenteDAO qDAO = new QuestionarioStudenteDAO();
		return qDAO.doDelete(questionario);
	}
	
	public boolean eliminaQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException{
		QuestionarioAziendaDAO qDAO = new QuestionarioAziendaDAO();
		return qDAO.doDelete(questionario);
	}
	
	public List<TirocinioBean> getTirocini(String order) throws SQLException {

		List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
		TirocinioDAO tirocinio = new TirocinioDAO();

		tirocini.addAll(tirocinio.doRetrieveAll(order));

		return tirocini;

	}

	public List<ConvenzioneBean> getConvenzioni(String order) throws SQLException {

		List<ConvenzioneBean> convenzioni = new ArrayList<ConvenzioneBean>();
		ConvenzioneDAO convenzione = new ConvenzioneDAO();

		convenzioni.addAll(convenzione.doRetrieveAll(order));

		return convenzioni;

	}
	
	public List<QuestionarioStudenteBean> getQuestionariStudente(String order) throws SQLException{
		QuestionarioStudenteDAO qDAO = new QuestionarioStudenteDAO();
		List<QuestionarioStudenteBean> questionari = new ArrayList<QuestionarioStudenteBean>();
		questionari = qDAO.doRetrieveAll(order);
		
		return questionari;
	}
	
	public List<QuestionarioAziendaBean> getQuestionariAzienda(String order) throws SQLException{
		QuestionarioAziendaDAO qDAO = new QuestionarioAziendaDAO();
		List<QuestionarioAziendaBean> questionari = new ArrayList<QuestionarioAziendaBean>();
		questionari = qDAO.doRetrieveAll(order);
		
		return questionari;
	}
}
