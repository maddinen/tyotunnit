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
@RequestMapping (value="/")
public class Kontrolleri {
	//pitää servletin virkaa, websovelluksessa on aina oltava servlet
	@Inject
	private TuntiDAO hdao;
	
	public TuntiDAO getHdao() {
		return hdao;
	}
	
	public void setHdao(TuntiDAO hdao) {
		this.hdao = hdao;
	}
	
	//TYHJÄ FORM
	@RequestMapping (value="/uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Tunti tyhjaTunti = new Tunti();
		//tyhjaTunti.setKayttaja_id(kayttaja_id);
		//tyhjaTunti.setPaivamaara(paivamaara);
		//tyhjaTunti.setTuntien_maara(tuntien_maara);
		//tyhjaTunti.setSelite(selite);
		
		model.addAttribute("tunti", tyhjaTunti);
		return "/";
	}
	
	//FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping (value="/uusi", method=RequestMethod.POST)
	public String create(@ModelAttribute(value="tunti") Tunti tunti) {
		hdao.lisaaTunti(tunti);
		return "redirect:/tuntilista";
	}
	
	//KAIKKIEN TUNTIEN NÄYTTÄMINEN
	@RequestMapping (value="tuntilista", method=RequestMethod.GET)
	public String getView(Map<String, Object> model) {
		model.put("tunnit", hdao.haeTunnit());
		return "tuntilista";
	
	}
}


/*
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
	
	@RequestMapping(value="/", produces="application/json;charset=UTF-8")
	public @ResponseBody String lisaaTunti(@RequestParam("henkilonTunnit") String json, HttpServletResponse response) throws IOException{
		dao.lisaaTunti(json);
	}
	
}*/