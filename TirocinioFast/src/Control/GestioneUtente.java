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

	StudenteBean studente = new StudenteBean();
	List<StudenteBean> studenti = new ArrayList<StudenteBean>();
	AziendaBean azienda = new AziendaBean();
	List<AziendaBean> aziende = new ArrayList<AziendaBean>();
	TutorBean tutor = new TutorBean();

	ImpiegatoBean impiegato = new ImpiegatoBean();

	ManagerUtente utente = new ManagerUtente();


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
				String password = request.getParameter("password");

				studente.setUsername(username);
				azienda.setUsername(username);
				impiegato.setUsername(username);
				tutor.setUsername(username);


				if(utente.getStudente(studente).equals(null)){
					if(utente.getAzienda(azienda).equals(null)) {
						if(utente.getTutor(tutor).equals(null)) {
							if(utente.getImpiegato(impiegato).equals(null)) {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("username no1");
							}else {
								if(utente.getImpiegato(impiegato).getPassword().equals(password)) {
									request.getSession().setAttribute("utenteSessione", utente.getImpiegato(impiegato));
									request.getSession().setAttribute("tipoUtente", "impiegato");

									RequestDispatcher view = request.getRequestDispatcher("homeImpiegato.jsp");
									view.forward(request, response);
								}else {
									response.setContentType("text/html;charset=ISO-8859-1");
									response.getWriter().write("password no2");
								}
							}
						}else {
							if(utente.getTutor(tutor).getPassword().equals(password)) {
								request.getSession().setAttribute("utenteSessione", utente.getTutor(tutor));
								request.getSession().setAttribute("tipoUtente", "tutor");
								
								RequestDispatcher view = request.getRequestDispatcher("homeTutor.jsp");
								view.forward(request, response);
							}else {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("password no3");
							}
						}
					}else {
						if(utente.getAzienda(azienda).getPassword().equals(password)) {
							request.getSession().setAttribute("utenteSessione", utente.getAzienda(azienda));
							request.getSession().setAttribute("tipoUtente", "azienda");
							
							RequestDispatcher view = request.getRequestDispatcher("homeAzienda.jsp");
							view.forward(request, response);
						}else {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("password no4");
						}
					}
				}else {
					if(utente.getStudente(studente).getPassword().equals(password)) {
						request.getSession().setAttribute("utenteSessione", utente.getStudente(studente));
						request.getSession().setAttribute("tipoUtente", "azienda");
						
						RequestDispatcher view = request.getRequestDispatcher("homeStudente.jsp");
						view.forward(request, response);
					}else {
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("password no5");
					}
				}


			} catch (SQLException e) {
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

				studente.setUsername(username);
				azienda.setUsername(username);
				impiegato.setUsername(username);
				tutor.setUsername(username);

				if(utente.getStudente(studente).equals(null)){
					if(utente.getAzienda(azienda).equals(null)){
						if(utente.getImpiegato(impiegato).equals(null)){
							if(utente.getTutor(tutor).equals(null)){
								response.getWriter().write("username no");
							}else {
								if(utente.getTutor(tutor).getDomanda().equals(risposta)){
									request.getSession().setAttribute("utenteSessione", utente.getTutor(tutor));
									request.getSession().setAttribute("tipoUtente", "tutor");

									RequestDispatcher view = request.getRequestDispatcher("reimposta.jsp");
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

								RequestDispatcher view = request.getRequestDispatcher("reimposta.jsp");
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

							RequestDispatcher view = request.getRequestDispatcher("reimposta.jsp");
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

						RequestDispatcher view = request.getRequestDispatcher("reimposta.jsp");
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
			System.out.print(request.getSession().getAttribute("tipoUtente"));
			try {
				if(password.equals(conferma)) {
					if(!(request.getSession().getAttribute("tipoUtente") == "studente")) {
						if(!(request.getSession().getAttribute("tipoUtente") == "azienda")) {
							if(!(request.getSession().getAttribute("tipoUtente") == "tutor")) {
								impiegato = (ImpiegatoBean) request.getSession().getAttribute("utenteSessione");
								impiegato.setPassword(password);
								utente.impostaPasswordImpiegato(impiegato);

								request.getSession().removeAttribute("tipoUtente");
								request.getSession().removeAttribute("utenteSessione");

								RequestDispatcher view = request.getRequestDispatcher("index.jsp");
								view.forward(request, response);
							} else {
								tutor = (TutorBean) request.getSession().getAttribute("utenteSessione");
								tutor.setPassword(password);
								utente.impostaPasswordTutor(tutor);

								request.getSession().removeAttribute("tipoUtente");
								request.getSession().removeAttribute("utenteSessione");

								RequestDispatcher view = request.getRequestDispatcher("index.jsp");
								view.forward(request, response);
							}
						} else {
							azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
							azienda.setPassword(password);
							utente.impostaPasswordAzienda(azienda);

							request.getSession().removeAttribute("tipoUtente");
							request.getSession().removeAttribute("utenteSessione");

							RequestDispatcher view = request.getRequestDispatcher("index.jsp");
							view.forward(request, response);
						}
					} else {
						studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
						studente.setPassword(password);
						utente.impostaPasswordStudente(studente);

						request.getSession().removeAttribute("tipoUtente");
						request.getSession().removeAttribute("utenteSessione");

						RequestDispatcher view = request.getRequestDispatcher("index.jsp");
						view.forward(request, response);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		

		}

		if(azioneUtente.equals("registraStudente")) {
			try{

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
				
				if(!(studenti.equals(null))) {
					for(StudenteBean s : studenti) {
						if(s.getEmail().equals(email)) {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("e-mail gia' esistente");
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
				} else {
					utente.registraStudente(studente);

					RequestDispatcher view = request.getRequestDispatcher("homeStudente.jsp");
					view.forward(request, response);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}


		if(azioneUtente.equals("registraAzienda")) {

			try{

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
					utente.registraAzienda(azienda);

					RequestDispatcher view = request.getRequestDispatcher("homeAzienda.jsp");
					view.forward(request, response);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		if(azioneUtente.equals("areaPersonale")) {
			//imposta password vedere se funziona l'equals invece che == di imposta
			if(!(request.getSession().getAttribute("tipoUtente").equals(studente))){
				if(!(request.getSession().getAttribute("tipoUtente").equals(azienda))){
					if(!(request.getSession().getAttribute("tipoUtente").equals(tutor))){
						RequestDispatcher view = request.getRequestDispatcher("homeImpiegato.jsp");
						view.forward(request, response);
					} else {
						RequestDispatcher view = request.getRequestDispatcher("homeTutor.jsp");
						view.forward(request, response);
					}
				} else {
					RequestDispatcher view = request.getRequestDispatcher("homeAzienda.jsp");
					view.forward(request, response);
				}
			} else {
				RequestDispatcher view = request.getRequestDispatcher("homeStudente.jsp");
				view.forward(request, response);
			}
			
		}

		
		if(azioneUtente.equals("salvaScheda")) {
			String descrizione = request.getParameter("descrizione");
			String logo = request.getParameter("logo");
			
			azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
			//controllare path immagine 
			String pathLogo = "/img/logo" + azienda.getNome();
			//aggiungere questi due campi alle cose di sopra :D 
			azienda.setDescrizione(descrizione);
			azienda.setLogo(logo);
			
		}

		
	}

}
