package Control;

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

import Bean.AziendaBean;
import Bean.ConvenzioneBean;
import Bean.ImpiegatoBean;
import Bean.StudenteBean;
import Bean.TirocinioBean;
import Bean.TutorBean;

/**
 * Servlet implementation class GestioneTirocinio
 */
@WebServlet("/GestioneTirocinio")
public class GestioneTirocinio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudenteBean studente = new StudenteBean();
	List<StudenteBean> studenti = new ArrayList<StudenteBean>();
	AziendaBean azienda = new AziendaBean();
	List<AziendaBean> aziende = new ArrayList<AziendaBean>();
	TutorBean tutor = new TutorBean();
	List<TutorBean> tutors = new ArrayList<TutorBean>();
	ImpiegatoBean impiegato = new ImpiegatoBean();

	TirocinioBean tirocinio = new TirocinioBean();
	List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
	List<ConvenzioneBean> convenzioni = new ArrayList<ConvenzioneBean>();

	ManagerUtente utente = new ManagerUtente();
	ManagerTirocinio richiesta = new ManagerTirocinio();
	ManagerDocumento documento = new ManagerDocumento();

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

		if(azioneTirocinio.equals("inoltraRichiesta")){
			//username azienda selezionata
			String aziendaTirocinio = request.getParameter("aziendaSelezionata");

			request.getSession().setAttribute("aziendaTirocinio", aziendaTirocinio);

			RequestDispatcher view = request.getRequestDispatcher("inoltraRichiesta.jsp");
			view.forward(request, response);
		}

		if(azioneTirocinio.equals("tirocinioDatiStudente")) {
			try {
				studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
				String aziendaTirocinio = (String) request.getSession().getAttribute("aziendaTirocinio");
				String tutorAccademico = request.getParameter("tutor"); 
				String annoAccademico = request.getParameter("annoAccademico");
				int cfu = Integer.parseInt(request.getParameter("cfu"));
				String h = request.getParameter("handicap");
				boolean handicap;
				if(h.equals("si")) {
					handicap = true;
				} else {
					handicap = false;
				}

				tirocinio.setStudente(studente.getUsername());
				tirocinio.setAzienda(aziendaTirocinio);
				tirocinio.setTutorAccademico(tutorAccademico);
				tirocinio.setAnnoAccademico(annoAccademico);
				tirocinio.setCfu(cfu);
				tirocinio.setHandicap(handicap);

				richiesta.salvaTirocinio(tirocinio);

				RequestDispatcher view = request.getRequestDispatcher("homeStudente.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}



		if(azioneTirocinio.equals("elencoRichiesteTirocinio")) {
			try {
				tirocini.addAll(documento.richiesteTirocinio());
				List<TirocinioBean> richieste = new ArrayList<TirocinioBean>();

				if(!(request.getSession().getAttribute("tipoUtente") == "studente")) {
					if(!(request.getSession().getAttribute("tipoUtente") == "azienda")) {
						if(!(request.getSession().getAttribute("tipoUtente") == "tutor")) {

							for(TirocinioBean t : tirocini) {
								if(t.isConvalidaAzienda() && t.isConvalidaTutor() && t.isConvalidaStudente()) {
									richieste.add(t);
								}
							}

							request.getSession().setAttribute("richiesteTirocinio", richieste);

							if(richieste.equals(null)) {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("nessuna richiesta");
							}

							RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteTirocinio.jsp");
							view.forward(request, response);
						} else {
							tutor = (TutorBean) request.getSession().getAttribute("utenteSessione");

							for(TirocinioBean t : tirocini) {
								if(t.isConvalidaAzienda() && t.getTutorAccademico().equals(tutor.getUsername())) {
									richieste.add(t);
								}
							}

							request.getSession().setAttribute("richiesteTirocinio", richieste);

							if(richieste.equals(null)) {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("nessuna richiesta");
							}

							RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteTirocinio.jsp");
							view.forward(request, response);
						}
					} else {
						azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");

						for(TirocinioBean t : tirocini) {
							if(t.getAzienda().equals(azienda.getUsername())) {
								richieste.add(t);
							}
						}

						request.getSession().setAttribute("richiesteTirocinio", richieste);

						if(richieste.equals(null)) {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("nessuna richiesta");
						}

						RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteTirocinio.jsp");
						view.forward(request, response);
					}
				} else {
					studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");

					for(TirocinioBean t : tirocini) {
						if(t.getStudente().equals(studente.getUsername())) {
							richieste.add(t);
						}
					}

					request.getSession().setAttribute("richiesteTirocinio", richieste);

					if(richieste.equals(null)) {
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("nessuna richiesta");
					}

					RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteTirocinio.jsp");
					view.forward(request, response);
				}


			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if(azioneTirocinio.equals("richiestaSelezionata")) {

			//parametro selezione l'url della richiesta selezionata
			//la ricerca all'interno del database per trovare corrispondenza che di sicuro ci sta 
			//la metti in un bean e lo imposti in sessione 
			//nome attributo sessione sarà richiestaSelezionata
			//dispatcher a mostra pdf , da chiedere a mario
			try {
				String url = request.getParameter("richiesta");
				tirocini.addAll(documento.richiesteTirocinio());

				for(TirocinioBean t : tirocini){
					if(t.getUrl().equals(url)){
						tirocinio = t;
					}
				}

				request.getSession().setAttribute("richiestaSelezionata", tirocinio);

				if(tirocinio.equals(null)){
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("nessuna richiesta");
				}

				RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
				view.forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("tirocinioDatiAzienda")) {
			try {
				azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");

				String sede = request.getParameter("sede");
				String tempi = request.getParameter("tempi");
				String periodo = request.getParameter("periodo");
				String obiettivi = request.getParameter("obiettivi");
				String facilitazioni = request.getParameter("facilitazioni");
				tirocinio.setSedeTirocinio(sede);
				tirocinio.setAccessoLocali(tempi);
				tirocinio.setPeriodoTirocinio(periodo);
				tirocinio.setObiettivoTirocinio(obiettivi);
				tirocinio.setFacilitazioni(facilitazioni);

				richiesta.salvaTirocinio(tirocinio);

				//portarsi avanti il nome della jsp da cui proviene il documento
				RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		if(azioneTirocinio.equals("inoltroAT")) {
			//settare la convalida
			
		}

		if(azioneTirocinio.equals("inoltroTS")) {

		}

		if(azioneTirocinio.equals("inoltroSI")) {

		}

		if(azioneTirocinio.equals("elencoAziende")) {
			try {
				aziende.addAll(utente.getAziende());
				convenzioni.addAll(documento.convenzioni());
				List<AziendaBean> aziendeConv = new ArrayList<AziendaBean>();
				for(AziendaBean a : aziende) {
					for(ConvenzioneBean c : convenzioni) {
						if(a.getPartitaIva().equals(c.getAzienda()) && c.isConvalida()) {
							aziendeConv.add(a);
						}
					}
				}

				if(aziendeConv.equals(null)) {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("nessuna azienda convenzionata");
					//BOH
					//RequestDispatcher view = request.getRequestDispatcher("aziendeConvenzionate.jsp");
					//view.forward(request, response);
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
				azienda = (AziendaBean) request.getSession().getAttribute("scheda");

				AziendaBean a = utente.getAzienda(azienda);

				request.getSession().setAttribute("aziendaSelezionata", a);
				RequestDispatcher view = request.getRequestDispatcher("schedaAzienda.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("ricercaAzienda")) {
			try {
				String nome = request.getParameter("nomeAzienda").toLowerCase();
				String sede = request.getParameter("sedeAzienda").toLowerCase();

				
				aziende.addAll(utente.getAziende());
				List<AziendaBean> listaAziende = new ArrayList<AziendaBean>();
				for(AziendaBean a : aziende){
					if(!(nome.equals(null)) && !(sede.equals(null))){
						if(a.getNome().toLowerCase().contains(nome) || a.getIndirizzo().toLowerCase().contains(sede)){
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

				RequestDispatcher view = request.getRequestDispatcher("aziendeConvenzionate.jsp");
				view.forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(azioneTirocinio.equals("tirociniConclusi")){
			try{
				tirocini = richiesta.richiesteTirocinio();
				List<TirocinioBean> conclusi = new ArrayList<TirocinioBean>();
				for(TirocinioBean t: tirocini){
					if(t.isConvalidaAzienda() && t.isConvalidaTutor() && 
							t.isConvalidaStudente() && t.isConvalidaRichiesta() && t.isConvalidaStudente()){
						conclusi.add(t);
					}
				}
				for(TirocinioBean t: conclusi){
					studente.setUsername(t.getStudente());
					azienda.setUsername(t.getAzienda());
					tutor.setUsername(t.getTutorAccademico());
					studenti.add(utente.getStudente(studente));
					aziende.add(utente.getAzienda(azienda));
					tutors.add(utente.getTutor(tutor));
				}
				
				request.getSession().setAttribute("listaTirociniConclusi", conclusi);
				request.getSession().setAttribute("listaStudenti", studenti);
				request.getSession().setAttribute("listaAziende", aziende);
				request.getSession().setAttribute("listaTutors", tutors);
				
				RequestDispatcher view = request.getRequestDispatcher("attivitaTirocinioConcluse.jsp");
				view.forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

}
