package fi.softala.bean;

import java.util.Date;

public class Tunti {
	private double maara;
	private String selite;
	private Date paivamaara;
	private Kayttaja henkilo;

	public Tunti() {
		super();
	}

	public Tunti(Date paivamaara, double maara, String selite) {
		super();
		this.paivamaara = paivamaara;
		this.maara = maara;
		this.selite = selite;
	}

	public Tunti(double maara, Date paivamaara, Kayttaja henkilo) {
		super();
		this.maara = maara;
		this.paivamaara = paivamaara;
		this.henkilo = henkilo;
	}

	public double getMaara() {
		return maara;
	}

	public void setMaara(double maara) {
		this.maara = maara;
	}

	public Date getPaivamaara() {
		return paivamaara;
	}

	public void setPaivamaara(Date paivamaara) {
		this.paivamaara = paivamaara;
	}

	public Kayttaja getHenkilo() {
		return henkilo;
	}

	public void setHenkilo(Kayttaja henkilo) {
		this.henkilo = henkilo;
	}

	@Override
	public String toString() {
		return "Tunti [maara=" + maara + ", paivamaara=" + paivamaara + ", henkilo=" + henkilo + "]";
	}

}