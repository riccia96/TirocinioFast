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

			if(azioneQuestionario.equals("QuestionarioStudente")) {
				try{
					ArrayList<String> scelte = new ArrayList<String>();
					String titolo = request.getParameter("titolo");
					String periodo = request.getParameter("periodo");
					scelte.add(request.getParameter("prima"));
					scelte.add(request.getParameter("seconda"));
					scelte.add(request.getParameter("terza"));
					scelte.add(request.getParameter("quarta"));
					scelte.add(request.getParameter("quinta"));
					scelte.add(request.getParameter("sesta"));
					scelte.add(request.getParameter("settima"));
					scelte.add(request.getParameter("ottava"));
					scelte.add(request.getParameter("nona"));
					scelte.add(request.getParameter("decima"));
					scelte.add(request.getParameter("undici"));
					scelte.add(request.getParameter("dodici"));
					scelte.add(request.getParameter("tredici"));
					scelte.add(request.getParameter("quattordici"));
					
					int id = Integer.parseInt((String) request.getSession().getAttribute("id"));
					QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
					StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
					AziendaBean azienda = new AziendaBean();
					TutorBean tutor = new TutorBean();
					questionarioStudente.setId(id);
					questionarioStudente = documento.questionarioStudente(questionarioStudente);
					questionarioStudente.setTitolo(titolo);
					questionarioStudente.setPeriodo(periodo);
					azienda.setUsername(questionarioStudente.getAzienda());
					azienda = utente.getAzienda(azienda);
					tutor.setUsername(questionarioStudente.getTutorAccademico());
					tutor = utente.getTutor(tutor);
					
					request.getSession().setAttribute("questionarioStudente", questionarioStudente);
					request.getSession().setAttribute("studente", studente);
					request.getSession().setAttribute("azienda", azienda);
					request.getSession().setAttribute("tutor", tutor);
					request.getSession().setAttribute("scelte", scelte);
					
					RequestDispatcher view = request.getRequestDispatcher("documentoQuestionarioStudente");
					view.forward(request, response);
					
				} catch (SQLException e){
					e.printStackTrace();
				}
				
			}
			
			if(azioneQuestionario.equals("QuestionarioAzienda")) {
				try {
					ArrayList<String> scelte = new ArrayList<String>();

					String titolo = request.getParameter("titolo");
					String posizione = request.getParameter("posizione");
					scelte.add(request.getParameter("prima"));
					scelte.add(request.getParameter("seconda"));
					scelte.add(request.getParameter("terza"));
					scelte.add(request.getParameter("quarta"));
					scelte.add(request.getParameter("quinta"));
					scelte.add(request.getParameter("sesta"));
					scelte.add(request.getParameter("settima"));
					scelte.add(request.getParameter("ottava"));
					scelte.add(request.getParameter("nona"));
					scelte.add(request.getParameter("decima"));
					scelte.add(request.getParameter("undici"));

					int id = Integer.parseInt((String) request.getSession().getAttribute("id"));
					QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();
					StudenteBean studente = new StudenteBean();
					AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
					TutorBean tutor = new TutorBean();
					questionarioAzienda.setId(id);
					questionarioAzienda = documento.questionarioAzienda(questionarioAzienda);
					questionarioAzienda.setTitoloTirocinio(titolo);
					questionarioAzienda.setPosizioneRicoperta(posizione);
					questionarioAzienda.setUrl("");
					
					studente.setUsername(questionarioAzienda.getStudente());
					studente = utente.getStudente(studente);
					tutor.setUsername(questionarioAzienda.getTutorAccademico());
					tutor = utente.getTutor(tutor);
					
					request.getSession().setAttribute("questionarioAzienda", questionarioAzienda);
					request.getSession().setAttribute("studente", studente);
					request.getSession().setAttribute("azienda", azienda);
					request.getSession().setAttribute("tutor", tutor);
					request.getSession().setAttribute("scelte", scelte);
					
					RequestDispatcher view = request.getRequestDispatcher("documentoQuestionarioAzienda");
					view.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(azioneQuestionario.equals("inoltraQuestionarioStudente")) {

			}
			
			if(azioneQuestionario.equals("inoltraQuestionarioAzienda")) {

			}
			
		}

}
