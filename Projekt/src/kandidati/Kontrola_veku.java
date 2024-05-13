package kandidati;

/**
 * Trieda Kontrola_veku je sucastou tried Kandidat_Pouzivatel a Pouzivatel
 */

public class Kontrola_veku {
	
	/**
	 * Funkcia kontrolaVeku_kandidat kontroluje, ci kandidat s danym vekom splna kriteria kandidovania za prezidenta SR
	 * @param vek Vek kandidata
	 * @return Funkcia vracia true v pripade, ze kandidat ma nad 40 rokov a false, ak nie
	 */
	public boolean kontrolaVeku_kandidat(int vek) {
        if(vek>=40) {
        	return true;// Na Slovensku moze kandidovat ten, kto ma nad 40 rokov
        }
        else {
        	return false;
        }
    }
	
	/**
	 * Funkcia kontrolaVeku_volic_pouzivatel kontroluje, ci pouzivatel s danym vekom ma volicske pravo
	 * @param vek Vek pouzivatela
	 * @return Funkcia vracia true v pripade, ze pouzivatel ma nad 18 a viac rokov a false, ak nie
	 */
	public boolean kontrolaVeku_volic_pouzivatel(int vek) { 
        if(vek>=18) {
        	return true;
        }
        else {
        	return false;
        }
    }
}
