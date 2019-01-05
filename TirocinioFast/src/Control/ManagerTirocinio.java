package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.AziendaBean;
import Bean.TirocinioBean;
import Model.AziendaDAO;

import Model.TirocinioDAO;

public class ManagerTirocinio {
	
	public List<AziendaBean> ricercaAzienda() throws SQLException{
		List<AziendaBean> lAzienda = new ArrayList<AziendaBean>();
		AziendaDAO aziende = new AziendaDAO();
		lAzienda.addAll(aziende.doRetrieveAll());
		return lAzienda;
	}
	
	public int salvaTirocinio(TirocinioBean tirocinio) throws SQLException{
		TirocinioDAO tDAO = new TirocinioDAO();
		return tDAO.doSave(tirocinio);
	}
	
	public List<TirocinioBean> richiesteTirocinio()throws SQLException {
		List<TirocinioBean> lTirocinio = new ArrayList<TirocinioBean>();
		TirocinioDAO tirocini = new TirocinioDAO();
		lTirocinio.addAll(tirocini.doRetrieveAll());
		return lTirocinio;
	}
	
	public TirocinioBean richiestaTirocinio(TirocinioBean tirocinio) throws SQLException{
		TirocinioDAO tDAO = new TirocinioDAO();
		return tDAO.doRetrieveByKey(tirocinio);
	}
	
	public boolean inoltraRichiesta(TirocinioBean tirocinio)throws SQLException{
		TirocinioDAO tDAO = new TirocinioDAO();
		return tDAO.doUpdate(tirocinio);
	}
	
}
