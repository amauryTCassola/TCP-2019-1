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
	}
	
	

	public Hashtable<String, String> getMusicMap() {
		return musicMap;
	}


	private static String simpleNote(Character charTexto, Music music) {
		String octave = music.getOctave();
		return charTexto + octave;
	}
	
	private String repeatNote(Music music) {
		String musicString = music.getMusicString();
		// TODO: understand and implement this shit
		return null;
	}
	

	public boolean loadMap() {
        return false; //default return action
    }

    public boolean saveMap() {
        return false; //default return action
    }

    private boolean hasKey() {
        return false;  //default return action
    }
    
    private String keyValue() {
    	return "";
    }
    
    
    
}
