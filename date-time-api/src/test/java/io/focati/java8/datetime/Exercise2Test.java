package io.focati.java8.datetime;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.DateAndTimes;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise2Test {

    /**
     * Créer un horaire avec les informations suivantes:
     * Heures = 23, Minutes = 07
     */
    @Easy @Test
    void localTimeOfHourToMinute() {

        LocalTime localTime = null; // A compléter

        assertThat(localTime.toString()).isEqualTo("23:07");
    }

    /**
     * Créer un horaire correspondant à la valeur suivante : 23:07:03.1
     */
    @Easy @Test
    void localTimeOfHourToNanoSec() {

        LocalTime localTime = null; // A compléter

        assertThat(localTime.toString()).isEqualTo("23:07:03.100");
    }

    /**
     * Créer un horaire correspondant à la valeur "23:07:03.1" en utilisant {@link LocalTime#parse}
     */
    @Easy @Test
    void localTimeParse() {

        LocalTime localTime = null; // A compléter

        assertThat(localTime.toString()).isEqualTo("23:07:03.100");
    }

    /**
     * Créer un nouvel horaire à partir de la variable #lt en fixant l'heure à 21
     */
    @Easy @Test
    void localTimeWith() {
        LocalTime lt = DateAndTimes.LT_23073050;

        LocalTime localTime = null; // A compléter

        assertThat(localTime.getHour()).isEqualTo(21);
        assertThat(localTime.getMinute()).isEqualTo(lt.getMinute());
        assertThat(localTime.getSecond()).isEqualTo(lt.getSecond());
    }

    /**
     * Créer un nouvel horaire à partir de la variable #lt avec 30 minutes d'avance
     */
    @Easy @Test
    void localTimePlus() {
        LocalTime lt = DateAndTimes.LT_23073050;

        LocalTime localTime = null; // A compléter

        assertThat(localTime.getHour()).isEqualTo(lt.getHour());
        assertThat(localTime.getMinute()).isEqualTo(lt.getMinute() + 30);
        assertThat(localTime.getSecond()).isEqualTo(lt.getSecond());
    }

    /**
     * Créer un nouvel horaire à partir de la variable #lt avec 3 heures de retard
     */
    @Easy @Test
    void localTimeMinus() {
        LocalTime lt = DateAndTimes.LT_23073050;

        LocalTime localTime = null; // A compléter

        assertThat(localTime.getHour()).isEqualTo(lt.getHour() - 3);
        assertThat(localTime.getMinute()).isEqualTo(lt.getMinute());
        assertThat(localTime.getSecond()).isEqualTo(lt.getSecond());
    }

    /**
     * Définir une duréée {@link Duration} de 3 heures, 30 minutes et 20.2 secondes
     * Créer un nouvel horaire à partir de la variable #lt avec un retard lié à la duréee définie précédemment
     */
    @Easy @Test
    void localTimeMinusDuration() {
        LocalTime lt = DateAndTimes.LT_23073050;

        Duration duration = null; // A compléter
        LocalTime localTime = null; // A compléter

        assertThat(localTime.getHour()).isEqualTo(19);
        assertThat(localTime.getMinute()).isEqualTo(37);
        assertThat(localTime.getSecond()).isEqualTo(10);
        assertThat(localTime.getNano()).isEqualTo(300000000);
        assertThat(duration.getSeconds()).isEqualTo(12620L);
        assertThat(duration.getNano()).isEqualTo(200000000);

    }

    /**
     * Vérifier si l'horaire #lt2 se trouve avant l'horaire #lt
     */
    @Easy @Test
    void localDateIsBefore() {
        LocalTime lt = DateAndTimes.LT_23073050;
        LocalTime lt2 = DateAndTimes.LT_12100000;

        boolean isBefore2307 = false; // A modifier

        assertThat(isBefore2307).isTrue();
    }

    /**
     * Créer un nouvel horaire à partir de la variable #lt et arrondi aux minutes
     */
    @Easy @Test
    void localTimeTruncatedTo() {
        LocalTime lt = DateAndTimes.LT_23073050;

        LocalTime localTime = null; // A compléter

        assertThat(lt.toString()).isEqualTo("23:07:30.500");
        assertThat(localTime.toString()).isEqualTo("23:07");
    }
}
