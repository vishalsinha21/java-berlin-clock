package com.ubs.opsit.interviews;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class BerlinClock implements TimeConverter {

    private Seconds secondsRow;
    private FiveHours fiveHourRow;
    private OneHours oneHourRow;
    private FiveMinutes fiveMinuteRow;
    private OneMinutes oneMinuteRow;

    @Override
    public String convertTime(String aTime) {
        requireNonNull(aTime);

        String[] timeArray = aTime.split(":");
        int hours = Integer.valueOf(timeArray[0]);
        int minutes = Integer.valueOf(timeArray[1]);
        int seconds = Integer.valueOf(timeArray[2]);

        secondsRow = Seconds.fromSeconds(seconds);
        fiveHourRow = FiveHours.fromHours(hours);
        oneHourRow = OneHours.fromHours(hours);
        fiveMinuteRow = FiveMinutes.fromMinutes(minutes);
        oneMinuteRow = OneMinutes.fromMinutes(minutes);

        return format("%s\n%s\n%s\n%s\n%s",
                secondsRow.getRepresentation(),
                fiveHourRow.getRepresentation(),
                oneHourRow.getRepresentation(),
                fiveMinuteRow.getRepresentation(),
                oneMinuteRow.getRepresentation());
    }

}
