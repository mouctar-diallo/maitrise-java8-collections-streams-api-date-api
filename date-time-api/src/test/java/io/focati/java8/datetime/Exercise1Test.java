package io.focati.java8.datetime;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.DateAndTimes;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise1Test {

    /**
     * Créer une date locale {@link LocalDate} en utilisant {@link LocalDate#of} avec les informations suivantes
     * Jour = 18, Mois = 06, Année = 2022
     */
    @Easy @Test
    void localDateOf() {

        LocalDate localDate = null; // A compléter

        assertThat(localDate.toString()).isEqualTo("2022-06-18");
    }

    /**
     * Créer une date locale {@link LocalDate} en utilisant {@link LocalDate#parse}
     */
    @Easy @Test
    void localDateParse() {

        String date = "2022-06-18";
        LocalDate localDate = null; // A compléter

        assertThat(localDate.toString()).isEqualTo("2022-06-18");
    }

    /**
     * Créer une nouvelle date locale à partir de la variable #ld en changeant l'année à 2022
     */
    @Easy @Test
    void localDateWith() {
        LocalDate ld = DateAndTimes.LD_20150618;

        LocalDate localDate = null; // A compléter

        assertThat(localDate.getYear()).isEqualTo(2022);
        assertThat(localDate.getMonth()).isEqualTo(ld.getMonth());
        assertThat(localDate.getDayOfMonth()).isEqualTo(ld.getDayOfMonth());
    }

    /**
     * Créer une nouvelle date locale à partir de la variable #ld en ajustant la date au premier jour de l'année suivante
     */
    @Easy @Test
    void localDateWithAdjuster() {
        LocalDate ld = DateAndTimes.LD_20150618;

        LocalDate localDate = null; // A compléter

        assertThat(localDate.getYear()).isEqualTo(ld.getYear() + 1);
        assertThat(localDate.getMonth()).isEqualTo(Month.JANUARY);
        assertThat(localDate.getDayOfMonth()).isEqualTo(1);
    }

    /**
     * Créer une nouvelle date locale à partir de la variable #ld avec 10 mois d'avance
     */
    @Easy @Test
    void localDatePlus() {
        LocalDate ld = DateAndTimes.LD_20150618;

        LocalDate localDate = null; // A compléter

        assertThat(localDate.getYear()).isEqualTo(ld.getYear() + 1);
        assertThat(localDate.getMonth()).isEqualTo(Month.APRIL);
        assertThat(localDate.getDayOfMonth()).isEqualTo(ld.getDayOfMonth());
    }

    /**
     * Créer une nouvelle date locale à partir de la variable #ld avec 10 jours de retard
     */
    @Easy @Test
    void localDateMinus() {
        LocalDate ld = DateAndTimes.LD_20150618;

        LocalDate localDate = null; // A compléter

        assertThat(localDate.getYear()).isEqualTo(ld.getYear());
        assertThat(localDate.getMonth()).isEqualTo(ld.getMonth());
        assertThat(localDate.getDayOfMonth()).isEqualTo(ld.getDayOfMonth() - 10);
    }

    /**
     * Définir une période {@link Period} avec les informations suivantes :
     * Jour = 3, Mois = 2, Année = 1
     * Créer une nouvelle date locale à partir de la variable #ld en y ajoutant la période créer précédemment
     */
    @Easy @Test
    void localDatePlusPeriod() {
        LocalDate ld = DateAndTimes.LD_20150618;

        Period period = null; // A compléter
        LocalDate localDate = null; // A compléter

        assertThat(localDate.getYear()).isEqualTo(ld.getYear() + 1);
        assertThat(period.getMonths()).isEqualTo(2);
        assertThat(localDate.getDayOfMonth()).isEqualTo(ld.getDayOfMonth() + 3);
    }

    /**
     * Vérifier si la date #ld se trouve après la date #ld2
     */
    @Easy @Test
    void localDateIsAfter() {
        LocalDate ld = DateAndTimes.LD_20150618;
        LocalDate ld2 = DateAndTimes.LD_20150807;

        boolean isAfter0618 = false; // A modifier

        assertThat(isAfter0618).isTrue();
    }

    /**
     * Créer une période couvrant l'intervalle entre la date #ld et la date #ld2
     */
    @Easy @Test
    void localDateUntil() {
        LocalDate ld = DateAndTimes.LD_20150618;
        LocalDate ld2 = DateAndTimes.LD_20150807;

        Period period = null; // A compléter

        assertThat(period.getYears()).isEqualTo(0);
        assertThat(period.getMonths()).isEqualTo(1);
        assertThat(period.getDays()).isEqualTo(20);
    }
}
