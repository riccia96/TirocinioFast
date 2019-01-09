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

				QuestionarioAziendaBean questionario = new QuestionarioAziendaBean();
				questionario.setAzienda(azienda.getUsername());


				questionario = documento.questionarioAzienda(questionario);


				if(questionario.getTitoloTirocinio().equals("")){
					RequestDispatcher view = request.getRequestDispatcher("questionarioAzienda");
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
