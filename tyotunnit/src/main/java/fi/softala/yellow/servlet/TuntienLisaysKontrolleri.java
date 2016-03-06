package fi.softala.yellow.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.yellow.bean.Tunti;
import fi.softala.yellow.dao.TuntiDAO;

/**
 * Servlet implementation class Kontrolleri
 * 
 * @author Marita Klaavu
 */

@Controller
@RequestMapping(value = "/tunti")
public class TuntienLisaysKontrolleri {
	// pitää servletin virkaa, websovelluksessa on aina oltava servlet
	@Inject
	private TuntiDAO hdao;

	public TuntiDAO getHdao() {
		return hdao;
	}

	public void setHdao(TuntiDAO hdao) {
		this.hdao = hdao;
	}

	// TYHJÄ FORM
	@RequestMapping(value = "uusi", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		Tunti tyhjaTunti = new Tunti();
		// tyhjaTunti.setKayttaja_id(kayttaja_id);
		// tyhjaTunti.setPaivamaara(paivamaara);
		// tyhjaTunti.setTuntien_maara(tuntien_maara);
		// tyhjaTunti.setSelite(selite);

		model.addAttribute("tunti", tyhjaTunti);
		return "form";
	}

	// FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "uusi", method = RequestMethod.POST)
	public String create(@ModelAttribute(value = "tunti") @Valid Tunti tunti, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		} else {
			hdao.lisaaTunti(tunti);
			return "redirect:/tuntilista/lista";
		}
	}

}

/*
 * @Controller public class Kontrolleri {
 * 
 * @Inject TuntiDAO dao;
 * 
 * @RequestMapping("tunnit.json") public @ResponseBody List<Tunti>
 * haeTunnitJSON() { List<Tunti> tunnit = dao.haeTunnit(); return tunnit; }
 * 
 * @RequestMapping("tunnit") public String naytaTuntilista() { return
 * "tuntilista"; }
 * 
 * @RequestMapping(value="/", produces="application/json;charset=UTF-8")
 * public @ResponseBody String lisaaTunti(@RequestParam("henkilonTunnit") String
 * json, HttpServletResponse response) throws IOException{ dao.lisaaTunti(json);
 * }
 * 
 * }
 */