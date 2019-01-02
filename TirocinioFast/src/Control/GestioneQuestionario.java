package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestioneQuestionario
 */
@WebServlet("/GestioneQuestionario")
public class GestioneQuestionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    		

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

			if(azioneQuestionario.equals("QuestionarioStudente")) {
				String titolo = request.getParameter("titolo");
				
				
			}
			
			if(azioneQuestionario.equals("QuestionarioAzienda")) {
				String titolo = request.getParameter("titolo");
				String posizione = request.getParameter("posizione");
			}
			
			if(azioneQuestionario.equals("inoltraQuestionarioStudente")) {

			}
			
			if(azioneQuestionario.equals("inoltraQuestionarioAzienda")) {

			}
			
		}

}
