package com.ubs.opsit.interviews;

import org.junit.Test;

import static com.ubs.opsit.interviews.FiveMinutes.FIFTY_FIVE;
import static com.ubs.opsit.interviews.FiveMinutes.FIVE;
import static com.ubs.opsit.interviews.FiveMinutes.TWENTY_FIVE;
import static com.ubs.opsit.interviews.FiveMinutes.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

public class FiveMinutesTest {

    @Test
    public void should_return_appropriate_type_for_minutes() throws Exception {
        assertThat(FiveMinutes.fromMinutes(0)).isEqualTo(ZERO);
        assertThat(FiveMinutes.fromMinutes(1)).isEqualTo(ZERO);
        assertThat(FiveMinutes.fromMinutes(5)).isEqualTo(FIVE);
        assertThat(FiveMinutes.fromMinutes(9)).isEqualTo(FIVE);
        assertThat(FiveMinutes.fromMinutes(25)).isEqualTo(TWENTY_FIVE);
        assertThat(FiveMinutes.fromMinutes(28)).isEqualTo(TWENTY_FIVE);
        assertThat(FiveMinutes.fromMinutes(55)).isEqualTo(FIFTY_FIVE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_invalid_minutes() throws Exception {
        FiveMinutes.fromMinutes(70);
    }
}