package fi.softala.bean;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import fi.softala.security.Salaaja;

/**
 * 
 * @author Katri Vilonen
 *
 */
public class Kayttaja {

	private String kayttajatunnus, email, etunimi, sukunimi, salasana, suola;
	private static final String SALAUS_ALGORITMI = Salaaja.SHA512;
	private static final int SALAUS_KIERROKSIA = 100;

	public Kayttaja(String kayttajatunnus, String salasana, String salasana2)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKayttajaPoikkeus {
		super();

		validoi(kayttajatunnus, salasana, salasana2);

		this.kayttajatunnus = kayttajatunnus;

		// generoidaan suola
		String suola = Salaaja.generoiSuola();
		setSuola(suola);
		// kryptataan salasana
		String kryptattuSalasana = Salaaja.salaa(salasana, getSuola(), SALAUS_ALGORITMI, SALAUS_KIERROKSIA);
		setSalasana(kryptattuSalasana);
	}

	public Kayttaja(String kayttajatunnus, String email, String etunimi, String sukunimi, String salasana,
			String suola) {
		super();
		this.kayttajatunnus = kayttajatunnus;
		this.email = email;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.salasana = salasana;
		this.suola = suola;
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

	public String getSuola() {
		return suola;
	}

	public void setSuola(String suola) {
		this.suola = suola;
	}

	@Override
	public String toString() {
		return "Kayttaja [etunimi=" + etunimi + ", sukunimi=" + sukunimi + "]";
	}

	private void validoi(String kayttajatunnus, String salasana, String salasana2) throws InvalidKayttajaPoikkeus {

		if (kayttajatunnus == null || kayttajatunnus.trim().length() < 3)
			throw new InvalidKayttajaPoikkeus("Käyttäjätunnuksen täytyy olla vähintään 3 merkkiä pitkä");
		else if (salasana == null || salasana.trim().length() < 6)
			throw new InvalidKayttajaPoikkeus("Salasanan täytyy olla vähintään 6 merkkiä pitkä");
		else if (!salasana.equals(salasana2))
			throw new InvalidKayttajaPoikkeus("Salasanat eivät täsmää");
	}

	// kryptaa annetun salasanan tämän olion suolalla ja vertaa sitä tämän olion
	// salasanahashiin
	public boolean vertaaSalasanaa(String salasana) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		String kryptattuSalasana = Salaaja.salaa(salasana, getSuola(), SALAUS_ALGORITMI, SALAUS_KIERROKSIA);

		return kryptattuSalasana.equals(this.salasana);
	}

}