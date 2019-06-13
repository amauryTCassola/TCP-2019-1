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
		
		
		Player player = new Player();
		//player.play(String.format(":Controller(7,%d) C I[Harpsichord] C C :Controller(7,%d) C C C R C1 C1 C1",
		//		Constants.VOLUME_DEFAULT, 80));
		player.play("I[Tubular_Bells] C C C R I14 C C C");
		//Music music = new Music(VOLUME_DEFAULT, BPM_DEFAULT, INSTRUMENT_DEFAULT, OCTAVE_DEFAULT);
		//MusicMapManager musicMap = new MusicMapManager(music);
		//System.out.println(musicMap.getMusicMap());
	}
}
