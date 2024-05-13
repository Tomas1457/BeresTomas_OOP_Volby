package kandidati;

/**
 * Trieda Kandidat 
 */
public class Kandidat implements Kandidati_interface{
    private String meno;
    protected int vek;
    private String strana;
    private int cisloKandidata;
    private int pocetHlasov;
    private int pocetHlasov_v_kraji[];
    private int pocetHlasov_v_strane[];
    
    /**
     *  Konstruktor pre vytvorenie novej instancie Kandidat s danymi parametrami
     * @param meno Meno kandidata
     * @param vek Vek kandidata
     * @param strana Strana, ktorej je kandidat sucastou
     * @param cisloKandidata Cislo kandidata
     */

    public Kandidat(String meno, int vek, String strana, int cisloKandidata) {
        this.meno = meno;
        this.vek = vek;
        this.strana = strana;
        this.cisloKandidata = cisloKandidata;
        this.pocetHlasov_v_kraji = new int[8]; //v Java jazyku musi byt pole takto inicializovane
        this.pocetHlasov_v_strane = new int[20];
    }

    public String getMeno() {
        return meno;
    }
    
    public String getInfo_o_kandidatovi() {
    	return "-" + strana + "-" + vek + " rokov";
    }
    
    public int getCisloKandidata() {
    	return cisloKandidata;
    }

    public void inkrementujHlasy(String kraj,String strana) {
    	int index=0;
    	int i=0;
        pocetHlasov++;
        switch (kraj) {
        case ("BA"): index=0;
        			break;
        case ("TT"): index=1;
        			break;
        case ("NR"): index=2;
        			break;
        case ("TN"): index=3;
        			break;
        case ("ZA"): index=4;
        			break;
        case ("BB"): index=5;
        			break;
        case ("PO"): index=6;
        			break;
        case ("KE"): index=7;
        			break;
        }
        pocetHlasov_v_kraji[index]++;
        
        if(strana!=null) {
        	switch(strana) {
        	case "OĽANO": i=0; break;
        	case "KDH": i=1; break;
        	case "SaS": i=2; break;
        	case "Hlas-SD": i=3; break;
        	case "SME RODINA": i=4; break;
        	case "Progresívne Slovensko": i=5; break;
        	case "ZA ĽUDÍ": i=6; break;
        	case "Republika": i=7; break;
        	case "Nezávislý kandidát": i=8; break;
        	case "Strana zelených": i=9; break;
        	case "Ľudová strana Naše Slovensko": i=10; break;
        	case "Most-Híd": i=11; break;
        	case "Za občanov Slovenska": i=12; break;
        	case "STAROSTOVIA": i=13; break;
        	case "SDKÚ-DS": i=14; break;
        	case "ĽUD": i=15; break;
        	case "Vlasť": i=16; break;
        	case "Kresťanská únia": i=17; break;
        	case "Smer-SD": i=18; break;
        	case "Zmena zdola": i=19; break;
        	}
        	pocetHlasov_v_strane[i]++;
        }
    }

    public int getPocetHlasov() {
        return pocetHlasov;
    }
    
    public int getPocetHlasov_v_kraji(String kraj) {
    	int index=0;
    	switch (kraj) {
        case ("BA"): index=0; break;
        case ("TT"): index=1; break;
        case ("NR"): index=2; break;
        case ("TN"): index=3; break;
        case ("ZA"): index=4; break;
        case ("BB"): index=5; break;
        case ("PO"): index=6; break;
        case ("KE"): index=7; break;
        }
    	return pocetHlasov_v_kraji[index];
    }
    
    public int getPocetHlasov_v_strane(String strana) {
    	int i=0;
    	switch(strana) {
        case "OĽANO": i=0; break;
        case "KDH": i=1; break;
        case "SaS": i=2; break;
        case "Hlas-SD": i=3; break;
        case "SME RODINA": i=4; break;
        case "Progresívne Slovensko": i=5; break;
        case "ZA ĽUDÍ": i=6; break;
        case "Republika": i=7; break;
        case "Nezávislý kandidát": i=8; break;
        case "Strana zelených": i=9; break;
        case "Ľudová strana Naše Slovensko": i=10; break;
        case "Most-Híd": i=11; break;
        case "Za občanov Slovenska": i=12; break;
        case "STAROSTOVIA": i=13; break;
        case "SDKÚ-DS": i=14; break;
        case "ĽUD": i=15; break;
        case "Vlasť": i=16; break;
        case "Kresťanská únia": i=17; break;
        case "Smer-SD": i=18; break;
        case "Zmena zdola": i=19; break;
        }
    	return pocetHlasov_v_strane[i];
    }
    
    public void anulujHlasy_Z_PrvehoKola() {
    	pocetHlasov=0;
    }
    
    public void zmenCisloKandidata(int i) {
    	cisloKandidata=i;
    }
}