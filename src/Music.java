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
    
    public void generateInitialMusicString(Integer volume, Integer bpm, Integer instrument) {
    	
    	setVolume(volume);
		setBPM(bpm);
		setInstrument(instrument);
    	
    	String volumeConfigString = Constants.MUSIC_STRING_SET_VOLUME(volume);
    	String BPMConfigString = Constants.MUSIC_STRING_SET_BPM(bpm);
    	String instrumentConfigString = Constants.MUSIC_STRING_SET_INSTRUMENT(instrument);
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
		
		this.instrument = newInstrumentIndex;
	}    
    
	public String getOctave() {
		return this.octave;
	}

	public void setOctave(String octave) {
		this.octave = octave;
	}
	
    
    
}
