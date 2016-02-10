package fi.softala.dao;

public class KayttajaDAOImpl implements KayttajaDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	/*
	 * Luo uuden k�ytt�j�n tietokantaan
	 */
	public void rekisteroi(Kayttaja kayttaja){
		
		
		
	}
	/*
	 * Etsii k�ytt�j�n kayttajatunnuksen perusteella.
	 */
	public Kayttaja etsiKayttaja(String kayttajatunnus){
		String sql = "SELECT etunimi, sukunimi, email, kayttajatunnus FROM Kayttajat WHERE kayttajatunnus = ?";
		Object[] parametrit = new Object[] { kayttajatunnus };
		RowMapper<Kayttaja> mapper = new KayttajaRowMapper();
		
		Kayttaja k;
		
		try {
			k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (Exception e){
			
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
