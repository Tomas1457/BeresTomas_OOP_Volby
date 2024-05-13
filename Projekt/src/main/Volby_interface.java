package main;

import java.util.List;
import java.util.Random;

import kandidati.Kandidat;
import volici.Poslanec;
import volici.Prezident;
import volici.Zupan;

/**
 * Rozhranie pre triedu Volby
 */

public interface Volby_interface {
	/**
	 * V metode hlasovanie prebieha hlasovanie takym sposobom, ze pre kazdeho poslanca sa prideli nahodny kandidat.
	 * Pokial je ale poslanec typu Prezident, kandidat sa vyberie viackrat podla toho, aky je pocet kandidatov, ktorych chce prezident podporit.
	 * Pokial je poslanec typu Zupan, zavola sa ja metoda udelujemHlas(), ktorou si Zupan pamata, koho volil
	 * @return vracia String, ze vsetci zucastneni odvolili
	 */
	String hlasovanie();
	
	/**
	 * V metode vypisCelkoveVysledky sa zapise pre kazdeho kandidata do vystupu typu StringBuilder pocet ziskanych hlasov
	 * @return vrati sa nasledne pretypovany vystup na String
	 */
	String vypisCelkoveVysledky();
	
	/**
	 * Metoda vypisVysledky_v_krajoch rovnako zapisuje do vystupu typu StringBuilder pocet ziskanych hlasov jednotlivych kandidatov v kazdom kraji.
	 * Robi to vo for cykle.
	 * @return vrati sa nasledne pretypovany vystup na String
	 */
	String vypisVysledky_v_krajoch();
	
	/**
	 * Pri metode vypisVysledky_v_stranach sa rovnako zapisuje do vystupu typu StringBuilder.
	 * Najprv sa vytvori pole stran.
	 * Funkcia Arrays.stream() sluzi na vytvorenie "prudu" zo zoznamu stran a nasledne sa pouzije pre kazdu stranu lambda vyraz, ktory do vystupu prida stranu a nasledne po jednom kandidatovi ich pocet hlasvo v danej strane.
	 * @return vrati sa nasledne pretypovany vystup na String
	 */
	String vypisVysledky_v_stranach();
	
	/**
	 * Pri metode vypisKandidatov sa rovnako zapisuje do vystupu typu StringBuilder.
	 * Po jednom prejde vsetkych kandidatov a do vystupu zapisuje jeho cislo, meno a dodatocne informacie ako vek a stranu.
	 * @return vrati sa nasledne pretypovany vystup na String
	 */
	String vypisKandidatov();
	
	/**
	 * Pri metode volbyZupanov sa rovnako zapisuje do vystupu typu StringBuilder.
	 * Po jednom prejde vsetkych poslancov/volicov a do vystupu zapisuje len v pripade, ze je dany poslanec typu Zupan a zaroven nie prezident. 
	 * Na to sa vyuziva RTTI.
	 * Do vystupu zapisuje kraj, z ktoreho je dany zupan pomocou metody getkraj definovanej v triede Zupan.
	 * A zaroven do vystupu zapisuje cislo kandidata, ktoreho dany Zupan volil.
	 * Cislo kandidata, ktoreho Zupan volil, ziska pomocou metody getUdelenyHlas definovanej v triede Zupan.
	 * @return vrati sa nasledne pretypovany vystup na String
	 */
	String volbyZupanov();
	
	/**
	 * Metoda DruheKoloVolieb najprv zavola metodu Najdi_vitazov_prveho_kola, ktora vrati najlepsich dvoch kandidatov zoradenych podla poctu hlasov ziskanych v prvom kole.
	 * V cykle sa nasledne meni cislo kandidatom tak, ze kandidat s vyssim poctom hlasov v prvom kole, bude mat cislo 1 a druhy 2.
	 * Obom sa zaroven v cykle anuluju hlasy z prveho kola.
	 * A do vystupu typu StringBuilder sa zapise cislo kandidata a meno kandidata (pre oboch kandidatov).
	 * @return vrati sa nasledne pretypovany vystup na String
	 */
	String DruheKoloVolieb();
	
	/**
	 * Metoda inkrementujSiluHlasuPrezidentovi sa zavola, ked uzivatel bude kandidovat (zvacsi sa pocet kandidatov), teda aj sila hlasu prezidenta.
	 * Zaroven sa znovu vygeneruje, kolko kandidatov chce prezident podporit. 
	 */
	void inkrementujSiluHlasuPrezidentovi();
	
	/**
	 * Implicitne implementovana metoda Vitaz_Druheho_Kola najprv zavola metodu Najdi_vitazov_prveho_kola, sice sme uz v druhom kole, no to vobec nevadi.
	 * Tato metoda totiz zoradi pole kandidatov podla poctu hlasov a my sa mozeme zaoberat len tym, co skoncil prvy, teda na indexe 0.
	 * Rovnako vyuziva zapis do vystupu typu StringBuilder.
	 * @return vrati sa nasledne pretypovany vystup na String
	 */
	default String Vitaz_Druheho_Kola() {
        List<Kandidat> kandidati = Najdi_vitazov_prveho_kola();
        StringBuilder vystup=new StringBuilder("\nVíťazom prezidentských volieb sa stáva:\n");
        int i=0;
        for (Kandidat kandidat: kandidati) {
            if (i==0)
                vystup.append(kandidat.getMeno()+"\n");
            i++;
        }
        return vystup.toString();
    }
	
	/**
	 * Metoda Najdi_vitazov_prveho_kola najprv vytvori list/pole kandidatov pod nazvom najlepsi_kandidati.
	 * Toto pole roztriedi opacne (od najvacsieho po najmensi) podla poctu ziskanych hlasov.
	 * @return vrati sublist/pole prvych dvoch kandidatov
	 */
    List<Kandidat> Najdi_vitazov_prveho_kola();
}

