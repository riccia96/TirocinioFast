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
import Bean.StudenteBean;
import Bean.TirocinioBean;
import Bean.TutorBean;

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

		if(azioneTirocinio.equals("inoltraRichiesta")){
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

		if(azioneTirocinio.equals("tirocinioDatiStudente")) {
			try {
				StudenteBean studente = new StudenteBean();
				TirocinioBean tirocinio = new TirocinioBean();

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

				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}



		if(azioneTirocinio.equals("elencoRichiesteTirocinio")) {
			try {
				StudenteBean studente = new StudenteBean();
				TutorBean tutor = new TutorBean();
				AziendaBean azienda = new AziendaBean();

				List<StudenteBean> studenti = new ArrayList<StudenteBean>();
				List<AziendaBean> aziende = new ArrayList<AziendaBean>();
				List<TutorBean> tutors = new ArrayList<TutorBean>();
				List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
				List<TirocinioBean> richieste = new ArrayList<TirocinioBean>();

				studenti = utente.getStudenti();
				aziende = utente.getAziende();
				tutors = utente.getTutorAccademici();

				tirocini.addAll(documento.richiesteTirocinio());

				if(!(request.getSession().getAttribute("tipoUtente").equals("studente"))) {
					if(!(request.getSession().getAttribute("tipoUtente").equals("azienda"))) {
						if(!(request.getSession().getAttribute("tipoUtente").equals("tutor"))) {

							for(TirocinioBean t : tirocini) {
								if(t.isConvalidaAzienda() && t.isConvalidaTutor() && t.isConvalidaStudente()) {
									richieste.add(t);
								}
							} 

							request.getSession().setAttribute("listaStudenti", studenti);
							request.getSession().setAttribute("listaAziende", aziende);
							request.getSession().setAttribute("listaTutor", tutors);
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

							request.getSession().setAttribute("listaStudenti", studenti);
							request.getSession().setAttribute("listaAziende", aziende);
							request.getSession().setAttribute("listaTutor", tutors);
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

						request.getSession().setAttribute("listaStudenti", studenti);
						request.getSession().setAttribute("listaAziende", aziende);
						request.getSession().setAttribute("listaTutor", tutors);
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

					request.getSession().setAttribute("listaStudenti", studenti);
					request.getSession().setAttribute("listaAziende", aziende);
					request.getSession().setAttribute("listaTutor", tutors);
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
				TirocinioBean tirocinio = new TirocinioBean();
				List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();

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
				AziendaBean azienda = new AziendaBean();
				TirocinioBean tirocinio = new TirocinioBean();

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

				request.getSession().setAttribute("aziendaTirocinio", azienda);
				//portarsi avanti il nome della jsp da cui proviene il documento
				RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		if(azioneTirocinio.equals("inoltroAT")) {
			//settare la convalida
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

		if(azioneTirocinio.equals("inoltroTS")) {
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

		if(azioneTirocinio.equals("inoltroSI")) {
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
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("nessuna azienda convenzionata");

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
				List<AziendaBean> aziende = new ArrayList<AziendaBean>();

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

		if(azioneTirocinio.equals("attivitaConvalidate")){
			try{
				StudenteBean studente = new StudenteBean();
				AziendaBean azienda = new AziendaBean();
				TutorBean tutor = new TutorBean();

				List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
				List<TirocinioBean> conclusi = new ArrayList<TirocinioBean>();
				List<StudenteBean> studenti = new ArrayList<StudenteBean>();
				List<AziendaBean> aziende = new ArrayList<AziendaBean>();
				List<TutorBean> tutors = new ArrayList<TutorBean>();

				tirocini = richiesta.richiesteTirocinio();

				for(TirocinioBean t: tirocini){
					if(t.isConvalidaAttivita()){
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

				RequestDispatcher view = request.getRequestDispatcher("elencoTirociniConclusi.jsp");
				view.forward(request, response);
			} catch (SQLException e){
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("tirociniConclusi")){
			try{
				StudenteBean studente = new StudenteBean();
				AziendaBean azienda = new AziendaBean();
				TutorBean tutor = new TutorBean();

				List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
				List<TirocinioBean> conclusi = new ArrayList<TirocinioBean>();
				List<StudenteBean> studenti = new ArrayList<StudenteBean>();
				List<AziendaBean> aziende = new ArrayList<AziendaBean>();
				List<TutorBean> tutors = new ArrayList<TutorBean>();

				tirocini = richiesta.richiesteTirocinio();

				for(TirocinioBean t: tirocini){
					if(t.isConvalidaAzienda() && t.isConvalidaTutor() && 
							t.isConvalidaStudente() && t.isConvalidaRichiesta() && !(t.isConvalidaAttivita())){
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

		if(azioneTirocinio.equals("accettaAttivita")){
			try {

				int idTirocinio = Integer.parseInt((String) request.getParameter("idTirocinio"));

				TirocinioBean tirocinio = new TirocinioBean();
				tirocinio.setId(idTirocinio);


				tirocinio = richiesta.richiestaTirocinio(tirocinio);
				
				
				
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
