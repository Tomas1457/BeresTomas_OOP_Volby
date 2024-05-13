package gui;

/**
 * Definica vlastnej vynimky
 */

public class Moja_vynimka extends Exception{
	/**
     * Konstruktor pre vytvorenie novej instancie Moja_vynimka s danou spravou
     * @param message Sprava vynimky
     */
	public Moja_vynimka(String message) {
        super(message);
    }
}
