package control;

import bean.ConvenzioneBean;
import bean.QuestionarioAziendaBean;
import bean.QuestionarioStudenteBean;
import bean.TirocinioBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConvenzioneDAO;
import model.QuestionarioAziendaDAO;
import model.QuestionarioStudenteDAO;
import model.TirocinioDAO;


public class ManagerDocumento {
  TirocinioDAO tDao = new TirocinioDAO();
  ConvenzioneDAO cDao = new ConvenzioneDAO();
  QuestionarioStudenteDAO qsDao = new QuestionarioStudenteDAO();
  QuestionarioAziendaDAO qaDao = new QuestionarioAziendaDAO();
  List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
  List<ConvenzioneBean> convenzioni = new ArrayList<ConvenzioneBean>();
  List<QuestionarioStudenteBean> questionari = new ArrayList<QuestionarioStudenteBean>();
  List<QuestionarioAziendaBean> questionariAzienda = new ArrayList<QuestionarioAziendaBean>();


  public int generaCodiceTirocinio() throws SQLException {

    return tDao.generaCodice();
  }

  public int generaCodiceConvenzione() throws SQLException {

    return cDao.generaCodice();
  }

  public int generaCodiceQuestionarioStudente() throws SQLException {

    return qsDao.generaCodice();
  }

  public int generaCodiceQuestionarioAzienda() throws SQLException {
    return qaDao.generaCodice();
  }

  public TirocinioBean getTirocinio(TirocinioBean tirocinio) throws SQLException {
    return tDao.doRetrieveByKey(tirocinio);
  }

  public ConvenzioneBean getConvenzione(ConvenzioneBean convenzione) throws SQLException {
    return cDao.doRetrieveByKey(convenzione);
  }

  public QuestionarioStudenteBean getQuestionarioStudente(QuestionarioStudenteBean questionario)
        throws SQLException {
    return qsDao.doRetrieveByKey(questionario);
  }

  public QuestionarioAziendaBean getQuestionarioAzienda(QuestionarioAziendaBean questionario) 
        throws SQLException {
    return qaDao.doRetrieveByKey(questionario);
  }

  public int salvaTirocinio(TirocinioBean tirocinio) throws SQLException {
    return tDao.doSave(tirocinio);
  }

  public int salvaConvenzione(ConvenzioneBean convenzione) throws SQLException {
    return cDao.doSave(convenzione);
  }

  public int salvaQuestionarioStudente(QuestionarioStudenteBean questionario) throws SQLException {
    return qsDao.doSave(questionario);
  }

  public int salvaQuestionarioAzienda(QuestionarioAziendaBean questionario) throws SQLException {
    return qaDao.doSave(questionario);
  }


  public boolean aggiornaTirocinio(TirocinioBean tirocinio) throws SQLException {
    return tDao.doUpdate(tirocinio);
  }

  public boolean aggiornaConvenzione(ConvenzioneBean convenzione) throws SQLException {
    return cDao.doUpdate(convenzione);
  }

  public boolean aggiornaQuestionarioStudente(QuestionarioStudenteBean questionario) 
         throws SQLException {
    return qsDao.doUpdate(questionario);
  }


  public boolean aggiornaQuestionarioAzienda(QuestionarioAziendaBean questionario) 
         throws SQLException {
    return qaDao.doUpdate(questionario);
  }

  public boolean eliminaTirocinio(TirocinioBean tirocinio) throws SQLException {
    return tDao.doDelete(tirocinio);
  }

  public boolean eliminaConvenzione(ConvenzioneBean convenzione) throws SQLException {
    return cDao.doDelete(convenzione);
  }

  public boolean eliminaQuestionarioStudente(QuestionarioStudenteBean questionario) 
         throws SQLException {
    return qsDao.doDelete(questionario);
  }

  public boolean eliminaQuestionarioAzienda(QuestionarioAziendaBean questionario) 
         throws SQLException {
    return qaDao.doDelete(questionario);
  }

  public List<TirocinioBean> getTirocini(String order) throws SQLException {
    tirocini.addAll(tDao.doRetrieveAll(order));
    return tirocini;

  }

  public List<ConvenzioneBean> getConvenzioni(String order) throws SQLException {
    convenzioni.addAll(cDao.doRetrieveAll(order));
    return convenzioni;

  }

  public List<QuestionarioStudenteBean> getQuestionariStudente(String order) throws SQLException {
    questionari = qsDao.doRetrieveAll(order);
    return questionari;
  }

  public List<QuestionarioAziendaBean> getQuestionariAzienda(String order) throws SQLException {
    questionariAzienda = qaDao.doRetrieveAll(order);
    return questionariAzienda;
  }
}
