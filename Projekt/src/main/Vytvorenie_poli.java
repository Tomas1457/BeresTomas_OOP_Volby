package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import kandidati.Kandidat;
import volici.Poslanec;
import volici.Prezident;
import volici.Zupan;

/**
 * Trieda Vytvorenie_poli sluzi na precitanie textoveho suboru a vytvorenie poli volicov a kandidatov
 */
public class Vytvorenie_poli {
	private List<Kandidat> kandidati;
    private List<Poslanec> poslanci;

    /**
     *  Konstruktor pre vytvorenie novej instancie Vytvorenie_poli 
     */
    public Vytvorenie_poli() {
        kandidati = new ArrayList<>();
        poslanci = new ArrayList<>();
    }
	
    /**
     * Metoda vytvorenie_kandidatova sluzi na vytvorenie a zaplnenie pola kandidatov
     */
	public void vytvorenie_kandidatov() {
		kandidati = new ArrayList<>(Arrays.asList( //vytvara sa uz hotovy zoznam (Arrays.asList), do ktoreho ale este viem doplnat prvky vdaka new ArrayList
            new Kandidat("Juraj Novák", 45, "Progresívne Slovensko", 1),
            new Kandidat("Eva Haláková", 50, "Nezávislý kandidát", 2),
            new Kandidat("Peter Vrba", 55, "Smer-SD", 3),
            new Kandidat("František Kostolanský",62,"Vlasť", 4),
            new Kandidat("Lukáš Šefčovič",70,"OĽANO",5)
        ));
	}
	
	/**
	 * Metoda getKandidati sluzi na vratenie listu kandidatov
	 * @return vracia list kandidatov
	 */
	public List getKandidati() {
		return kandidati;
	}
	
	/**
	 * Metoda vytvorenie_poslancov postupne zaplna pole poslancov zupanmi, prezidentkou SR a poslancami VUC, ktorych mena su zapisane v textovom subore
	 * @throws FileNotFoundException Program vyhodi FileNotFound vynimku, ked nenajde dany textovy subor, teda poslanci.txt
	 */
	public void vytvorenie_poslancov() throws FileNotFoundException {
        poslanci = new ArrayList<>();
        
        
        poslanci.add(new Zupan("Milan Majerský","PO","KDH"));
        poslanci.add(new Zupan("Erika Jurinová","ZA","OĽANO"));
        poslanci.add(new Zupan("Jozef Viskupič","TT","OĽANO"));
        poslanci.add(new Zupan("Juraj Droba","BA","SaS"));
        poslanci.add(new Zupan("Jaroslav Baška","TN","SMER-SD"));
        poslanci.add(new Zupan("Branislav Becík","NR","HLAS-SD"));
        poslanci.add(new Zupan("Ondrej Lunter","BB","Nezávislý kandidát"));
        poslanci.add(new Zupan("Rastislav Trnka","KE","KDH"));
        
        Random random=new Random();
        poslanci.add(new Prezident("Zuzana Čaputová","BA","PS", kandidati.size(), random.nextInt(kandidati.size()))); 
        
        File file=new File("src/poslanci.txt");
        Scanner myReader = new Scanner(file);
        
        int i=0;
        String meno = null;
        String strana;
        String kraj;
        while(myReader.hasNextLine()) {
        	if(i%2==0) {
        		meno=myReader.nextLine();
        	}
        	else {
        		strana=myReader.nextLine();
        		if (i<=20) {
        			kraj="BA";
        		}
        		else if(i>40&&i<=80) {
        			kraj="TT";
        		}
        		else if(i>80&&i<=120) {
        			kraj="NR";
        		}
        		else if(i>120&&i<=160) {
        			kraj="TN";
        		}
        		else if(i<1600&&i<=200) {
        			kraj="ZA";
        		}
        		else if(i>200&&i<=240) {
        			kraj="BB";
        		}
        		else if(i>240&&i<=280) {
        			kraj="PO";
        		}
        		else
        			kraj="KE";
        		poslanci.add(new Poslanec(meno,kraj,strana));
        	}
        	i++;
        }
        
        myReader.close();
	}
	/**
	 * Metoda getKandidati sluzi na vratenie listu poslancov
	 * @return vracia list poslancov
	 */
	public List getPoslanci() {
		return poslanci;
	}
}
