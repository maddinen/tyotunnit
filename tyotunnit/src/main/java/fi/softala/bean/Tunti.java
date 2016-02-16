package fi.softala.bean;

import java.util.Date;

public class Tunti {
	private int kayttaja_id;
	private Date paivamaara;
	private double tuntien_maara;
	private String selite;

	public Tunti() {
		super();
	}

	public Tunti(int kayttaja_id, Date paivamaara, double tuntien_maara, String selite) {
		super();
		this.kayttaja_id = kayttaja_id;
		this.paivamaara = paivamaara;
		this.tuntien_maara = tuntien_maara;
		this.selite = selite;
	}

	public int getKayttaja_id() {
		return kayttaja_id;
	}

	public void setKayttaja_id(int kayttaja_id) {
		this.kayttaja_id = kayttaja_id;
	}

	public Date getPaivamaara() {
		return paivamaara;
	}

	public void setPaivamaara(Date paivamaara) {
		this.paivamaara = paivamaara;
	}

	public double getTuntien_maara() {
		return tuntien_maara;
	}

	public void setTuntien_maara(double tuntien_maara) {
		this.tuntien_maara = tuntien_maara;
	}

	public String getSelite() {
		return selite;
	}

	public void setSelite(String selite) {
		this.selite = selite;
	}

	@Override
	public String toString() {
		return "kayttaja_id:" + kayttaja_id + "\n paivamaara:" + paivamaara + "\n tuntien_maara:" + tuntien_maara
				+ "\n selite:" + selite + "\n\n";
	}

}