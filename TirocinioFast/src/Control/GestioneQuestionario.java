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
import Bean.QuestionarioAziendaBean;
import Bean.QuestionarioStudenteBean;
import Bean.StudenteBean;
import Bean.TirocinioBean;
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
				List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>(); 
				List<QuestionarioStudenteBean> questionari = new ArrayList<QuestionarioStudenteBean>();
				QuestionarioStudenteBean questionario = new QuestionarioStudenteBean();
				TutorBean tutor = new TutorBean();
				AziendaBean azienda = new AziendaBean();
				boolean flag = false;

				tirocini = documento.richiesteTirocinio();
				questionari = documento.questionariStudente();
				for(TirocinioBean t : tirocini){
					if(t.getStudente().equals(studente.getUsername()) && t.isConvalidaRichiesta()){
						flag = true;
						for(QuestionarioStudenteBean q : questionari){
							if(t.getStudente().equals(q.getStudente())){
								questionario = q;
								tutor.setUsername(questionario.getTutorAccademico());
								tutor = utente.getTutor(tutor);
								azienda.setUsername(questionario.getAzienda());
								azienda = utente.getAzienda(azienda);
							}

						}
					} 
				}
				if(flag) {
					if(questionario.getTitolo().equals("")){

						RequestDispatcher view = request.getRequestDispatcher("questionarioStudenteCompilazione.jsp");
						view.forward(request, response);
					} else {
						
						request.getSession().setAttribute("questionarioStudente", questionario);
						request.getSession().setAttribute("questSAzienda", azienda);
						request.getSession().setAttribute("questSTutor", tutor);
						RequestDispatcher view = request.getRequestDispatcher("questionari.jsp");
						view.forward(request, response);
					}
				} else {
					RequestDispatcher view = request.getRequestDispatcher("nessunaRisorsa.jsp");
					view.forward(request, response);
				}
				
				


			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneQuestionario.equals("questionarioAzienda")) {
			try {
				AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
				List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>(); 
				List<QuestionarioAziendaBean> questionari = new ArrayList<QuestionarioAziendaBean>();
				List<QuestionarioAziendaBean> questionariA = new ArrayList<QuestionarioAziendaBean>();
				List<StudenteBean> studenti = new ArrayList<StudenteBean>();
				List<TutorBean> tutors = new ArrayList<TutorBean>();
				StudenteBean studente = new StudenteBean();
				TutorBean tutor = new TutorBean();
				
				boolean flag = false;

				tirocini = documento.richiesteTirocinio();
				questionari = documento.questionariAzienda();
				
				for(TirocinioBean t : tirocini){
					if(t.getAzienda().equals(azienda.getUsername()) && t.isConvalidaRichiesta()){
						flag = true;
						for(QuestionarioAziendaBean q : questionari){
							if(t.getAzienda().equals(q.getAzienda())){
								questionariA.add(q);
								
								tutor.setUsername(q.getTutorAccademico());
								tutor = utente.getTutor(tutor);
								tutors.add(tutor);
								studente.setUsername(q.getStudente());
								studente = utente.getStudente(studente);
								studenti.add(studente);
							}

						}
					} 
				}

				if(questionariA.size() == 0){
					RequestDispatcher view = request.getRequestDispatcher("nessunaRisorsa.jsp");
					view.forward(request, response);
				} else {
					request.getSession().setAttribute("questionariA", questionariA);
					request.getSession().setAttribute("studenti", studenti);
					request.getSession().setAttribute("tutors", tutors);
					
					RequestDispatcher view = request.getRequestDispatcher("questionari.jsp");
					view.forward(request, response);
				}
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
