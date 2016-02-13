package fi.softala.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Tunti;


public class TuntiRowMapper implements RowMapper<Tunti>  {
	public Tunti mapRow(ResultSet rs, int rowNo) throws SQLException {
		Tunti h = new Tunti();
		h.setPaivamaara(rs.getDate("pvm"));
		h.setMaara(rs.getDouble("tuntien_maara"));
		h.setSelite(rs.getString("kommentti"));
		return h;
	}
}
