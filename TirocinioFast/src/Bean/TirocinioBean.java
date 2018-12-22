package Bean;

public class TirocinioBean implements java.io.Serializable {

	private static final long serialVersionUID = 5L;
	
	/**Costruttore*/

	public TirocinioBean() {}

	/**Getter e Setter*/

	public int getStudente() {
		return studente;
	}

	public void setStudente(int studente) {
		this.studente = studente;
	}

	public int getAzienda() {
		return azienda;
	}

	public void setAzienda(int azienda) {
		this.azienda = azienda;
	}

	public int getTutorAccademico() {
		return tutorAccademico;
	}

	public void setTutorAccademico(int tutorAccademico) {
		this.tutorAccademico = tutorAccademico;
	}

	public int getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(int impiegato) {
		this.impiegato = impiegato;
	}

	public String getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(String annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public boolean isHandicap() {
		return handicap;
	}

	public void setHandicap(boolean handicap) {
		this.handicap = handicap;
	}

	public String getSedeTirocinio() {
		return sedeTirocinio;
	}

	public void setSedeTirocinio(String sedeTirocinio) {
		this.sedeTirocinio = sedeTirocinio;
	}

	public String getAccessoLocali() {
		return accessoLocali;
	}

	public void setAccessoLocali(String accessoLocali) {
		this.accessoLocali = accessoLocali;
	}

	public String getPeriodoTirocinio() {
		return periodoTirocinio;
	}

	public void setPeriodoTirocinio(String periodoTirocinio) {
		this.periodoTirocinio = periodoTirocinio;
	}

	public String getObiettivoTirocinio() {
		return obiettivoTirocinio;
	}

	public void setObiettivoTirocinio(String obiettivoTirocinio) {
		this.obiettivoTirocinio = obiettivoTirocinio;
	}

	public String getFacilitazioni() {
		return facilitazioni;
	}

	public void setFacilitazioni(String facilitazioni) {
		this.facilitazioni = facilitazioni;
	}

	public boolean isConvalidaAzienda() {
		return convalidaAzienda;
	}

	public void setConvalidaAzienda(boolean convalidaAzienda) {
		this.convalidaAzienda = convalidaAzienda;
	}

	public boolean isConvalidaTutor() {
		return convalidaTutor;
	}

	public void setConvalidaTutor(boolean convalidaTutor) {
		this.convalidaTutor = convalidaTutor;
	}

	public boolean isConvalidaStudente() {
		return convalidaStudente;
	}

	public void setConvalidaStudente(boolean convalidaStudente) {
		this.convalidaStudente = convalidaStudente;
	}

	public boolean isConvalidaRichiesta() {
		return convalidaRichiesta;
	}

	public void setConvalidaRichiesta(boolean convalidaRichiesta) {
		this.convalidaRichiesta = convalidaRichiesta;
	}

	public boolean isConvalidaAttivita() {
		return convalidaAttivita;
	}

	public void setConvalidaAttivita(boolean convalidaAttivita) {
		this.convalidaAttivita = convalidaAttivita;
	}

	public String getRegistroOre() {
		return registroOre;
	}

	public void setRegistroOre(String registroOre) {
		this.registroOre = registroOre;
	}

	public String getQuestionarioStudente() {
		return questionarioStudente;
	}

	public void setQuestionarioStudente(String questionarioStudente) {
		this.questionarioStudente = questionarioStudente;
	}

	public String getQuestionarioAzienda() {
		return questionarioAzienda;
	}

	public void setQuestionarioAzienda(String questionarioAzienda) {
		this.questionarioAzienda = questionarioAzienda;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**toString*/
	
	@Override
	public String toString(){
		return "Tirocinio [Studente: " + this.getStudente() +
				"][Azienda: " + this.getAzienda() +
				"][Tutor accademico: " + this.getTutorAccademico() +
				"][Impieagato: " + this.getImpiegato() +
				"][Anno accademico: " + this.getAnnoAccademico() +
				"][CFU: " + this.getCfu() +
				"][Handicap: " + this.isHandicap() +
				"][Sede tirocinio: " + this.getSedeTirocinio() +
				"][Accesso ai locali: " + this.getAccessoLocali() +
				"][Periodo tirocinio: " + this.getPeriodoTirocinio() +
				"][Obiettivo tirocinio: " + this.getObiettivoTirocinio() +
				"][Facilitazioni: " + this.getFacilitazioni() +
				"][Convalida azienda: " + this.isConvalidaAzienda() +
				"][Convalida tutor: " + this.isConvalidaTutor() +
				"][Convalida studente: " + this.isConvalidaStudente() +
				"][Convalida richiesta: " + this.isConvalidaRichiesta() +
				"][Convalida attività: " + this.isConvalidaAttivita() +
				"][Registro ore: " + this.getRegistroOre() +
				"][Questionario studente: " + this.getQuestionarioStudente() +
				"][Questionario azienda: " + this.getQuestionarioAzienda() +
				"][Url: " + this.getUrl() + "]";
	}

	/**Variabili di istanza*/

	private int studente;
	private int azienda;
	private int tutorAccademico;
	private int impiegato;
	private String annoAccademico;
	private int cfu;
	private boolean handicap;
	private String sedeTirocinio;
	private String accessoLocali;
	private String periodoTirocinio;
	private String obiettivoTirocinio;
	private String facilitazioni;
	private boolean convalidaAzienda;
	private boolean convalidaTutor;
	private boolean convalidaStudente;
	private boolean convalidaRichiesta;
	private boolean convalidaAttivita;
	private String registroOre;
	private String questionarioStudente;
	private String questionarioAzienda;
	private String url;
	
}
