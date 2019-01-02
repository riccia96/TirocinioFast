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
import Bean.ConvenzioneBean;
import Bean.ImpiegatoBean;
import Bean.StudenteBean;
import Bean.TirocinioBean;
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

	TirocinioBean tirocinio = new TirocinioBean();
	List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
	List<ConvenzioneBean> convenzioni = new ArrayList<ConvenzioneBean>();
	
	ManagerUtente utente = new ManagerUtente();
	ManagerTirocinio richiesta = new ManagerTirocinio();
	ManagerDocumento documento = new ManagerDocumento();

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
			//username azienda selezionata
			String aziendaTirocinio = request.getParameter("aziendaSelezionata");

			request.getSession().setAttribute("aziendaTirocinio", aziendaTirocinio);

			RequestDispatcher view = request.getRequestDispatcher("inoltraRichiesta.jsp");
			view.forward(request, response);
		}

		if(azioneTirocinio.equals("inoltroSA")) {
			try {
				studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
				String aziendaTirocinio = (String) request.getSession().getAttribute("aziendaTirocinio");
				String tutorAccademico = request.getParameter("tutor"); 
				String annoAccademico = request.getParameter("annoAccademico");
				int cfu = Integer.parseInt(request.getParameter("cfu"));
				String h = request.getParameter("handicap");
				boolean handicap;
				if(h.equals("si")) {
					handicap = true;
				} else {
					handicap = false;
				}

				tirocinio.setStudente(studente.getUsername());
				tirocinio.setAzienda(aziendaTirocinio);
				tirocinio.setTutorAccademico(tutorAccademico);
				tirocinio.setAnnoAccademico(annoAccademico);
				tirocinio.setCfu(cfu);
				tirocinio.setHandicap(handicap);

				richiesta.salvaTirocinio(tirocinio);

				RequestDispatcher view = request.getRequestDispatcher("homeStudente.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("richiesteAzienda")) {
			try {
				azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");

				tirocini.addAll(richiesta.richiesteTirocinio());
				List<TirocinioBean> richieste = new ArrayList<TirocinioBean>();
				for(TirocinioBean t : tirocini) {
					if(t.getAzienda().equals(azienda.getUsername())) {
						richieste.add(t);
					}
				}

				request.getSession().setAttribute("richieste", richieste);

				RequestDispatcher view = request.getRequestDispatcher("richiesteTirocinioA.jsp");
				view.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		if(azioneTirocinio.equals(""))

			if(azioneTirocinio.equals("inoltroAT")) {
				try {
					azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
					String sede = request.getParameter("sede");
					String tempi = request.getParameter("tempi");
					String periodo = request.getParameter("periodo");
					String obiettivi = request.getParameter("obiettivi");
					String facilitazioni = request.getParameter("facilitazioni");
					tirocinio.setSedeTirocinio(sede);
					tirocinio.setAccessoLocali(tempi);
					tirocinio.setPeriodoTirocinio(periodo);
					tirocinio.setObiettivoTirocinio(obiettivi);
					tirocinio.setFacilitazioni(facilitazioni);

				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

		if(azioneTirocinio.equals("inoltroTS")) {

		}

		if(azioneTirocinio.equals("inoltroSI")) {

		}

		if(azioneTirocinio.equals("elencoAziende")) {
			try {
				aziende.addAll(utente.getAziende());
				convenzioni.addAll(documento.convenzioni());
				List<AziendaBean> aziendeConv = new ArrayList<AziendaBean>();
				for(AziendaBean a : aziende) {
					for(ConvenzioneBean c : convenzioni) {
						if(a.getNome().equals(c.getAzienda())) {
							aziendeConv.add(a);
						}
					}
				}
				if(aziendeConv.equals(null)) {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("nessuna azienda convenzionata");
					//BOH
					//RequestDispatcher view = request.getRequestDispatcher("aziendeConvenzionate.jsp");
					//view.forward(request, response);
				}
				else {
					request.getSession().setAttribute("aziendeConvenzionate", aziendeConv);
					RequestDispatcher view = request.getRequestDispatcher("aziendeConvenzionate.jsp");
					view.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(azioneTirocinio.equals("schedaAzienda")) {

		}

		if(azioneTirocinio.equals("ricercaAzienda")) {

		}

	}

}
