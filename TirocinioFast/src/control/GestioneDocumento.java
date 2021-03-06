package control;

import bean.AziendaBean;
import bean.ConvenzioneBean;
import bean.QuestionarioAziendaBean;
import bean.QuestionarioStudenteBean;
import bean.StudenteBean;
import bean.TirocinioBean;
import bean.TutorBean;

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

/**
 * Servlet implementation class GestioneDocumento
 */
@WebServlet("/GestioneDocumento")
public class GestioneDocumento extends HttpServlet {
  private static final long serialVersionUID = 1L;

  static ManagerUtente utente = new ManagerUtente();
  static ManagerDocumento documento = new ManagerDocumento();

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    doPost(request, response);
  }


  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   * @param azioneDocumento il tipo di azione che si cattura tramite le jsp
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String azioneDocumento = request.getParameter("azioneDocumento");

    if (azioneDocumento.equals("compilaTirocinioStudente")) {
      try {
        StudenteBean studente = new StudenteBean();
        TirocinioBean tirocinio = new TirocinioBean();

        studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
        String aziendaTirocinio = (String) request.getSession().getAttribute("aziendaTirocinio");
        String tutorAccademico = request.getParameter("tutor"); 
        String annoAccademico = request.getParameter("annoAccademico");
        int cfu = Integer.parseInt(request.getParameter("cfu"));
        String h = request.getParameter("handicap");
        boolean handicap;
        if (h.equals("si")) {
          handicap = true;
        } else {
          handicap = false;
        }

        if (annoAccademico.length() > 8 && annoAccademico.length() < 45) {
          tirocinio.setStudente(studente.getUsername());
          tirocinio.setAzienda(aziendaTirocinio);
          tirocinio.setTutorAccademico(tutorAccademico);
          tirocinio.setAnnoAccademico(annoAccademico);
          tirocinio.setCfu(cfu);
          tirocinio.setHandicap(handicap);

          documento.salvaTirocinio(tirocinio);

          RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
                 + "azioneDocumento=elencoRichiesteTirocinio");
          view.forward(request, response);
        } else {
          RequestDispatcher view = request.getRequestDispatcher("formatoSbagliato.jsp");
          view.forward(request, response);
        }
      } catch (SQLException e) {

        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("compilaTirocinioAzienda")) {
      try {
        AziendaBean azienda = new AziendaBean();

        int idT = Integer.parseInt((String) request.getParameter("idTiroci"));

        TirocinioBean tirocinio = new TirocinioBean();
        tirocinio.setId(idT);
        tirocinio = documento.getTirocinio(tirocinio);

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

        documento.aggiornaTirocinio(tirocinio);

        request.getSession().setAttribute("aziendaTirocinio", azienda);
        request.getSession().setAttribute("tipoDocumento", "tirocinio");

        RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
              + "azioneDocumento=elencoRichiesteTirocinio");
        view.forward(request, response);
      } catch (SQLException e) {

        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("questAziendaCompilazione")) {
      try {
        int id = Integer.parseInt((String) request.getParameter("idQ"));
        QuestionarioAziendaBean quest = new QuestionarioAziendaBean();

        quest.setId(id);
        quest = documento.getQuestionarioAzienda(quest);
        request.getSession().setAttribute("questAzienda", quest);

        RequestDispatcher view = request.getRequestDispatcher(
              "questionarioAziendaCompilazione.jsp");
        view.forward(request, response);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("compilaQuestionarioStudente")) {
      try {
        request.getSession().removeAttribute("questionarioStudente");
        request.getSession().removeAttribute("studente");
        request.getSession().removeAttribute("questSAzienda");
        request.getSession().removeAttribute("questSTutor");
        request.getSession().removeAttribute("risposte");
        List<TirocinioBean> tirocini = documento.getTirocini("id ASC");
        ArrayList<String> risposte = new ArrayList<String>();
        TirocinioBean tir = new TirocinioBean();
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
        for (String r: risposte) {
          scelte += r + "*";
        }

        QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
        StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
        AziendaBean azienda = new AziendaBean();
        TutorBean tutor = new TutorBean();

        for (TirocinioBean t : tirocini) {
          if (t.getStudente().equals(studente.getUsername())) {
            azienda.setUsername(t.getAzienda());
            tutor.setUsername(t.getTutorAccademico());
            tir = t;

          }
        }


        questionarioStudente.setTitolo(titolo);
        questionarioStudente.setPeriodo(periodo);
        questionarioStudente.setScelte(scelte);
        questionarioStudente.setStudente(studente.getUsername());
        questionarioStudente.setAzienda(azienda.getUsername());
        questionarioStudente.setTutorAccademico(tutor.getUsername());
        azienda = utente.getAzienda(azienda);

        tutor = utente.getTutor(tutor);

        documento.salvaQuestionarioStudente(questionarioStudente);
        QuestionarioStudenteBean questiona = new QuestionarioStudenteBean();
        ArrayList<QuestionarioStudenteBean> questionari = (ArrayList<QuestionarioStudenteBean>)
               documento.getQuestionariStudente("id ASC");
        for (QuestionarioStudenteBean q : questionari) {
          if (q.getTitolo().equals(questionarioStudente.getTitolo())) {
            questiona = q;
          }
        }
        tir.setQuestionarioStudente(questiona.getId());
        documento.aggiornaTirocinio(tir);

        request.getSession().setAttribute("questionarioStudente", questionarioStudente);
        request.getSession().setAttribute("studente", studente);
        request.getSession().setAttribute("questSAzienda", azienda);
        request.getSession().setAttribute("questSTutor", tutor);
        request.getSession().setAttribute("risposte", risposte);

        RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
                + "azioneDocumento=questionarioStudente");
        view.forward(request, response);

      } catch (SQLException e) {

        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("compilaQuestionarioAzienda")) {
      try {
        ArrayList<String> risposte = new ArrayList<String>();
        List<TirocinioBean> tirocini = documento.getTirocini("id ASC");
        TirocinioBean tir = new TirocinioBean();
        String titolo = request.getParameter("titolo");
        String posizione = request.getParameter("posizione");
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

        String scelte = "";
        for (String r: risposte) {
          scelte += r + "*";
        }

        int id = Integer.parseInt((String) request.getParameter("idQuest"));
        QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();
        StudenteBean studente = new StudenteBean();
        AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
        TutorBean tutor = new TutorBean();
        questionarioAzienda.setId(id);
        questionarioAzienda = documento.getQuestionarioAzienda(questionarioAzienda);

        questionarioAzienda.setPeriodoTirocinio(periodo);
        questionarioAzienda.setTitoloTirocinio(titolo);
        questionarioAzienda.setPosizioneRicoperta(posizione);
        questionarioAzienda.setScelte(scelte);
        questionarioAzienda.setConvalida(false);

        studente.setUsername(questionarioAzienda.getStudente());
        studente = utente.getStudente(studente);
        tutor.setUsername(questionarioAzienda.getTutorAccademico());
        tutor = utente.getTutor(tutor);

        for (TirocinioBean t : tirocini) {
          if (t.getStudente().equals(studente.getUsername()) 
                   && t.getAzienda().equals(azienda.getUsername())) {
            tir = t;
          }
        }

        documento.aggiornaQuestionarioAzienda(questionarioAzienda);

        ArrayList<QuestionarioAziendaBean> questionari = (ArrayList<QuestionarioAziendaBean>)
              documento.getQuestionariAzienda("id ASC");
        QuestionarioAziendaBean quest = new QuestionarioAziendaBean();
        for (QuestionarioAziendaBean q : questionari) {
          if (q.getTitoloTirocinio().equals(questionarioAzienda.getTitoloTirocinio())) {
            quest = q;
          }
        }
        tir.setQuestionarioAzienda(quest.getId());
        documento.aggiornaTirocinio(tir);

        RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
              + "azioneDocumento=questionarioAzienda");
        view.forward(request, response);
      } catch (SQLException e) {

        e.printStackTrace();
      }
    }


    if (azioneDocumento.equals("compilaConvenzione")) {
      try {
        request.getSession().removeAttribute("azienda");
        request.getSession().removeAttribute("convenzione");
        AziendaBean azienda = new AziendaBean();
        ConvenzioneBean convenzione = new ConvenzioneBean();

        azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");

        String luogoNascitaR = request.getParameter("luogoNascitaR");
        String dataNascitaR = request.getParameter("dataNascitaR");
        int numeroDipendenti = Integer.parseInt(request.getParameter("numeroDipendenti"));
        String referente = request.getParameter("referente");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String attivita = request.getParameter("descrizioneAttivita");
        String docente = request.getParameter("tutor");

        convenzione.setId(documento.generaCodiceConvenzione());
        convenzione.setAzienda(azienda.getUsername());

        convenzione.setLuogoNascitaCeo(luogoNascitaR);
        convenzione.setDataNascitaCeo(dataNascitaR);
        convenzione.setNumeroDipendenti(numeroDipendenti);
        convenzione.setReferente(referente);
        convenzione.setTelefonoReferente(telefono);
        convenzione.setEmailReferente(email);
        convenzione.setAttivita(attivita);
        convenzione.setTutorAccademico(docente);

        if ((luogoNascitaR.length() > 3 && luogoNascitaR.length() < 31) 
                && (dataNascitaR.length() > 7 && dataNascitaR.length() < 15) 
                && (referente.length() > 4 && referente.length() < 51) 
                && (telefono.length() > 6 && telefono.length() < 14) 
                && (email.length() > 4 && email.length() < 31) 
                && (attivita.length() > 24 && attivita.length() < 1001)) {        

          documento.salvaConvenzione(convenzione);

          request.getSession().setAttribute("azienda", azienda);
          request.getSession().setAttribute("convenzione", convenzione);

          RequestDispatcher view = request.getRequestDispatcher("GestioneConvenzione?"
               + "azioneConvenzione=apriForm");
          view.forward(request, response);

        } else {
          RequestDispatcher view = request.getRequestDispatcher("formatoSbagliato.jsp");
          view.forward(request, response);
        }


      } catch (SQLException e) {

        e.printStackTrace();
      }
    }


    if (azioneDocumento.equals("mostraDocumento")) {
      try {
        request.getSession().removeAttribute("richiestaSelezionata");
        request.getSession().removeAttribute("tipoDocumento");
        int id = Integer.parseInt((String) request.getParameter("idT"));
        TirocinioBean tirocinio = new TirocinioBean();

        tirocinio.setId(id);
        tirocinio = documento.getTirocinio(tirocinio);

        request.getSession().setAttribute("richiestaSelezionata", tirocinio);
        request.getSession().setAttribute("tipoDocumento", "tirocinio");

        RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
        view.forward(request, response);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("mostraQuestionario")) {
      try {
        int id = Integer.parseInt((String) request.getParameter("idQ"));
        String tipoUtente = (String) request.getSession().getAttribute("tipoUtente");

        if (tipoUtente.equals("studente")) {
          QuestionarioStudenteBean questionarioS = new QuestionarioStudenteBean();
          AziendaBean azienda = new AziendaBean();
          TutorBean tutor = new TutorBean();
          ConvenzioneBean convenzione = new ConvenzioneBean();
          List<ConvenzioneBean> convenzioni = documento.getConvenzioni("id ASC");
          questionarioS.setId(id);

          questionarioS = documento.getQuestionarioStudente(questionarioS);


          if (!questionarioS.getUrl().equals("")) {
            request.getSession().setAttribute("questionarioStudente", questionarioS);
            request.getSession().setAttribute("tipoDocumento", "questionarioStudente");

            RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
            view.forward(request, response);
          } else {
            StudenteBean studente = (StudenteBean) 
                  request.getSession().getAttribute("utenteSessione");
            azienda.setUsername(questionarioS.getAzienda());
            azienda = utente.getAzienda(azienda);
            tutor.setUsername(questionarioS.getTutorAccademico());
            String scelte = questionarioS.getScelte();
            ArrayList<String> risposte = new ArrayList<String>();

            for (int i = 0; i < 14; i++) {
              int a = scelte.indexOf('*');
              String risposta = scelte.substring(0, a);
              scelte = scelte.substring(a + 1);

              risposte.add(risposta);
            }

            for (ConvenzioneBean c : convenzioni) {
              if (c.getAzienda().equals(azienda.getUsername())) {
                convenzione = c;
                break;
              }
            }


            request.getSession().setAttribute("questSAzienda", azienda);
            request.getSession().setAttribute("questSTutor", tutor);
            request.getSession().setAttribute("questionarioSConvenzione", convenzione);
            request.getSession().setAttribute("questionarioStudente", questionarioS);
            request.getSession().setAttribute("risposte", risposte);
            request.getSession().setAttribute("studente", studente);

            RequestDispatcher view = request.getRequestDispatcher(
                "documentoQuestionarioStudente.jsp");
            view.forward(request, response);
          }
        } else if (tipoUtente.equals("azienda")) {
          QuestionarioAziendaBean questionarioA = new QuestionarioAziendaBean();
          StudenteBean studente = new StudenteBean();
          TutorBean tutor = new TutorBean();
          ConvenzioneBean convenzione = new ConvenzioneBean();
          List<ConvenzioneBean> convenzioni = documento.getConvenzioni("id ASC");

          questionarioA.setId(id);
          questionarioA = documento.getQuestionarioAzienda(questionarioA);

          if (!questionarioA.getUrl().equals("")) {
            request.getSession().setAttribute("questionarioAzienda", questionarioA);
            request.getSession().setAttribute("tipoDocumento", "questionarioAzienda");

            RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
            view.forward(request, response);
          } else {
            AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
            studente.setUsername(questionarioA.getStudente());
            studente = utente.getStudente(studente);
            tutor.setUsername(questionarioA.getTutorAccademico());
            tutor = utente.getTutor(tutor);
            String scelte = questionarioA.getScelte();
            ArrayList<String> risposte = new ArrayList<String>();

            for (int i = 0; i < 11; i++) {
              int a = scelte.indexOf('*');
              String risposta = scelte.substring(0, a);
              scelte = scelte.substring(a + 1);

              risposte.add(risposta);
            }

            for (ConvenzioneBean c : convenzioni) {
              if (c.getAzienda().equals(azienda.getUsername())) {
                convenzione = c;
              }
            }

            request.getSession().setAttribute("questSAzienda", azienda);
            request.getSession().setAttribute("questSTutor", tutor);
            request.getSession().setAttribute("questionarioAConvenzione", convenzione);
            request.getSession().setAttribute("questionarioAzienda", questionarioA);
            request.getSession().setAttribute("risposteA", risposte);
            request.getSession().setAttribute("questStudente", studente);

            RequestDispatcher view = request.getRequestDispatcher(
                "documentoQuestionarioAzienda.jsp");
            view.forward(request, response);
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("uploadTirocinio")) {
      try {
        String utente = (String) request.getSession().getAttribute("tipoUtente");


        String nomeFile = (String) request.getParameter("attivitaTirocinioFirmata");
        if (utente.equals("azienda")) {

          if (!nomeFile.equals(null)) {
            int id = Integer.parseInt((String) request.getParameter("id"));
            TirocinioBean tirocinio = new TirocinioBean();
            tirocinio.setId(id);
            tirocinio = documento.getTirocinio(tirocinio);
            tirocinio.setUrl("pdf/" + nomeFile);
            tirocinio.setConvalidaAzienda(true);
            documento.aggiornaTirocinio(tirocinio);

            request.getSession().setAttribute("tirocinio", tirocinio);

            RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
                  + "azioneDocumento=elencoRichiesteTirocinio");
            view.forward(request, response);

          }
        } else if (utente.equals("tutor")) {

          int id = Integer.parseInt((String) request.getParameter("id"));
          TirocinioBean tirocinio = new TirocinioBean();
          tirocinio.setId(id);
          tirocinio = documento.getTirocinio(tirocinio);
          tirocinio.setUrl("pdf/" + nomeFile);
          tirocinio.setConvalidaTutor(true);
          documento.aggiornaTirocinio(tirocinio);

          request.getSession().setAttribute("tirocinio", tirocinio);

          RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
                + "azioneDocumento=elencoRichiesteTirocinio");
          view.forward(request, response);
        } else if (utente.equals("studente")) {
          int id = Integer.parseInt((String) request.getParameter("id"));
          TirocinioBean tirocinio = new TirocinioBean();
          tirocinio.setId(id);
          tirocinio = documento.getTirocinio(tirocinio);
          tirocinio.setUrl("pdf/" + nomeFile);
          if (!tirocinio.isConvalidaRichiesta()) {
            tirocinio.setConvalidaStudente(true);
          } else {
            tirocinio.setConvalidaAttivita(true);
          }
          documento.aggiornaTirocinio(tirocinio);

          request.getSession().setAttribute("tirocinio", tirocinio);

          RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
                + "azioneDocumento=elencoRichiesteTirocinio");
          view.forward(request, response);


        } else if (utente.equals("impiegato")) {
          int id = Integer.parseInt((String) request.getParameter("id"));
          TirocinioBean tirocinio = new TirocinioBean();
          tirocinio.setId(id);
          tirocinio = documento.getTirocinio(tirocinio);
          tirocinio.setUrl("pdf/" + nomeFile);
          tirocinio.setConvalidaRichiesta(true);
          documento.aggiornaTirocinio(tirocinio);

          request.getSession().setAttribute("tirocinio", tirocinio);

          RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
                + "azioneDocumento=elencoRichiesteTirocinio");
          view.forward(request, response);


        } else {
          response.setContentType("text/html;charset=ISO-8859-1");
          response.getWriter().write("carica il file");
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("tirociniConclusi")) {
      try {
        String tipoUtente = (String) request.getSession().getAttribute("tipoUtente");
        StudenteBean studente = new StudenteBean();
        AziendaBean azienda = new AziendaBean();
        TutorBean tutor = new TutorBean();

        List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
        List<TirocinioBean> conclusi = new ArrayList<TirocinioBean>();
        List<StudenteBean> studenti = new ArrayList<StudenteBean>();
        List<AziendaBean> aziende = new ArrayList<AziendaBean>();
        List<TutorBean> tutors = new ArrayList<TutorBean>();

        tirocini = documento.getTirocini("id ASC");

        for (TirocinioBean t: tirocini) {
          if (t.isConvalidaAzienda() && t.isConvalidaTutor() 
                && t.isConvalidaStudente() && t.isConvalidaRichiesta() 
                && !(t.isConvalidaAttivita())) {
            conclusi.add(t);
          }
        }
        if (tipoUtente.equals("impiegato")) {
          for (TirocinioBean t: conclusi) {
            studente.setUsername(t.getStudente());
            azienda.setUsername(t.getAzienda());
            tutor.setUsername(t.getTutorAccademico());
            studenti.add(utente.getStudente(studente));
            aziende.add(utente.getAzienda(azienda));
            tutors.add(utente.getTutor(tutor));
          }
          
        } else {
          studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
          for (TirocinioBean t: conclusi) {
            if (t.getStudente().equals(studente.getUsername())) {
              azienda.setUsername(t.getAzienda());
              tutor.setUsername(t.getTutorAccademico());
              studenti.add(utente.getStudente(studente));
              aziende.add(utente.getAzienda(azienda));
              tutors.add(utente.getTutor(tutor));
            }
          }
        }
        request.getSession().setAttribute("listaTirociniConclusi", conclusi);
        request.getSession().setAttribute("listaStudenti", studenti);
        request.getSession().setAttribute("listaAziende", aziende);
        request.getSession().setAttribute("listaTutors", tutors);
        
        RequestDispatcher view = request.getRequestDispatcher("attivitaTirocinioConcluse.jsp");
        view.forward(request, response);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("uploadConvenzione")) {
      try {

        String utente = (String) request.getSession().getAttribute("tipoUtente");

        String nomeFile = (String) request.getParameter("nomeFileConvenzione");
        if (utente.equals("azienda")) {

          if (!nomeFile.equals(null)) {
            ConvenzioneBean convenzione = (ConvenzioneBean) 
                 request.getSession().getAttribute("convenzione");
            convenzione.setUrl("pdf/" + nomeFile);

            documento.aggiornaConvenzione(convenzione);
            RequestDispatcher view = request.getRequestDispatcher("GestioneConvenzione?"
                  + "azioneConvenzione=apriForm");
            view.forward(request, response);

          }
        } else if (utente.equals("impiegato")) {

          int idConv = Integer.parseInt((String) request.getParameter("idConvenzione"));

          ConvenzioneBean conv = new ConvenzioneBean();
          conv.setId(idConv);
          conv = documento.getConvenzione(conv);

          conv.setUrl("pdf/" + nomeFile);
          conv.setConvalida(true);

          documento.aggiornaConvenzione(conv);
 
          RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?azioneDocumento=elencoRichiesteConvenzioni");
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




    if (azioneDocumento.equals("uploadQuestionarioStudente")) {
      try {
        String nomeFile = (String) request.getParameter("questionarioFirmatoStudente");
        int idQ = Integer.parseInt((String) request.getParameter("id"));

        QuestionarioStudenteBean questionario = new QuestionarioStudenteBean();
        questionario.setId(idQ);
        questionario = documento.getQuestionarioStudente(questionario);
        questionario.setUrl("pdf/" + nomeFile);
        documento.aggiornaQuestionarioStudente(questionario);
        RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
              + "azioneDocumento=questionarioStudente");
        view.forward(request, response);


      } catch (SQLException e) {
        e.printStackTrace();
      }
    }


    if (azioneDocumento.equals("uploadQuestionarioAzienda")) {
      try {
        String nomeFile = (String) request.getParameter("questionarioFirmatoAzienda");
        int idQ = Integer.parseInt((String) request.getParameter("id"));
        QuestionarioAziendaBean questionario = new QuestionarioAziendaBean();
        questionario.setId(idQ);
        questionario = documento.getQuestionarioAzienda(questionario);
        questionario.setUrl("pdf/" + nomeFile);
        documento.aggiornaQuestionarioAzienda(questionario);
        RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
              + "azioneDocumento=questionarioAzienda");
        view.forward(request, response);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }





    if (azioneDocumento.equals("uploadRegistroOre")) {
      try {
        String nomeFile = (String) request.getParameter("nomeRegistroOre");

        int idTiro = Integer.parseInt((String) request.getParameter("id"));

        TirocinioBean tirocinio = new TirocinioBean();
        tirocinio.setId(idTiro);
        tirocinio = documento.getTirocinio(tirocinio);

        tirocinio.setRegistroOre("pdf/" + nomeFile);
        documento.aggiornaTirocinio(tirocinio);

        QuestionarioAziendaBean questionarioA = new QuestionarioAziendaBean();

        questionarioA.setAzienda(tirocinio.getAzienda());
        questionarioA.setStudente(tirocinio.getStudente());
        questionarioA.setTutorAccademico(tirocinio.getTutorAccademico());

        documento.salvaQuestionarioAzienda(questionarioA);

        RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
             + "azioneDocumento=registroOre");
        view.forward(request, response);
      } catch (SQLException e) {

        e.printStackTrace();
      }
    }


    if (azioneDocumento.equals("registroOre")) {
      try {

        List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();
        tirocini = documento.getTirocini("id ASC");


        StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
        List<ConvenzioneBean> convenzioni = documento.getConvenzioni("id ASC");
        ConvenzioneBean conv = new ConvenzioneBean();
        TutorBean tutor = new TutorBean();
        AziendaBean azienda = new AziendaBean();
        for (TirocinioBean t : tirocini) {
          if (t.getStudente().equals(studente.getUsername())) {

            if (t.isConvalidaRichiesta()) {

              tutor.setUsername(t.getTutorAccademico());
              tutor = utente.getTutor(tutor);
              azienda.setUsername(t.getAzienda());
              azienda = utente.getAzienda(azienda);
              for (ConvenzioneBean c : convenzioni) {
                if (c.getAzienda().equals(azienda.getUsername())) {
                  conv = c;
                }
              }
              request.getSession().setAttribute("tutorOre", tutor);
              request.getSession().setAttribute("aziendaOre", azienda);
              request.getSession().setAttribute("tirocinioOre", t);
              request.getSession().setAttribute("studenteOre", studente);
              request.getSession().setAttribute("convenzioneOre", conv);
              RequestDispatcher view = request.getRequestDispatcher("elencoRegistroOre.jsp");
              view.forward(request, response);
            } else {

              RequestDispatcher view = request.getRequestDispatcher("nessunaRisorsa.jsp");
              view.forward(request, response);
            }
          }

        }

      } catch (SQLException e) {

        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("elencoRichiesteTirocinio")) {
      try {
        StudenteBean studente = new StudenteBean();
        TutorBean tutor = new TutorBean();
        AziendaBean azienda = new AziendaBean();

        List<StudenteBean> studenti = new ArrayList<StudenteBean>();
        List<AziendaBean> aziende = new ArrayList<AziendaBean>();
        List<TutorBean> tutors = new ArrayList<TutorBean>();
        List<TirocinioBean> richieste = new ArrayList<TirocinioBean>();
        List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();

        studenti = utente.getStudenti("username ASC");
        aziende = utente.getAziende("username ASC");
        tutors = utente.getTutorAccademici("username ASC");

        tirocini.addAll(documento.getTirocini("id ASC"));

        if (!(request.getSession().getAttribute("tipoUtente").equals("studente"))) {
          if (!(request.getSession().getAttribute("tipoUtente").equals("azienda"))) {
            if (!(request.getSession().getAttribute("tipoUtente").equals("tutor"))) {

              for (TirocinioBean t : tirocini) {
                if (t.isConvalidaAzienda() && t.isConvalidaTutor() && t.isConvalidaStudente()) {
                  richieste.add(t);
                }
              } 

              request.getSession().setAttribute("listaStudenti", studenti);
              request.getSession().setAttribute("listaAziende", aziende);
              request.getSession().setAttribute("listaTutor", tutors);
              request.getSession().setAttribute("richiesteTirocinio", richieste);

              if (richieste.equals(null)) {
                response.setContentType("text/html;charset=ISO-8859-1");
                response.getWriter().write("nessuna richiesta");
              }

              RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteTirocinio.jsp");
              view.forward(request, response);
            } else {              
              tutor = (TutorBean) request.getSession().getAttribute("utenteSessione");

              for (TirocinioBean t : tirocini) {
                if (t.isConvalidaAzienda() && t.getTutorAccademico().equals(tutor.getUsername())) {
                  richieste.add(t);
                }
              }

              request.getSession().setAttribute("listaStudenti", studenti);
              request.getSession().setAttribute("listaAziende", aziende);
              request.getSession().setAttribute("listaTutor", tutors);
              request.getSession().setAttribute("richiesteTirocinio", richieste);

              if (richieste.equals(null)) {
                response.setContentType("text/html;charset=ISO-8859-1");
                response.getWriter().write("nessuna richiesta");
              }

              RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteTirocinio.jsp");
              view.forward(request, response);
            }
          } else {

            azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");

            for (TirocinioBean t : tirocini) {
              if (t.getAzienda().equals(azienda.getUsername())) {
                richieste.add(t);
              }
            }

            request.getSession().setAttribute("listaStudenti", studenti);
            request.getSession().setAttribute("listaAziende", aziende);
            request.getSession().setAttribute("listaTutor", tutors);
            request.getSession().setAttribute("richiesteTirocinio", richieste);

            if (richieste.equals(null)) {
              response.setContentType("text/html;charset=ISO-8859-1");
              response.getWriter().write("nessuna richiesta");
            }

            RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteTirocinio.jsp");
            view.forward(request, response);
          }
        } else {

          studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");

          for (TirocinioBean t : tirocini) {
            if (t.getStudente().equals(studente.getUsername())) {
              richieste.add(t);
            }
          }

          request.getSession().setAttribute("listaStudenti", studenti);
          request.getSession().setAttribute("listaAziende", aziende);
          request.getSession().setAttribute("listaTutor", tutors);
          request.getSession().setAttribute("richiesteTirocinio", richieste);

          if (richieste.equals(null)) {
            response.setContentType("text/html;charset=ISO-8859-1");
            response.getWriter().write("nessuna richiesta");
          }

          RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteTirocinio.jsp");
          view.forward(request, response);
        }


      } catch (SQLException e) {
        e.printStackTrace();
      }

    }

    if (azioneDocumento.equals("selezionaAttivita")) {
      try {

        int idTirocinio = Integer.parseInt((String) request.getParameter("idTirocinio"));
        TirocinioBean tirocinio = new TirocinioBean();
        tirocinio.setId(idTirocinio);

        tirocinio = documento.getTirocinio(tirocinio);

        QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
        QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();

        questionarioStudente.setId(tirocinio.getQuestionarioStudente());
        questionarioAzienda.setId(tirocinio.getQuestionarioAzienda());

        questionarioStudente = documento.getQuestionarioStudente(questionarioStudente);
        questionarioAzienda = documento.getQuestionarioAzienda(questionarioAzienda);

        request.getSession().setAttribute("tirocinio", tirocinio);
        request.getSession().setAttribute("questionarioStudente", questionarioStudente);
        request.getSession().setAttribute("questionarioAzienda", questionarioAzienda);
        request.getSession().setAttribute("convalida", "tirocinio");

        RequestDispatcher view = request.getRequestDispatcher("mostraPDFConferma.jsp");
        view.forward(request, response);

      } catch (SQLException e) {
        e.printStackTrace();
      }

    }    

    if (azioneDocumento.equals("accettaAttivita")) {
      try {
        String tipo = (String) request.getParameter("tipo");
        int id = -1;
        if (tipo.equals("tirocinio")) {
          id = Integer.parseInt((String) request.getParameter("idTirocinio"));

          TirocinioBean tirocinio = new TirocinioBean();
          tirocinio.setId(id);

          tirocinio = documento.getTirocinio(tirocinio);

          QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
          QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();

          questionarioStudente.setId(tirocinio.getQuestionarioStudente());
          questionarioAzienda.setId(tirocinio.getQuestionarioAzienda());

          questionarioStudente = documento.getQuestionarioStudente(questionarioStudente);
          questionarioAzienda = documento.getQuestionarioAzienda(questionarioAzienda);

          tirocinio.setConvalidaAttivita(true);
          questionarioStudente.setConvalida(true);
          questionarioAzienda.setConvalida(true);

          documento.aggiornaQuestionarioStudente(questionarioStudente);
          documento.aggiornaQuestionarioAzienda(questionarioAzienda);
          documento.aggiornaTirocinio(tirocinio);

          RequestDispatcher view = request.getRequestDispatcher("attivitaTirocinioConcluse.jsp");
          view.forward(request, response);
        } else {
          id = Integer.parseInt((String) request.getParameter("idConvenzione"));

          ConvenzioneBean convenzione = new ConvenzioneBean();
          convenzione.setId(id);
          convenzione = documento.getConvenzione(convenzione);
          convenzione.setConvalida(true);
          documento.aggiornaConvenzione(convenzione);

          RequestDispatcher view = request.getRequestDispatcher("GestioneDocumento?"
              + "azioneDocumento=elencoRichiesteConvenzioni");
          view.forward(request, response);
        }
      }  catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("richiestaSelezionata")) {
      try {
        TirocinioBean tirocinio = new TirocinioBean();
        List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();

        String url = request.getParameter("richiesta");
        tirocini.addAll(documento.getTirocini("id ASC"));

        for (TirocinioBean t : tirocini) {
          if (t.getUrl().equals(url)) {
            tirocinio = t;
          }
        }

        request.getSession().setAttribute("richiestaSelezionata", tirocinio);

        if (tirocinio.equals(null)) {
          response.setContentType("text/html;charset=ISO-8859-1");
          response.getWriter().write("nessuna richiesta");
        }

        request.getSession().setAttribute("tipoDocumento", "tirocinio");

        RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
        view.forward(request, response);

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("compilaAzienda")) {

      try {
        TirocinioBean tirocinio = new TirocinioBean();

        int id = Integer.parseInt((String) request.getParameter("idTiro"));

        tirocinio.setId(id);
        tirocinio = documento.getTirocinio(tirocinio);

        request.getSession().setAttribute("richiestaTiro", tirocinio);
        RequestDispatcher view = request.getRequestDispatcher("compilazioneCampiAzienda.jsp");
        view.forward(request, response);

      } catch (SQLException e) {

        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("compilato")) {
      try {
        TirocinioBean tirocinio = new TirocinioBean();
        ConvenzioneBean convenzione = new ConvenzioneBean();
        List<ConvenzioneBean> listaConv;
        TutorBean tutor = new TutorBean();
        AziendaBean azienda = new AziendaBean();
        StudenteBean studente = new StudenteBean();

        listaConv = documento.getConvenzioni("id ASC");


        int id = Integer.parseInt((String) request.getParameter("idTiro"));
        tirocinio.setId(id);
        tirocinio = documento.getTirocinio(tirocinio);

        String stud = tirocinio.getStudente();
        String tuto = tirocinio.getTutorAccademico();
        String azie = tirocinio.getAzienda();

        for (ConvenzioneBean c : listaConv) {
          if (c.getAzienda().equals(azie)) {
            convenzione = c;
            break;
          }
        }

        tutor.setUsername(tuto);
        tutor = utente.getTutor(tutor);
        azienda.setUsername(azie);
        azienda = utente.getAzienda(azienda);
        studente.setUsername(stud);
        studente = utente.getStudente(studente);

        if (tirocinio.getUrl().equals("")) {
          request.getSession().setAttribute("richiesta", tirocinio);
          request.getSession().setAttribute("tutor", tutor);
          request.getSession().setAttribute("azienda", azienda);
          request.getSession().setAttribute("studente", studente);
          request.getSession().setAttribute("convenzione", convenzione);
          RequestDispatcher view = request.getRequestDispatcher("documentoRichiestaTirocinio.jsp");
          view.forward(request, response);
        } else {
          request.getSession().setAttribute("richiestaSelezionata", tirocinio);
          request.getSession().setAttribute("tipoDocumento", "tirocinio");
          RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
          view.forward(request, response);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("attivitaConvalidate")) {
      try {
        List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>();

        tirocini = documento.getTirocini("id ASC");

        if (!(tirocini.size() == 0)) {

          StudenteBean studente = new StudenteBean();
          AziendaBean azienda = new AziendaBean();
          TutorBean tutor = new TutorBean();

          List<TirocinioBean> conclusi = new ArrayList<TirocinioBean>();
          List<StudenteBean> studenti = new ArrayList<StudenteBean>();
          List<AziendaBean> aziende = new ArrayList<AziendaBean>();
          List<TutorBean> tutors = new ArrayList<TutorBean>();



          for (TirocinioBean t: tirocini) {
            if (t.isConvalidaAttivita()) {
              conclusi.add(t);
            }
          }


          for (TirocinioBean t: conclusi) {
            studente.setUsername(t.getStudente());
            azienda.setUsername(t.getAzienda());
            tutor.setUsername(t.getTutorAccademico());
            studenti.add(utente.getStudente(studente));
            aziende.add(utente.getAzienda(azienda));
            tutors.add(utente.getTutor(tutor));
          }


          request.getSession().setAttribute("listaTirociniConclusi", conclusi);
          request.getSession().setAttribute("listaStudenti", studenti);
          request.getSession().setAttribute("listaAziende", aziende);
          request.getSession().setAttribute("listaTutors", tutors);

          RequestDispatcher view = request.getRequestDispatcher("attivitaTirocinioConcluse.jsp");
          view.forward(request, response);

        } else {
          response.setContentType("text/html;charset=ISO-8859-1");
          response.getWriter().write("nessuna attività conclusa");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }



    if (azioneDocumento.equals("selezionaConvenzione")) {
      try {
        String tipoUtente = (String) request.getSession().getAttribute("tipoUtente");
        int id = Integer.parseInt((String) request.getParameter("idConv"));
        ConvenzioneBean convenzione = new ConvenzioneBean();
        convenzione.setId(id);
        convenzione = documento.getConvenzione(convenzione);
        if (!convenzione.getUrl().equals("")) {
          if (tipoUtente.equals("azienda")) {
            request.getSession().setAttribute("pdfConv", convenzione);
            request.getSession().setAttribute("tipoDocumento", "convenzione");
            RequestDispatcher view = request.getRequestDispatcher("mostraPDF.jsp");
            view.forward(request, response);
          } else {
            request.getSession().setAttribute("doc", convenzione);
            request.getSession().setAttribute("convalida", "convenzione");

            RequestDispatcher view = request.getRequestDispatcher("mostraPDFConferma.jsp");
            view.forward(request, response);
          }
        } else {
          
          request.getSession().setAttribute("pdfConv", convenzione);
          RequestDispatcher view = request.getRequestDispatcher("documentoConvenzione.jsp");
          view.forward(request, response);

        }


      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    if (azioneDocumento.equals("convenzioniConvalidate")) {
      try {
        List<ConvenzioneBean> convenzioni = documento.getConvenzioni("id ASC");
        List<ConvenzioneBean> richieste = new ArrayList<ConvenzioneBean>();
        List<AziendaBean> aziende = new ArrayList<AziendaBean>();

        for (ConvenzioneBean c : convenzioni) {
          if ((c.isConvalida())) {
            AziendaBean a = new AziendaBean();
            a.setUsername(c.getAzienda());
            aziende.add(utente.getAzienda(a));
            richieste.add(c);
          }
        }

        request.getSession().setAttribute("listaConvenzioni", richieste);
        request.getSession().setAttribute("listaAziende", aziende);

        if (richieste.equals(null)) {
          RequestDispatcher view = request.getRequestDispatcher("nessunaRisorsa.jsp");
          view.forward(request, response);
        }

        RequestDispatcher view = request.getRequestDispatcher("elencoConvenzioniAccettate.jsp");
        view.forward(request, response);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }






    if (azioneDocumento.equals("elencoRichiesteConvenzioni")) {
      try {
        List<ConvenzioneBean> convenzioni = documento.getConvenzioni("id ASC");
        List<ConvenzioneBean> richieste = new ArrayList<ConvenzioneBean>();
        List<AziendaBean> aziende = new ArrayList<AziendaBean>();

        for (ConvenzioneBean c : convenzioni) {
          if (!(c.isConvalida())) {
            AziendaBean a = new AziendaBean();
            a.setUsername(c.getAzienda());
            aziende.add(utente.getAzienda(a));
            richieste.add(c);
          }
        }

        request.getSession().setAttribute("richiesteConvenzioni", richieste);
        request.getSession().setAttribute("listaAziende", aziende);

        if (richieste.equals(null)) {
          response.setContentType("text/html;charset=ISO-8859-1");
          response.getWriter().write("nessuna richiesta");
        }

        RequestDispatcher view = request.getRequestDispatcher("elencoRichiesteConvenzioni.jsp");
        view.forward(request, response);

      } catch (SQLException e) {
        e.printStackTrace();
      }

    }

    if (azioneDocumento.equals("questionarioStudente")) {
      try {

        StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utenteSessione");
        List<TirocinioBean> tirocini = new ArrayList<TirocinioBean>(); 
        List<QuestionarioStudenteBean> questionari = new ArrayList<QuestionarioStudenteBean>();
        QuestionarioStudenteBean questionario = new QuestionarioStudenteBean();
        TutorBean tutor = new TutorBean();
        AziendaBean azienda = new AziendaBean();
        boolean flag = false;

        tirocini = documento.getTirocini("id ASC");
        questionari = documento.getQuestionariStudente("id ASC");
        for (TirocinioBean t : tirocini) {
          if (t.getStudente().equals(studente.getUsername()) && t.isConvalidaRichiesta()) {
            flag = true;
            for (QuestionarioStudenteBean q : questionari) {
              if (t.getStudente().equals(q.getStudente())) {
                questionario = q;
                tutor.setUsername(questionario.getTutorAccademico());
                tutor = utente.getTutor(tutor);
                azienda.setUsername(questionario.getAzienda());
                azienda = utente.getAzienda(azienda);
              }

            }
          } 
        }
        if (flag) {
          if (questionario.getTitolo().equals("")) {

            RequestDispatcher view = request.getRequestDispatcher(
                "questionarioStudenteCompilazione.jsp");
            view.forward(request, response);
          } else {

            request.getSession().setAttribute("questionarioStudente", questionario);
            request.getSession().setAttribute("questSAzienda", azienda);
            request.getSession().setAttribute("questSTutor", tutor);
            RequestDispatcher view = request.getRequestDispatcher("elencoQuestionari.jsp");
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

    if (azioneDocumento.equals("questionarioAzienda")) {
      try {
        AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("utenteSessione");
        List<QuestionarioAziendaBean> questionari = documento.getQuestionariAzienda("id ASC");
        List<QuestionarioAziendaBean> quest = new ArrayList<QuestionarioAziendaBean>();
        List<StudenteBean> studenti = new ArrayList<StudenteBean>();
        List<TutorBean> tutors = new ArrayList<TutorBean>();
        StudenteBean studente = new StudenteBean();
        TutorBean tutor = new TutorBean();


        for (QuestionarioAziendaBean q : questionari) {
          if (q.getAzienda().equals(azienda.getUsername())) {
            quest.add(q);
            studente.setUsername(q.getStudente());
            studenti.add(utente.getStudente(studente));
            tutor.setUsername(q.getTutorAccademico());
            tutors.add(utente.getTutor(tutor));
          }
        }
        if (quest.size() > 0) {
          request.getSession().setAttribute("tiroQuestAzienda", quest);
          request.getSession().setAttribute("studenti", studenti);
          request.getSession().setAttribute("tutors", tutors);

          RequestDispatcher view = request.getRequestDispatcher("elencoQuestionari.jsp");
          view.forward(request, response);
        } else {
          RequestDispatcher view = request.getRequestDispatcher("nessunaRisorsa.jsp");
          view.forward(request, response);
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }


  }
}
