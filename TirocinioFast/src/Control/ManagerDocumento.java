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

	public TirocinioBean DownloadTirocinio(TirocinioBean pathDoc) throws SQLException {
		TirocinioDAO tirocinio = new TirocinioDAO();
		return tirocinio.doRetrieveByKey(pathDoc);
	}

	public boolean UploadTirocinio(TirocinioBean pathDoc) throws SQLException {
		TirocinioDAO tirocinio = new TirocinioDAO();
		return tirocinio.doUpdate(pathDoc);
	}
	
	public ConvenzioneBean DownloadConvenzione(ConvenzioneBean pathDoc) throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.doRetrieveByKey(pathDoc);
	}

	public boolean UploadConvenzione(ConvenzioneBean pathDoc) throws SQLException {
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		return convenzione.doUpdate(pathDoc);
	}
	
	public QuestionarioStudenteBean DownloadQuestionarioStudente(QuestionarioStudenteBean pathDoc) throws SQLException {
		QuestionarioStudenteDAO questionario = new QuestionarioStudenteDAO();
		return questionario.doRetrieveByKey(pathDoc);
	}

	public boolean UploadQuestionarioStudente(QuestionarioStudenteBean pathDoc) throws SQLException {
		QuestionarioStudenteDAO questionario = new QuestionarioStudenteDAO();
		return questionario.doUpdate(pathDoc);
	}
	
	public QuestionarioAziendaBean DownloadQuestionarioAzienda(QuestionarioAziendaBean pathDoc) throws SQLException {
		QuestionarioAziendaDAO questionario = new QuestionarioAziendaDAO();
		return questionario.doRetrieveByKey(pathDoc);
	}

	public boolean UploadQuestionarioAienda(QuestionarioAziendaBean pathDoc) throws SQLException {
		QuestionarioAziendaDAO questionario = new QuestionarioAziendaDAO();
		return questionario.doUpdate(pathDoc);
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
}
