package com.ubs.opsit.interviews;

import java.util.stream.Stream;

public enum OneMinutes {

    ZERO(0, "OOOO"),
    ONE(1, "YOOO"),
    TWO(2, "YYOO"),
    THREE(3, "YYYO"),
    FOUR(4, "YYYY");

    OneMinutes(int minutesRemainder, String representation) {
        this.minutesRemainder = minutesRemainder;
        this.representation = representation;
    }

    private int minutesRemainder;
    private String representation;

    public String getRepresentation() {
        return representation;
    }

    public static OneMinutes fromMinutes(int minutes) {
        return Stream.of(OneMinutes.values())
                .filter(oneMinutes -> oneMinutes.minutesRemainder == (minutes % 5))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Valid OneMinutes found for minutes: " + minutes));
    }

}
