package fi.softala.yellow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.yellow.bean.Kayttaja;

public class KayttajaRowMapper implements RowMapper<Kayttaja> {

	public Kayttaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kayttaja k = new Kayttaja();
		k.setEtunimi(rs.getString("etunimi"));
		k.setSukunimi(rs.getString("sukunimi"));
		k.setKayttajatunnus(rs.getString("kayttajatunnus"));
		k.setEmail(rs.getString("email"));

		return k;
	}
}
