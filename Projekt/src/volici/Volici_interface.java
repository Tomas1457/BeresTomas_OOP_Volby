package volici;

import kandidati.Kandidat;

/**
 * Rozhranie pre volicov (poslanec, zupan, prezident a pouzivatel)
 */
public interface Volici_interface {
	/**
	 * Metoda volim vola metodu inkrementujHlasy definovanu v triede Kandidat.
	 * @param kandidat Argumentom je nahodne vybraty kandidat v triede Volby.
	 */
	void volim(Kandidat kandidat);
	
}
