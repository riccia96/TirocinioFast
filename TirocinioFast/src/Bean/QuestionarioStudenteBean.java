package Bean;

public class QuestionarioStudenteBean implements java.io.Serializable {

	private static final long serialVersionUID = 7L;
	
	/**Costruttore*/

	public QuestionarioStudenteBean() {}

	/**Getter e Setter*/

	public String getStudente() {
		return studente;
	}

	public void setStudente(String studente) {
		this.studente = studente;
	}

	public String getTutorAccademico() {
		return tutorAccademico;
	}

	public void setTutorAccademico(String tutorAccademico) {
		this.tutorAccademico = tutorAccademico;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	
	public String getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(String impiegato) {
		this.impiegato = impiegato;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**toString*/

	@Override
	public String toString(){
		return "Questionario azienda [Studente: " + this.getStudente() +
				"][Tutor accademico: " + this.getTutorAccademico() +
				"][Azienda: " + this.getAzienda() +
				"][Impiegato: " + this.getImpiegato() +
				"][Periodo: " + this.getPeriodo() +
				"][Titolo: " + this.getTitolo() +
				"][Convalida: " + this.isConvalida() +
				"][Url: " + this.getUrl() + "]";
	}

	/**Variabili di istanza*/

	private String studente;
	private String tutorAccademico;
	private String azienda;
	private String impiegato;
	private String periodo;
	private String titolo;
	private boolean	convalida;
	private String url;

}
