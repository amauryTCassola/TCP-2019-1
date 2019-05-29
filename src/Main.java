/**
 * 
 */

import org.jfugue.player.Player;

/**
 * @author Amaury, Felipe and Rafael
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.print("Java fucking sucks ass");

		Parser teste = new Parser();
		System.out.println(teste.textToMusic());

		Player player = new Player();
		player.play("C D E F G A B");
	}
}
