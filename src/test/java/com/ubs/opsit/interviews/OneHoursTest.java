package com.ubs.opsit.interviews;

import org.junit.Test;

import static com.ubs.opsit.interviews.OneHours.FOUR;
import static com.ubs.opsit.interviews.OneHours.ONE;
import static com.ubs.opsit.interviews.OneHours.TWO;
import static com.ubs.opsit.interviews.OneHours.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

public class OneHoursTest {

    @Test
    public void should_return_appropriate_type_for_hours() throws Exception {
        assertThat(OneHours.fromHours(0)).isEqualTo(ZERO);
        assertThat(OneHours.fromHours(10)).isEqualTo(ZERO);
        assertThat(OneHours.fromHours(1)).isEqualTo(ONE);
        assertThat(OneHours.fromHours(11)).isEqualTo(ONE);
        assertThat(OneHours.fromHours(2)).isEqualTo(TWO);
        assertThat(OneHours.fromHours(22)).isEqualTo(TWO);
        assertThat(OneHours.fromHours(24)).isEqualTo(FOUR);
    }

}