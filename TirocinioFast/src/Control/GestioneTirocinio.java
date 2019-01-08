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
import Bean.QuestionarioAziendaBean;
import Bean.QuestionarioStudenteBean;
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
		
		
		
		//no

		if(azioneTirocinio.equals("richiestaSelezionata")) {
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
				
				request.getSession().setAttribute("tipoDocumento", "tirocinio");

				RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
				view.forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		


	
		//no
		
		if(azioneTirocinio.equals("compilaAzienda")) {

			try {
				TirocinioBean tirocinio = new TirocinioBean();
				
				int id = Integer.parseInt((String) request.getParameter("idTiro"));
				
				tirocinio.setId(id);
				tirocinio = richiesta.richiestaTirocinio(tirocinio);
				
				request.getSession().setAttribute("richiestaTiro", tirocinio);
				RequestDispatcher view = request.getRequestDispatcher("compilazioneCampiAzienda.jsp");
				view.forward(request, response);
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		//no
		
		if(azioneTirocinio.equals("compilato")){
			try {
				TirocinioBean tirocinio = new TirocinioBean();
				TutorBean tutor = new TutorBean();
				AziendaBean azienda = new AziendaBean();
				StudenteBean studente = new StudenteBean();
				ConvenzioneBean convenzione = new ConvenzioneBean();
				List<ConvenzioneBean> listaConv;

				listaConv = documento.convenzioni();


				int id = Integer.parseInt((String) request.getParameter("idTiro"));
				tirocinio.setId(id);
				tirocinio = richiesta.richiestaTirocinio(tirocinio);

				String tuto = tirocinio.getTutorAccademico();
				String azie = tirocinio.getAzienda();
				String stud = tirocinio.getStudente();

				for(ConvenzioneBean c : listaConv) {
					if(c.getAzienda().equals(azie)) {
						convenzione = c;
						break;
					}
				}

				tutor.setUsername(tuto);
				tutor = utente.getTutor(tutor);
				azienda.setUsername(azie);
				azienda = utente.getAzienda(azienda);
				studente.setUsername(stud);
				studente = utente.getStudente(studente);

				if(tirocinio.getUrl().equals("")){
					request.getSession().setAttribute("richiesta", tirocinio);
					request.getSession().setAttribute("tutor", tutor);
					request.getSession().setAttribute("azienda", azienda);
					request.getSession().setAttribute("studente", studente);
					request.getSession().setAttribute("convenzione", convenzione);
					RequestDispatcher view = request.getRequestDispatcher("documentoRichiestaTirocinio.jsp");
					view.forward(request, response);
				}else{
					request.getSession().setAttribute("richiesta", tirocinio);
					request.getSession().setAttribute("tipoDocumento", "tirocinio");
					RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
					view.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//no
		
				if(azioneTirocinio.equals("attivitaConvalidate")){
					try{
						List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();

						tirocini = richiesta.richiesteTirocinio();

						if(!(tirocini.size() == 0)) {

							StudenteBean studente = new StudenteBean();
							AziendaBean azienda = new AziendaBean();
							TutorBean tutor = new TutorBean();


							List<TirocinioBean> conclusi = new ArrayList<TirocinioBean>();
							List<StudenteBean> studenti = new ArrayList<StudenteBean>();
							List<AziendaBean> aziende = new ArrayList<AziendaBean>();
							List<TutorBean> tutors = new ArrayList<TutorBean>();



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
						} else {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("nessuna attività conclusa");
						}
					} catch (SQLException e){
						e.printStackTrace();
					}
				}

				//no
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
				
				//no

				if(azioneTirocinio.equals("selezionaAttivita")){
					try {

						int idTirocinio = Integer.parseInt((String) request.getParameter("idTirocinio"));

						TirocinioBean tirocinio = new TirocinioBean();
						tirocinio.setId(idTirocinio);

						tirocinio = richiesta.richiestaTirocinio(tirocinio);

						QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
						QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();

						questionarioStudente.setId(tirocinio.getQuestionarioStudente());
						questionarioAzienda.setId(tirocinio.getQuestionarioAzienda());

						questionarioStudente = documento.QuestionarioStudente(questionarioStudente);
						questionarioAzienda = documento.questionarioAzienda(questionarioAzienda);

						request.getSession().setAttribute("tirocinio", tirocinio);
						request.getSession().setAttribute("questionarioStudente", questionarioStudente);
						request.getSession().setAttribute("questionarioAzienda", questionarioAzienda);

						RequestDispatcher view = request.getRequestDispatcher("mostraPDFConferma.jsp");
						view.forward(request, response);

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
				
				//no

				if(azioneTirocinio.equals("accettaAttivita")){
					try {
						int idTirocinio = Integer.parseInt((String) request.getParameter("idTirocinio"));

						TirocinioBean tirocinio = new TirocinioBean();
						tirocinio.setId(idTirocinio);

						tirocinio = richiesta.richiestaTirocinio(tirocinio);

						QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
						QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();

						questionarioStudente.setId(tirocinio.getQuestionarioStudente());
						questionarioAzienda.setId(tirocinio.getQuestionarioAzienda());

						questionarioStudente = documento.QuestionarioStudente(questionarioStudente);
						questionarioAzienda = documento.questionarioAzienda(questionarioAzienda);

						tirocinio.setConvalidaAttivita(true);
						questionarioStudente.setConvalida(true);
						questionarioAzienda.setConvalida(true);

						documento.UploadQuestionarioStudente(questionarioStudente);
						documento.UploadQuestionarioAzienda(questionarioAzienda);
						documento.convalidaTirocinio(tirocinio);

						RequestDispatcher view = request.getRequestDispatcher("attivitaTirocinioConcluse.jsp");
						view.forward(request, response);
					}  catch (SQLException e) {
						e.printStackTrace();
					}
				}

		//ok
		
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
		


		
	
		
		//ok
		
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
		
		//ok

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
		
		//ok

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

		
		
		
		
		//ok
		
		
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

		
		
		
		//ok
		
		
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

		
		
		//ok
		
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

				RequestDispatcher view = request.getRequestDispatcher("elencoAziendeConvenzionate.jsp");
				view.forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
		
		
	}

}
