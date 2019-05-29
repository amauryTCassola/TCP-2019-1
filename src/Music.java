public class Music {

    private String musicString;
    //Initial configs - these vars are set by their values in the GUI
    private Integer volume;
    private Integer BPM;
    private Integer instrument;

    public static String generateMusicString(Integer volume, Integer BPM, Integer instrument) {
        //Pega os atributos das devidas textbox da GUI e gera uma music string
        return "No music string generated"; //default return value
    }

    public String getMusicString() {
        return musicString;
    }

    public void setMusicString() {
        musicString = generateMusicString(volume, BPM, instrument);
    }
}
