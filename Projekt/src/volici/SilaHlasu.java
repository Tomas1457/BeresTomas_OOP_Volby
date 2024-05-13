package volici;

/**
 * Trieda SilaHlasu je trieda, ktora je zahrnuta v triede Zupan vdaka agregacii.
 */
public class SilaHlasu {
	private long silaHlasu;
	
	/**
	 * Metoda vypocitanie_sily vypocita silu na zaklade vysledkov zo zupnych volieb z roku 2023 danych kandidatov a na zaklade poctu obyvatelov v danom kraji.
	 * @param kraj Parametrom, ktory vstupuje do metody, kraj, z ktoreho pochadza zupan.
	 * @return Metoda vrati hodnotu sily hlasu.
	 */
	long vypocitanie_sily(String kraj) {
		double pocet_obyvatelov_v_kraji=0;
		double pocet_hlasov_vo_volbach=0; //pocet hlasov, ktore ten dany zupan ziskal vo volbach
		
		switch (kraj) {
		case ("BA"): pocet_obyvatelov_v_kraji=659598; pocet_hlasov_vo_volbach=136983;break;
		case ("TT"): pocet_obyvatelov_v_kraji=563591; pocet_hlasov_vo_volbach=69743;break;
		case ("NR"): pocet_obyvatelov_v_kraji=676672; pocet_hlasov_vo_volbach=58765;break;
		case ("TN"): pocet_obyvatelov_v_kraji=585882; pocet_hlasov_vo_volbach=131705;break;
		case ("ZA"): pocet_obyvatelov_v_kraji=691368; pocet_hlasov_vo_volbach=80049;break;
		case ("BB"): pocet_obyvatelov_v_kraji=647874; pocet_hlasov_vo_volbach=96438;break;
		case ("PO"): pocet_obyvatelov_v_kraji=825022; pocet_hlasov_vo_volbach=111343;break;
		case ("KE"): pocet_obyvatelov_v_kraji=800414; pocet_hlasov_vo_volbach=110362;break;
		}
		
		silaHlasu=Math.round(pocet_hlasov_vo_volbach/pocet_obyvatelov_v_kraji*50);
		
		return silaHlasu;
	}
	
}
