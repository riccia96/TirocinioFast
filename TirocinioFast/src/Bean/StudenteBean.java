package Bean;

import java.io.Serializable;

public class StudenteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**Costruttore*/
	
	public StudenteBean() {}

	/**Getter e Setter*/

	
	/**toString*/
	
	@Override
	public String toString(){
		return "Studente [Nome: " + this.getNome() + 
			   "][Cognome: " + this.getCognome() + 
			   "][Matricola: " + this.getMatricola() +
			   "][Luogo Nascita: " + this.getLuogoNascita() +
			   "][Data Nascita: " + this.getDataNascita() +
			   "][Indirizzo: " + this.getIndirizzo() +
			   "][Città: " + this.getCitta() +
			   "][Codice Fiscale: " + this.getCodiceFiscale() +
			   "][Telefono: " + this.getTelefono() +
			   "][E-mail: " + this.getEmail() +
			   "][Username: " + this.getUsername() +
			   "][Password: " + this.getPassword() +
			   "][Risposta: " + this.getDomanda() + "]";
	}

	/**Variabili di istanza*/
	
	private String nome;
	private String cognome;
	private String luogoNascita;
	private String dataNascita;
	private String indirizzo;
	private String citta;
	private String codiceFiscale;
	private String matricola;
	private String email;
	private String telefono;
	private String username;
	private String password;
	private String domanda;
}
