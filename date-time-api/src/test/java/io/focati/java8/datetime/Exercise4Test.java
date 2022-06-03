package io.focati.java8.datetime;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.DateAndTimes;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise4Test {

    /**
     * Créer une unité temporelle zone/date/time {@link ZonedDateTime} en utilisant {@link ZonedDateTime#of}
     * avec la valeur 2015-07-10 2:14:25.000 et l'heure normale du Japon
     */
    @Easy @Test
    void zonedDateTimeOf() {
        ZonedDateTime zonedDateTime = null; // A compléter

        assertThat(zonedDateTime.toString()).isEqualTo("2015-07-10T02:14:25+09:00[Asia/Tokyo]");
    }

    /**
     * Créer une unité temporelle zone/date/time {@link ZonedDateTime} en utilisant {@link ZonedDateTime#parse}
     * avec la valeur 2015-06-18 23:07:25.000 et l'heure normale du Japon
     */
    @Easy @Test
    void zonedDateTimeParse() {
        ZonedDateTime zonedDateTime = null; // A compléter

        assertThat(zonedDateTime.toString()).isEqualTo("2015-06-18T23:07:25+09:00[Asia/Tokyo]");
    }

    /**
     * Formatter l'une unité temporelle zone/date/heure #zdt afin d'obtenir la valeur 2015_06_18_23_07_30_JST"
     */
    @Easy @Test
    void zonedDateTimeFormat() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        String strZdt = null; // A compléter

        assertThat(strZdt).isEqualTo("2015_06_18_23_07_30_JST");
    }

    /**
     * Créez une unité temporelle zone/date/heure {@link ZonedDateTime} à l'heure normale du Pacifique à partir de la variable #ldt
     */
    @Easy @Test
    void toPST() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        ZonedDateTime zonedDateTime = null; // A compléter

        assertThat(zonedDateTime.toLocalDateTime()).isEqualTo(ldt);
        assertThat(zonedDateTime.getZone().toString()).isEqualTo("America/Los_Angeles");
    }

    /**
     * Créez une unité temporelle zone/date/heure {@link ZonedDateTime} à l'heure normale du Pacifique à partir de #zdt
     * et qui réflète le même instant
     */
    @Easy @Test
    void sameInstantAs() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        ZonedDateTime zonedDateTime = null; // A compléter

        assertThat(zonedDateTime.toString()).isEqualTo("2015-06-18T07:07:30.500-07:00[America/Los_Angeles]");
    }

    /**
     * Créez une unité temporelle zone/date/heure {@link ZonedDateTime} à l'heure normale du Pacifique à partir de #zdt
     * tout en gardant le même horaire
     */
    @Easy @Test
    void sameLocalAs() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        ZonedDateTime zonedDateTime = null; // A compléter

        assertThat(zonedDateTime.toString()).isEqualTo("2015-06-18T23:07:30.500-07:00[America/Los_Angeles]");
    }
}
