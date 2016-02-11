package fi.softala.dao;

import fi.softala.bean.Kayttaja;

public class KayttajaDAOImpl implements KayttajaDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * Luo uuden k�ytt�j�n tietokantaan
	 */
	public void rekisteroi(Kayttaja kayttaja) {

		Connection yhteys = avaaYhteys();

		try {

			// tarkistetaan, ett� usernamella ei jo l�ydy k�ytt�j��
			PreparedStatement kayttajatunnusHaku = yhteys
					.prepareStatement("SELECT id FROM Kayttajat WHERE kayttajatunnus = ?");
			kayttajatunnusHaku.setString(1, kayttaja.getKayttajatunnus());
			ResultSet rs = kayttajatunnusHaku.executeQuery();
			if (rs.next())
				throw new UsernameVarattuPoikkeus();

			// suoritetaan lis�ys
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
			// JOTAIN VIRHETT� TAPAHTUI
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys(yhteys);
		}

	}

	/*
	 * Etsii k�ytt�j�n kayttajatunnuksen perusteella.
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
	 * Listaa kaikki k�ytt�j�t s�hk�posteineen
	 */
	public List<Kayttaja> haeKayttajat() {

		String sql = "SELECT kayttajatunnus, etunimi, sukunimi, email FROM Kayttajat";
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		List<Kayttaja> kayttajat = jdbcTemplate.query(sql, mapper);

		return kayttajat;

	}
}
