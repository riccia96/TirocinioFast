package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.AziendaBean;
import Bean.QuestionarioAziendaBean;
import Bean.QuestionarioStudenteBean;
import Bean.StudenteBean;
import Bean.TutorBean;

/**
 * Servlet implementation class GestioneQuestionario
 */
@WebServlet("/GestioneQuestionario")
public class GestioneQuestionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ManagerDocumento documento = new ManagerDocumento();
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
		String azioneQuestionario = request.getParameter("azioneQuestionario");

		if(azioneQuestionario.equals("questionarioStudente")) {
			try {

				StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");

				QuestionarioStudenteBean questionario = new QuestionarioStudenteBean();
				questionario.setStudente(studente.getUsername());

				questionario = documento.questionarioStudente(questionario);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneQuestionario.equals("questionarioAzienda")) {
			AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
		}
		
		

		
		if(azioneQuestionario.equals("inoltraQuestionarioStudente")) {

		}

		if(azioneQuestionario.equals("inoltraQuestionarioAzienda")) {

		}

	}

}
