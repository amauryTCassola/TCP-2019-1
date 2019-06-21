import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicTest {
	
	Music music = new Music(Constants.VOLUME_DEFAULT, Constants.BPM_DEFAULT, 
			Constants.INSTRUMENT_DEFAULT, Constants.OCTAVE_DEFAULT);
	
	@Test
	void addMusicPieceTest() {
		assertEquals("", music.getMusicString());
		music.addToMusicString("A5");
		assertEquals("A5", music.getMusicString());
		music.addToMusicString("B6");
		assertEquals("A5 B6", music.getMusicString());
	}

}
