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
import Bean.TutorBean;

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
		
		//no
		
		if(azioneConvenzione.equals("elencoRichiesteConvenzioni")) {
			try {
				List<ConvenzioneBean> convenzioni = documento.convenzioni();
				List<ConvenzioneBean> richieste = new ArrayList<ConvenzioneBean>();
				List<AziendaBean> aziende = new ArrayList<AziendaBean>();

				for(ConvenzioneBean c : convenzioni) {
					if(!(c.isConvalida())) {
						AziendaBean a = new AziendaBean();
						a.setUsername(c.getAzienda());
						aziende.add(utente.getAzienda(a));
						richieste.add(c);
					}
				}

				request.getSession().setAttribute("richiesteConvenzioni", richieste);
				request.getSession().setAttribute("listaAziende", aziende);

				if(richieste.equals(null)) {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("nessuna richiesta");
				}

				RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteConvenzioni.jsp");
				view.forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		//no
		if(azioneConvenzione.equals("convenzioniConvalidate")){
			try{
				List<ConvenzioneBean> convenzioni = documento.convenzioni();
				List<ConvenzioneBean> richieste = new ArrayList<ConvenzioneBean>();
				List<AziendaBean> aziende = new ArrayList<AziendaBean>();

				for(ConvenzioneBean c : convenzioni) {
					if((c.isConvalida())) {
						AziendaBean a = new AziendaBean();
						a.setUsername(c.getAzienda());
						aziende.add(utente.getAzienda(a));
						richieste.add(c);
					}
				}

				request.getSession().setAttribute("listaConvenzioni", richieste);
				request.getSession().setAttribute("listaAziende", aziende);

				if(richieste.equals(null)) {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("nessuna richiesta");
				}

				RequestDispatcher view = request.getRequestDispatcher("elencoConvenzioniAccettate.jsp");
				view.forward(request, response);
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	
		//no
		if(azioneConvenzione.equals("selezionaConvenzione")){
			try {
				
				int id = Integer.parseInt((String) request.getParameter("idConv"));
				ConvenzioneBean convenzione = new ConvenzioneBean();
				convenzione.setId(id);
				convenzione = documento.convenzione(convenzione);
				
				if(!convenzione.getUrl().equals("")) {
					request.getSession().setAttribute("pdfConv", convenzione);
					request.getSession().setAttribute("tipoDocumento", "convenzione");
					RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
					view.forward(request, response);

				} else {
					request.getSession().setAttribute("doc", convenzione);
					RequestDispatcher view = request.getRequestDispatcher("documentoConvenzione.jsp");
					view.forward(request, response);

				}

				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

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
