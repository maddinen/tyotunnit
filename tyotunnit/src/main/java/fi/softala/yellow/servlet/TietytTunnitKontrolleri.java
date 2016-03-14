

package fi.softala.yellow.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
public class TietytTunnitKontrolleri {
	//pit�� servletin virkaa, websovelluksessa on aina oltava servlet
	@Inject
	private TuntiDAO hdao;
	
	public TuntiDAO getHdao() {
		return hdao;
	}
	
	public void setHdao(TuntiDAO hdao) {
		this.hdao = hdao;
	}
	
	//FORMIN TEKEMINEN
		@RequestMapping(value="kayttajantunnit", method=RequestMethod.GET)
		public String getCreateForm(Model model) {
			return "personHourlist";
		}
	
	//HENKIL�N TIETOJEN N�YTT�MINEN
		@RequestMapping(value="{kayttaja_id}", method=RequestMethod.POST)
		public String getView(@PathVariable Integer kayttaja_id, Model model) {
			List<Tunti> kayttajanTunnit = hdao.haeKayttajanTunnit(kayttaja_id);
			model.addAttribute("kayttajanTunnit", kayttajanTunnit);
			return "personHourlist";
		}
}

