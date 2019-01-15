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
	TirocinioDAO tDAO = new TirocinioDAO();
	ConvenzioneDAO cDAO = new ConvenzioneDAO();
	QuestionarioStudenteDAO qsDAO = new QuestionarioStudenteDAO();
	QuestionarioAziendaDAO qaDAO = new QuestionarioAziendaDAO();
	List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
	List<ConvenzioneBean> convenzioni = new ArrayList<ConvenzioneBean>();
	List<QuestionarioStudenteBean> questionari = new ArrayList<QuestionarioStudenteBean>();
	List<QuestionarioAziendaBean> questionariAzienda = new ArrayList<QuestionarioAziendaBean>();

	
	public int generaCodiceTirocinio() throws SQLException {
		
		return tDAO.generaCodice();
	}
	
	public int generaCodiceConvenzione() throws SQLException {
		
		return cDAO.generaCodice();
	}
	
	public int generaCodiceQuestionarioStudente() throws SQLException{
		
		return qsDAO.generaCodice();
	}
	
	public int generaCodiceQuestionarioAzienda() throws SQLException{
		return qaDAO.generaCodice();
	}
	
	public TirocinioBean getTirocinio(TirocinioBean tirocinio) throws SQLException {
		return tDAO.doRetrieveByKey(tirocinio);
	}

	public ConvenzioneBean getConvenzione(ConvenzioneBean convenzione) throws SQLException {
		return cDAO.doRetrieveByKey(convenzione);
	}
	
	public QuestionarioStudenteBean getQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		return qsDAO.doRetrieveByKey(questionario);
	}
	
	public QuestionarioAziendaBean getQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		return qaDAO.doRetrieveByKey(questionario);
	}
	
	public int salvaTirocinio(TirocinioBean tirocinio) throws SQLException {
		return tDAO.doSave(tirocinio);
	}
	
	public int salvaConvenzione(ConvenzioneBean convenzione) throws SQLException {
		return cDAO.doSave(convenzione);
	}

	public int salvaQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		return qsDAO.doSave(questionario);
	}

	public int salvaQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		return qaDAO.doSave(questionario);
	}

	
	public boolean aggiornaTirocinio(TirocinioBean tirocinio) throws SQLException {
		return tDAO.doUpdate(tirocinio);
	}

	public boolean aggiornaConvenzione(ConvenzioneBean convenzione) throws SQLException {
		ConvenzioneDAO cDAO = new ConvenzioneDAO();
		return cDAO.doUpdate(convenzione);
	}

	public boolean aggiornaQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		return qsDAO.doUpdate(questionario);
	}
	
	
	public boolean aggiornaQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		return qaDAO.doUpdate(questionario);
	}
	
	public boolean eliminaTirocinio(TirocinioBean tirocinio) throws SQLException{
		return tDAO.doDelete(tirocinio);
	}
	
	public boolean eliminaConvenzione(ConvenzioneBean convenzione) throws SQLException{
		return cDAO.doDelete(convenzione);
	}
	
	public boolean eliminaQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException{
		return qsDAO.doDelete(questionario);
	}
	
	public boolean eliminaQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException{
		return qaDAO.doDelete(questionario);
	}
	
	public List<TirocinioBean> getTirocini(String order) throws SQLException {
		tirocini.addAll(tDAO.doRetrieveAll(order));
		return tirocini;

	}

	public List<ConvenzioneBean> getConvenzioni(String order) throws SQLException {
		convenzioni.addAll(cDAO.doRetrieveAll(order));
		return convenzioni;

	}
	
	public List<QuestionarioStudenteBean> getQuestionariStudente(String order) throws SQLException{
		questionari = qsDAO.doRetrieveAll(order);
		return questionari;
	}
	
	public List<QuestionarioAziendaBean> getQuestionariAzienda(String order) throws SQLException{
		questionariAzienda = qaDAO.doRetrieveAll(order);
		return questionariAzienda;
	}
}
