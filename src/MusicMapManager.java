import java.util.Hashtable;


public class MusicMapManager {
	private Hashtable<String, String> musicMap = new Hashtable<String, String>();
	
	public MusicMapManager(Music music){
		
		// Default notes
		musicMap.put("A",simpleNote('A', music));
		musicMap.put("B",simpleNote('B', music));
		musicMap.put("C",simpleNote('C', music));
		musicMap.put("D",simpleNote('D', music));
		musicMap.put("E",simpleNote('E', music));
		musicMap.put("F",simpleNote('F', music));
		musicMap.put("G",simpleNote('G', music));
		
		// Note repeat / Pause
		musicMap.put("a",repeatNote(music));
		musicMap.put("b",repeatNote(music));
		musicMap.put("c",repeatNote(music));
		musicMap.put("d",repeatNote(music));
		musicMap.put("e",repeatNote(music));
		musicMap.put("f",repeatNote(music));
		musicMap.put("g",repeatNote(music));
		
		musicMap.put(" ", doublesVolume(music));
		
		musicMap.put("!", changeInstrumentToHarpsichord(music));
		
		musicMap.put("O", turnUpVolumeTenPerCent(music));
		musicMap.put("o", turnUpVolumeTenPerCent(music));
		musicMap.put("I", turnUpVolumeTenPerCent(music));
		musicMap.put("i", turnUpVolumeTenPerCent(music));
		musicMap.put("U", turnUpVolumeTenPerCent(music));
		musicMap.put("u", turnUpVolumeTenPerCent(music));
		
		// TODO the rest of the mapping
		
		musicMap.put("!", changeInstrumentToHarpsichord(music));
		
	}
	

	private String turnUpVolumeTenPerCent(Music music) {
		Integer volume = music.getVolume();
		Integer newVolume = integerValueForNewVolume(volume);
		newVolume = ifTooBigGetMaxVolume(newVolume);
		music.setVolume(newVolume);
		return String.format(":Controller(7, %d)", newVolume);
	}


	private int integerValueForNewVolume(Integer volume) {
		return (int) Math.round(volume * 1.1);
	}


	private String changeInstrumentToHarpsichord(Music music) {
		music.setInstrument(6);
		return "I6";
	}


	private String doublesVolume(Music music) {
		Integer volume = music.getVolume();
		Integer newDoubledVolume = volume * 2;
		newDoubledVolume = ifTooBigGetMaxVolume(newDoubledVolume);
		music.setVolume(newDoubledVolume);
		return String.format(":Controller(7, %d)", newDoubledVolume);
	}
	
	
	private Integer ifTooBigGetMaxVolume(Integer volume) {
		if (volume > Constants.MAX_VOLUME)
			return Constants.MAX_VOLUME;
		else return volume;
	}


	private static String simpleNote(Character note, Music music) {
		String octave = music.getOctave();
		return note + octave;
	}
	
	
	private static String repeatNote(Music music) {
		String musicString = music.getMusicString();
		// TODO: ask professor if a repeat any notes or only A notes
		return "";
	}
	

	public boolean loadMap() {
		// TODO: implement this thing - we really want it?
        return false;
    }

    public boolean saveMap() {
    	// TODO: implement this thing - we really want it?
    	return false;
    }

    public boolean hasKey(String key) {
        return musicMap.containsKey(key);
    }
    
    public String keyValue(String key) {
    	return musicMap.get(key);
    }
    
    public Hashtable<String, String> getMusicMap() {
		return musicMap;
	}
}
