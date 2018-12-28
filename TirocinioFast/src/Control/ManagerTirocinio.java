package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.AziendaBean;
import Model.AziendaDAO;

public class ManagerTirocinio {
	
	public List<AziendaBean> ricercaAzienda() throws SQLException{
		List<AziendaBean> lAzienda = new ArrayList<AziendaBean>();
		AziendaDAO aziende = new AziendaDAO();
		lAzienda.addAll(aziende.doRetrieveAll());
		return lAzienda;
	}
	
	
	
	/*

	public List<AziendaBean> ricercaAzienda(String nome, String sede) throws SQLException{
		
		List<AziendaBean> lAzienda = new ArrayList<AziendaBean>();
		AziendaDAO azienda = new AziendaDAO();
		
		lAzienda.addAll(azienda.doRetrieveAll());
		
		for(int i = 0; i < lAzienda.size(); i++){
			
			if(!lAzienda.get(i).getNome().equals(nome)){
				
				String indirizzo = lAzienda.get(i).getIndirizzo();
				
				if(indirizzo.compareTo(sede) != 0)
					lAzienda.remove(i);
				
			}
		}
		
		return lAzienda;
		
	}
	
	public List<AziendaBean> ricercaAziendaNome(String nome) throws SQLException{
		
		List<AziendaBean> lAzienda = new ArrayList<AziendaBean>();
		AziendaDAO azienda = new AziendaDAO();
		
		lAzienda.addAll(azienda.doRetrieveAll());
		
		for(int i = 0; i < lAzienda.size(); i++){
			
			if(!lAzienda.get(i).getNome().equals(nome))
				lAzienda.remove(i);
			
		}
		
		return lAzienda;
		
	}
	
	public List<AziendaBean> ricercaAziendaSede(String sede) throws SQLException{
		
		List<AziendaBean> lAzienda = new ArrayList<AziendaBean>();
		AziendaDAO azienda = new AziendaDAO();
		
		lAzienda.addAll(azienda.doRetrieveAll());
		
		for(int i = 0; i < lAzienda.size(); i++){
			
			String indirizzo = lAzienda.get(i).getIndirizzo();
			
			if(indirizzo.compareTo(sede) != 0)
				lAzienda.remove(i);
			
		}
		
		return lAzienda;
		
	}
	
	*/
	
}
