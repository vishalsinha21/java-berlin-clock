package com.ubs.opsit.interviews;

import static java.lang.String.format;

public class BerlinClock implements TimeConverter {

    private String secondsLamp = "O";
    private String fiveHourRow = "OOOO";
    private String oneHourRow = "OOOO";
    private String fiveMinuteRow = "OOOOOOOOOOO";
    private String oneMinuteRow = "OOOO";

    @Override
    public String convertTime(String aTime) {
        String[] timeArray = aTime.split(":");
        int hours = Integer.valueOf(timeArray[0]);
        int minutes = Integer.valueOf(timeArray[1]);
        int seconds = Integer.valueOf(timeArray[2]);

        secondsLamp = getSecondsLamp(seconds);

        int hoursAsMultipleOf5 = hours / 5;
        fiveHourRow = getHourRow(hoursAsMultipleOf5);

        int remainderHours = hours % 5;
        oneHourRow = getHourRow(remainderHours);

        int minutesAsMultipleOf5 = minutes / 5;
        fiveMinuteRow = getFiveMinuteRow(minutesAsMultipleOf5);

        int remainderMinutes = minutes % 5;
        oneMinuteRow = getOneMinuteRow(remainderMinutes);

        return format("%s\n%s\n%s\n%s\n%s", secondsLamp, fiveHourRow, oneHourRow, fiveMinuteRow, oneMinuteRow);
    }

    private String getOneMinuteRow(int remainderMinutes) {
        String oneMinuteRow;
        switch (remainderMinutes) {
            case 0:
                oneMinuteRow = "OOOO";
                break;
            case 1:
                oneMinuteRow = "YOOO";
                break;
            case 2:
                oneMinuteRow = "YYOO";
                break;
            case 3:
                oneMinuteRow = "YYYO";
                break;
            case 4:
                oneMinuteRow = "YYYY";
                break;
            default:
                oneMinuteRow = "OOOO";
        }

        return oneMinuteRow;

    }

    private String getFiveMinuteRow(int minutesAsMultipleOf5) {
        String fiveMinuteRow;
        switch (minutesAsMultipleOf5) {
            case 0:
                fiveMinuteRow = "OOOOOOOOOOO";
                break;
            case 1:
                fiveMinuteRow = "YOOOOOOOOOO";
                break;
            case 2:
                fiveMinuteRow = "YYOOOOOOOOO";
                break;
            case 3:
                fiveMinuteRow = "YYROOOOOOOO";
                break;
            case 4:
                fiveMinuteRow = "YYRYOOOOOOO";
                break;
            case 5:
                fiveMinuteRow = "YYRYYOOOOOO";
                break;
            case 6:
                fiveMinuteRow = "YYRYYROOOOO";
                break;
            case 7:
                fiveMinuteRow = "YYRYYRYOOOO";
                break;
            case 8:
                fiveMinuteRow = "YYRYYRYYOOO";
                break;
            case 9:
                fiveMinuteRow = "YYRYYRYYROO";
                break;
            case 10:
                fiveMinuteRow = "YYRYYRYYRYO";
                break;
            case 11:
                fiveMinuteRow = "YYRYYRYYRYY";
                break;
            default:
                fiveMinuteRow = "OOOOOOOOOOO";
        }

        return fiveMinuteRow;
    }

    private String getHourRow(int hourFactor) {
        String hourRow;
        switch (hourFactor) {
            case 0:
                hourRow = "OOOO";
                break;
            case 1:
                hourRow = "ROOO";
                break;
            case 2:
                hourRow = "RROO";
                break;
            case 3:
                hourRow = "RRRO";
                break;
            case 4:
                hourRow = "RRRR";
                break;
            default:
                hourRow = "OOOO";
        }

        return hourRow;
    }

    private String getSecondsLamp(int seconds) {
        return seconds % 2 == 0 ? "Y" : "O";
    }

}
