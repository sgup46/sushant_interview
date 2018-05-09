package com.ubs.opsit.interviews.helper;

import com.ubs.opsit.interviews.constants.BerlinConstants;

public class BerlinClockHelper{

    /**
     * get the seconds row
     * @param seconds total
     * @return get the seconds row
     */
    public String getSecondsRow(int seconds) {
    	// get the value based on remainder
    	return getRowOutput(seconds%2, BerlinConstants.OFF ,BerlinConstants.YELLOW, 1);
	}
    
    /**
     * get both the hour rows
     * @param hour total
     * @return both the hour rows
     */
    public String getHourRows(int hour) {
    	StringBuilder builder = new StringBuilder();
    	builder.append(getHourRow1(hour)).append(BerlinConstants.NEWLINE_GENERATOR);
    	builder.append(getHourRow2(hour));
    	return builder.toString();
	}
    
    /**
     * get both the minute rows
     * @param minutes total
     * @return both the minute rows
     */
    public String getMinuteRows(int minutes) {
    	StringBuilder builder = new StringBuilder();
    	builder.append(getMinutesRow1(minutes)).append(BerlinConstants.NEWLINE_GENERATOR);
    	builder.append(getMinutesRow2(minutes));
    	return builder.toString();
	}
    
    /**
     * Output for hour row 1
     * @param hour total
     * @return hour row 1 output
     */
    private String getHourRow1(int hour) {
    	return getRowOutput(hour/5, BerlinConstants.RED, BerlinConstants.OFF , 4 );
	}
    
    /**
     * Output for Hour row 2
     * @param hour total
     * @return output for hour row 2
     */
    private String getHourRow2(int hour) {
    	return getRowOutput(hour%5, BerlinConstants.RED ,BerlinConstants.OFF, 4);
	}
    
    /**
     * Output for first minute row
     * @param minutes total
     * @return single first minute row
     */
    private String getMinutesRow1(int minutes) {
		String output = BerlinConstants.BLANK;
		int marker = 0;
		for (int i = 0; i < minutes/5; i++, marker++) {
			if (marker % 3 == 2) {
				output += BerlinConstants.RED;
			} else {
				output += BerlinConstants.YELLOW;
			}
		}
		for (int k = output.length(); k < 11; k++) {
			output += BerlinConstants.OFF;
		}
		return output;
	}
    
    /**
     * Output to get second row of Minutes
     * @param minutes total minutes
     * @return single second row minutes
     */
    private String getMinutesRow2(int minutes) {
    	return getRowOutput(minutes%5, BerlinConstants.YELLOW ,BerlinConstants.OFF, 4);
	}
    
    /**
     * Generic method to get the output
     * @param lightsOn total counts on light to be on
     * @param letterOn Signal
     * @param letterOff signal
     * @param lightsAll total lights in row
     * @return final output row single
     */
    private String getRowOutput(final int lightsOn, String letterOn, String letterOff , int lightsAll) {
        String output = BerlinConstants.BLANK;
		for (int i = 0; i < lightsOn; i++) {
			output += letterOn;
		}
		for (int k = output.length(); k < lightsAll; k++) {
			output += letterOff;
		}
		return output;
	}

}
