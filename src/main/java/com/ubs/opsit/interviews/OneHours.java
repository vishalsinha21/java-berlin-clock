package com.ubs.opsit.interviews;

import java.util.stream.Stream;

public enum OneHours {

    ZERO(0, "OOOO"),
    ONE(1, "ROOO"),
    TWO(2, "RROO"),
    THREE(3, "RRRO"),
    FOUR(4, "RRRR");

    OneHours(int hoursRemainder, String representation) {
        this.hoursRemainder = hoursRemainder;
        this.representation = representation;
    }

    private int hoursRemainder;
    private String representation;

    public String getRepresentation() {
        return representation;
    }

    public static OneHours fromHours(int hours) {
        return Stream.of(OneHours.values())
                .filter(oneHours -> oneHours.hoursRemainder == (hours % 5))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Valid OneHours found for hours: " + hours));
    }

}
