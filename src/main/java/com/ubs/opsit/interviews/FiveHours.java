package com.ubs.opsit.interviews;

import java.util.stream.Stream;

public enum FiveHours {

    ZERO(0, "OOOO"),
    FIVE(1, "ROOO"),
    TEN(2, "RROO"),
    FIFTEEN(3, "RRRO"),
    TWENTY(4, "RRRR");

    FiveHours(int hoursInMultipleOf5, String representation) {
        this.hoursInMultipleOf5 = hoursInMultipleOf5;
        this.representation = representation;
    }

    private int hoursInMultipleOf5;
    private String representation;

    public String getRepresentation() {
        return representation;
    }

    public static FiveHours fromHours(int hours) {
        return Stream.of(FiveHours.values())
                .filter(fiveHours -> fiveHours.hoursInMultipleOf5 == (hours / 5))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Valid FiveHours found for hours: " + hours));
    }

}
