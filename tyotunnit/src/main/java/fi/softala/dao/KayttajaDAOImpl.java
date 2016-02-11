package fi.softala.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import fi.softala.bean.Kayttaja;

public class KayttajaDAOImpl<JdbcTemplate> implements KayttajaDAO {


	private Connection yhteys;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * Luo uuden käyttäjän tietokantaan
	 */
	public void rekisteroi(Kayttaja kayttaja) {
		avaaYhteys();
		try {

			// tarkistetaan, että usernamella ei jo löydy käyttäjää
			PreparedStatement kayttajatunnusHaku = yhteys
					.prepareStatement("SELECT kayttajatunnus FROM Kayttajat WHERE kayttajatunnus = ?");
			kayttajatunnusHaku.setString(1, kayttaja.getKayttajatunnus());
			ResultSet rs = kayttajatunnusHaku.executeQuery();
			if (rs.next())
				//throw new UsernameVarattuPoikkeus();

			// suoritetaan lisäys
			PreparedStatement ps = yhteys.prepareStatement(
					"INSERT INTO Kayttajat(etunimi, sukunimi, email, kayttajatunnus, salasana, suola) values(?,?,?,?,?,?)");
			ps.setString(1, kayttaja.getEtunimi());
			ps.setString(2, kayttaja.getSukunimi());
			ps.setString(3, kayttaja.getEmail());
			ps.setString(4, kayttaja.getKayttajatunnus());
			ps.setString(5, kayttaja.getSalasana());
			ps.setString(6, kayttaja.getSuola());

			ps.executeUpdate();

		} catch (SQLException e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys();
		}

	}

	private void avaaYhteys() {
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			String username = "a1500882";
			String password = "suXAsP63h";
			String url = "jdbc:mariadb://localhost:15001/a1500882";
			try {
				Connection yhteys = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Etsii käyttäjän kayttajatunnuksen perusteella.
	 */
	public Kayttaja etsiKayttaja(String kayttajatunnus) {
		String sql = "SELECT etunimi, sukunimi, email, kayttajatunnus FROM Kayttajat WHERE kayttajatunnus = ?";
		Object[] parametrit = new Object[] { kayttajatunnus };
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();

		Kayttaja k;

		try {
			k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (Exception e) {

		}
		return k;
	}

	/*
	 * Listaa kaikki käyttäjät sähköposteineen
	 */
	public List<Kayttaja> haeKayttajat() {

		String sql = "SELECT kayttajatunnus, etunimi, sukunimi, email FROM Kayttajat";
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		List<Kayttaja> kayttajat = jdbcTemplate.query(sql, mapper);

		return kayttajat;

	}
	
	public void suljeYhteys() {
		try {
			yhteys.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
