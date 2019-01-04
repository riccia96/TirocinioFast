package Bean;

public class TutorBean implements java.io.Serializable {

	private static final long serialVersionUID = 3L;
	
	/**Costruttore*/

	public TutorBean() {
		this.username = "";
		this.password = "";
		this.matricola = "";
		this.email = "";
		this.username = "";
		this.password = "";
		this.domanda = "";
	}

	/**Getter e Setter*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	/**toString*/

	@Override
	public String toString(){
		return "Tutor [Nome: " + this.getNome() +
				"][Cognome: " + this.getCognome() +
				"][Matricola: " + this.getMatricola() +
				"][E-mail: " + this.getEmail() +
				"][Username: " + this.getUsername() +
				"][Password: " + this.getPassword() +
				"][Risposta: " + this.getDomanda() + "]";
	}
 
	/**Variabili di istanza*/

	private String nome;
	private String cognome;
	private String matricola;
	private String email;
	private String username;
	private String password;
	private String domanda;

}
