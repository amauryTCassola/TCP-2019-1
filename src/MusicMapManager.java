import java.util.Hashtable;


public class MusicMapManager {
	private Hashtable<String, MusicCommand> musicMap = new Hashtable<String, MusicCommand>();
	
	public MusicMapManager(){
		
		// Default notes
		musicMap.put("A", new SimpleNote('A'));
		musicMap.put("B",new SimpleNote('B'));
		musicMap.put("C",new SimpleNote('C'));
		musicMap.put("D",new SimpleNote('D'));
		musicMap.put("E",new SimpleNote('E'));
		musicMap.put("F",new SimpleNote('F'));
		musicMap.put("G",new SimpleNote('G'));
		
		// Note repeat / Pause
		/*
		 * TODO: IMPLEMENT THIS REPEAT NOTE CLASS
		 * musicMap.put("a",repeatNote(music));
		musicMap.put("b",repeatNote(music));
		musicMap.put("c",repeatNote(music));
		musicMap.put("d",repeatNote(music));
		musicMap.put("e",repeatNote(music));
		musicMap.put("f",repeatNote(music));
		musicMap.put("g",repeatNote(music));*/
		
		musicMap.put(" ", new DoublesVolume());
		
		musicMap.put("!", new ChangeInstrumentToHarpsichord());
		
		musicMap.put("O", new TurnUpVolumeTenPerCent());
		musicMap.put("o", new TurnUpVolumeTenPerCent());
		musicMap.put("I", new TurnUpVolumeTenPerCent());
		musicMap.put("i", new TurnUpVolumeTenPerCent());
		musicMap.put("U", new TurnUpVolumeTenPerCent());
		musicMap.put("u", new TurnUpVolumeTenPerCent());
		
		// TODO the rest of the mapping
		
		
	}
	
	
	interface MusicCommand { 
	    String command(Music music);
	} 
	
	
	class SimpleNote implements MusicCommand {
		private char note;
		
		public SimpleNote(char note){
			this.note = note;
		}	
		public String command(Music music) {
			String octave = music.getOctave();
			return this.note + octave;
		}
	}

	
	class DoublesVolume implements MusicCommand {
		
		public String command(Music music) {
			Integer volume = music.getVolume();
			Integer newDoubledVolume = volume * 2;
			newDoubledVolume = ifTooBigGetMaxVolume(newDoubledVolume);
			music.setVolume(newDoubledVolume);
			return String.format(":Controller(7, %d)", newDoubledVolume);
		}
	}
	
	
	class ChangeInstrumentToHarpsichord implements MusicCommand {
		
		public String command(Music music) {
			music.setInstrument(6);
			return "I6";
		}
	}
	
	
	class TurnUpVolumeTenPerCent implements MusicCommand {
		
		public String command(Music music) {
			Integer volume = music.getVolume();
			Integer newVolume = integerValueForNewVolume(volume);
			newVolume = ifTooBigGetMaxVolume(newVolume);
			music.setVolume(newVolume);
			return String.format(":Controller(7, %d)", newVolume);
		}
	}
	


	private int integerValueForNewVolume(Integer volume) {
		return (int) Math.round(volume * 1.1);
	}

	
	private Integer ifTooBigGetMaxVolume(Integer volume) {
		if (volume > Constants.MAX_VOLUME)
			return Constants.MAX_VOLUME;
		else return volume;
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
    
    public String keyValue(String key, Music music) {
    	return musicMap.get(key).command(music);
    }
    
    public Hashtable<String, MusicCommand> getMusicMap() {
		return musicMap;
	}
}
