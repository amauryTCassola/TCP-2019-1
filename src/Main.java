/**
 * 
 */

/**
 * @author Amaury, Felipe and Rafael
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//Player player = new Player();
		//player.play(String.format(":Controller(7,%d) C I[Harpsichord] C C :Controller(7,%d) C C C R C1 C1 C1",
		//		Constants.VOLUME_DEFAULT, 80));
		//player.play("I[Tubular_Bells] C C C R I14 C C C");
		Music music = new Music(Constants.VOLUME_DEFAULT, Constants.BPM_DEFAULT, 
				Constants.INSTRUMENT_DEFAULT, Constants.OCTAVE_DEFAULT);
		MusicMapManager musicMap = new MusicMapManager();
		Parser parser = new Parser(musicMap, music);
		
		String inputText = "Aachaiajkia";
		int maxCharLength = 3;
		
		System.out.println("initial music string:"+music.getMusicString());
		parser.iteratesThroughString(inputText, maxCharLength);
		System.out.println("\nfinal music string:\n"+music.getMusicString());

		
		
	}
}
