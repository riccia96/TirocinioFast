package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.AziendaBean;
import Bean.ImpiegatoBean;
import Bean.StudenteBean;
import Bean.TutorBean;

/**
 * Servlet implementation class GestioneTirocinio
 */
@WebServlet("/GestioneTirocinio")
public class GestioneTirocinio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudenteBean studente = new StudenteBean();
	AziendaBean azienda = new AziendaBean();
	List<AziendaBean> aziende = new ArrayList<AziendaBean>();
	TutorBean tutor = new TutorBean();
	List<TutorBean> tutors = new ArrayList<TutorBean>();
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
		String azioneTirocinio = request.getParameter("azioneTirocinio");

		if(azioneTirocinio.equals("inoltraRichiesta")){
			
		}
		
		if(azioneTirocinio.equals("inoltroSA")) {
			studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
			String azienda = request.getSession().getAttribute("usernameAzienda");
			String tutorAccademico = request.get;
			String annoAccademico;
			int cfu;
			boolean handicap;
		}
		
		if(azioneTirocinio.equals("inoltroAT")) {

		}
		
		if(azioneTirocinio.equals("inoltroTS")) {

		}
		
		if(azioneTirocinio.equals("inoltroSI")) {

		}
		
		if(azioneTirocinio.equals("elencoAziende")) {

		}
		
		if(azioneTirocinio.equals("schedaAzienda")) {

		}
		
		if(azioneTirocinio.equals("ricercaAzienda")) {

		}
		
	}

}
