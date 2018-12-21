package Bean;

public class AziendaBean implements java.io.Serializable {

	private static final long serialVersionUID = 2L;
	
	/**Costruttore*/

	public AziendaBean() {}

	/**Getter e Setter*/



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
				"][Risposta: " + this.getDomanda() + "]";
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

}
