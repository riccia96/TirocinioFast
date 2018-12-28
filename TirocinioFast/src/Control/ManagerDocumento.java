package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.AziendaBean;
import Bean.ConvenzioneBean;
import Bean.QuestionarioAziendaBean;
import Bean.QuestionarioStudenteBean;
import Bean.StudenteBean;
import Bean.TirocinioBean;
import Bean.TutorBean;
import Model.AziendaDAO;
import Model.ConvenzioneDAO;
import Model.QuestionarioAziendaDAO;
import Model.QuestionarioStudenteDAO;
import Model.StudenteDAO;
import Model.TirocinioDAO;
import Model.TutorAccademicoDAO;

public class ManagerDocumento {

	public boolean Download(String pathDoc){
		return false;
	}
	
	public boolean Upload(String pathDoc){
		return false;
	}
	
	public List<TirocinioBean> richiesteTirocinio() throws SQLException{
		
		List<TirocinioBean> lTirocinio = new ArrayList<TirocinioBean>();
		TirocinioDAO tirocinio = new TirocinioDAO();
		
		lTirocinio.addAll(tirocinio.doRetrieveAll());
		
		return lTirocinio;
		
	}
	
	public List<ConvenzioneBean> convenzioni() throws SQLException{
		
		List<ConvenzioneBean> lConvenzioni = new ArrayList<ConvenzioneBean>();
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		
		lConvenzioni.addAll(convenzione.doRetrieveAll());
		
		return lConvenzioni;
		
	}
	
	public boolean compilaRichiestaTirocinio(String idStudente, String idAzienda, String idTutor, String annoAccademico, int cfu, boolean handicap) throws SQLException{
		
		TirocinioDAO tirocinio = new TirocinioDAO();
		TirocinioBean t = new TirocinioBean();
		StudenteBean studente = new StudenteBean();
		AziendaBean azienda = new AziendaBean();
		TutorBean tutor = new TutorBean();
		StudenteDAO dStudente = new StudenteDAO();
		AziendaDAO dAzienda = new AziendaDAO();
		TutorAccademicoDAO dTutor = new TutorAccademicoDAO();
		List<StudenteBean> lStudente = new ArrayList<StudenteBean>();
		List<AziendaBean> lAzienda = new ArrayList<AziendaBean>();
		List<TutorBean> lTutor = new ArrayList<TutorBean>();
		
		lStudente.addAll(dStudente.doRetrieveAll());
		lAzienda.addAll(dAzienda.doRetrieveAll());
		lTutor.addAll(dTutor.doRetrieveAll());
		
		for(int i = 0; i < lStudente.size(); i++){
			
			if(lStudente.get(i).getMatricola() == idStudente){
				studente = lStudente.get(i);
				break;
			}
		}
		
		for(int i = 0; i < lAzienda.size(); i++){
			
			if(lAzienda.get(i).getPartitaIva().equals(idAzienda)){
				azienda = lAzienda.get(i);
				break;
			}
		}
		
		for(int i = 0; i < lTutor.size(); i++){
			
			if(lTutor.get(i).getMatricola().equals(idTutor)){
				tutor = lTutor.get(i);
				break;
			}
		}
		
		t.setStudente(studente.getMatricola());
		t.setAzienda(azienda.getPartitaIva());
		t.setTutorAccademico(tutor.getMatricola());
		t.setImpiegato(null);
		t.setAnnoAccademico(annoAccademico);
		t.setCfu(cfu);
		t.setHandicap(handicap);
				
		if(tirocinio.doSave(t) != -1)
			return true;
		
		return false;
	}
	
	public boolean compilaRichiestaTirocinioAzienda(String idAzienda, String idStudente, String sedeTirocinio, String periodoTirocinio, String accessoLocali,
			String obiettivoTirocinio, String facilitazioni) throws SQLException{
		
		TirocinioDAO tirocinio = new TirocinioDAO();
		TirocinioBean t = new TirocinioBean();
		
		t = tirocinio.doRetrieveByKey(idStudente);
		
		t.setSedeTirocinio(sedeTirocinio);
		t.setAccessoLocali(accessoLocali);
		t.setPeriodoTirocinio(periodoTirocinio);
		t.setObiettivoTirocinio(obiettivoTirocinio);
		t.setFacilitazioni(facilitazioni);
		//t.setConvalidaAzienda(true);
		
		if(tirocinio.doSave(t) != -1) {
			return true;
		}
		else {
		return false;
		}
	}
	
	public boolean compilaConvenzione(String idAzienda, String luogoNascita, String dataNascita, int numDipendenti, String referente, String telefonoReferente, String emailReferente, String descrizione, String docente) throws SQLException{
		ConvenzioneDAO convenzione = new ConvenzioneDAO();
		ConvenzioneBean c = new ConvenzioneBean();
		
		c.setAzienda(idAzienda);
		c.setLuogoNascitaCeo(luogoNascita);
		c.setDataNascitaCeo(dataNascita);
		c.setNumeroDipendenti(numDipendenti);
		c.setReferente(referente);
		c.setTelefonoReferente(telefonoReferente);
		c.setEmailReferente(emailReferente);
		c.setAttivita(descrizione);
		c.setTutorAccademico(docente);
		
		convenzione.doSave(c);
		
		return true;
	}
	
	public boolean compilaQuestionarioStudente(String idStudente, String idAzienda, String idTutor, String titolo, String periodo) throws SQLException{
		QuestionarioStudenteDAO qsd = new QuestionarioStudenteDAO();
		QuestionarioStudenteBean qsb = new QuestionarioStudenteBean();
		TirocinioDAO td = new TirocinioDAO();
		TirocinioBean tb = new TirocinioBean();
		
		qsb.setStudente(idStudente);
		qsb.setAzienda(idAzienda);
		qsb.setTutorAccademico(idTutor);
		qsb.setTitolo(titolo);
		qsb.setPeriodo(periodo);
		
		qsd.doSave(qsb);
		
		/*
		tb.setStudente(idStudente);
		tb.setAzienda(idAzienda);
		tb = td.doRetrieveByKey(tb);
		tb.setQuestionarioStudente(questionarioStudente);
	*/	
		return true;
	}
	
	public boolean compilaQuestionarioAzienda(String idAzienda, String idStudente, String idTutor, String titolo, String periodo, String posizioneRicoperta) throws SQLException{
		QuestionarioAziendaDAO qad = new QuestionarioAziendaDAO();
		QuestionarioAziendaBean qab = new QuestionarioAziendaBean();
		
		qab.setAzienda(idAzienda);
		qab.setStudente(idStudente);
		qab.setTutorAccademico(idTutor);
		qab.setTitoloTirocinio(titolo);
		qab.setPeriodoTirocinio(periodo);
		qab.setPosizioneRicoperta(posizioneRicoperta);
		
		qad.doSave(qab);
		
		
		
		return true;
	}
	/*
	public boolean convalidaTirocinio(String idStudente, String idAzienda, String idTutor, String pathRichiestaTirocinio, String pathQuestionarioStudente, String pathQuestionarioAzienda, String pathQuestionarioAzienda){
		
	}
	*/
}
