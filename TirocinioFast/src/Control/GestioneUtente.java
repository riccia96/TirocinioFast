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
import Bean.ImpiegatoBean;
import Bean.StudenteBean;
import Bean.TutorBean;


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
				System.out.println(username);
				boolean user = false;
				String password = request.getParameter("password");
				System.out.println(password);
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

<<<<<<< HEAD


				if(s.getUsername().equals("")){
					if(a.getUsername().equals("")) {
						if(t.getUsername().equals("")) {
							if(i.getUsername().equals("")) {
								RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
								view.forward(request, response);
							}else {
								if(i.getPassword().equals(password)) {
									request.getSession().setAttribute("utenteSessione", utente.getImpiegato(impiegato));
									request.getSession().setAttribute("tipoUtente", "impiegato");

									RequestDispatcher view = request.getRequestDispatcher("home.jsp");
									view.forward(request, response);
								}else {
									RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
									view.forward(request, response);
								}
							}
						}else {
							if(t.getPassword().equals(password)) {
								request.getSession().setAttribute("utenteSessione", utente.getTutor(tutor));
								request.getSession().setAttribute("tipoUtente", "tutor");

								RequestDispatcher view = request.getRequestDispatcher("home.jsp");
								view.forward(request, response);
							}else {
								RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
								view.forward(request, response);
							}
						}
					}else {
						if(a.getPassword().equals(password)) {
							request.getSession().setAttribute("utenteSessione", utente.getAzienda(azienda));
							request.getSession().setAttribute("tipoUtente", "azienda");

							RequestDispatcher view = request.getRequestDispatcher("home.jsp");
							view.forward(request, response);
						}else {
							RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
							view.forward(request, response);
						}
					}
				}else {
=======
				System.out.println("controllo1"+s.getUsername().equals(username));
				if(s.getUsername().equals(username)) {
					user = true;
					System.out.println("controllo2"+s.getUsername().equals(username));
>>>>>>> branch 'master' of https://github.com/riccia96/TirocinioFast.git
					if(s.getPassword().equals(password)) {
						System.out.println("sto in controllo password stud");
						request.getSession().setAttribute("utenteSessione", s);
						request.getSession().setAttribute("tipoUtente", "studente");
						System.out.println("sto prima di dispatcher");
						response.sendRedirect("home.jsp");
						//RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						//view.forward(request, response);
						System.out.println("studok");
						pass = true;
						System.out.println("1"+user);
						
					}else {
						System.out.println("passstudno");
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("passwordNo");
						
					}
				} else if(a.getUsername().equals(username)) {
					user = true;
					if(a.getPassword().equals(password)) {
						request.getSession().setAttribute("utenteSessione", utente.getAzienda(azienda));
						request.getSession().setAttribute("tipoUtente", "azienda");

						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
						System.out.println("azieok");
						pass = true;
						
					}else {
<<<<<<< HEAD
						RequestDispatcher view = request.getRequestDispatcher("utenteNonTrovato.jsp");
						view.forward(request, response);
=======
						System.out.println("passazienoo");
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("passwordNo");
						
>>>>>>> branch 'master' of https://github.com/riccia96/TirocinioFast.git
					}
				}
				else if(t.getUsername().equals(username)) {
					user = true;
					if(t.getPassword().equals(password)) {
						request.getSession().setAttribute("utenteSessione", utente.getTutor(tutor));
						request.getSession().setAttribute("tipoUtente", "tutor");

						RequestDispatcher view = request.getRequestDispatcher("home.jsp");
						view.forward(request, response);
						System.out.println("tutook");
						pass = true;
						
					}else {
						System.out.println("passtutonooo");
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("passwordNo");
						
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
						System.out.println("passimpno");
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("passwordNo");
						
					}
				} else if(!user) {
					System.out.println(user);
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("usernameNo");
					System.out.println("usernamenooooooo");
					
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
								response.getWriter().write("username no");
							}else {
								if(utente.getTutor(tutor).getDomanda().equals(risposta)){
									request.getSession().setAttribute("utenteSessione", utente.getTutor(tutor));
									request.getSession().setAttribute("tipoUtente", "tutor");

									RequestDispatcher view = request.getRequestDispatcher("impostaPassword.jsp");
									view.forward(request, response);
								}else {
									response.setContentType("text/html;charset=ISO-8859-1");
									response.getWriter().write("risposta errata");
								}
							}
						}else {
							if(utente.getImpiegato(impiegato).getDomanda().equals(risposta)){
								request.getSession().setAttribute("utenteSessione", utente.getImpiegato(impiegato));
								request.getSession().setAttribute("tipoUtente", "impiegato");

								RequestDispatcher view = request.getRequestDispatcher("impostaPassword.jsp");
								view.forward(request, response);
							}else {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("risposta errata");
							}
						}
					}else {
						if(utente.getAzienda(azienda).getDomanda().equals(risposta)){
							request.getSession().setAttribute("utenteSessione", utente.getAzienda(azienda));
							request.getSession().setAttribute("tipoUtente", "azienda");

							RequestDispatcher view = request.getRequestDispatcher("impostaPassword.jsp");
							view.forward(request, response);
						}else {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("risposta errata");
						}
					}
				}else {
					if(utente.getStudente(studente).getDomanda().equals(risposta)){
						request.getSession().setAttribute("utenteSessione", utente.getStudente(studente));
						request.getSession().setAttribute("tipoUtente", "studente");

						RequestDispatcher view = request.getRequestDispatcher("impostaPassword.jsp");
						view.forward(request, response);
					}else {
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("risposta errata");
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
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("password non corrispondenti");
					}
				}
				else {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("password non rispetta parametri");
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

				if(nome.length()>2 && nome.length()<31){
					if(cognome.length()>2 && cognome.length()<31){
						if(luogoNascita.length()>2 && luogoNascita.length()<21){
							if(dataNascita.length()>7 && dataNascita.length()<11){
								if(indirizzo.length()>4 && indirizzo.length()<31){
									if(citta.length()>2 && citta.length()<21){
										if(codiceFiscale.length()== 16){
											if(matricola.length()== 10){
												if(email.length()>4 && email.length()<31){
													if(telefono.length()>6 && telefono.length()<14){
														if(username.length()>4 && username.length()<21){
															if(password.length()>7 && password.length()<21){
																if(risposta.length()>1 && risposta.length()<31){													

																	if(!(studenti.equals(null))) {
																		for(StudenteBean s : studenti) {
																			if(s.getEmail().equals(email)) {
																				response.setContentType("text/html;charset=ISO-8859-1");
																				response.getWriter().write("email gia' esistente");
																			}
																			if(s.getMatricola().equals(matricola)) {
																				response.setContentType("text/html;charset=ISO-8859-1");
																				response.getWriter().write("matricola gia' esistente");
																			}
																			if(s.getCodiceFiscale().equals(codiceFiscale)) {
																				response.setContentType("text/html;charset=ISO-8859-1");
																				response.getWriter().write("codice fiscale gia' esistente");
																			}
																			if(s.getUsername().equals(username)) {
																				response.setContentType("text/html;charset=ISO-8859-1");
																				response.getWriter().write("username gia' esistente");
																			}
																		}
																	}
																	if(!(password.equals(conferma))){
																		response.setContentType("text/html;charset=ISO-8859-1");
																		response.getWriter().write("password non corrispondenti");
																	} 
																	utente.salvaStudente(studente);

																	request.getSession().setAttribute("utenteSessione", studente);
																	request.getSession().setAttribute("tipoUtente", "studente");

																	RequestDispatcher view = request.getRequestDispatcher("home.jsp");
																	view.forward(request, response);
																} else {
																	response.setContentType("text/html;charset=ISO-8859-1");
																	response.getWriter().write("formato risposta sbagliato");
																}								
															}
															else{
																response.setContentType("text/html;charset=ISO-8859-1");
																response.getWriter().write("formato password sbagliato");	
															}												
														}
														else {
															response.setContentType("text/html;charset=ISO-8859-1");
															response.getWriter().write("formato username sbagliato");
														}
													}
													else {
														response.setContentType("text/html;charset=ISO-8859-1");
														response.getWriter().write("formato telefono sbagliato");
													}
												}
												else{
													response.setContentType("text/html;charset=ISO-8859-1");
													response.getWriter().write("formato email sbagliato");
												}
											}
											else{
												response.setContentType("text/html;charset=ISO-8859-1");
												response.getWriter().write("formato matricola sbagliato");
											}
										}
										else{
											response.setContentType("text/html;charset=ISO-8859-1");
											response.getWriter().write("formato CF sbagliato");
										}
									}
									else {
										response.setContentType("text/html;charset=ISO-8859-1");
										response.getWriter().write("formato citta sbagliato");
									}
								}
								else {
									response.setContentType("text/html;charset=ISO-8859-1");
									response.getWriter().write("formato indirizzo sbagliato");
								}
							}
							else {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("formato data sbagliato");
							}
						}
						else {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("formato luogo sbagliato");
						}
					}
					else {
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("formato cognome sbagliato");
					}
				} 
				else {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("formato nome sbagliato");
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

				if(nome.length()>2 && nome.length()<31){
					if(partitaIva.length()==11){
						if(ceo.length()>4 && ceo.length()<51){
							if(indirizzo.length()>4 && indirizzo.length()<31){
								if(email.length()>4 && email.length()<31){
									if(telefono.length()>6 && telefono.length()<13){
										if(username.length()>4 && username.length()<21){
											if(password.length()>7 && password.length()<21){
												if(risposta.length()>1 && risposta.length()<31){

													if(!(aziende.equals(null))) {
														for(AziendaBean a : aziende) {
															if(a.getEmail().equals(email)) {
																response.setContentType("text/html;charset=ISO-8859-1");
																response.getWriter().write("email gia' esistente");
															}
															if(a.getNome().equals(nome)) {
																response.setContentType("text/html;charset=ISO-8859-1");
																response.getWriter().write("nome azienda gia' esistente");
															}
															if(a.getUsername().equals(username)) {
																response.setContentType("text/html;charset=ISO-8859-1");
																response.getWriter().write("username gia' esistente");
															}
														}
													}

													if(!(password.equals(conferma))){
														response.setContentType("text/html;charset=ISO-8859-1");
														response.getWriter().write("password non corrispondenti");
													} else {
														utente.salvaAzienda(azienda);

														request.getSession().setAttribute("utenteSessione", azienda);
														request.getSession().setAttribute("tipoUtente", "azienda");

														RequestDispatcher view = request.getRequestDispatcher("home.jsp");
														view.forward(request, response);
													}
												}

												else{
													response.setContentType("text/html;charset=ISO-8859-1");
													response.getWriter().write("formato risposta sbagliato");
												}
											}
											else {
												response.setContentType("text/html;charset=ISO-8859-1");
												response.getWriter().write("formato password sbagliato");
											}
										}
										else {
											response.setContentType("text/html;charset=ISO-8859-1");
											response.getWriter().write("formato username sbagliato");
										}
									}
									else {
										response.setContentType("text/html;charset=ISO-8859-1");
										response.getWriter().write("formato telefono sbagliato");
									}
								}
								else {
									response.setContentType("text/html;charset=ISO-8859-1");
									response.getWriter().write("formato email sbagliato");
								}
							}
							else {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("formato indirizzo sbagliato");
							}
						} 
						else {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("formato ceo sbagliato");
						}
					}
					else {
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("formato pi sbagliato");
					}
				} 
				else {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("formato nome sbagliato");
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
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("formato descrizione sbagliato");
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
