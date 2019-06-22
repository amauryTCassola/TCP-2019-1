

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;



public class MusicMapManagerTest {
	
	Music music = new Music(Constants.VOLUME_DEFAULT, Constants.BPM_DEFAULT, 
			Constants.INSTRUMENT_DEFAULT, Constants.OCTAVE_DEFAULT);
	MusicMapManager map = new MusicMapManager();
	
	@Test
	public void keyValueSimpleNoteTest() {
		assertEquals("B5", map.keyValue("B", music));
		music.setOctave("6");
		assertEquals("C6", map.keyValue("C", music));
	}
	
	@Test
	public void keyValueDoubleVolumeTest() {
		assertEquals(40, music.getVolume().intValue());
		assertEquals(":Controller(7, 80)", map.keyValue(" ", music));
		assertEquals(80, music.getVolume().intValue());
	}
	
	@Test
	public void hasKeysMapped() {
		assertEquals(false, map.hasKey("a"));
		assertEquals(false, map.hasKey("n"));
		assertEquals(false, map.hasKey("#"));
		assertEquals(false, map.hasKey("^"));
		assertEquals(false, map.hasKey("j"));
	}
	
	@Test
	public void keyValueRepeatNoteTest() {
		map.setLastMusicCommand("D");
		assertEquals("D5", map.keyValue("else", music)); //retorna uma nota quando else segue uma nota
		map.setLastMusicCommand("K");
		assertEquals("R", map.keyValue("else", music)); //retorna um Rest quando o else segue algo que nao eh uma nota
	}
	
	@Test
	public void keyValueRaiseVolume10Percent() {
		assertEquals(40, music.getVolume().intValue());
		assertEquals(":Controller(7, 44)", map.keyValue("i", music));
		assertEquals(44, music.getVolume().intValue());
		assertEquals(":Controller(7, 48)", map.keyValue("O", music));
		assertEquals(48, music.getVolume().intValue());
	}
	
	@Test
	public void changeInstrumentToHarpsichord() {
		assertEquals(0, music.getInstrument().intValue());
		assertEquals("I6", map.keyValue("!", music));
		assertEquals(6, music.getInstrument().intValue());
	}
	
	@Test
	public void tryToRaiseOctave() {
		assertEquals("5", music.getOctave());
		map.keyValue("?", music);
		assertEquals("6", music.getOctave());
		map.keyValue("?", music); //oitava 7
		map.keyValue("?", music);//oitava 8
		map.keyValue("?", music); //oitava 9
		assertEquals("9", music.getOctave());
		map.keyValue("?", music); //oitava 10
		map.keyValue("?", music); //como nao sobe mais uma oitava volta para a default = 5
		assertEquals("5", music.getOctave());
	}
	
	@Test
	public void changeInstrumentToTubularBells() {
		assertEquals(0, music.getInstrument().intValue());
		assertEquals("I14", map.keyValue("\n", music));
		assertEquals(14, music.getInstrument().intValue());
	}
	
	@Test
	public void changeInstrumentToPanFlute() {
		assertEquals(0, music.getInstrument().intValue());
		assertEquals("I75", map.keyValue(";", music));
		assertEquals(75, music.getInstrument().intValue());
	}
	
	@Test
	public void changeInstrumentToChurchOrgan() {
		assertEquals(0, music.getInstrument().intValue());
		assertEquals("I19", map.keyValue(",", music));
		assertEquals(19, music.getInstrument().intValue());
	}
	
	@Test
	public void changeInstrumentByDigit() {
		assertEquals(0, music.getInstrument().intValue());
		map.setReadDigit('9');
		assertEquals("I9", map.keyValue("digit", music));
		map.setReadDigit('6');
		assertEquals("I15", map.keyValue("digit", music));
	}
}
