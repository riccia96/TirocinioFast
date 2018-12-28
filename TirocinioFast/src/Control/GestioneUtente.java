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
import Model.AziendaDAO;
import Model.ImpiegatoDAO;
import Model.StudenteDAO;
import Model.TutorAccademicoDAO;

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
									RequestDispatcher view = request.getRequestDispatcher("HomeImpiegato.jsp");
									view.forward(request, response);
								}else {
									response.setContentType("text/html;charset=ISO-8859-1");
									response.getWriter().write("password no");
								}
							}
						}else {
							if(utente.getTutor(tutor).getPassword().equals(password)) {
								RequestDispatcher view = request.getRequestDispatcher("HomeTutor.jsp");
								view.forward(request, response);
							}else {
								response.setContentType("text/html;charset=ISO-8859-1");
								response.getWriter().write("password no");
							}
						}
					}else {
						if(utente.getAzienda(azienda).getPassword().equals(password)) {
							RequestDispatcher view = request.getRequestDispatcher("HomeAzienda.jsp");
							view.forward(request, response);
						}else {
							response.setContentType("text/html;charset=ISO-8859-1");
							response.getWriter().write("password no");
						}
					}
				}else {
					if(utente.getStudente(studente).getPassword().equals(password)) {
						RequestDispatcher view = request.getRequestDispatcher("HomeStudente.jsp");
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
	}

}
