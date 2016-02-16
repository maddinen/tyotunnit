package fi.softala.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.softala.bean.Tunti;
import fi.softala.dao.TuntiDAO;



/**
 * Servlet implementation class Kontrolleri
 */

public class Kontrolleri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Kontrolleri.doGet()");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		TuntiDAO dao = (TuntiDAO) context.getBean("daoLuokka");
		ArrayList<Tunti> tunnit = (ArrayList<Tunti>)dao.haeTunnit();
		// tallennetaan request olion alle tuntilista
		request.setAttribute("tunnit", tunnit);
		
		RequestDispatcher disp = request.getRequestDispatcher("tuntilista.jsp");
		disp.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Kontrolleri.doPost()");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		TuntiDAO dao = (TuntiDAO) context.getBean("daoLuokka");
		
		//KAYTTAJA_ID
		String kayttaja_idStr = request.getParameter("kayttaja_id");
		int kayttaja_id = Integer.parseInt(kayttaja_idStr);
		//PAIVAMAARA
		String pvmStr = request.getParameter("pvm");
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date pvm = new Date();
		try {
			pvm = format.parse(pvmStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//TUNTIEN MAARA
		String maaraStr = request.getParameter("tuntien_maara");
		double tuntien_maara = Double.parseDouble(maaraStr);
		//SELITE
		String selite = request.getParameter("selite");
		Tunti h = new Tunti(kayttaja_id, pvm, tuntien_maara, selite);
		dao.lisaaTunti(h);

		String jsp = "/tuntilista.jsp";
        RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
        dispather.forward(request, response);
		//doGet(request, response);
	}

}
