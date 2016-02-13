package fi.softala.servlet;

import java.io.IOException;
import java.util.Date;
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
		TuntiDAO dao = (TuntiDAO) context.getBean("tuntidao");
		ArrayList<Tunti> tunnit = (ArrayList<Tunti>) dao.haeTunnit();
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
		TuntiDAO dao = (TuntiDAO) context.getBean("tuntidao");
		String pvmStr = request.getParameter("pvm");
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date pvm = format.parse(pvmStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String maaraStr = request.getParameter("tuntien_maara");
		double tuntien_maara = Double.parseDouble(maaraStr);
		String selite = request.getParameter("kommentti");
		Tunti h = new Tunti();

		doGet(request, response);
	}

}
