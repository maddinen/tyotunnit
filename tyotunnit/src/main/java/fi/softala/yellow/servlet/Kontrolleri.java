package fi.softala.yellow.servlet;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.softala.yellow.bean.Tunti;
import fi.softala.yellow.dao.TuntiDAO;



/**
 * Servlet implementation class Kontrolleri
 * @author Marita Klaavu
 */

@Controller
public class Kontrolleri {
	@Inject
	TuntiDAO dao;

	@RequestMapping("tunnit.json")
	public @ResponseBody List<Tunti> haeTunnitJSON() {
		List<Tunti> tunnit = dao.haeTunnit();
		return tunnit;
	}
	
	@RequestMapping("tunnit")
	public String naytaTuntilista() {
		return "tuntilista";
	}
}