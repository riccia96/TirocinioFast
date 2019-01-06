package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ConvenzioneBean;
import Bean.TirocinioBean;

/**
 * Servlet implementation class GestioneDocumento
 */
@WebServlet("/GestioneDocumento")
public class GestioneDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ManagerDocumento documento = new ManagerDocumento();
	static ManagerTirocinio richiesta = new ManagerTirocinio();

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
		String azioneDocumento = request.getParameter("azioneDocumento");

		if(azioneDocumento.equals("uploadConvenzione")) {
			try {
				String utente = (String) request.getSession().getAttribute("tipoUtente");
			

				String nomeFile = (String) request.getParameter("nomeFileConvenzione");
				if(utente.equals("azienda")){
					
					if(!nomeFile.equals(null)) {
						ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("convenzione");
						convenzione.setUrl("pdf/" + nomeFile);

						documento.UploadConvenzione(convenzione);
						RequestDispatcher view = request.getRequestDispatcher("GestioneConvenzione?azioneConvenzione=apriForm");
						view.forward(request, response);

					}} else if(utente.equals("impiegato")){

						int idConv = Integer.parseInt((String) request.getParameter("idConvenzione"));
						
						ConvenzioneBean conv = new ConvenzioneBean();
						conv.setId(idConv);
						conv = documento.convenzione(conv);
						
						conv.setUrl("pdf/" + nomeFile);
						conv.setConvalida(true);
						
						documento.UploadConvenzione(conv);
						
						RequestDispatcher view = request.getRequestDispatcher("GestioneConvenzione?azioneConvenzione=elencoRichiesteConvenzioni");
						view.forward(request, response);
					}
				 else {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("carica il file");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(azioneDocumento.equals("uploadTirocinio")) {
			try {
				String utente = (String) request.getSession().getAttribute("tipoUtente");
			

				String nomeFile = (String) request.getParameter("attivitaTirocinioFirmata");
				if(utente.equals("azienda")){
					
					if(!nomeFile.equals(null)) {
						int id = Integer.parseInt((String) request.getParameter("id"));
						TirocinioBean tirocinio = new TirocinioBean();
						tirocinio.setId(id);
						tirocinio = richiesta.richiestaTirocinio(tirocinio);
						tirocinio.setUrl("pdf/" + nomeFile);
						tirocinio.setConvalidaAzienda(true);
						documento.UploadTirocinio(tirocinio);
						
						request.getSession().setAttribute("tirocinio", tirocinio);
						
						RequestDispatcher view = request.getRequestDispatcher("GestioneTirocinio?azioneTirocinio=elencoRichiesteTirocinio");
						view.forward(request, response);

					}
				} else if(utente.equals("tutor")){

					int id = Integer.parseInt((String) request.getParameter("id"));
					TirocinioBean tirocinio = new TirocinioBean();
					tirocinio.setId(id);
					tirocinio = richiesta.richiestaTirocinio(tirocinio);
					tirocinio.setUrl("pdf/" + nomeFile);
					tirocinio.setConvalidaTutor(true);
					documento.UploadTirocinio(tirocinio);
					
					request.getSession().setAttribute("tirocinio", tirocinio);
					
					RequestDispatcher view = request.getRequestDispatcher("GestioneTirocinio?azioneTirocinio=elencoRichiesteTirocinio");
					view.forward(request, response);
				} else if(utente.equals("studente")){
					int id = Integer.parseInt((String) request.getParameter("id"));
					TirocinioBean tirocinio = new TirocinioBean();
					tirocinio.setId(id);
					tirocinio = richiesta.richiestaTirocinio(tirocinio);
					tirocinio.setUrl("pdf/" + nomeFile);
					tirocinio.setConvalidaStudente(true);
					documento.UploadTirocinio(tirocinio);
					
					request.getSession().setAttribute("tirocinio", tirocinio);
					
					RequestDispatcher view = request.getRequestDispatcher("GestioneTirocinio?azioneTirocinio=elencoRichiesteTirocinio");
					view.forward(request, response);


				} else if(utente.equals("impiegato")){
					int id = Integer.parseInt((String) request.getParameter("id"));
					TirocinioBean tirocinio = new TirocinioBean();
					tirocinio.setId(id);
					tirocinio = richiesta.richiestaTirocinio(tirocinio);
					tirocinio.setUrl("pdf/" + nomeFile);
					tirocinio.setConvalidaRichiesta(true);
					documento.UploadTirocinio(tirocinio);
					
					request.getSession().setAttribute("tirocinio", tirocinio);
					
					RequestDispatcher view = request.getRequestDispatcher("GestioneTirocinio?azioneTirocinio=elencoRichiesteTirocinio");
					view.forward(request, response);


				}
				else {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("carica il file");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
