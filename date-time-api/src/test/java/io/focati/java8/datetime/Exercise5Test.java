package io.focati.java8.datetime;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.DateAndTimes;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise5Test {

    /**
     * Créer une unité temporelle {@link Timestamp} à partir de #ldt
     */
    @Easy @Test
    void localDateTime2Timestamp() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        Timestamp timestamp = Timestamp.valueOf(ldt);

        assertThat(timestamp.toString()).isEqualTo("2015-06-18 23:07:30.5");
    }

    /**
     * Créer une unité temporelle {@link Date} à partir de #ld
     */
    @Easy @Test
    void localDate2date() {
        LocalDate ld = DateAndTimes.LD_20150618;

        Date date = Date.valueOf(ld);

        assertThat(date.toString()).isEqualTo("2015-06-18");
    }

    /**
     * Créer une unité temporelle {@link LocalDateTime} à partir de #timestamp
     */
    @Easy @Test
    void timestamp2LocalDateTime() {
        Timestamp timestamp = DateAndTimes.OLD_TIMESTAMP_20150618_23073050;

        LocalDateTime localDateTime = timestamp.toLocalDateTime();

        assertThat(localDateTime.toString()).isEqualTo("2015-06-18T23:07:30.500");
    }

    /**
     * Créer une unité temporelle {@link LocalDate} à partir de #date
     */
    @Easy @Test
    void date2LocalDate() {
        Date date = DateAndTimes.OLD_DATE_20150618;

        LocalDate localDate = date.toLocalDate();

        assertThat(localDate.toString()).isEqualTo("2015-06-18");
    }
}
