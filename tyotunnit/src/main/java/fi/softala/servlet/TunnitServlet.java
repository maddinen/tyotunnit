package fi.softala.servlet;

import java.util.List;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import fi.softala.bean.Tunti;
import fi.softala.dao.TuntiDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class TunnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TunnitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
		disp.forward(request, response);

		List<Tunti> tunnit = null;

		try {
			TuntiDAO hDAO = new TuntiDAO();
			tunnit = hDAO.haeTunnit();
		} catch (Exception e) {

		}
		request.setAttribute("tunnit", tunnit);
		request.getRequestDispatcher("tuntilista.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pvmStr = request.getParameter("pvm");
		SimpleDateFormat pvmFormat = new SimpleDateFormat("dd.MM");
		Date pvm = new Date();
		try {
			pvm = pvmFormat.parse(pvmStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String tuntien_maaraStr = request.getParameter("tuntien_maara");
		double tuntien_maara = Double.parseDouble(tuntien_maaraStr);
		String kommentti = request.getParameter("kommentti");
		 
		Tunti h = new Tunti(pvm, tuntien_maara, kommentti);
		try {
			TuntiDAO hDAO = new TuntiDAO();
			hDAO.lisaaTunti(h);
		} catch (Exception e){
			
		}
		response.sendRedirect("index.jsp");
	}

}