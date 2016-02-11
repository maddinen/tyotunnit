package fi.softala.bean;

import java.util.Date;

public class Tunti {
	private double maara;
	private String selite;
	private Date paivamaara;
	private Kayttaja kayttaja;

	public Tunti() {
		super();
	}

	public Tunti(Date paivamaara, double maara, String selite) {
		super();
		this.paivamaara = paivamaara;
		this.maara = maara;
		this.selite = selite;
	}

	public Tunti(double maara, Date paivamaara, Kayttaja kayttaja) {
		super();
		this.maara = maara;
		this.paivamaara = paivamaara;
		this.kayttaja = kayttaja;
	}

	public double getMaara() {
		return maara;
	}

	public void setMaara(double maara) {
		this.maara = maara;
	}
	
	public String getSelite() {
		return selite;
	}

	public void setSelite(String selite) {
		this.selite = selite;
	}

	public Date getPaivamaara() {
		return paivamaara;
	}

	public void setPaivamaara(Date paivamaara) {
		this.paivamaara = paivamaara;
	}

	public Kayttaja getKayttaja() {
		return kayttaja;
	}

	public void setkayttaja(Kayttaja kayttaja) {
		this.kayttaja = kayttaja;
	}

	@Override
	public String toString() {
		return "Tunti [maara=" + maara + ", paivamaara=" + paivamaara + ", kayttaja=" + kayttaja + "]";
	}

}