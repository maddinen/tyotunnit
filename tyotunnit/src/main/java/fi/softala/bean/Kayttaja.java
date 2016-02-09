package fi.softala.bean;

/**
 * 
 * @author Katri Vilonen
 *
 */
public class Kayttaja {

	private String kayttajatunnus, email, etunimi, sukunimi, salasana;

	public Kayttaja(){
		super();
		kayttajatunnus = null;
		email = null;
		etunimi = null;
		sukunimi = null;
		salasana = null;
	}
	
	public Kayttaja(String kayttajatunnus, String email, String etunimi, String sukunimi, String salasana) {
		super();
		this.kayttajatunnus = kayttajatunnus;
		this.email = email;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.salasana = salasana;
	}

	public String getKayttajatunnus() {
		return kayttajatunnus;
	}

	public void setKayttajatunnus(String kayttajatunnus) {
		this.kayttajatunnus = kayttajatunnus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	@Override
	public String toString() {
		return "Kayttaja [etunimi=" + etunimi + ", sukunimi=" + sukunimi + "]";
	}	
	
}