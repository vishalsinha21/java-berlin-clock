package com.ubs.opsit.interviews;

import java.util.stream.Stream;

public enum Seconds {

    EVEN(0, "Y"),
    ODD(1, "O");

    Seconds(int secondsRemainder, String representation) {
        this.secondsRemainder = secondsRemainder;
        this.representation = representation;
    }

    private int secondsRemainder;
    private String representation;

    public String getRepresentation() {
        return representation;
    }

    public static Seconds fromSeconds(int seconds) {
        return Stream.of(Seconds.values())
                .filter(sec -> sec.secondsRemainder == (seconds % 2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Valid Seconds type found for seconds value: " + seconds));
    }
}
