import java.util.Hashtable;
import java.util.List;


public class MusicMapManager {
	private Hashtable<String, MusicCommand> musicMap = new Hashtable<String, MusicCommand>();
	private String lastMusicCommand = "";
	
	public MusicMapManager(){
		
		// Default notes
		musicMap.put("A", new SimpleNote('A'));
		musicMap.put("B",new SimpleNote('B'));
		musicMap.put("C",new SimpleNote('C'));
		musicMap.put("D",new SimpleNote('D'));
		musicMap.put("E",new SimpleNote('E'));
		musicMap.put("F",new SimpleNote('F'));
		musicMap.put("G",new SimpleNote('G'));
		
		// Note repeat or Pause
//		musicMap.put("a", new RepeatNote());
//		musicMap.put("b", new RepeatNote());
//		musicMap.put("c", new RepeatNote());
//		musicMap.put("d", new RepeatNote());
//		musicMap.put("e", new RepeatNote());
//		musicMap.put("f", new RepeatNote());
//		musicMap.put("g", new RepeatNote());
		musicMap.put("else", new RepeatNote());
		
		musicMap.put(" ", new DoublesVolume());
		
		musicMap.put("!", new ChangeInstrumentToHarpsichord());
		musicMap.put("\n", new ChangeInstrumentToTubularBells());
		musicMap.put(";", new ChangeInstrumentToPanFlute());
		musicMap.put(",", new ChangeInstrumentToChurchOrgan());
		
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
	
	
	class RepeatNote implements MusicCommand {
		
		public String command(Music music) {
			if (isNote(lastMusicCommand)) 
				return lastMusicCommand + music.getOctave();
			
			else
				return Constants.MUSIC_PAUSE;	
		}

		private boolean isNote(String lastMusicCommand) {
			//Character firstCharMusicCommand = lastMusicCommand.charAt(0);
			if (Constants.NOTES.contains(lastMusicCommand))
				return true;
			else
				return false;
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
	
	
	class ChangeInstrumentToTubularBells implements MusicCommand {
		
		public String command(Music music) {
			music.setInstrument(14);
			return "I14";
		}
	}
	
	
	class ChangeInstrumentToPanFlute implements MusicCommand {
		
		public String command(Music music) {
			music.setInstrument(75);
			return "I75";
		}
	}
	
	
	class ChangeInstrumentToChurchOrgan implements MusicCommand {
		
		public String command(Music music) {
			music.setInstrument(19);
			return "I19";
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
    
    public void setLastMusicCommand(String lastMusicCommand) {
		this.lastMusicCommand = lastMusicCommand;
	}
    
    public Hashtable<String, MusicCommand> getMusicMap() {
		return musicMap;
	}
}
