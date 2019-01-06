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

/**
 * Servlet implementation class GestioneDocumento
 */
@WebServlet("/GestioneDocumento")
public class GestioneDocumento extends HttpServlet {
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
		String azioneDocumento = request.getParameter("azioneDocumento");

		if(azioneDocumento.equals("uploadConvenzione")) {
			try {
				String utente = (String) request.getSession().getAttribute("utenteSessione");
				
				String nomeFile = (String) request.getParameter("nomeFileConvenzione");
				if(!nomeFile.equals(null)) {
					ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("convenzione");
					convenzione.setUrl("pdf/" + nomeFile);
					System.out.println(convenzione.getUrl());
					documento.UploadConvenzione(convenzione);
					
					if(utente.equals("azienda")){
						RequestDispatcher view = request.getRequestDispatcher("convenzioneEsistente.jsp");
						view.forward(request, response);
					} else if(utente.equals("impiegato")){
						convenzione.setConvalida(true);
						documento.UploadConvenzione(convenzione);
						RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteConvenzione.jsp");
						view.forward(request, response);
					}
				} else {
					response.setContentType("text/html;charset=ISO-8859-1");
					response.getWriter().write("carica il file");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
