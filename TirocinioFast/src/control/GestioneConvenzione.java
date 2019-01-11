package control;

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

import bean.AziendaBean;
import bean.ConvenzioneBean;
import bean.TutorBean;

/**
 * Servlet implementation class GestioneConvenzione
 */
@WebServlet("/GestioneConvenzione")
public class GestioneConvenzione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ManagerUtente utente = new ManagerUtente();
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


		String azioneConvenzione = request.getParameter("azioneConvenzione");
		
		//ok
		if(azioneConvenzione.equals("apriForm")){
			try {
				List<TutorBean> tutors = new ArrayList<TutorBean>();
				tutors = utente.getTutorAccademici();

				AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
				List<ConvenzioneBean> convenzioni = documento.convenzioni();
				boolean flag = false;
				for(ConvenzioneBean c: convenzioni) {
					if(c.getAzienda().equals(azienda.getUsername())) {
						request.getSession().setAttribute("convenzioneA", c);
						flag = true;
					}
				}
				if(flag) {

					RequestDispatcher view = request.getRequestDispatcher("convenzioneEsistente.jsp");
					view.forward(request, response);
				} else {
					request.getSession().setAttribute("tutors", tutors);

					RequestDispatcher view = request.getRequestDispatcher("convenzione.jsp");
					view.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
