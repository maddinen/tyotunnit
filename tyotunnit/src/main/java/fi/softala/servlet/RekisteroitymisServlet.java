package fi.softala.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.softala.bean.InvalidKayttajaPoikkeus;
import fi.softala.bean.Kayttaja;
import fi.softala.dao.DAOPoikkeus;
import fi.softala.dao.KayttajaDAO;
import fi.softala.dao.KayttajaDAOImpl;

/**
 * Servlet implementation class RekisteroitymisServlet
 */
@WebServlet("/rekisteroidy")
public class RekisteroitymisServlet extends HttpServlet {

	// En ole varma onko se tossa kansiossa koska en enää löydä sitä
	public static final String FRONT_PAGE = "WEB-INF/register.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RekisteroitymisServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(FRONT_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String email = request.getParameter("email");
		String kayttajatunnus = request.getParameter("kayttajatunnus");
		String salasana = request.getParameter("password");
		String salasana2 = request.getParameter("password2");

		try {
			// luodaan käyttäjä suolalla ja hashilla
			Kayttaja kayttaja = new Kayttaja(kayttajatunnus, salasana, salasana2);
			// lisätään tietokantaan
			KayttajaDAOImpl dao = new KayttajaDAOImpl();
			dao.rekisteroi(kayttaja);

			// takaisin onnistumisviestillä
			response.sendRedirect("rekisteroidy?onnistui=y");

		} catch (InvalidKayttajaPoikkeus e) {
			takaisinVirheviestilla(e.getMessage(), kayttajatunnus, request, response);
		} /*
			 * catch(UsernameVarattuPoikkeus e) { String virheviesti =
			 * "Käyttäjätunnus " +kayttajatunnus +
			 * " on jo varattu, valitse toinen käyttäjätunnus!";
			 * takaisinVirheviestilla(virheviesti, kayttajatunnus, request,
			 * response); }
			 */catch (NoSuchAlgorithmException e) {
			throw new ServletException("Salausalgoritmia ei löydy.", e);
		}
	}

	private void takaisinVirheviestilla(String viesti, String kayttajatunnus, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", viesti);
		request.setAttribute("prev_reg_username", kayttajatunnus);
		request.getRequestDispatcher(FRONT_PAGE).forward(request, response);

	}

}
