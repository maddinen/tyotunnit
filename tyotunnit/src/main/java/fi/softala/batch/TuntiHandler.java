package fi.softala.batch;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.softala.bean.Tunti;
import fi.softala.dao.TuntiDAO;



public class TuntiHandler {

	public static void main(String[] args) {
		System.out.println("TuntiHandler.main()");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		TuntiDAO dao = (TuntiDAO)context.getBean("daoLuokka");
		
		System.out.println("-------------------");
		System.out.println("LISTATAAN KAIKKI");
		System.out.println("-------------------");
		
		List<Tunti> tunnit = dao.haeTunnit();
		for (Tunti s : tunnit) {}

	}

}
