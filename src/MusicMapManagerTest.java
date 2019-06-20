

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;



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
	

}
