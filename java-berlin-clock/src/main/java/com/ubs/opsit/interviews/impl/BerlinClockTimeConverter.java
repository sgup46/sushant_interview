package com.ubs.opsit.interviews.impl;
import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.constants.BerlinConstants;
import com.ubs.opsit.interviews.helper.BerlinClockHelper;

public class BerlinClockTimeConverter implements TimeConverter{

    @Override
    public String convertTime(String aTime) {
        
    	// validation 
    	if (aTime ==null || !aTime.matches(BerlinConstants.TIME_PATTERN)) {
            throw new IllegalArgumentException(BerlinConstants.TIME_VALIDATION_MESSAGE);
        }

        StringBuilder timeSB = new StringBuilder();
        String[] timeElements = aTime.split(":");
        
        BerlinClockHelper helper = new BerlinClockHelper();
        
        timeSB.append(helper.getSecondsRow(Integer.parseInt(timeElements[2]))).append(BerlinConstants.NEWLINE_GENERATOR);
        timeSB.append(helper.getHourRows(Integer.parseInt(timeElements[0]))).append(BerlinConstants.NEWLINE_GENERATOR);
        timeSB.append(helper.getMinuteRows(Integer.parseInt(timeElements[1])));
        
        return timeSB.toString();
	}

}
