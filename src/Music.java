public class Music {

    private String musicString;
    
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
        return musicString;
    }

    public void setMusicString() {
        musicString = generateMusicString(volume, BPM, instrument);
    }

	public String getOctave() {
		return octave;
	}

	public void setOctave(String octave) {
		this.octave = octave;
	}
    
    
    
}
