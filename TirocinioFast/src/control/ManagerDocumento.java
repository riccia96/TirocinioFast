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
		TirocinioDAO tirocinioDAO = new TirocinioDAO();
		return tirocinioDAO.doRetrieveByKey(tirocinio);
	}

	public ConvenzioneBean getConvenzione(ConvenzioneBean pathDoc) throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.doRetrieveByKey(pathDoc);
	}
	
	public QuestionarioStudenteBean getQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		QuestionarioStudenteDAO questionarioDAO = new QuestionarioStudenteDAO();
		return questionarioDAO.doRetrieveByKey(questionario);
	}
	
	public QuestionarioAziendaBean getQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		QuestionarioAziendaDAO questionarioDAO = new QuestionarioAziendaDAO();
		return questionarioDAO.doRetrieveByKey(questionario);
	}
	
	public int salvaTirocinio(TirocinioBean tirocinio) throws SQLException {
		TirocinioDAO tDAO = new TirocinioDAO();
		return tDAO.doSave(tirocinio);
	}
	
	public int salvaConvenzione(ConvenzioneBean convenzione) throws SQLException {
		ConvenzioneDAO cDAO = new ConvenzioneDAO();
		return cDAO.doSave(convenzione);
	}

	public int salvaQuestionarioStudente(QuestionarioStudenteBean questionarioS) throws SQLException {
		QuestionarioStudenteDAO questionario = new QuestionarioStudenteDAO();
		return questionario.doSave(questionarioS);
	}

	public int salvaQuestionarioAzienda(QuestionarioAziendaBean questionarioA) throws SQLException {
		QuestionarioAziendaDAO questionario = new QuestionarioAziendaDAO();
		return questionario.doSave(questionarioA);
	}

	
	public boolean aggiornaTirocinio(TirocinioBean pathDoc) throws SQLException {
		TirocinioDAO tirocinio = new TirocinioDAO();
		return tirocinio.doUpdate(pathDoc);
	}

	public boolean aggiornaConvenzione(ConvenzioneBean convenzione) throws SQLException {
		ConvenzioneDAO convenzioneDAO = new ConvenzioneDAO();
		return convenzioneDAO.doUpdate(convenzione);
	}

	public boolean aggiornaQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		QuestionarioStudenteDAO questionarioDAO = new QuestionarioStudenteDAO();
		return questionarioDAO.doUpdate(questionario);
	}
	
	
	public boolean aggiornaQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		QuestionarioAziendaDAO questionarioDAO = new QuestionarioAziendaDAO();
		return questionarioDAO.doUpdate(questionario);
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
	
	public List<TirocinioBean> getTirocini() throws SQLException {

		List<TirocinioBean> lTirocinio = new ArrayList<TirocinioBean>();
		TirocinioDAO tirocinio = new TirocinioDAO();

		lTirocinio.addAll(tirocinio.doRetrieveAll());

		return lTirocinio;

	}

	public List<ConvenzioneBean> getConvenzioni() throws SQLException {

		List<ConvenzioneBean> lConvenzioni = new ArrayList<ConvenzioneBean>();
		ConvenzioneDAO convenzione = new ConvenzioneDAO();

		lConvenzioni.addAll(convenzione.doRetrieveAll());

		return lConvenzioni;

	}
	
	public List<QuestionarioStudenteBean> getQuestionariStudente() throws SQLException{
		QuestionarioStudenteDAO questionarioDAO = new QuestionarioStudenteDAO();
		List<QuestionarioStudenteBean> questionari = new ArrayList<QuestionarioStudenteBean>();
		questionari = questionarioDAO.doRetrieveAll();
		
		return questionari;
	}
	
	public List<QuestionarioAziendaBean> getQuestionariAzienda() throws SQLException{
		QuestionarioAziendaDAO questionarioDAO = new QuestionarioAziendaDAO();
		List<QuestionarioAziendaBean> questionari = new ArrayList<QuestionarioAziendaBean>();
		questionari = questionarioDAO.doRetrieveAll();
		
		return questionari;
	}
}
