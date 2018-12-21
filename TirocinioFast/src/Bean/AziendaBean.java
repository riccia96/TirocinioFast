package Bean;

import java.sql.Date;

public class AziendaBean implements java.io.Serializable {

	private static final long serialVersionUID = 2L;
	
	/**Costruttore*/

	public AziendaBean() {}

	/**Getter e Setter*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getCEO() {
		return CEO;
	}

	public void setCEO(String CEO) {
		this.CEO = CEO;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public String getLuogoNascitaCEO() {
		return luogoNascitaCEO;
	}

	public void setLuogoNascitaCEO(String luogoNascitaCEO) {
		this.luogoNascitaCEO = luogoNascitaCEO;
	}

	public Date getDataNascitaCEO() {
		return dataNascitaCEO;
	}

	public void setDataNascitaCEO(Date dataNascitaCEO) {
		this.dataNascitaCEO = dataNascitaCEO;
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


	/**toString*/
	
	@Override
	public String toString(){
		return "Azienda [Nome: " + this.getNome() +
				"][Partita Iva: " + this.getPartitaIva() +
				"][CEO: " + this.getCEO() +
				"][Sede: " + this.getSede() +
				"][E-mail: " + this.getEmail() +
				"][Telefono: " + this.getTelefono() +
				"][Username: " + this.getUsername() +
				"][Password: " + this.getPassword() +
				"][Risposta: " + this.getDomanda() +
				"][Luogo nascita CEO: " + this.getLuogoNascitaCEO() +
				"][Data nascita CEO: " + this.getDataNascitaCEO() +
				"][Numero dipendenti: " + this.getNumeroDipendenti() +
				"][Referente: " + this.getReferente() +
				"][Telefono referente: " + this.getTelefonoReferente() +
				"][E-mail referente: " + this.getEmailReferente() +
				"][Attivita: " + this.getAttivita() + "]";
	}

	/**Variabili di istanza*/

	private String nome;
	private String partitaIva;
	private String CEO;
	private String sede;
	private String email;
	private String telefono;
	private String username;
	private String password;
	private String domanda;
	private String luogoNascitaCEO;
	private Date dataNascitaCEO;
	private int numeroDipendenti;
	private String referente;
	private String telefonoReferente;
	private String emailReferente;
	private String attivita;

}
