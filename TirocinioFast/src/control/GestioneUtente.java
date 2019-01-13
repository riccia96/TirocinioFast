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
import bean.ImpiegatoBean;
import bean.StudenteBean;
import bean.TutorBean;


/**
 * Servlet implementation class GestioneUtente
 */
@WebServlet("/GestioneUtente")
public class GestioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ManagerUtente utente = new ManagerUtente();


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

		String azioneUtente = request.getParameter("azioneUtente");

		if(azioneUtente.equals("login")) {
			try {
				String username = request.getParameter("username");
				boolean user = false;
				String password = request.getParameter("password");
				boolean pass = false;

				StudenteBean studente = new StudenteBean();
				AziendaBean azienda = new AziendaBean();
				TutorBean tutor = new TutorBean();
				ImpiegatoBean impiegato = new ImpiegatoBean();

				studente.setUsername(username);
				azienda.setUsername(username);
				impiegato.setUsername(username);
				tutor.setUsername(username);

				StudenteBean s = utente.getStudente(studente);
				AziendaBean a = utente.getAzienda(azienda);
				TutorBean t = utente.getTutor(tutor);
				ImpiegatoBean i = utente.getImpiegato(impiegato);

				if(s.getUsername().equals(username)) {
					user = true;
					if(s.getPassword().equals(password)) {
						request.getSession().setAttribute("utenteSessione", s);
						request.getSession().setAttribute("tipoUtente", "studente");
						pass=true;
						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
												
						
					}else {
						RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
						view.forward(request, response);
						
					}
				} else if(a.getUsername().equals(username)) {
					user = true;
					if(a.getPassword().equals(password)) {
						request.getSession().setAttribute("utenteSessione", utente.getAzienda(azienda));
						request.getSession().setAttribute("tipoUtente", "azienda");

						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
						pass = true;
						
					}else {
						RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
						view.forward(request, response);
						
					}
				}
				else if(t.getUsername().equals(username)) {
					user = true;
					if(t.getPassword().equals(password)) {
						request.getSession().setAttribute("utenteSessione", utente.getTutor(tutor));
						request.getSession().setAttribute("tipoUtente", "tutor");

						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
						
						pass = true;
						
					}else {
						RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
						view.forward(request, response);
					}
				}
				else if(i.getUsername().equals(username)) {
					user = true;
					if(i.getPassword().equals(password)) {
						request.getSession().setAttribute("utenteSessione", utente.getImpiegato(impiegato));
						request.getSession().setAttribute("tipoUtente", "impiegato");

						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
						pass = true;
						
					}else {
						RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
						view.forward(request, response);
						
					}
				} else if(!user) {
					RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
					view.forward(request, response);
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}


		}


		if(azioneUtente.equals("logout")) {
			request.getSession().invalidate();
			response.sendRedirect("index.jsp");
		}


		if(azioneUtente.equals("recuperaPassword")) {
			try{
				String username = request.getParameter("username");
				String risposta = request.getParameter("risposta");

				StudenteBean studente = new StudenteBean();
				AziendaBean azienda = new AziendaBean();
				TutorBean tutor = new TutorBean();
				ImpiegatoBean impiegato = new ImpiegatoBean();

				studente.setUsername(username);
				azienda.setUsername(username);
				impiegato.setUsername(username);
				tutor.setUsername(username);

				StudenteBean s = utente.getStudente(studente);
				AziendaBean a = utente.getAzienda(azienda);
				TutorBean t = utente.getTutor(tutor);
				ImpiegatoBean i = utente.getImpiegato(impiegato);



				if(s.getUsername().equals("")){
					if(a.getUsername().equals("")) {
						if(t.getUsername().equals("")) {
							if(i.getUsername().equals("")) {
								RequestDispatcher view = request.getRequestDispatcher("usernameNo.jsp");
								view.forward(request, response);
								}else {
								if(utente.getTutor(tutor).getDomanda().equals(risposta)){
									request.getSession().setAttribute("utenteSessione", utente.getTutor(tutor));
									request.getSession().setAttribute("tipoUtente", "tutor");

									RequestDispatcher view = request.getRequestDispatcher("impostaPassword.jsp");
									view.forward(request, response);
								}else {
									RequestDispatcher view = request.getRequestDispatcher("rispostaSbagliata.jsp");
									view.forward(request, response);
								}
							}
						}else {
							if(utente.getImpiegato(impiegato).getDomanda().equals(risposta)){
								request.getSession().setAttribute("utenteSessione", utente.getImpiegato(impiegato));
								request.getSession().setAttribute("tipoUtente", "impiegato");

								RequestDispatcher view = request.getRequestDispatcher("impostaPassword.jsp");
								view.forward(request, response);
							}else {
								RequestDispatcher view = request.getRequestDispatcher("rispostaSbagliata.jsp");
								view.forward(request, response);
							}
						}
					}else {
						if(utente.getAzienda(azienda).getDomanda().equals(risposta)){
							request.getSession().setAttribute("utenteSessione", utente.getAzienda(azienda));
							request.getSession().setAttribute("tipoUtente", "azienda");

							RequestDispatcher view = request.getRequestDispatcher("impostaPassword.jsp");
							view.forward(request, response);
						}else {
							RequestDispatcher view = request.getRequestDispatcher("rispostaSbagliata.jsp");
							view.forward(request, response);
						}
					}
				}else {
					if(utente.getStudente(studente).getDomanda().equals(risposta)){
						request.getSession().setAttribute("utenteSessione", utente.getStudente(studente));
						request.getSession().setAttribute("tipoUtente", "studente");

						RequestDispatcher view = request.getRequestDispatcher("impostaPassword.jsp");
						view.forward(request, response);
					}else {
						RequestDispatcher view = request.getRequestDispatcher("rispostaSbagliata.jsp");
						view.forward(request, response);
					}
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneUtente.equals("impostaPassword")) {

			String password = request.getParameter("password");
			String conferma = request.getParameter("conferma");


			StudenteBean studente = new StudenteBean();
			AziendaBean azienda = new AziendaBean();
			TutorBean tutor = new TutorBean();
			ImpiegatoBean impiegato = new ImpiegatoBean();

			try {
				if (password.length()>7 && password.length()<21){
					if(password.equals(conferma)) {
						if(!(request.getSession().getAttribute("tipoUtente").equals("studente"))) {
							if(!(request.getSession().getAttribute("tipoUtente").equals("azienda"))) {
								if(!(request.getSession().getAttribute("tipoUtente").equals("tutor"))) {
									impiegato = (ImpiegatoBean) request.getSession().getAttribute("utenteSessione");
									impiegato.setPassword(password);
									utente.aggiornaImpiegato(impiegato);

									request.getSession().removeAttribute("tipoUtente");
									request.getSession().removeAttribute("utenteSessione");

									RequestDispatcher view = request.getRequestDispatcher("index.jsp");
									view.forward(request, response);
								} else {
									tutor = (TutorBean) request.getSession().getAttribute("utenteSessione");
									tutor.setPassword(password);
									utente.aggiornaTutor(tutor);

									request.getSession().removeAttribute("tipoUtente");
									request.getSession().removeAttribute("utenteSessione");

									RequestDispatcher view = request.getRequestDispatcher("index.jsp");
									view.forward(request, response);
								}
							} else {
								azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
								azienda.setPassword(password);
								utente.aggiornaAzienda(azienda);

								request.getSession().removeAttribute("tipoUtente");
								request.getSession().removeAttribute("utenteSessione");

								RequestDispatcher view = request.getRequestDispatcher("index.jsp");
								view.forward(request, response);
							}
						} else {
							studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
							studente.setPassword(password);
							utente.aggiornaStudente(studente);

							request.getSession().removeAttribute("tipoUtente");
							request.getSession().removeAttribute("utenteSessione");

							RequestDispatcher view = request.getRequestDispatcher("index.jsp");
							view.forward(request, response);
						}
					}
					else {
						RequestDispatcher view = request.getRequestDispatcher("passwordNonCorrispondenti.jsp");
						view.forward(request, response);;
					}
				}
				else {
					RequestDispatcher view = request.getRequestDispatcher("formatoSbagliatoI.jsp");
					view.forward(request, response);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}		

		}

		if(azioneUtente.equals("registraStudente")) {
			try{
				StudenteBean studente = new StudenteBean();
				List<StudenteBean> studenti = new ArrayList<StudenteBean>();

				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String luogoNascita = request.getParameter("luogo");
				String dataNascita = request.getParameter("data");
				String indirizzo = request.getParameter("indirizzo");
				String citta = request.getParameter("citta");
				String codiceFiscale = request.getParameter("codice");
				String matricola = request.getParameter("matricola");
				String email = request.getParameter("email");
				String telefono = request.getParameter("telefono");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String conferma = request.getParameter("conferma");
				String risposta = request.getParameter("domanda");

				studente.setNome(nome);
				studente.setCognome(cognome);
				studente.setLuogoNascita(luogoNascita);
				studente.setDataNascita(dataNascita);
				studente.setIndirizzo(indirizzo);
				studente.setCitta(citta);
				studente.setCodiceFiscale(codiceFiscale);
				studente.setMatricola(matricola);
				studente.setEmail(email);
				studente.setTelefono(telefono);
				studente.setUsername(username);
				studente.setPassword(password);
				studente.setDomanda(risposta);

				studenti.addAll(utente.getStudenti());

				if((nome.length()>2 && nome.length()<31) && (cognome.length()>2 && cognome.length()<31) && (luogoNascita.length()>2 && luogoNascita.length()<21) && (dataNascita.length()>7 && dataNascita.length()<11) && (indirizzo.length()>4 && indirizzo.length()<31) && (citta.length()>2 && citta.length()<21) && (codiceFiscale.length()== 16) && (matricola.length()== 10) && (email.length()>4 && email.length()<31) && (telefono.length()>6 && telefono.length()<14) && (username.length()>4 && username.length()<21) && (password.length()>7 && password.length()<21) && (risposta.length()>1 && risposta.length()<31)){
										
				if(!(studenti.equals(null))) {
					for(StudenteBean s : studenti) {
						if(s.getEmail().equals(email)) {
							RequestDispatcher view = request.getRequestDispatcher("emailEsistente.jsp");
							view.forward(request, response);
								}
						if(s.getMatricola().equals(matricola)) {
							RequestDispatcher view = request.getRequestDispatcher("matricolaEsistente.jsp");
							view.forward(request, response);
								}
						if(s.getCodiceFiscale().equals(codiceFiscale)) {
							RequestDispatcher view = request.getRequestDispatcher("codiceFiscaleEsistente.jsp");
							view.forward(request, response);
								}
						if(s.getUsername().equals(username)) {
							RequestDispatcher view = request.getRequestDispatcher("usernameEsistente.jsp");
							view.forward(request, response);
								}
							}
						}
						if(!(password.equals(conferma))){
							RequestDispatcher view = request.getRequestDispatcher("passwordNonCorrispondenti.jsp");
							view.forward(request, response);
								} 
						
						utente.salvaStudente(studente);
						request.getSession().setAttribute("utenteSessione", studente);
						request.getSession().setAttribute("tipoUtente", "studente");
						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
						
					} else {
							RequestDispatcher view = request.getRequestDispatcher("formatoSbagliatoI.jsp");
							view.forward(request, response);
					}
			}
							catch(SQLException e){
								e.printStackTrace();
							}
					}


		if(azioneUtente.equals("registraAzienda")) {

			try{
				AziendaBean azienda = new AziendaBean();
				List<AziendaBean> aziende = new ArrayList<AziendaBean>();

				String nome = request.getParameter("nome");
				String partitaIva = request.getParameter("iva");
				String ceo = request.getParameter("ceo");
				String indirizzo = request.getParameter("sede");
				String email = request.getParameter("email");
				String telefono = request.getParameter("telefono");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String conferma = request.getParameter("conferma");
				String risposta = request.getParameter("domanda");

				azienda.setNome(nome);
				azienda.setPartitaIva(partitaIva);
				azienda.setCeo(ceo);
				azienda.setEmail(email);
				azienda.setIndirizzo(indirizzo);
				azienda.setTelefono(telefono);
				azienda.setUsername(username);
				azienda.setPassword(password);
				azienda.setDomanda(risposta);
				azienda.setDescrizione("");
				azienda.setLogo("");

				aziende.addAll(utente.getAziende());

				if((nome.length()>2 && nome.length()<31) && (partitaIva.length()==11) && (ceo.length()>4 && ceo.length()<51) && (indirizzo.length()>4 && indirizzo.length()<31) && (email.length()>4 && email.length()<31) && (telefono.length()>6 && telefono.length()<13) && (username.length()>4 && username.length()<21) && (password.length()>7 && password.length()<21) && (risposta.length()>1 && risposta.length()<31)){

													if(!(aziende.equals(null))) {
														for(AziendaBean a : aziende) {
															if(a.getEmail().equals(email)) {
																RequestDispatcher view = request.getRequestDispatcher("emailEsistente.jsp");
																view.forward(request, response);
																	}
															if(a.getNome().equals(nome)) {
																RequestDispatcher view = request.getRequestDispatcher("nomeEsistente.jsp");
																view.forward(request, response);
															}
															if(a.getUsername().equals(username)) {
																RequestDispatcher view = request.getRequestDispatcher("usernameEsistente.jsp");
																view.forward(request, response);
															}
														}
													}

													if(!(password.equals(conferma))){
														RequestDispatcher view = request.getRequestDispatcher("passwordNonCorrispondenti.jsp");
														view.forward(request, response);
													} else {
														utente.salvaAzienda(azienda);

														request.getSession().setAttribute("utenteSessione", azienda);
														request.getSession().setAttribute("tipoUtente", "azienda");

														RequestDispatcher view = request.getRequestDispatcher("home.jsp");
														view.forward(request, response);
													}
												}

												else{
													RequestDispatcher view = request.getRequestDispatcher("formatoSbagliatoI.jsp");
													view.forward(request, response);
												}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}


		if(azioneUtente.equals("areaPersonale")) {

			if(!(request.getSession().getAttribute("tipoUtente").equals("studente"))){
				if(!(request.getSession().getAttribute("tipoUtente").equals("azienda"))){
					if(!(request.getSession().getAttribute("tipoUtente").equals("tutor"))){

						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
					} else {

						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
					}
				} else {

					RequestDispatcher view = request.getRequestDispatcher("home.jsp");
					view.forward(request, response);
				}
			} else {

				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			}

		}


		if(azioneUtente.equals("salvaScheda")) {
			try {
				String descrizione = request.getParameter("descrizione");
				String logo = request.getParameter("logo");

				if(descrizione.length()>24 && descrizione.length()<1000){
					AziendaBean azienda = new AziendaBean();

					azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");

					String pathLogo = "img/" + logo;

					azienda.setDescrizione(descrizione);
					azienda.setLogo(pathLogo);

					utente.aggiornaAzienda(azienda);

					RequestDispatcher view = request.getRequestDispatcher("home.jsp");
					view.forward(request, response);
				} 
				else{
					RequestDispatcher view = request.getRequestDispatcher("formatoSbagliato.jsp");
					view.forward(request, response);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
