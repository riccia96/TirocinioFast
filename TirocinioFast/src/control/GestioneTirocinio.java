package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AziendaBean;
import bean.ConvenzioneBean;
import bean.QuestionarioAziendaBean;
import bean.QuestionarioStudenteBean;
import bean.StudenteBean;
import bean.TirocinioBean;
import bean.TutorBean;

/**
 * Servlet implementation class GestioneTirocinio
 */
@WebServlet("/GestioneTirocinio")
public class GestioneTirocinio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ManagerUtente utente = new ManagerUtente();
	static ManagerTirocinio richiesta = new ManagerTirocinio();
	static ManagerDocumento documento = new ManagerDocumento();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String azioneTirocinio = request.getParameter("azioneTirocinio");
		
		if(azioneTirocinio.equals("richiediTirocinio")){
			try {
				String aziendaTirocinio = request.getParameter("aziendaSelezionata");

				List<TutorBean> tutorAccademici = utente.getTutorAccademici();

				request.getSession().setAttribute("aziendaTirocinio", aziendaTirocinio);
				request.getSession().setAttribute("elencoTutor", tutorAccademici);
				RequestDispatcher view = request.getRequestDispatcher("richiestaTirocinioStudente.jsp");
				view.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("inoltroRichiestaTutor")) {

			try {
				TirocinioBean tirocinio = new TirocinioBean();
				int id = Integer.parseInt((String) request.getSession().getAttribute("idTirocinio"));
				tirocinio.setId(id);
				tirocinio = richiesta.richiestaTirocinio(tirocinio);

				tirocinio.setConvalidaAzienda(true);
				richiesta.inoltraRichiesta(tirocinio);

				RequestDispatcher view = request.getRequestDispatcher("richiesteTirocinio.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("inoltroRichiestaStudente")) {
			try {
				TirocinioBean tirocinio = new TirocinioBean();
				int id = Integer.parseInt((String) request.getSession().getAttribute("idTirocinio"));
				tirocinio.setId(id);
				tirocinio = richiesta.richiestaTirocinio(tirocinio);

				tirocinio.setConvalidaTutor(true);
				richiesta.inoltraRichiesta(tirocinio);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("inoltroRichiestaImpiegato")) {
			try{
				TirocinioBean tirocinio = new TirocinioBean();
				int id = Integer.parseInt((String) request.getSession().getAttribute("idTirocinio"));
				tirocinio.setId(id);
				tirocinio = richiesta.richiestaTirocinio(tirocinio);

				tirocinio.setConvalidaStudente(true);
				richiesta.inoltraRichiesta(tirocinio);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("elencoAziende")) {
			try {
				List<AziendaBean> aziendeConv = new ArrayList<AziendaBean>();
				List<AziendaBean> az = utente.getAziende();
				List<ConvenzioneBean> conv = documento.convenzioni();

				request.getSession().removeAttribute("listaAziende");

				for(AziendaBean a : az) {

					for(ConvenzioneBean c : conv) {

						if(a.getUsername().equals(c.getAzienda()) && c.isConvalida()) {

							aziendeConv.add(a);
						}
					}
				}

				if(aziendeConv.equals(null)) {
					RequestDispatcher view = request.getRequestDispatcher("nessunaRisorsa.jsp");
					view.forward(request, response);
				}
				else {

					request.getSession().setAttribute("listaAziende", aziendeConv);

					RequestDispatcher view = request.getRequestDispatcher("elencoAziendeConvenzionate.jsp");
					view.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("schedaAzienda")) {
			try {

				String username = request.getParameter("scheda");

				AziendaBean azienda = new AziendaBean();
				azienda.setUsername(username);

				AziendaBean a = utente.getAzienda(azienda);

				request.getSession().setAttribute("aziendaSelezionata", a);
				RequestDispatcher view = request.getRequestDispatcher("visualizzaScheda.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("ricercaAzienda")) {
			try {
				List<AziendaBean> aziende = utente.getAziende();
				List<ConvenzioneBean> convenzioni = documento.convenzioni();
				List<AziendaBean> aziendeConv = new ArrayList<AziendaBean>();
				String nome = request.getParameter("nomeAzienda").toLowerCase();
				String sede = request.getParameter("sedeAzienda").toLowerCase();
				for(AziendaBean a : aziende) {

					for(ConvenzioneBean c : convenzioni) {
						
						if(a.getUsername().equals(c.getAzienda()) && c.isConvalida()) {
							aziendeConv.add(a);
							
						}
						
					}
				}

				if(aziendeConv.size() == 0) {
					RequestDispatcher view = request.getRequestDispatcher("nessunaRisorsa.jsp");
					view.forward(request, response);
				}
				else {

					List<AziendaBean> listaAziende = new ArrayList<AziendaBean>();
					for(AziendaBean a : aziendeConv){
						if(!(nome.equals(null)) && !(sede.equals(null))){
							if(a.getNome().toLowerCase().contains(nome) && a.getIndirizzo().toLowerCase().contains(sede)){
								listaAziende.add(a);
							}
						}else if(!(nome.equals(null)) && sede.equals(null)){
							if(a.getNome().toLowerCase().contains(nome)){
								listaAziende.add(a);
							}
						}else if(nome.equals(null) && !(sede.equals(null))){
							if(a.getIndirizzo().toLowerCase().contains(sede)){
								listaAziende.add(a);
							}
						} 
					}

					request.getSession().setAttribute("listaAziende", listaAziende);

					RequestDispatcher view = request.getRequestDispatcher("elencoAziendeConvenzionate.jsp");
					view.forward(request, response);
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
