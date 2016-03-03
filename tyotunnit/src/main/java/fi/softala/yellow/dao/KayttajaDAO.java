package fi.softala.yellow.dao;

import java.util.List;

import fi.softala.yellow.bean.Kayttaja;

public interface KayttajaDAO {

	public abstract void rekisteroi(Kayttaja kayttaja) throws DAOPoikkeus;

	public abstract Kayttaja etsiKayttaja(String kayttajatunnus);

	public abstract List<Kayttaja> haeKayttajat();

}
