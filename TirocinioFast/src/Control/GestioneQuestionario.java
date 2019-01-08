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

		if(azioneQuestionario.equals("compilaQuestionarioStudente")) {
			try{
				ArrayList<String> risposte = new ArrayList<String>();
				String titolo = request.getParameter("titolo");
				String periodo = request.getParameter("periodo");
				risposte.add(request.getParameter("prima"));
				risposte.add(request.getParameter("seconda"));
				risposte.add(request.getParameter("terza"));
				risposte.add(request.getParameter("quarta"));
				risposte.add(request.getParameter("quinta"));
				risposte.add(request.getParameter("sesta"));
				risposte.add(request.getParameter("settima"));
				risposte.add(request.getParameter("ottava"));
				risposte.add(request.getParameter("nona"));
				risposte.add(request.getParameter("decima"));
				risposte.add(request.getParameter("undici"));
				risposte.add(request.getParameter("dodici"));
				risposte.add(request.getParameter("tredici"));
				risposte.add(request.getParameter("quattordici"));

				String scelte = "";
				for(String r: risposte) {
					scelte += r + "*";
				}


				int id = Integer.parseInt((String) request.getSession().getAttribute("id"));
				QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
				StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
				AziendaBean azienda = new AziendaBean();
				TutorBean tutor = new TutorBean();

				questionarioStudente.setId(id);

				questionarioStudente = documento.questionarioStudente(questionarioStudente);
				questionarioStudente.setTitolo(titolo);
				questionarioStudente.setPeriodo(periodo);
				questionarioStudente.setScelte(scelte);

				azienda.setUsername(questionarioStudente.getAzienda());
				azienda = utente.getAzienda(azienda);
				tutor.setUsername(questionarioStudente.getTutorAccademico());
				tutor = utente.getTutor(tutor);

				request.getSession().setAttribute("questionarioStudente", questionarioStudente);
				request.getSession().setAttribute("studente", studente);
				request.getSession().setAttribute("azienda", azienda);
				request.getSession().setAttribute("tutor", tutor);
				request.getSession().setAttribute("risposte", risposte);

				RequestDispatcher view = request.getRequestDispatcher("documentoQuestionarioStudente");
				view.forward(request, response);

			} catch (SQLException e){
				e.printStackTrace();
			}

		}

		if(azioneQuestionario.equals("compilaQuestionarioAzienda")) {
			try {
				ArrayList<String> risposte = new ArrayList<String>();

				String titolo = request.getParameter("titolo");
				String posizione = request.getParameter("posizione");
				risposte.add(request.getParameter("prima"));
				risposte.add(request.getParameter("seconda"));
				risposte.add(request.getParameter("terza"));
				risposte.add(request.getParameter("quarta"));
				risposte.add(request.getParameter("quinta"));
				risposte.add(request.getParameter("sesta"));
				risposte.add(request.getParameter("settima"));
				risposte.add(request.getParameter("ottava"));
				risposte.add(request.getParameter("nona"));
				risposte.add(request.getParameter("decima"));
				risposte.add(request.getParameter("undici"));

				String scelte = "";
				for(String r: risposte) {
					scelte += r + "*";
				}

				int id = Integer.parseInt((String) request.getSession().getAttribute("id"));
				QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();
				StudenteBean studente = new StudenteBean();
				AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
				TutorBean tutor = new TutorBean();
				questionarioAzienda.setId(id);
				questionarioAzienda = documento.questionarioAzienda(questionarioAzienda);

				questionarioAzienda.setTitoloTirocinio(titolo);
				questionarioAzienda.setPosizioneRicoperta(posizione);
				questionarioAzienda.setScelte(scelte);

				studente.setUsername(questionarioAzienda.getStudente());
				studente = utente.getStudente(studente);
				tutor.setUsername(questionarioAzienda.getTutorAccademico());
				tutor = utente.getTutor(tutor);

				request.getSession().setAttribute("questionarioAzienda", questionarioAzienda);
				request.getSession().setAttribute("studente", studente);
				request.getSession().setAttribute("tutor", tutor);
				request.getSession().setAttribute("risposte", risposte);

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
