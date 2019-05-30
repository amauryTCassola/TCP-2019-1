/**
 * 
 */

import org.jfugue.player.Player;
import java.util.*;

/**
 * @author Amaury, Felipe and Rafael
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer musicCounter = 0;

		//definindo um hashtable para usar como map manager
		Hashtable<String,String> testMap = new Hashtable<String, String>();
		testMap.put("A", simpleNote('A'));
		testMap.put("B", "B");
		testMap.put("C", "C");
		testMap.put("D", "D");
		testMap.put("E","E");
		testMap.put("F", "F");
		testMap.put("G", "G");



		//MusicMapManager testeMapManager = new MusicMapManager();

		System.out.println(testMap);

		//Player player = new Player();
		//player.play("C C5 D D5 E E5 F F5 G G5 A A5 B B5");
		//player.play("C R C5 R R C C7");
	}

	private static String simpleNote(Character charTexto) {
		return charTexto + "5";
	}
}
