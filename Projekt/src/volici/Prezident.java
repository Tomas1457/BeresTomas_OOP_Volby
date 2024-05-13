package volici;
import kandidati.Kandidat;

/**
 * Trieda Prezident rozsiruje triedu Zupan
 */
public class Prezident extends Zupan {
    private int pocetVolenychKandidatov;

    /**
     * Konstruktor pre vytvorenie novej instancie Zupan s danymi argumentami.
     * @param meno Meno prezidenta
     * @param kraj Kraj, z ktoreho prezident pochadza
     * @param strana Strana, ktorej je prezident sucastou
     * @param silaHlasu Sila hlasu prezidenta je rovna celkovemu poctu kandidatov
     * @param pocetVolenychKandidatov Pocet volenych kandidatov sa nahodne vygeneruje
     */
    public Prezident(String meno, String kraj, String strana, int silaHlasu, int pocetVolenychKandidatov) {
        super(meno, kraj, strana);
        this.pocetVolenychKandidatov = pocetVolenychKandidatov;
        this.sila_hlasu = silaHlasu;
    }
    
    /**
     * Metoda getPocetVolenychKandidatov
     * @return vrati pocetVolenychKandidatov
     */
    public int getPocetVolenychKandidatov() {
    	return pocetVolenychKandidatov;
    }
    
    /**
     * Metoda inkrementujSiluHlasu zvysi silu hlasu prezidenta o 1 pri pridani dalsieho kandidata uzivatelom.
     */
    public void inkrementujSiluHlasu() {
    	sila_hlasu++;
    }
    
    /**
     * Metoda zmenPocetVolenychKandidatov je volana, ked uzivatel prida noveho kandidata.
     * @param i Ako parameter do funkcie vstupuje novovygenerovane cislo, ktore sa priradi atributu pocetVolenychKandidatov.
     */
    public void zmenPocetVolenychKandidatov(int i) {
    	pocetVolenychKandidatov=i;
    }
}