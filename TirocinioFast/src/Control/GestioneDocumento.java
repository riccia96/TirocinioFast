package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
 * Servlet implementation class GestioneDocumento
 */
@WebServlet("/GestioneDocumento")
public class GestioneDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ManagerUtente utente = new ManagerUtente();
	static ManagerDocumento documento = new ManagerDocumento();
	static ManagerTirocinio richiesta = new ManagerTirocinio();

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
		String azioneDocumento = request.getParameter("azioneDocumento");

		if(azioneDocumento.equals("compilaTirocinioStudente")) {
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

		if(azioneDocumento.equals("compilaTirocinioAzienda")) {
			try {
				AziendaBean azienda = new AziendaBean();

				int idT = Integer.parseInt((String) request.getParameter("idTiroci"));

				TirocinioBean tirocinio = new TirocinioBean();
				tirocinio.setId(idT);
				tirocinio = richiesta.richiestaTirocinio(tirocinio);

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

				richiesta.inoltraRichiesta(tirocinio);

				request.getSession().setAttribute("aziendaTirocinio", azienda);
				request.getSession().setAttribute("tipoDocumento", "tirocinio");

				RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio");
				view.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if(azioneDocumento.equals("compilaQuestionarioStudente")) {
			try {
				ArrayList<String> risposte = new ArrayList<String>();
				String titolo = request.getParameter("titolo");
				String periodo = request.getParameter("periodo");
				risposte.add(request.getParameter("prima"));
				risposte.add(request.getParameter("seconda"));
				risposte.add(request.getParameter("terza"));
				risposte.add(request.getParameter("quarta"));
				risposte.add(request.getParameter("quinta"));
				risposte.add(request.getParameter("sesta"));
				risposte.add(request.getParameter("settima"));
				risposte.add(request.getParameter("ottava"));
				risposte.add(request.getParameter("nona"));
				risposte.add(request.getParameter("decima"));
				risposte.add(request.getParameter("undici"));
				risposte.add(request.getParameter("dodici"));
				risposte.add(request.getParameter("tredici"));
				risposte.add(request.getParameter("quattordici"));

				String scelte = "";
				for(String r: risposte) {
					scelte += r + "*";
				}
				System.out.println(scelte);

				int id = Integer.parseInt((String) request.getSession().getAttribute("id"));
				QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
				StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
				AziendaBean azienda = new AziendaBean();
				TutorBean tutor = new TutorBean();

				questionarioStudente.setId(id);

				questionarioStudente = documento.questionarioStudente(questionarioStudente);
				questionarioStudente.setTitolo(titolo);
				questionarioStudente.setPeriodo(periodo);
				questionarioStudente.setScelte(scelte);

				azienda.setUsername(questionarioStudente.getAzienda());
				azienda = utente.getAzienda(azienda);
				tutor.setUsername(questionarioStudente.getTutorAccademico());
				tutor = utente.getTutor(tutor);

				request.getSession().setAttribute("questionarioStudente", questionarioStudente);
				request.getSession().setAttribute("studente", studente);
				request.getSession().setAttribute("azienda", azienda);
				request.getSession().setAttribute("tutor", tutor);
				request.getSession().setAttribute("risposte", risposte);

				RequestDispatcher view = request.getRequestDispatcher("documentoQuestionarioStudente.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if(azioneDocumento.equals("compilaQuestionarioAzienda")) {
			try {
				ArrayList<String> risposte = new ArrayList<String>();

				String titolo = request.getParameter("titolo");
				String posizione = request.getParameter("posizione");
				risposte.add(request.getParameter("prima"));
				risposte.add(request.getParameter("seconda"));
				risposte.add(request.getParameter("terza"));
				risposte.add(request.getParameter("quarta"));
				risposte.add(request.getParameter("quinta"));
				risposte.add(request.getParameter("sesta"));
				risposte.add(request.getParameter("settima"));
				risposte.add(request.getParameter("ottava"));
				risposte.add(request.getParameter("nona"));
				risposte.add(request.getParameter("decima"));
				risposte.add(request.getParameter("undici"));

				String scelte = "";
				for(String r: risposte) {
					scelte += r + "*";
				}
				System.out.println(scelte);
				int id = Integer.parseInt((String) request.getSession().getAttribute("id"));
				QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();
				StudenteBean studente = new StudenteBean();
				AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
				TutorBean tutor = new TutorBean();
				questionarioAzienda.setId(id);
				questionarioAzienda = documento.questionarioAzienda(questionarioAzienda);

				questionarioAzienda.setTitoloTirocinio(titolo);
				questionarioAzienda.setPosizioneRicoperta(posizione);
				questionarioAzienda.setScelte(scelte);

				studente.setUsername(questionarioAzienda.getStudente());
				studente = utente.getStudente(studente);
				tutor.setUsername(questionarioAzienda.getTutorAccademico());
				tutor = utente.getTutor(tutor);

				request.getSession().setAttribute("questionarioAzienda", questionarioAzienda);
				request.getSession().setAttribute("studente", studente);
				request.getSession().setAttribute("tutor", tutor);
				request.getSession().setAttribute("risposte", risposte);

				RequestDispatcher view = request.getRequestDispatcher("documentoQuestionarioAzienda.jsp");
				view.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}


		if(azioneDocumento.equals("compilaConvenzione")) {
			try {
				AziendaBean azienda = new AziendaBean();
				ConvenzioneBean convenzione = new ConvenzioneBean();

				azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");

				String luogoNascitaR = request.getParameter("luogoNascitaR");
				String dataNascitaR = request.getParameter("dataNascitaR");
				int numeroDipendenti = Integer.parseInt(request.getParameter("numeroDipendenti"));
				String referente = request.getParameter("referente");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				String attivita = request.getParameter("descrizioneAttivita");
				String docente = request.getParameter("tutor");

				convenzione.setId(documento.generaCodice());
				convenzione.setAzienda(azienda.getUsername());

				convenzione.setLuogoNascitaCeo(luogoNascitaR);
				convenzione.setDataNascitaCeo(dataNascitaR);
				convenzione.setNumeroDipendenti(numeroDipendenti);
				convenzione.setReferente(referente);
				convenzione.setTelefonoReferente(telefono);
				convenzione.setEmailReferente(email);
				convenzione.setAttivita(attivita);
				convenzione.setTutorAccademico(docente);

				if((luogoNascitaR.length()>3 && luogoNascitaR.length()<31) && (dataNascitaR.length()>7 && dataNascitaR.length()<15) && (referente.length()>4 && referente.length()<51) && (telefono.length()>6 && telefono.length()<14) && (email.length()>4 && email.length()<31) && (attivita.length()>24 && attivita.length()<1001)){				

					documento.compilaConvenzione(convenzione);

					request.getSession().setAttribute("azienda", azienda);
					request.getSession().setAttribute("convenzione", convenzione);

					RequestDispatcher view = request.getRequestDispatcher("GestioneConvenzione?azioneConvenzione=apriForm");
					view.forward(request, response);

				} 
				else {
					RequestDispatcher view = request.getRequestDispatcher("formatoSbagliato.jsp");
					view.forward(request, response);
				}


			} catch (SQLException e) {

				e.printStackTrace();
			}
		}


		if(azioneDocumento.equals("mostraDocumento")){
			try {
				int id = Integer.parseInt((String) request.getParameter("idT"));
				TirocinioBean tirocinio = new TirocinioBean();

				tirocinio.setId(id);
				tirocinio = richiesta.richiestaTirocinio(tirocinio);

				request.getSession().setAttribute("richiesta", tirocinio);
				request.getSession().setAttribute("tipoDocumento", "tirocinio");

				RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(azioneDocumento.equals("mostraQuestionario")){
			try {
				int id = Integer.parseInt((String) request.getParameter("idQ"));
				String tipoUtente = (String) request.getSession().getAttribute("tipoUtente");

				if(tipoUtente.equals("studente")){
					QuestionarioStudenteBean questionarioS = new QuestionarioStudenteBean();
					AziendaBean azienda = new AziendaBean();
					TutorBean tutor = new TutorBean();
					ConvenzioneBean convenzione = new ConvenzioneBean();
					List<ConvenzioneBean> convenzioni = documento.convenzioni();
					questionarioS.setId(id);

					questionarioS = documento.QuestionarioStudente(questionarioS);
					
					
					if(!questionarioS.getUrl().equals("")){
						request.getSession().setAttribute("questionarioStudente", questionarioS);
						request.getSession().setAttribute("tipoDocumento", "questionarioStudente");

						RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
						view.forward(request, response);
					} else {
						azienda.setUsername(questionarioS.getAzienda());
						azienda = utente.getAzienda(azienda);
						tutor.setUsername(questionarioS.getTutorAccademico());
						
						for(ConvenzioneBean c : convenzioni){
							if(c.getAzienda().equals(azienda.getUsername())){
								convenzione = c;
								break;
							}
						}
						
						request.getSession().setAttribute("questionarioSAzienda", azienda);
						request.getSession().setAttribute("questionarioSTutor", tutor);
						request.getSession().setAttribute("questionarioSConvenzione", convenzione);
						request.getSession().setAttribute("questionarioStudente", questionarioS);
						
						RequestDispatcher view = request.getRequestDispatcher("documentoQuestionarioStudente.jsp");
						view.forward(request, response);
					}
				} else if(tipoUtente.equals("azienda")){
					QuestionarioAziendaBean questionarioA = new QuestionarioAziendaBean();

					questionarioA.setId(id);
					questionarioA = documento.QuestionarioAzienda(questionarioA);
					
					request.getSession().setAttribute("questionarioAzienda", questionarioA);
					request.getSession().setAttribute("tipoDocumento", "questionarioAzienda");
					
					RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
					view.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneDocumento.equals("uploadTirocinio")) {
			try {
				String utente = (String) request.getSession().getAttribute("tipoUtente");


				String nomeFile = (String) request.getParameter("attivitaTirocinioFirmata");
				if(utente.equals("azienda")){

					if(!nomeFile.equals(null)) {
						int id = Integer.parseInt((String) request.getParameter("id"));
						TirocinioBean tirocinio = new TirocinioBean();
						tirocinio.setId(id);
						tirocinio = richiesta.richiestaTirocinio(tirocinio);
						tirocinio.setUrl("pdf/" + nomeFile);
						tirocinio.setConvalidaAzienda(true);
						documento.UploadTirocinio(tirocinio);

						request.getSession().setAttribute("tirocinio", tirocinio);

						RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio");
						view.forward(request, response);

					}
				} else if(utente.equals("tutor")){

					int id = Integer.parseInt((String) request.getParameter("id"));
					TirocinioBean tirocinio = new TirocinioBean();
					tirocinio.setId(id);
					tirocinio = richiesta.richiestaTirocinio(tirocinio);
					tirocinio.setUrl("pdf/" + nomeFile);
					tirocinio.setConvalidaTutor(true);
					documento.UploadTirocinio(tirocinio);

					request.getSession().setAttribute("tirocinio", tirocinio);

					RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio");
					view.forward(request, response);
				} else if(utente.equals("studente")){
					int id = Integer.parseInt((String) request.getParameter("id"));
					TirocinioBean tirocinio = new TirocinioBean();
					tirocinio.setId(id);
					tirocinio = richiesta.richiestaTirocinio(tirocinio);
					tirocinio.setUrl("pdf/" + nomeFile);
					tirocinio.setConvalidaStudente(true);
					documento.UploadTirocinio(tirocinio);

					request.getSession().setAttribute("tirocinio", tirocinio);

					RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio");
					view.forward(request, response);


				} else if(utente.equals("impiegato")){
					int id = Integer.parseInt((String) request.getParameter("id"));
					TirocinioBean tirocinio = new TirocinioBean();
					tirocinio.setId(id);
					tirocinio = richiesta.richiestaTirocinio(tirocinio);
					tirocinio.setUrl("pdf/" + nomeFile);
					tirocinio.setConvalidaRichiesta(true);
					documento.UploadTirocinio(tirocinio);

					request.getSession().setAttribute("tirocinio", tirocinio);

					RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio");
					view.forward(request, response);


				}
				else {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("carica il file");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneDocumento.equals("tirociniConclusi")){
			try{
				String tipoUtente = (String) request.getSession().getAttribute("tipoUtente");
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
				if(tipoUtente.equals("impiegato")){
					for(TirocinioBean t: conclusi){
						studente.setUsername(t.getStudente());
						azienda.setUsername(t.getAzienda());
						tutor.setUsername(t.getTutorAccademico());
						studenti.add(utente.getStudente(studente));
						aziende.add(utente.getAzienda(azienda));
						tutors.add(utente.getTutor(tutor));
					}
				} else {
					studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
					for(TirocinioBean t: conclusi){
						if(t.getStudente().equals(studente.getUsername())){
							azienda.setUsername(t.getAzienda());
							tutor.setUsername(t.getTutorAccademico());
							studenti.add(utente.getStudente(studente));
							aziende.add(utente.getAzienda(azienda));
							tutors.add(utente.getTutor(tutor));
						}
					}
				}
				request.getSession().setAttribute("listaTirociniConclusi", conclusi);
				request.getSession().setAttribute("listaStudenti", studenti);
				request.getSession().setAttribute("listaAziende", aziende);
				request.getSession().setAttribute("listaTutors", tutors);

				RequestDispatcher view = request.getRequestDispatcher("attivitaTirocinioConcluse.jsp");
				view.forward(request, response);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		if(azioneDocumento.equals("uploadConvenzione")) {
			try {

				String utente = (String) request.getSession().getAttribute("tipoUtente");

				String nomeFile = (String) request.getParameter("nomeFileConvenzione");
				if(utente.equals("azienda")){

					if(!nomeFile.equals(null)) {
						ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("convenzione");
						convenzione.setUrl("pdf/" + nomeFile);

						documento.UploadConvenzione(convenzione);
						RequestDispatcher view = request.getRequestDispatcher("GestioneConvenzione?azioneConvenzione=apriForm");
						view.forward(request, response);

					}} else if(utente.equals("impiegato")){

						int idConv = Integer.parseInt((String) request.getParameter("idConvenzione"));

						ConvenzioneBean conv = new ConvenzioneBean();
						conv.setId(idConv);
						conv = documento.convenzione(conv);

						conv.setUrl("pdf/" + nomeFile);
						conv.setConvalida(true);

						documento.UploadConvenzione(conv);

						RequestDispatcher view = request.getRequestDispatcher("GestioneConvenzione?azioneConvenzione=elencoRichiesteConvenzioni");
						view.forward(request, response);
					}
					else {
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("carica il file");
					}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		/*

		if(azioneDocumento.equals("uploadQuestionarioStudente")) {
			try {

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		if(azioneDocumento.equals("uploadQuestionarioAzienda")) {
			try {

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}



		 */

		if(azioneDocumento.equals("uploadRegistroOre")) {
			try {
				String nomeFile = (String) request.getParameter("nomeRegistroOre");

				int idTiro = Integer.parseInt((String) request.getParameter("id"));

				TirocinioBean tirocinio = new TirocinioBean();
				tirocinio.setId(idTiro);
				tirocinio = documento.DownloadTirocinio(tirocinio);

				tirocinio.setRegistroOre("pdf/" + nomeFile);

				documento.UploadTirocinio(tirocinio);

				RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?azioneDocumento=registroOre");
				view.forward(request, response);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}


		if(azioneDocumento.equals("registroOre")) {
			try {
				
				List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
				tirocini = documento.richiesteTirocinio();

				StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
			
				TutorBean tutor = new TutorBean();
				AziendaBean azienda = new AziendaBean();
				for(TirocinioBean t : tirocini) {
					if(t.getStudente().equals(studente.getUsername())) {
						
						if(t.isConvalidaRichiesta()) {
						
							tutor.setUsername(t.getTutorAccademico());
							tutor = utente.getTutor(tutor);
							azienda.setUsername(t.getAzienda());
							azienda = utente.getAzienda(azienda);
							request.getSession().setAttribute("tutorOre", tutor);
							request.getSession().setAttribute("aziendaOre", azienda);
							request.getSession().setAttribute("tirocinioOre", t);
							RequestDispatcher view = request.getRequestDispatcher("registroOre.jsp");
							view.forward(request, response);
						} else {
						
							RequestDispatcher view = request.getRequestDispatcher("nessunaRisorsa.jsp");
							view.forward(request, response);
						}
					}

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if(azioneDocumento.equals("elencoRichiesteTirocinio")) {
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










		if(azioneDocumento.equals("elencoRichiesteConvenzioni")) {
			try {
				List<ConvenzioneBean> convenzioni = documento.convenzioni();
				List<ConvenzioneBean> richieste = new ArrayList<ConvenzioneBean>();
				List<AziendaBean> aziende = new ArrayList<AziendaBean>();

				for(ConvenzioneBean c : convenzioni) {
					if(!(c.isConvalida())) {
						AziendaBean a = new AziendaBean();
						a.setUsername(c.getAzienda());
						aziende.add(utente.getAzienda(a));
						richieste.add(c);
					}
				}

				request.getSession().setAttribute("richiesteConvenzioni", richieste);
				request.getSession().setAttribute("listaAziende", aziende);

				if(richieste.equals(null)) {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("nessuna richiesta");
				}

				RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteConvenzioni.jsp");
				view.forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
