import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;


public class Constants {
	
	
	// Music default configurations
	public static final Integer VOLUME_DEFAULT = 40;
	public static final Integer BPM_DEFAULT = 120;
	public static final Integer BPM_MAX = 220;
	public static final Integer BPM_MIN = 1;
	public static final Integer INSTRUMENT_DEFAULT = 0;
	public static final String OCTAVE_DEFAULT = "5";
	
	public static final Character ZERO_CHAR = '0';
	
	public static final String MUSIC_PAUSE = "R";
	public static final List<String> NOTES = (Arrays.asList(
					"A", "B", "C", "D", "E", "F", "G"
					));
	public static final Integer MAX_OCTAVE = 10;
	public static final Integer MAX_VOLUME = 127;
	public static final Integer MAX_INSTRUMENT = 127;
	
	public static final String ELSE_COMMAND = "else";
	public static final String DIGIT_COMMAND = "digit";
	
	public static final String EMPTY_STRING = "";
	
	public static final Integer SUBSTRING_LENGTH = 2;
	
	public static final Integer PIANO_NUMBER = 0;
	public static final Integer HARPSICHORD_NUMBER = 6;
	public static final Integer TUBULAR_BELLS_NUMBER = 14;
	public static final Integer CHURCH_ORGAN_NUMBER = 19;
	public static final Integer GUITAR_NUMBER = 24;
	public static final Integer VIOLIN_NUMBER = 40;
	public static final Integer TRUMPET_NUMBER = 56;
	public static final Integer FLUTE_NUMBER = 73;
	public static final Integer PAN_FLUTE_NUMBER = 75;
	
	
	
	public static final String[] INSTRUMENT_LIST = 
			 {
					"#0   Piano", 
					"#1   Guitar",
					"#2   Violin",
					"#3   Trumpet",
					"#4   Flute"
			 };
	public static HashMap<Integer, Integer> INSTRUMENTS_MAP = new HashMap<Integer, Integer>() {
		{
			put(0, PIANO_NUMBER);
			put(1, GUITAR_NUMBER);
			put(2, VIOLIN_NUMBER);
			put(3, TRUMPET_NUMBER);
			put(4, FLUTE_NUMBER);
		}
	};
	
	
	public static final String ABOUT_TEXT = "Musify is a program coded by the GitHub users:"
			+ "<br>@amauryTCassola, @colombelli, @Rafaelfferreira"
			+ "<br>Its purpose is to generate a music given an inputted text."
			+ "<br><br>It is very simple and intuitive to use: first, type or load a text into the"
			+ " first text box; then, chose the inital configs (Instrument, BPM and Volume) and"
			+ " click on the Generate! button; finally, press play to listen to the generated music"
			+ " and, if wanted, you can save it using the File menu."
			+ "<br><br>Have fun!";
	
	public static final String FORMATTED_TEXT = 
			String.format("<html><div align=\"justify\" WIDTH=%d>%s</div></html>", 290, ABOUT_TEXT);
	
	public static final int STANDARD_BUTTON_HEIGHT = 65;
	public static final int STANDARD_BUTTON_WIDTH = 65;
	public static final int STANDARD_TEXTAREA_COLUMNS_COUNT = 32;
	public static final int STANDARD_TEXTAREA_ROWS_COUNT = 5;
	public static final Color COLOR_WHITE = new Color(1.0f, 1.0f, 1.0f);
	public static final Color COLOR_GRAY = new Color(0.5f, 0.5f, 0.5f);
	
}
