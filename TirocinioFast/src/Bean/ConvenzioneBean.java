package Bean;

public class ConvenzioneBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 6L;
	
	/**Costruttore*/
	
	public ConvenzioneBean() {}	
	
	/**Getter e Setter*/
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
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
	
	public boolean isConvalida() {
		return convalida;
	}
	
	public void setConvalida(boolean convalida) {
		this.convalida = convalida;
	}
	
	/**toString*/
	
	@Override
	public String toString() {
		return "ConvenzioneBean [Url: " + this.getUrl() + 
				"][Azienda: " + this.getAzienda() + 
				"][TutorAccademico: " + this.getTutorAccademico() +
				"][Convalida: " + this.isConvalida() + "]";
	}
	
	/**Variabili di istanza*/
	
	private String url;
	private int azienda;
	private int tutorAccademico;
	private boolean convalida;
	
}
