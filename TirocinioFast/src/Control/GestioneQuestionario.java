package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ConvenzioneBean;

/**
 * Servlet implementation class GestioneQuestionario
 */
@WebServlet("/GestioneQuestionario")
public class GestioneQuestionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
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
			String azioneQuestionario = request.getParameter("azioneQuestionario");

			if(azioneQuestionario.equals("QuestionarioStudente")) {
				try{
					String titolo = request.getParameter("titolo");
					String periodo = request.getParameter("periodo");

					int id = Integer.parseInt((String) request.getSession().getAttribute("id"));
					ConvenzioneBean convenzione = new ConvenzioneBean();
					convenzione.setId(id);
					convenzione = documento.convenzione(convenzione);
				} catch (SQLException e){
					e.printStackTrace();
				}
				
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
