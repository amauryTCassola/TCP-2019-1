public class Music {

    private String musicString = "";
    private String lastMusicCommand = " ";
    
    private Integer volume;
    private Integer BPM;
    private Integer instrument;
    private String octave;
    
    
    // Class constructor
    public Music(Integer volume, Integer BPM, Integer instrument, String octave) {
    	this.volume = volume;
    	this.BPM = BPM;
    	this.instrument = instrument;
    	this.octave = octave;
    }
    
    public static String generateMusicString(Integer volume, Integer BPM, Integer instrument) {
    	// Get the attributes of the textbox of the GUI and generates a musicString
        return "No music string generated"; //default return value
    }

    public String getMusicString() {
        return this.musicString;
    }

    public void setMusicString() {
        this.musicString = generateMusicString(volume, BPM, instrument);
    }
    
    public void addToMusicString(String musicPiece) {
    	if (musicString == "") {
    		this.musicString += musicPiece;
    	}
    	else {
    		this.musicString += " " + musicPiece;
    	}
    }
    
    public Integer getVolume() {
		return this.volume;
	}
	
	public void setVolume(Integer newVolume) {
		this.volume = newVolume;
	}
    
	public Integer getBPM() {
		return this.BPM;
	}
	
	public void setBPM(Integer newBPM) {
		this.BPM = newBPM;
	}
	
	public Integer getInstrument() {
		return this.instrument;
	}
	
	public void setInstrument(Integer newInstrument) {
		this.instrument = newInstrument;
	}    
    
	public String getOctave() {
		return this.octave;
	}

	public void setOctave(String octave) {
		this.octave = octave;
	}

	public String getLastMusicCommand() {
		return lastMusicCommand;
	}

//	public void setLastMusicCommand(String lastMusicCommand) {
//		this.lastMusicCommand = lastMusicCommand;
//	}

	
    
    
}
