package com.ubs.opsit.interviews;

import java.util.stream.Stream;

public enum FiveMinutes {

    ZERO(0, "OOOOOOOOOOO"),
    FIVE(1, "YOOOOOOOOOO"),
    TEN(2, "YYOOOOOOOOO"),
    FIFTEEN(3, "YYROOOOOOOO"),
    TWENTY(4, "YYRYOOOOOOO"),
    TWENTY_FIVE(5, "YYRYYOOOOOO"),
    THIRTY(6, "YYRYYROOOOO"),
    THIRTY_FIVE(7, "YYRYYRYOOOO"),
    FORTY(8, "YYRYYRYYOOO"),
    FORTY_FIVE(9, "YYRYYRYYROO"),
    FIFTY(10, "YYRYYRYYRYO"),
    FIFTY_FIVE(11, "YYRYYRYYRYY");

    FiveMinutes(int minutesInMultipleOf5, String representation) {
        this.minutesInMultipleOf5 = minutesInMultipleOf5;
        this.representation = representation;
    }

    private int minutesInMultipleOf5;
    private String representation;

    public String getRepresentation() {
        return representation;
    }

    public static FiveMinutes fromMinutes(int minutes) {
        return Stream.of(FiveMinutes.values())
                .filter(fiveMinutes -> fiveMinutes.minutesInMultipleOf5 == (minutes / 5))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Valid FiveMinutes found for minutes: " + minutes));
    }

}
