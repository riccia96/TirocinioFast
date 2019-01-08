package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.ConvenzioneBean;
import Bean.QuestionarioAziendaBean;
import Bean.QuestionarioStudenteBean;
import Bean.TirocinioBean;
import Model.ConvenzioneDAO;
import Model.QuestionarioAziendaDAO;
import Model.QuestionarioStudenteDAO;
import Model.TirocinioDAO;


public class ManagerDocumento {
	
	public int generaCodice() throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.generaCodice();
	}

	public TirocinioBean DownloadTirocinio(TirocinioBean tirocinio) throws SQLException {
		TirocinioDAO tirocinioDAO = new TirocinioDAO();
		return tirocinioDAO.doRetrieveByKey(tirocinio);
	}

	public boolean UploadTirocinio(TirocinioBean pathDoc) throws SQLException {
		TirocinioDAO tirocinio = new TirocinioDAO();
		return tirocinio.doUpdate(pathDoc);
	}
	
	public ConvenzioneBean DownloadConvenzione(ConvenzioneBean pathDoc) throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.doRetrieveByKey(pathDoc);
	}

	public boolean UploadConvenzione(ConvenzioneBean convenzione) throws SQLException {
		ConvenzioneDAO convenzioneDAO = new ConvenzioneDAO();
		return convenzioneDAO.doUpdate(convenzione);
	}
	
	public QuestionarioStudenteBean QuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		QuestionarioStudenteDAO questionarioDAO = new QuestionarioStudenteDAO();
		return questionarioDAO.doRetrieveByKey(questionario);
	}

	public boolean UploadQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
		QuestionarioStudenteDAO questionarioDAO = new QuestionarioStudenteDAO();
		return questionarioDAO.doUpdate(questionario);
	}
	
	public QuestionarioAziendaBean QuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		QuestionarioAziendaDAO questionarioDAO = new QuestionarioAziendaDAO();
		return questionarioDAO.doRetrieveByKey(questionario);
	}

	public boolean UploadQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
		QuestionarioAziendaDAO questionarioDAO = new QuestionarioAziendaDAO();
		return questionarioDAO.doUpdate(questionario);
	}
	
	public List<TirocinioBean> richiesteTirocinio() throws SQLException {

		List<TirocinioBean> lTirocinio = new ArrayList<TirocinioBean>();
		TirocinioDAO tirocinio = new TirocinioDAO();

		lTirocinio.addAll(tirocinio.doRetrieveAll());

		return lTirocinio;

	}

	public List<ConvenzioneBean> convenzioni() throws SQLException {

		List<ConvenzioneBean> lConvenzioni = new ArrayList<ConvenzioneBean>();
		ConvenzioneDAO convenzione = new ConvenzioneDAO();

		lConvenzioni.addAll(convenzione.doRetrieveAll());

		return lConvenzioni;

	}

	public int compilaTirocinioStudente(TirocinioBean tirocinioS) throws SQLException {
		TirocinioDAO tirocinio = new TirocinioDAO();
		return tirocinio.doSave(tirocinioS);
	}

	public boolean compilaTirocinioAzienda(TirocinioBean tirocinioA) throws SQLException {
		TirocinioDAO tirocinio = new TirocinioDAO();
		return tirocinio.doUpdate(tirocinioA);
	}

	public int compilaConvenzione(ConvenzioneBean convenzioneA) throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.doSave(convenzioneA);
	}

	public int compilaQuestionarioStudente(QuestionarioStudenteBean questionarioS) throws SQLException {
		QuestionarioStudenteDAO questionario = new QuestionarioStudenteDAO();
		return questionario.doSave(questionarioS);
	}

	public int compilaQuestionarioAzienda(QuestionarioAziendaBean questionarioA) throws SQLException {
		QuestionarioAziendaDAO questionario = new QuestionarioAziendaDAO();
		return questionario.doSave(questionarioA);
	}

	public boolean convalidaTirocinio(TirocinioBean tirocinioS) throws SQLException {
		TirocinioDAO tirocinio = new TirocinioDAO();
		return tirocinio.doUpdate(tirocinioS);
	}


	public boolean convalidaConvenzione(ConvenzioneBean convenzioneA) throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.doUpdate(convenzioneA);
	}
	
	public ConvenzioneBean convenzione(ConvenzioneBean convenzioneA) throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.doRetrieveByKey(convenzioneA);
	}
	
	public QuestionarioStudenteBean questionarioStudente(QuestionarioStudenteBean questionarioStudente) throws SQLException{
		QuestionarioStudenteDAO questionario = new QuestionarioStudenteDAO();
		return questionario.doRetrieveByKey(questionarioStudente);
	}
	
	public QuestionarioAziendaBean questionarioAzienda(QuestionarioAziendaBean questionarioAzienda) throws SQLException{
		QuestionarioAziendaDAO questionario = new QuestionarioAziendaDAO();
		return questionario.doRetrieveByKey(questionarioAzienda);
	}
}
