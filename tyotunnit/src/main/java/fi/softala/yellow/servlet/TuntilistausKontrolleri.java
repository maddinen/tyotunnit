
package fi.softala.yellow.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.softala.yellow.bean.Tunti;
import fi.softala.yellow.dao.TuntiDAO;



/**
 * Servlet implementation class Kontrolleri
 * @author Marita Klaavu
 */

@Controller
@RequestMapping (value="/tuntilista")
public class TuntilistausKontrolleri {

	//pitää servletin virkaa, websovelluksessa on aina oltava servlet
	@Inject
	private TuntiDAO hdao;
	
	public TuntiDAO getHdao() {
		return hdao;
	}
	
	public void setHdao(TuntiDAO hdao) {
		this.hdao = hdao;
	}
	
	
	//KAIKKIEN TUNTIEN NÄYTTÄMINEN
	@RequestMapping (value="/lista", method=RequestMethod.GET)
	public String getView(Map<String, Object> model) {
		model.put("tunnit", hdao.haeTunnit());
		return "tuntilista";
	
	}
}

