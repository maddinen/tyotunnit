package fi.softala.yellow.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.yellow.dao.TuntiDAO;
import fi.softala.yellow.dao.TuntiRowMapper;
import fi.softala.yellow.bean.Tunti;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

/** @author Marita Klaavu */

@Repository
public class TuntiDAOImpl implements TuntiDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Tallettaa parametrina annetun tuntitiedon tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	public void lisaaTunti(Tunti h) {
		final String sql = "insert into Tunnit(kayttaja_id, pvm, tuntien_maara, selite) values(?,?,?,?)";

		// tehdään muuttujat että anonyymissä sisäluokassa GC onnistuu
		final int kayttaja_id = h.getKayttaja_id();
		final Date pvm = h.getPaivamaara();
		final double tuntien_maara = h.getTuntien_maara();
		final String selite = h.getSelite();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys PreparedStatementCreatorilla ja keyholderilla
		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] { "id" });
				ps.setInt(1, kayttaja_id);
				ps.setDate(2, pvm);
				ps.setDouble(3, tuntien_maara);
				ps.setString(4, selite);
				return ps;
			}

		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		h.setId(idHolder.getKey().intValue());

	}

	
	public List<Tunti> haeTunnit() {
		String sql = "select kayttaja_id, pvm, tuntien_maara, selite from Tunnit;";
		RowMapper<Tunti> mapper = new TuntiRowMapper();
		List<Tunti> tunnit = jdbcTemplate.query(sql, mapper);
		//System.out.println("HAETTIIN TIETOKANNASTA TUNNIT: \n" + tunnit.toString());
		return tunnit;
	}

	
	public List<Tunti> haeKayttajanTunnit(int kayttaja_id) {
		final String sql = "select kayttaja_id, pvm, tuntien_maara, selite from Tunnit where kayttaja_id = ?";
		Object[] parametrit = new Object[] { kayttaja_id };
		RowMapper<Tunti> mapper = new TuntiRowMapper();

		List<Tunti> tunnit = null;
		try {
			tunnit = jdbcTemplate.query(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			//throw new HenkiloaEiLoydyPoikkeus(e);
		}
		return tunnit;
	}
	
	public double laskeTunnit(int kayttaja_id){
		String sql = "";
		// insert code here
		double summa = 0;
		return summa;
	}
	
	public void poistaTunti(Tunti h) {
		String sql = "delete from Tunnit where tunti_id = ?";
		// insert code here
		System.out.println("TIETO POISTETTU");
	}
	
	
}
