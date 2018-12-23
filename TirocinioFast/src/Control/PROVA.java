package Control;

import java.sql.SQLException;

import Bean.StudenteBean;
import Model.StudenteDAO;

public class PROVA {

	public static void main(String[] args) throws SQLException {
	StudenteDAO prova = new StudenteDAO();
	StudenteBean stud = new StudenteBean();
	
	stud.setNome("Anna");
	stud.setCognome("Riccio");
	stud.setLuogoNascita("Napoli");
	stud.setDataNascita("04-09-1996");
	stud.setIndirizzo("Via Scotola");
	stud.setCitta("Somma Vesuviana");
	stud.setCodiceFiscale("rccnmr96e");
	stud.setMatricola("049504");
	stud.setEmail("anna.ricco@tohmt.cci");
	stud.setTelefono("43424322");
	stud.setUsername("sbanfsde");
	stud.setPassword("troppobrava");
	stud.setDomanda("oookkkkkkkay");
	
	prova.doSave(stud);
	System.out.println("è andato tutto bene");
	
	
	}
	

}
