package fi.softala.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Tunti;


public class TuntiRowMapper implements RowMapper<Tunti>  {
	public Tunti mapRow(ResultSet rs, int rowNo) throws SQLException {
		Tunti h = new Tunti();
		h.setKayttaja_id(rs.getInt("kayttaja_id"));
		h.setPaivamaara(rs.getDate("pvm"));
		h.setTuntien_maara(rs.getDouble("tuntien_maara"));
		h.setSelite(rs.getString("selite"));
		return h;
	}
}
