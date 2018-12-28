package Control;

import java.io.IOException;
import java.sql.SQLException;

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

	AziendaBean azienda = new AziendaBean();

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
								response.getWriter().write("username no");
							}else {
								if(utente.getImpiegato(impiegato).getPassword().equals(password)) {
									request.getSession().setAttribute("utenteSessione", utente.getImpiegato(impiegato));
									
									RequestDispatcher view = request.getRequestDispatcher("homeImpiegato.jsp");
									view.forward(request, response);
								}else {
									response.setContentType("text/html;charset=ISO-8859-1");
									response.getWriter().write("password no");
								}
							}
						}else {
							if(utente.getTutor(tutor).getPassword().equals(password)) {
								request.getSession().setAttribute("utenteSessione", utente.getTutor(tutor));
								
								RequestDispatcher view = request.getRequestDispatcher("homeTutor.jsp");
								view.forward(request, response);
							}else {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("password no");
							}
						}
					}else {
						if(utente.getAzienda(azienda).getPassword().equals(password)) {
							request.getSession().setAttribute("utenteSessione", utente.getAzienda(azienda));
							
							RequestDispatcher view = request.getRequestDispatcher("homeAzienda.jsp");
							view.forward(request, response);
						}else {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("password no");
						}
					}
				}else {
					if(utente.getStudente(studente).getPassword().equals(password)) {
						request.getSession().setAttribute("utenteSessione", utente.getStudente(studente));
						
						RequestDispatcher view = request.getRequestDispatcher("homeStudente.jsp");
						view.forward(request, response);
					}else {
						response.setContentType("text/html;charset=ISO-8859-1");
						response.getWriter().write("password no");
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

		}

		if(azioneUtente.equals("impostaPassword")) {

		}

		if(azioneUtente.equals("registra")) {

		}

		if(azioneUtente.equals("areaPersonale")) {

		}

		if(azioneUtente.equals("compilaScheda")) {

		}
		
		if(azioneUtente.equals("completaScheda")) {

		}
	}

}
