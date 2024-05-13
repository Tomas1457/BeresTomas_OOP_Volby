/**
 * @author Tomas Beres
 * Prezidentske volby
 */

package gui;

import kandidati.*;
import volici.*;
import main.*;

import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import kandidati.Kandidat;
import kandidati.Kandidat_Pouzivatel;
import main.Volby;
import main.Vytvorenie_poli;
import volici.Poslanec;
import volici.Pouzivatel;

/**
 * Pouzivatelske rozhranie
 */
public class gui extends Application{
	private Button vypis_kandidatov = new Button("Zoznam kandidátov");
	private Button hlasovanie = new Button("Hlasovanie");
	private Button vypis_celkovych_vysledkov=new Button ("Celkové výsledky volieb");
	private Button vypis_podla_krajov = new Button ("Výsledky volieb v jednotlivých krajoch");
	private Button vypis_podla_stran = new Button ("Výsledky volieb podľa príslušnosti k stranám");
	private Button druhe_kolo = new Button ("Druhé kolo prezidentských volieb");
	private Button hlasovanie_v_druhom_kole = new Button ("Hlasovanie");
	private Button celkovy_vitaz = new Button ("Víťaz prezidentských volieb");
	private Button spat = new Button ("Zrušiť");
	private TextField cislo_voleneho_kandidata = new TextField("Číslo voleného kandidáta");
	private Button potvrdit_volbu = new Button("Potvrdiť");
	private Button volba_zupanov = new Button("Koho volili predsedovia VÚC?");
	
	private Button chcem_kandidovat = new Button ("Chcem kandidovať");
	private TextField meno = new TextField ("Meno a priezvisko");
	private TextField vek = new TextField ("Vek");
	private TextField strana = new TextField ("Politická strana");
	private Button potvrdit = new Button ("Potvrdiť");
	private Button zrusit = new Button ("Zrušiť");
	
	private Button chcem_volit = new Button ("Chcem voliť");
	private boolean je_druhe_kolo=false;
	
	private ScrollPane scroll = new ScrollPane(); //zatial nepouzite
	private TextArea output = new TextArea();
	private Button vymazat = new Button("Vymazať text");
	
	private final ObservableList<String> kraj =
	            FXCollections.observableArrayList(
	                    "BA", "TT", "NR", "TN", "ZA", "BB", "PO", "KE"
	            );
	 
	private final ComboBox<String> krajComboBox = new ComboBox<>(kraj);
	private void initKrajComboBox() {
        krajComboBox.setValue("Vyberte kraj");
        krajComboBox.setVisible(false);
    }
	
	 private void vypisDoTextArea(String text) {
	        output.appendText(text);
	 }

	
	public void start(Stage mainWindow) throws FileNotFoundException {
		initKrajComboBox();
		
		Vytvorenie_poli vytvorenie_poli = new Vytvorenie_poli();
	    vytvorenie_poli.vytvorenie_kandidatov();
	    vytvorenie_poli.vytvorenie_poslancov();
	    List<Kandidat> kandidati = vytvorenie_poli.getKandidati();
	    List<Poslanec> poslanci = vytvorenie_poli.getPoslanci();
		
		Volby volby=new Volby(kandidati,poslanci);
		
		mainWindow.setTitle("Voľby");
		FlowPane pane = new FlowPane();
		
		pane.getChildren().add(vypis_kandidatov);
		pane.getChildren().add(hlasovanie);
		pane.getChildren().add(vypis_celkovych_vysledkov);
		pane.getChildren().add(vypis_podla_krajov);
		pane.getChildren().add(vypis_podla_stran);
		pane.getChildren().add(volba_zupanov);
		pane.getChildren().add(druhe_kolo);
		pane.getChildren().add(hlasovanie_v_druhom_kole);
		pane.getChildren().add(celkovy_vitaz);
		pane.getChildren().add(chcem_kandidovat);
		pane.getChildren().add(meno);
		pane.getChildren().add(vek);
		pane.getChildren().add(strana);
		pane.getChildren().add(potvrdit);
		pane.getChildren().add(zrusit);
		pane.getChildren().add(output);
		pane.getChildren().add(chcem_volit);
		pane.getChildren().add(krajComboBox);
		pane.getChildren().add(spat);
		pane.getChildren().add(cislo_voleneho_kandidata);
		pane.getChildren().add(potvrdit_volbu);
		pane.getChildren().add(vymazat);
		
		
		scroll.setContent(pane);
		output.setPrefSize(500, 300);
		
		volba_zupanov.setVisible(false);
		potvrdit_volbu.setVisible(false);
		cislo_voleneho_kandidata.setVisible(false);
		spat.setVisible(false);
		chcem_volit.setVisible(false);
		potvrdit.setVisible(false);
		zrusit.setVisible(false);
		meno.setVisible(false);
		vek.setVisible(false);
		strana.setVisible(false);
		hlasovanie.setVisible(false);
		vypis_celkovych_vysledkov.setVisible(false);
		vypis_podla_krajov.setVisible(false);
		vypis_podla_stran.setVisible(false);
		druhe_kolo.setVisible(false);
		hlasovanie_v_druhom_kole.setVisible(false);
		celkovy_vitaz.setVisible(false);
		
		volba_zupanov.setOnAction(e->{
			output.appendText(volby.volbyZupanov());
		});
		
		vypis_kandidatov.setOnAction(e->{
			//tu sa vyuzije RTTI na identifikaciu typu objektu v metode obsluhujucej tlacidlo
			Button clickedButton = (Button) e.getSource();
	        String buttonText = clickedButton.getText();

	        if (buttonText.equals("Zoznam kandidátov")) {
	            output.appendText(volby.vypisKandidatov());
	        }
	        
			hlasovanie.setVisible(true);
			chcem_volit.setVisible(true);
		}
		);
		
		hlasovanie.setOnAction(e->{
			output.appendText(volby.hlasovanie());
			hlasovanie.setVisible(false);
			vypis_celkovych_vysledkov.setVisible(true);
			vypis_podla_krajov.setVisible(true);
			vypis_podla_stran.setVisible(true);
			druhe_kolo.setVisible(true);
			chcem_kandidovat.setVisible(false);
			vypis_kandidatov.setVisible(false);
			chcem_volit.setVisible(false);
			volba_zupanov.setVisible(true);
		});
		
		hlasovanie_v_druhom_kole.setOnAction(e->{
			output.appendText(volby.hlasovanie());
			hlasovanie_v_druhom_kole.setVisible(false);
			vypis_celkovych_vysledkov.setVisible(true);
			vypis_podla_krajov.setVisible(true);
			vypis_podla_stran.setVisible(true);
			celkovy_vitaz.setVisible(true);
			chcem_volit.setVisible(false);
			volba_zupanov.setVisible(true);
		});
		
		vypis_celkovych_vysledkov.setOnAction(e->{
			output.appendText(volby.vypisCelkoveVysledky());
		});
		
		vypis_podla_krajov.setOnAction(e->{
			output.appendText(volby.vypisVysledky_v_krajoch());
		});
		
		vypis_podla_stran.setOnAction(e->{
			output.appendText(volby.vypisVysledky_v_stranach());
		});
		
		druhe_kolo.setOnAction(e->{
			output.appendText(volby.DruheKoloVolieb());
			druhe_kolo.setVisible(false);
			hlasovanie_v_druhom_kole.setVisible(true);
			vypis_celkovych_vysledkov.setVisible(false);
			vypis_podla_krajov.setVisible(false);
			vypis_podla_stran.setVisible(false);
			chcem_volit.setVisible(true);
			volba_zupanov.setVisible(false);
			je_druhe_kolo=true;
		});
		
		celkovy_vitaz.setOnAction(e->{
			output.appendText(volby.Vitaz_Druheho_Kola());
		});
		
		chcem_kandidovat.setOnAction(e->{
			vypis_kandidatov.setVisible(false);
			meno.setVisible(true);
			vek.setVisible(true);
			strana.setVisible(true);
			potvrdit.setVisible(true);
			zrusit.setVisible(true);
			chcem_kandidovat.setVisible(false);
			hlasovanie.setVisible(false);
			chcem_volit.setVisible(false);
			volba_zupanov.setVisible(false);
		});
		
		zrusit.setOnAction(e->{
			vypis_kandidatov.setVisible(true);
			chcem_kandidovat.setVisible(true);
			meno.setVisible(false);
			vek.setVisible(false);
			strana.setVisible(false);
			potvrdit.setVisible(false);
			zrusit.setVisible(false);
			volba_zupanov.setVisible(false);
		});
		
		potvrdit.setOnAction(e -> {
		    String menoText = meno.getText();
		    String vekText = vek.getText();
		    String stranaText = strana.getText();
		    
		    try {
		    	Kandidat_Pouzivatel kandidatPouzivatel = new Kandidat_Pouzivatel(menoText, vekText, stranaText, kandidati.size()+1);
		    	boolean mozeKandidovat = kandidatPouzivatel.get_moze_kandidovat();

		    	if (mozeKandidovat) {
		    		kandidati.add(kandidatPouzivatel);
		    		volby.inkrementujSiluHlasuPrezidentovi(); //ked sa uzivatel rozhodne kandidovat, zvysi sa sila hlasu prezidenta a zaroven sa znovu vygeneruje pocet volenych kandidatov
		    	} else {
		    		throw new Moja_vynimka("Osoba nie je staršia ako 40 rokov, nemôže kandidovať.");
		    	}
		    }catch(Moja_vynimka ex){
		    	output.setText(ex.getMessage());
		    }
		    
		    vypis_kandidatov.setVisible(true);
	        chcem_kandidovat.setVisible(true);
	        meno.setVisible(false);
	        vek.setVisible(false);
	        strana.setVisible(false);
	        potvrdit.setVisible(false);
	        zrusit.setVisible(false);
		});
		
		chcem_volit.setOnAction(e->{
			hlasovanie.setVisible(false);
			hlasovanie_v_druhom_kole.setVisible(false);
			meno.setVisible(true);
			vek.setVisible(true);
			krajComboBox.setVisible(true);
			spat.setVisible(true);
			chcem_volit.setVisible(false);
			vypis_kandidatov.setVisible(false);
			chcem_kandidovat.setVisible(false);
			cislo_voleneho_kandidata.setVisible(true);
			potvrdit_volbu.setVisible(true);
		});
		
		spat.setOnAction(e->{
			if(je_druhe_kolo==false)
				hlasovanie.setVisible(true);
			else
				hlasovanie_v_druhom_kole.setVisible(true);
			meno.setVisible(false);
			vek.setVisible(false);
			krajComboBox.setVisible(false);
			spat.setVisible(false);
			chcem_volit.setVisible(true);
			chcem_kandidovat.setVisible(true);
			cislo_voleneho_kandidata.setVisible(false);
			potvrdit_volbu.setVisible(false);
		});
		
		potvrdit_volbu.setOnAction(e -> {
		    if (!je_druhe_kolo) {
		        hlasovanie.setVisible(true);
		    } else {
		        hlasovanie_v_druhom_kole.setVisible(true);
		    }
		    meno.setVisible(false);
		    vek.setVisible(false);
		    krajComboBox.setVisible(false);
		    spat.setVisible(false);
		    chcem_volit.setVisible(true);
		    cislo_voleneho_kandidata.setVisible(false);
		    potvrdit_volbu.setVisible(false);

		    String menoText = meno.getText();
		    String vekText = vek.getText();
		    String vybranyKraj = krajComboBox.getValue();
		    boolean mozeVolit = false;
		    
		    try {
		        int voleny_kandidat = Integer.parseInt(cislo_voleneho_kandidata.getText());
		        if ((je_druhe_kolo==false && voleny_kandidat > 0 && voleny_kandidat <= kandidati.size()) || (je_druhe_kolo==true && voleny_kandidat > 0 && voleny_kandidat <= 2)) {
		            Pouzivatel pouzivatel = new Pouzivatel(menoText, vekText, vybranyKraj);
		            mozeVolit = pouzivatel.get_moze_volit();
		            if (!mozeVolit) {
		                throw new Moja_vynimka("Osoba nie je staršia ako 18 rokov, nemôže voliť.");
		            } else {
		                pouzivatel.volim(kandidati.get(voleny_kandidat-1));
		            }
		        } else {
		            throw new Moja_vynimka("Neplatný hlasovací lístok, zadali ste neplatné číslo kandidáta\n");
		        }
		    } catch (Moja_vynimka ex) {
		        output.setText(ex.getMessage());
		    }

		    
		});
		
		vymazat.setOnAction(e->{
			output.clear();
		});
		
		
		mainWindow.setScene(new Scene(scroll, 500, 500));
		mainWindow.show();
		
		
	}
	/**
	 * Vhodne pouzit pre JavaFX
	 * @param args Argumenty prikazoveho riadku
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
