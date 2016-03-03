package fi.softala.yellow.dao;

import java.util.List;

import fi.softala.yellow.bean.Tunti;

/**
 * M‰‰rittelee Tuntien k‰sittelyn.
 * @author Marita Klaavu
 *
 */
public interface TuntiDAO {
	public abstract List<Tunti> haeTunnit();
	public abstract List<Tunti> haeKayttajanTunnit(int kayttaja_id);
	public abstract double laskeTunnit(int kayttaja_id);
	public abstract void lisaaTunti(Tunti h);

}