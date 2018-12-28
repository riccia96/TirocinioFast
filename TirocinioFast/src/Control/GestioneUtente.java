package Control;

import java.io.IOException;
import java.sql.SQLException;

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

	static StudenteDAO studenteDAO = new StudenteDAO();
	StudenteBean studente = new StudenteBean();
	
	static AziendaDAO aziendaDAO = new AziendaDAO();
	AziendaBean azienda = new AziendaBean();
	
	static TutorAccademicoDAO tutorDAO = new TutorAccademicoDAO();
	TutorBean tutor = new TutorBean();
	
	static ImpiegatoDAO impiegatoDAO = new ImpiegatoDAO();
	ImpiegatoBean impiegato = new ImpiegatoBean();
	
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

		if(azioneUtente.equals("Login")) {

			try {
				String email = request.getParameter("username");
				String password = request.getParameter("password");
				
				
				
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
