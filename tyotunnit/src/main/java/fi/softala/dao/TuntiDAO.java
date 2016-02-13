package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Tunti;

/**
 * M‰‰rittelee Tuntien k‰sittelyn.
 * @author Marita Klaavu
 *
 */
public interface TuntiDAO {
	public abstract List<Tunti> haeTunnit();
	public abstract void lisaaTunti(Tunti h);

}