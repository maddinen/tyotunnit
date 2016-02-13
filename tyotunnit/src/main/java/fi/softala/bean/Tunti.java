package fi.softala.bean;

import java.util.Date;

public class Tunti {
	private Kayttaja kayttaja;
	private Date paivamaara;
	private double maara;
	private String selite;
	
	

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

	public Kayttaja getKayttaja() {
		return kayttaja;
	}

	public void setKayttaja(Kayttaja kayttaja) {
		this.kayttaja = kayttaja;
	}

	public Date getPaivamaara() {
		return paivamaara;
	}

	public void setPaivamaara(Date paivamaara) {
		this.paivamaara = paivamaara;
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

	@Override
	public String toString() {
		return "Tunti [kayttaja=" + kayttaja + ", paivamaara=" + paivamaara + ", maara=" + maara + ", selite=" + selite
				+ "]";
	}

	
}