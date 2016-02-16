package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Tunti;

/**
 * Määrittelee Tuntien käsittelyn.
 * @author Marita Klaavu
 *
 */
public interface TuntiDAO {
	public abstract List<Tunti> haeTunnit();
	public abstract List<Tunti> haeKayttajanTunnit(int kayttaja_id);
	public abstract void lisaaTunti(Tunti h);

}