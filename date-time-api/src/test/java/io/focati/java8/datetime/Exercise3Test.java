package io.focati.java8.datetime;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.DateAndTimes;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise3Test {

    /**
     * Créer une unité temporelle date/heure correspondant à la valeur suivante : 2022-06-20 23:07:30 en utilisant {@link LocalDateTime#of}
     */
    @Easy @Test
    void localDateTimeOf() {
        LocalDateTime localDateTime = LocalDateTime
                .of(2022,6,20,23,7,30);

        assertThat(localDateTime.toString()).isEqualTo("2022-06-20T23:07:30");
    }

    /**
     * Créer une unité temporelle date/heure correspondant à la valeur suivante : 2022-06-20 23:07:30 en utilisant {@link LocalDateTime#parse}
     */
    @Easy @Test
    void localDateTimeParse() {
        LocalDateTime localDateTime = LocalDateTime.parse("2022-06-20T23:07:30");

        assertThat(localDateTime.toString()).isEqualTo("2022-06-20T23:07:30");
    }

    /**
     * Créer une unité temporelle date/heure à partir de la variable #ldt en se positionnant au premier jour du mois prochain
     * et en arrondisant les heures
     */
    @Easy @Test
    void localTimeWith() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        LocalDateTime localDateTime = ldt.with(TemporalAdjusters.firstDayOfNextMonth())
                .truncatedTo(ChronoUnit.HOURS);

        assertThat(localDateTime.toString()).isEqualTo("2015-07-01T23:00");
    }

    /**
     * Créer une unité temporelle date/heure à partir de la variable #ldt avec 10 mois d'avance et 5 heures de retard
     */
    @Easy @Test
    void localDatePlusMinus() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        LocalDateTime localDateTime = ldt.plusMonths(10).minusHours(5);

        assertThat(localDateTime.toString()).isEqualTo("2016-04-18T18:07:30.500");
    }

    /**
     * Formatter l'une unité temporelle date/heure #ldt afin d'obtenir la valeur "2015_06_18_23_07_30"
     */
    @Easy @Test
    void localDateTimeFormat() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String strLdt = ldt.format(formatter);

        assertThat(strLdt).isEqualTo("2015_06_18_23_07_30");
    }

    /**
     * Extraire de l' unité de temporelle #ldt la date #localDate et l'horaire #localTime
     */
    @Easy @Test
    void toLocalDateAndTime() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        LocalDate localDate = ldt.toLocalDate();
        LocalTime localTime = ldt.toLocalTime();

        assertThat(localDate.toString()).isEqualTo("2015-06-18");
        assertThat(localTime.toString()).isEqualTo("23:07:30.500");
    }

    /**
     * Construire deux unités temporelles date/heure égales
     * #localDateTime1 à partir de #ld
     * et #localDateTime2 à partir de #lt
     */
    @Easy @Test
    void toLocalDateTime() {
        LocalDate ld = DateAndTimes.LD_20150618;
        LocalTime lt = DateAndTimes.LT_23073050;

        LocalDateTime localDateTime1 = ld.atTime(lt);
        LocalDateTime localDateTime2 = lt.atDate(ld);

        assertThat(localDateTime1.toString()).isEqualTo("2015-06-18T23:07:30.500");
        assertThat(localDateTime1.isEqual(localDateTime2)).isTrue();
    }
}
