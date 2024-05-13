package kandidati;

/**
 * Trieda Kandidat_Pouzivatel je rozsierenim triedy Kandidat
 */

public class Kandidat_Pouzivatel extends Kandidat {
	
	/**
	 * Agregacia, tato trieda obsahuje dalsiu triedu Kontrola_veku 
	 */
	private Kontrola_veku kontrola_veku=new Kontrola_veku();
	
	private boolean moze_kandidovat;
	
	/**
	 * Konstruktor pre vytvorenie novej instancie Kandidat_pouzivatel s danymi parametrami
	 * @param meno Meno, ktore zadal uzivatel
	 * @param vek Vek, ktory zadal uzivatel
	 * @param strana Strana, ktorej je uzivatel prislusnikom
	 * @param cisloKandidata Cislo kandidata
	 */
			
    public Kandidat_Pouzivatel(String meno, String vek, String strana, int cisloKandidata) {
        super(meno, Integer.parseInt(vek), strana, cisloKandidata);
        moze_kandidovat=kontrola_veku.kontrolaVeku_kandidat(this.getvek());
    }
    
    /**
     * Funkcia getvek
     * @return vracia vek kandidata
     */
    public int getvek() {
    	return vek;
    }
    
    /**
     * Metoda get_moze_kandidovat
     * @return vracia true/false v zavislosti od toho, ci pouzivatel moze byt zaradeny do pola kandidatov
     */
    public boolean get_moze_kandidovat() {
    	return moze_kandidovat;
    }
}
