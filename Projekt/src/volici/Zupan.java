package volici;
import kandidati.Kandidat;

/**
 * Trieda Zupan, ktora zahrna atributy a metody triedy Poslanec
 */

public class Zupan extends Poslanec {
    private int udelenyHlas;
    private SilaHlasu silaHlasu;
    
    protected long sila_hlasu;
    
    /**
    * Konstruktor pre vytvorenie novej instancie Zupan s danymi argumentami.
    * Vypocita sa tu aj sila hlasu na zaklade metody vypocitanie_sily definovanej v triede SilaHlasu.
    * @param meno Meno zupana
    * @param kraj Kraj, z ktoreho zupan pochadza
    * @param strana Strana, ktorej je zupan prislusnikom
    */
    public Zupan(String meno, String kraj, String strana) {
        super(meno, kraj, strana);
        silaHlasu=new SilaHlasu();
        sila_hlasu=silaHlasu.vypocitanie_sily(kraj);
    }
     
    /**
     * Prekonavana metoda volim, kde sa inkrementuje pocet hlasov kandidatovi na zaklade toho, aku ma zupan silu hlasu.
     * @param kandidat Argumentom je nahodne vybraty kandidat v triede Volby.
     */
    public void volim(Kandidat kandidat) {
        for (int i=0;i<sila_hlasu;i++)
    		kandidat.inkrementujHlasy(kraj,strana);
    }
    
    /**
     * Metoda getSilaHlasu.
     * @return vrati silu hlasu daneho zupana.
     */
    public long getSilaHlasu() {
        return sila_hlasu;
    }
    
    /**
     * Metoda udelujemHlas sluzi na zapamatanie si toho, komu udelil dany zupan hlas do atributu udelenyHlas
     * @param i Ako argument prichadza do funkcie cislo kandidata, ktoreho zupan volil.
     */
    
    public void udelujemHlas(int i) {
    	udelenyHlas=i;
    }
    
    /**
     * Metoda getUdelenyHlas
     * @return vrati cislo kandidata, ktoreho zupan volil.
     */
    public int getUdelenyHlas() {
    	return udelenyHlas;
    }
    
    /**
     * Metoda getKraj
     * @return vrati kraj, z ktoreho zupan pochadza
     */
    
    public String getKraj() {
    	return kraj;
    }
}