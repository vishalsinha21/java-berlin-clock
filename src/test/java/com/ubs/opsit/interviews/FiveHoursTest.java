package com.ubs.opsit.interviews;

import org.junit.Test;

import static com.ubs.opsit.interviews.FiveHours.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FiveHoursTest {

    @Test
    public void should_return_appropriate_type_for_given_hours() throws Exception {
        assertThat(FiveHours.fromHours(0)).isEqualTo(ZERO);
        assertThat(FiveHours.fromHours(3)).isEqualTo(ZERO);
        assertThat(FiveHours.fromHours(7)).isEqualTo(FIVE);
        assertThat(FiveHours.fromHours(12)).isEqualTo(TEN);
        assertThat(FiveHours.fromHours(15)).isEqualTo(FIFTEEN);
        assertThat(FiveHours.fromHours(20)).isEqualTo(TWENTY);
        assertThat(FiveHours.fromHours(24)).isEqualTo(TWENTY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_invalid_hours() throws Exception {
        FiveHours.fromHours(50);
    }
}