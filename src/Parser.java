public class Parser {
	
	MusicMapManager musicMap;
	Music music;
	
	public Parser (MusicMapManager map, Music music) {
		this.musicMap = map;
		this.music = music;
	}
	

    public void buildMusicString(String inputText) {
    	iteratesThroughString(inputText, Constants.SUBSTRING_LENGTH);
    }

    
    public void iteratesThroughString(String inputText, int substringLength) {
    	
    	int lastIterableSubstringIndex = inputText.length() - (substringLength - 1);  
    	int startSubstring = 0;
    	int endSubstring = 0;
    	String substring;
    	
    	for (startSubstring = 0; startSubstring < lastIterableSubstringIndex; startSubstring++){
    		endSubstring = startSubstring + substringLength;
    		substring = inputText.substring(startSubstring, endSubstring); //.substring in java ends with open interval
    		iteratesThroughSubstring(substring);
		}
    	
 	
    	// Deals with remainder substring
    	while (startSubstring != inputText.length()) {
    		substring = inputText.substring(startSubstring, inputText.length());
    		iteratesThroughSubstring(substring);
    		startSubstring++;
    	}
	}
    
    private void iteratesThroughSubstring(String substring) {
    	
    	int endSubstring = substring.length();	
    	String command;
    	
    	while (endSubstring > 0) {
    		command = substring.substring(0, endSubstring);
    		if (tryCommand(command)) 
    			return;
    		else
    			endSubstring--;
    	}
    	
    	if(firstCharIsDigit(substring)) {
    		tryCommand(Constants.DIGIT_COMMAND);
    		return;
    	}
    		
    	else
    		tryCommand(Constants.ELSE_COMMAND);
    	
    }


	private boolean firstCharIsDigit(String substring) {
		Character firstChar = substring.charAt(0);
    	if (Character.isDigit(firstChar)) {
    		musicMap.setReadDigit(firstChar);
    		return true;
    	}
    	else
    		return false;
	}

	private boolean tryCommand(String command) {
    	String musicCommand;
    	
    	if (musicMap.hasKey(command)) { 		
    		musicCommand = musicMap.keyValue(command, music);
    		music.addToMusicString(musicCommand);
    		musicMap.setLastMusicCommand(command);
    		return true;
    	}
    	else
    		return false;
    }
	
}
