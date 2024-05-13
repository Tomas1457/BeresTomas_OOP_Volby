package main;
import java.util.*;

import kandidati.Kandidat;
import volici.Poslanec;
import volici.Prezident;
import volici.Zupan;

/**
 * Trieda Volby implementuje rozhranie Volby_interface
 * Toto je najdolezitejsia trieda, s ktorou interaguje gui
 */

public class Volby implements Volby_interface {
    private List<Kandidat> kandidati;
    private List<Poslanec> poslanci;

    /**
     * Konstruktor pre vytvorenie novej instancie Volby a s danymi listami
     * @param kandidati List kandidatov je jednym argumentom
     * @param poslanci List poslancov/volicov je druhym argumentom
     */
    public Volby(List<Kandidat> kandidati, List<Poslanec> poslanci) {
        this.kandidati = kandidati;
        this.poslanci = poslanci;
    }
    
    public String hlasovanie() {
        poslanci.forEach(poslanec -> {
            if (poslanec instanceof Prezident) {
                // tu sa vyuziva RTTI na zistenie, ci je poslanec typu Prezident
            	Prezident prezident = (Prezident) poslanec; //pretypovanie
                for (int i = 0; i < prezident.getPocetVolenychKandidatov(); i++) { 
                    prezident.volim(vyberNahodnehoKandidata());
                }
            } else {
            	Kandidat voleny_kandidat=vyberNahodnehoKandidata();
                poslanec.volim(voleny_kandidat);
                if (poslanec instanceof Zupan) {
                	Zupan zupan = (Zupan) poslanec;
                	zupan.udelujemHlas(voleny_kandidat.getCisloKandidata());
                }
            }
        });
        
        String vystup = ("\nPoslanci, predsedovia vyšších územných celkov a prezident zahlasovali za jednotlivých kandidátov\n");
        return vystup;
    }
    
    public void inkrementujSiluHlasuPrezidentovi() { 
    	poslanci.forEach(poslanec->{
    		if (poslanec instanceof Prezident) {
    			Prezident prezident = (Prezident) poslanec;
    			prezident.inkrementujSiluHlasu();
    			Random random = new Random();
    			prezident.zmenPocetVolenychKandidatov(random.nextInt(kandidati.size()));
    		}
    	});
    }
    
    /**
     * Metoda vyberNahodnehoKandidata vyberie index nahodneho kandidata
     * @return vracia kandidata na danom indexe
     */
    private Kandidat vyberNahodnehoKandidata() {
        Random random = new Random();
        int index = random.nextInt(kandidati.size());
        return kandidati.get(index);
    }

    public String vypisCelkoveVysledky() {
    	StringBuilder vystup = new StringBuilder("\nCelkové výsledky volieb:\n");
        kandidati.forEach(kandidat -> vystup.append(kandidat.vratHlasy()));
                
        return vystup.toString()+"\n";
    }
    
    public String vypisVysledky_v_krajoch() {
    	StringBuilder vystup = new StringBuilder("\n");
    	for (int i=0;i<8;i++) {
    		String kraj;
    		switch (i) {
    		case 0: vystup.append("Výsledky volieb v Bratislavskom kraji:");
    				kraj="BA";
    				vystup.append("\n");
    	    		kandidati.forEach(kandidat -> vystup.append(kandidat.getMeno())
    	    	                .append(": ")
    	    	                .append(kandidat.getPocetHlasov_v_kraji("BA"))
    	    	                .append(" hlasov\n"));
    				break;
    		case 1: vystup.append("Výsledky volieb v Trnavskom kraji:");
    				kraj="TT";
    				vystup.append("\n");
    	    		kandidati.forEach(kandidat -> vystup.append(kandidat.getMeno())
    	    	                .append(": ")
    	    	                .append(kandidat.getPocetHlasov_v_kraji("TT"))
    	    	                .append(" hlasov\n"));
    				break;
    		case 2: vystup.append("Výsledky volieb v Nitrianskom kraji:");
    				kraj="NR";
    				vystup.append("\n");
    	    		kandidati.forEach(kandidat -> vystup.append(kandidat.getMeno())
    	    	                .append(": ")
    	    	                .append(kandidat.getPocetHlasov_v_kraji("NR"))
    	    	                .append(" hlasov\n"));
    				break;
    		case 3: vystup.append("Výsledky volieb v Trenčianskom kraji:");
    				kraj="TN";
    				vystup.append("\n");
    	    		kandidati.forEach(kandidat -> vystup.append(kandidat.getMeno())
    	    	                .append(": ")
    	    	                .append(kandidat.getPocetHlasov_v_kraji("TN"))
    	    	                .append(" hlasov\n"));
    				break;
    		case 4: vystup.append("Výsledky volieb v Žilinskom kraji:");
    				kraj="ZA";
    				vystup.append("\n");
    	    		kandidati.forEach(kandidat -> vystup.append(kandidat.getMeno())
    	    	                .append(": ")
    	    	                .append(kandidat.getPocetHlasov_v_kraji("ZA"))
    	    	                .append(" hlasov\n"));
    				break;
    		case 5: vystup.append("Výsledky volieb v Banskobystrickom kraji:");
    				kraj="BB";
    				vystup.append("\n");
    	    		kandidati.forEach(kandidat -> vystup.append(kandidat.getMeno())
    	    	                .append(": ")
    	    	                .append(kandidat.getPocetHlasov_v_kraji("BB"))
    	    	                .append(" hlasov\n"));
    				break;
    		case 6: vystup.append("Výsledky volieb v Prešovskom kraji:");
    				kraj="PO";
    				vystup.append("\n");
    	    		kandidati.forEach(kandidat -> vystup.append(kandidat.getMeno())
    	    	                .append(": ")
    	    	                .append(kandidat.getPocetHlasov_v_kraji("PO"))
    	    	                .append(" hlasov\n"));
    				break;
    		case 7: vystup.append("Výsledky volieb v Košickom kraji:");
    				kraj="KE";
    				vystup.append("\n");
    	    		kandidati.forEach(kandidat -> vystup.append(kandidat.getMeno())
    	    	                .append(": ")
    	    	                .append(kandidat.getPocetHlasov_v_kraji("KE"))
    	    	                .append(" hlasov\n"));
    				break;			
    		}
    		vystup.append("\n");
    	}
    	return vystup.toString()+"\n";
    }
    
    public String vypisVysledky_v_stranach() {
    	String[] strany = {"OĽANO", "KDH", "SaS", "Hlas-SD", "SME RODINA", "Progresívne Slovensko", 
                "ZA ĽUDÍ", "Republika", "Nezávislý kandidát", "Strana zelených", 
                "Ľudová strana Naše Slovensko", "Most-Híd", "Za občanov Slovenska", 
                "STAROSTOVIA", "SDKÚ-DS", "ĽUD", "Vlasť", "Kresťanská únia", "Smer-SD", 
                "Zmena zdola"};

    	StringBuilder vystup = new StringBuilder("\nVýsledky jednotlivých kandidátov v jednotlivých stranách:");

    	Arrays.stream(strany).forEach(strana -> { //funkcia Arrays.stream() sluzi na vytvorenie "prudu" zo zoznamu stran a nasledne sa pouzije pre kazdu stranu lambda vyraz
    		vystup.append("\n" + strana + ":\n");
    		kandidati.forEach(kandidat -> {
    			vystup.append(kandidat.getMeno() + ": " + kandidat.getPocetHlasov_v_strane(strana) + "\n");
    		});
    		vystup.append("\n");
    	});
    	
    	return vystup.toString();
    }
    
    public String vypisKandidatov() {
    	StringBuilder vystup=new StringBuilder("Prezidentskí kandidáti:\n");
    	kandidati.forEach(kandidat->vystup.append(kandidat.getCisloKandidata())
    			.append(": ")
    			.append(kandidat.getMeno())
    			.append(kandidat.getInfo_o_kandidatovi())
    			.append("\n"));
    	return vystup.toString();
    }
    
    public List<Kandidat> Najdi_vitazov_prveho_kola() {
        List<Kandidat> najlepsiKandidati = new ArrayList<>(kandidati);
        Collections.sort(najlepsiKandidati, Comparator.comparingInt(Kandidat::getPocetHlasov).reversed());
        return najlepsiKandidati.subList(0, Math.min(2, najlepsiKandidati.size()));
    }
    
    
    public String volbyZupanov() {
    	StringBuilder vystup = new StringBuilder("\nPredsedovia VÚC volili nasledovne:\n");
    	poslanci.forEach(poslanec->{if (poslanec instanceof Zupan&& !(poslanec instanceof Prezident)) {
    		Zupan zupan = (Zupan) poslanec;
    		vystup.append("Predseda ");
    		vystup.append(zupan.getKraj());
    		vystup.append(" kraja udelil hlas kandidátovi číslo ");
    		vystup.append(zupan.getUdelenyHlas());
    		vystup.append(".\n");
    	}	
    	});
    	return vystup.toString()+"\n";
    }
    
    public String DruheKoloVolieb() {
        kandidati = Najdi_vitazov_prveho_kola();
        StringBuilder vystup=new StringBuilder("\nDo 2.kola prezidentských volieb postupujú:\n");
        int i=1;
        for (Kandidat kandidat: kandidati) {
            kandidat.zmenCisloKandidata(i);
            vystup.append(kandidat.getCisloKandidata()+". "+kandidat.getMeno()+"\n");
            kandidat.anulujHlasy_Z_PrvehoKola();
            i++;
        }
        vystup.append("\n");
        return vystup.toString();
    }
    
    
}