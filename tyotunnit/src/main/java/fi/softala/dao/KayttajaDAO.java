package fi.softala.dao;

import fi.softala.bean.Kayttaja;
import java.util.List;

public interface KayttajaDAO {

	public abstract void rekisteroi(Kayttaja kayttaja);

	public abstract Kayttaja etsiKayttaja(String kayttajatunnus);

	public abstract List<Kayttaja> haeKayttajat();

}
