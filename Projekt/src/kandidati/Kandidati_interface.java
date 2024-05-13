package kandidati;

/**
 * Rozhranie pre kandidatov
 */

public interface Kandidati_interface {
	/**
	 * Funkcia getMeno 
	 * @return vracia Meno kandidata
	 */
	String getMeno();
	
	/**
	 * Funkcia getInfo_o_kandidatovi 
	 * @return vracia stranu a vek kandidata
	 */
	String getInfo_o_kandidatovi();
	
	/**
	 * Funkcia getCisloKandidata
	 * @return vracia cislo kandidata
	 */
	int getCisloKandidata();
	
	/**
	 * Funkcia inkrementujHlasy je pouzita, ked je kandidat voleny a inkrementuje celkovy pocet hlasov, pocet hlasov v strane a v kraji
	 * @param kraj Do funkcie vchadza ako argument kraj, z ktoreho pochadza volic.
	 * @param strana Do funkcie vchadza ako druhy argument strana, ktorej je volic sucastou
	 */
	void inkrementujHlasy(String kraj,String strana);
	
	/**
	 * Funkcia getPocetHlasov
	 * @return vracia celkovy pocet hlasov daneho kandidata
	 */
	int getPocetHlasov();
	
	/**
	 * Funkcia getPocetHlasov_v_kraji
	 * @param kraj Ako parameter prichadza kraj
	 * @return vracia pocet hlasov v danom kraji
	 */
	int getPocetHlasov_v_kraji(String kraj);
	
	/**
	 * Funkcia getPocetHlasov_v_strane
	 * @param strana  Ako parameter prichadza strana
	 * @return vracia pocet hlasov v danej strane
	 */
	int getPocetHlasov_v_strane(String strana);
	
	/**
	 * Funkcia anulujHlasy_Z_PrvehoKola je vyuzita pri zahajeni druheho kola volieb a anuluje hlasy danych kandidatov z prveho kola
	 */
	void anulujHlasy_Z_PrvehoKola();

	/**
	 * Funkcia zmenCisloKandidata sa vyuziva po ukonceni prveho kola volieb, kedy sa cisla kandidatov, ktori postupili, menia na 1 a 2
	 * @param i Ako argument prichadza nove cislo kandidata
	 */

	void zmenCisloKandidata(int i);
	
	/**
	 * Implicitne definovana metoda vratHlasy
	 * @return vracia retazec, ktory vyzera: Meno: 15 hlasov\n (napriklad)
	 */
	
	default String vratHlasy() {
		String vystup=(getMeno()+": "+getPocetHlasov()+" hlasov\n");
        return vystup;
    }
	
}
