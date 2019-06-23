public class Music {

    private String musicString = "";
    
    private Integer volume;
    private Integer BPM;
    private Integer instrument;
    private String octave;
    
    
    public Music(Integer volume, Integer BPM, Integer instrument, String octave) {
    	this.volume = volume;
    	this.BPM = BPM;
    	this.instrument = instrument;
    	this.octave = octave;
    }
    
    public void generateInitialMusicString() {
    	
    	String volumeConfigString = ":Controller(7,"+this.volume+")";
    	String BPMConfigString = "T"+this.BPM;
    	String instrumentConfigString = "I"+this.instrument;
        this.musicString = volumeConfigString + " " + BPMConfigString + " " + instrumentConfigString;
    }

    public String getMusicString() {
        return musicString;
    }

    public void setMusicString(String newMusicString) {
        this.musicString = newMusicString;
    }
    
    public void addToMusicString(String musicPiece) {
    	if (musicString == Constants.EMPTY_STRING || musicPiece == Constants.EMPTY_STRING) {
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
	
	public void setInstrument(Integer newInstrumentIndex) {
		this.instrument = Constants.INSTRUMENTS_MAP.get(newInstrumentIndex);
	}    
    
	public String getOctave() {
		return this.octave;
	}

	public void setOctave(String octave) {
		this.octave = octave;
	}
	
    
    
}
