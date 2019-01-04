package Bean;

public class QuestionarioAziendaBean implements java.io.Serializable {

	

	private static final long serialVersionUID = 8L;
	
	/**Costruttore*/

	public QuestionarioAziendaBean() {
		this.studente = "";
		this.azienda = "";
		this.tutorAccademico = "";
		this.impiegato = "";
		this.periodoTirocinio = "";
		this.titoloTirocinio = "";
		this.posizioneRicoperta = "";
		this.convalida = false;
		this.url = "";

	}

	/**Getter e Setter*/
 
	public String getStudente() {
		return studente;
	}

	public void setStudente(String studente) {
		this.studente = studente;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	public String getTutorAccademico() {
		return tutorAccademico;
	}

	public void setTutorAccademico(String tutorAccademico) {
		this.tutorAccademico = tutorAccademico;
	}

	public String getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(String impiegato) {
		this.impiegato = impiegato;
	}

	public String getPeriodoTirocinio() {
		return periodoTirocinio;
	}

	public void setPeriodoTirocinio(String periodoTirocinio) {
		this.periodoTirocinio = periodoTirocinio;
	}

	public String getTitoloTirocinio() {
		return titoloTirocinio;
	}

	public void setTitoloTirocinio(String titoloTirocinio) {
		this.titoloTirocinio = titoloTirocinio;
	}

	public String getPosizioneRicoperta() {
		return posizioneRicoperta;
	}

	public void setPosizioneRicoperta(String posizioneRicoperta) {
		this.posizioneRicoperta = posizioneRicoperta;
	}

	public boolean isConvalida() {
		return convalida;
	}

	public void setConvalida(boolean convalida) {
		this.convalida = convalida;
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
		return "Questionario azienda [Studente: " + this.getStudente() +
				"][Azienda: " + this.getAzienda() +
				"][Tutor accademico: " + this.getTutorAccademico() +
				"][Impiegato: " + this.getImpiegato() +
				"][Periodo: " + this.getPeriodoTirocinio() +
				"][Titolo: " + this.getTitoloTirocinio() +
				"][Posizione ricoperta: " + this.getPosizioneRicoperta() + 
				"][Convalida: " + this.isConvalida() +
				"][Url: " + this.getUrl() + "]";
	}

	/**Variabili di istanza*/

	private String studente;
	private String azienda;
	private String tutorAccademico;
	private String impiegato;
	private String periodoTirocinio;
	private String titoloTirocinio;
	private String posizioneRicoperta;
	private boolean convalida;
	private String url;

}
