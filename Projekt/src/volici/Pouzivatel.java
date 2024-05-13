package volici;
import kandidati.Kontrola_veku;

/**
 * Trieda Pouzivatel rozsiruje triedu Poslanec.
 */
public class Pouzivatel extends Poslanec {
    private String vek;
    private Kontrola_veku kontrola_veku=new Kontrola_veku();
    private boolean moze_volit;
    
    /**
     * Konstruktor pre vytvorenie novej instancie Zupan s danymi argumentami.
     * V tejto casti sa zaroven priradi vdaka metode kontrolaVeku_volic_pouzivatel implementovanej v triede Kontrola_veku v baliku kandidati atributu moze_volit true/false.
     * @param meno Meno, ktore zadal pouzivatel
     * @param vek Vek pouzivatela, no v tejto casti je zatial reprezentovany Stringom
     * @param kraj Kraj, z ktoreho pouzivatel pochadza
     */
    public Pouzivatel(String meno, String vek, String kraj) {
        super(meno,kraj,null);
        this.vek = vek;
        moze_volit=kontrola_veku.kontrolaVeku_volic_pouzivatel(this.getVek());
    }

    /**
     * Metoda getVek
     * @return vrati pretypovany String vek
     */
    public int getVek() {
    	return Integer.parseInt(vek); //pretypovanie na stringu na int
    }
    
    /**
     * Metoda get_moze_volit
     * @return vrati hodnotu atributu moze_volit
     */
    public boolean get_moze_volit() {
    	return moze_volit;
    }
}
