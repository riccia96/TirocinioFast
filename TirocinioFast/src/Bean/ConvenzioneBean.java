package Bean;

public class ConvenzioneBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 6L;
	
	/**Costruttore*/
	
	public ConvenzioneBean() {}	
	
	/**Getter e Setter*/
	
	
	/**toString*/
	
	@Override
	public String toString() {
		return "ConvenzioneBean [Azienda: " + this.getAzienda() + 
				"][TutorAccademico: " + this.getTutorAccademico() +
				"][Impiegato: " + this.getImpiegato() + 
				"][Luogo nascita CEO: " + this.getLuogoNascitaCEO() +
				"][Data nascita CEO: " + this.getDataNascitaCEO() +
				"][Numero dipendenti: " + this.getNumeroDipendenti() +
				"][Referente: " + this.getReferente() +
				"][Telefono referente: " + this.getTelefonoReferente() +
				"][E-mail referente: " + this.getEmailReferente() +
				"][Attivita: " + this.getAttivita() + 
				"][Convalida: " + this.isConvalida() + 
				"][Url: " + this.getUrl() + "]";
	}
	
	/**Variabili di istanza*/
	
	private int azienda;
	private int tutorAccademico;
	private int impiegato;
	private String luogoNascitaCeo;
	private String dataNascitaCeo;
	private int numeroDipendenti;
	private String referente;
	private String telefonoReferente;
	private String emailReferente;
	private String attivita;
	private boolean convalida;
	private String url;
	
}
