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
		
		// Default music config values for testing without GUI
		final Integer VOLUME = 10200;
		final Integer BPM = 120;
		final Integer INSTRUMENT = 1;
		final String OCTAVE = "5";
		
		//Player player = new Player();
		//player.play("C D E F G A B");
		Music music = new Music(VOLUME, BPM, INSTRUMENT, OCTAVE);
		MusicMapManager musicMap = new MusicMapManager(music);
		System.out.println(musicMap.getMusicMap());
	}
}
