package com.ubs.opsit.interviews;

import org.junit.Test;

import static com.ubs.opsit.interviews.OneMinutes.FOUR;
import static com.ubs.opsit.interviews.OneMinutes.ONE;
import static com.ubs.opsit.interviews.OneMinutes.THREE;
import static com.ubs.opsit.interviews.OneMinutes.TWO;
import static com.ubs.opsit.interviews.OneMinutes.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

public class OneMinutesTest {

    @Test
    public void should_return_appropriate_type_for_minutes() throws Exception {
        assertThat(OneMinutes.fromMinutes(0)).isEqualTo(ZERO);
        assertThat(OneMinutes.fromMinutes(5)).isEqualTo(ZERO);
        assertThat(OneMinutes.fromMinutes(1)).isEqualTo(ONE);
        assertThat(OneMinutes.fromMinutes(51)).isEqualTo(ONE);
        assertThat(OneMinutes.fromMinutes(2)).isEqualTo(TWO);
        assertThat(OneMinutes.fromMinutes(22)).isEqualTo(TWO);
        assertThat(OneMinutes.fromMinutes(3)).isEqualTo(THREE);
        assertThat(OneMinutes.fromMinutes(43)).isEqualTo(THREE);
        assertThat(OneMinutes.fromMinutes(4)).isEqualTo(FOUR);
        assertThat(OneMinutes.fromMinutes(54)).isEqualTo(FOUR);
    }

}