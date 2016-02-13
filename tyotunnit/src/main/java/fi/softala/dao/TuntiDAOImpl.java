package fi.softala.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import fi.softala.bean.Tunti;

public class TuntiDAOImpl implements TuntiDAO {
	private Connection yhteys;
	private JdbcTemplate jdbcTemplate;

	public TuntiDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Tunti> haeTunnit() {
		String sql = "select pvm, tuntien_maara, kommentti from Tunnit;";
		RowMapper<Tunti> mapper = new TuntiRowMapper();
		List<Tunti> tunnit = jdbcTemplate.query(sql, mapper);

		System.out.println("HAETTIIN TIETOKANNASTA TUNNIT: " + tunnit.toString());
		return tunnit;
	}

	public void lisaaTunti(Tunti h) {
		String sql = "insert into Tunnit(pvm, tuntien_maara, kommentti) values(?,?,?)";
		Object[] parametrit = new Object[] { h.getPaivamaara(), h.getMaara(), h.getSelite() };
		jdbcTemplate.update(sql, parametrit);

		System.out.println("LISÄTTIIN TUNTITIETO TIETOKANTAAN: " + h);

	}

}
