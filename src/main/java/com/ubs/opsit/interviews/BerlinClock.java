package com.ubs.opsit.interviews;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.join;
import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

public class BerlinClock implements TimeConverter {

    private final String NEW_LINE = "\n";
    private final String NO_SPACE = "";
    private final String OFF_LAMP = "O";
    private final String RED_LAMP = "R";
    private final String YELLOW_LAMP = "Y";

    private String secondsRow;
    private String hoursTopRow;
    private String hoursBottomRow;
    private String minutesTopRow;
    private String minutesBottomRow;

    @Override
    public String convertTime(String aTime) {
        requireNonNull(aTime);

        String[] timeArray = aTime.split(":");
        int hours = Integer.valueOf(timeArray[0]);
        int minutes = Integer.valueOf(timeArray[1]);
        int seconds = Integer.valueOf(timeArray[2]);

        secondsRow = seconds % 2 == 0 ? YELLOW_LAMP : OFF_LAMP;
        hoursTopRow = getOnOffString(4, hours / 5, RED_LAMP);
        hoursBottomRow = getOnOffString(4, hours % 5, RED_LAMP);
        minutesTopRow = getOnOffString(11, minutes / 5, YELLOW_LAMP).replaceAll("YYY", "YYR");
        minutesBottomRow = getOnOffString(4, minutes % 5, YELLOW_LAMP);

        return join(NEW_LINE, asList(secondsRow, hoursTopRow, hoursBottomRow, minutesTopRow, minutesBottomRow));
    }

    private String getOnOffString(int totalLamp, int litLamps, String litLampFormat) {
        List<String> arr = IntStream.range(0, totalLamp)
                .mapToObj(i -> (i < litLamps) ? litLampFormat : OFF_LAMP)
                .collect(Collectors.toList());
        return String.join(NO_SPACE, arr);
    }

}
