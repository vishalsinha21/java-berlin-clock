package com.ubs.opsit.interviews;

import org.junit.Test;

import static com.ubs.opsit.interviews.Seconds.EVEN;
import static com.ubs.opsit.interviews.Seconds.ODD;
import static org.assertj.core.api.Assertions.assertThat;


public class SecondsTest {

    @Test
    public void should_return_appropriate_type_for_given_seconds() throws Exception {
        assertThat(Seconds.fromSeconds(0)).isEqualTo(EVEN);
        assertThat(Seconds.fromSeconds(20)).isEqualTo(EVEN);
        assertThat(Seconds.fromSeconds(1)).isEqualTo(ODD);
        assertThat(Seconds.fromSeconds(59)).isEqualTo(ODD);
    }

}