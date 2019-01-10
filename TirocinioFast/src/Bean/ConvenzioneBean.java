package Bean;

public class ConvenzioneBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 6L;
	
	/**Costruttore*/
	
	public ConvenzioneBean() {
		this.id = -1;
		this.azienda = "";
		this.tutorAccademico = "";
		this.impiegato = "";
		this.luogoNascitaCeo = "";
		this.dataNascitaCeo = "";
		this.numeroDipendenti = 0;
		this.referente = "";
		this.telefonoReferente = "";
		this.emailReferente = "";
		this.attivita = "";
		this.convalida = false;
		this.url = "";
	}	
	
	/**Getter e Setter*/
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
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
 
	public String getLuogoNascitaCeo() {
		return luogoNascitaCeo;
	}

	public void setLuogoNascitaCeo(String luogoNascitaCeo) {
		this.luogoNascitaCeo = luogoNascitaCeo;
	}

	public String getDataNascitaCeo() {
		return dataNascitaCeo;
	}

	public void setDataNascitaCeo(String dataNascitaCeo) {
		this.dataNascitaCeo = dataNascitaCeo;
	}

	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}

	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}

	public String getReferente() {
		return referente;
	}

	public void setReferente(String referente) {
		this.referente = referente;
	}

	public String getTelefonoReferente() {
		return telefonoReferente;
	}

	public void setTelefonoReferente(String telefonoReferente) {
		this.telefonoReferente = telefonoReferente;
	}

	public String getEmailReferente() {
		return emailReferente;
	}

	public void setEmailReferente(String emailReferente) {
		this.emailReferente = emailReferente;
	}

	public String getAttivita() {
		return attivita;
	}

	public void setAttivita(String attivita) {
		this.attivita = attivita;
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
	public String toString() {
		return "ConvenzioneBean [Azienda: " + this.getAzienda() + 
				"][TutorAccademico: " + this.getTutorAccademico() +
				"][Impiegato: " + this.getImpiegato() + 
				"][Luogo nascita CEO: " + this.getLuogoNascitaCeo() +
				"][Data nascita CEO: " + this.getDataNascitaCeo() +
				"][Numero dipendenti: " + this.getNumeroDipendenti() +
				"][Referente: " + this.getReferente() +
				"][Telefono referente: " + this.getTelefonoReferente() +
				"][E-mail referente: " + this.getEmailReferente() +
				"][Attivita: " + this.getAttivita() + 
				"][Convalida: " + this.isConvalida() + 
				"][Url: " + this.getUrl() + "]";
	}
	
	/**Variabili di istanza*/
	
	
	private String azienda;
	private String tutorAccademico;
	private String impiegato;
	private String luogoNascitaCeo;
	private String dataNascitaCeo;
	private int numeroDipendenti;
	private String referente;
	private String telefonoReferente;
	private String emailReferente;
	private String attivita;
	private boolean convalida;
	private String url;
	private int id;
	
}
