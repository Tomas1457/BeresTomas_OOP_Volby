package volici;
import kandidati.Kandidat;

/**
 * Trieda Poslanec implementuje rozhranie Volici_interface
 */

public class Poslanec implements Volici_interface {
    protected String meno;
    protected String kraj;
    protected String strana;
    
    /**
     * Konstruktor pre vytvorenie novej instancie Poslanec s danymi argumentmi
     * @param meno Meno poslanca
     * @param kraj Kraj, z ktoreho poslanec pochadza
     * @param strana Strana, ktorej je poslanec prislusnikom
     */

    public Poslanec(String meno, String kraj, String strana) {
        this.meno = meno;
        this.kraj = kraj;
        this.strana = strana;
    }

    public void volim(Kandidat kandidat) {
        kandidat.inkrementujHlasy(kraj,strana);
    }
    
    
}
