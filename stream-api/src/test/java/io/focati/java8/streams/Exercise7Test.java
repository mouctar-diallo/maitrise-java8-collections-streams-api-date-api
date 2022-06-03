package io.focati.java8.streams;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.annotation.Medium;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import io.focati.java8.tools.entity.Shop;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise7Test {

    /**
     * Créer un flux d'entier #ageStream à partir des âges des clients
     * Ensuite déterminer la moyenne d'âge
     *
     */
    @Medium @Test
    void averageAge() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        IntStream ageStream = null; // A compléter
        OptionalDouble average = null; // A compléter

        assertThat(average.getAsDouble()).isEqualTo(28.7);
    }

    /**
     * Créer un flux de nombres avec les prix des articles des boutiques
     * Ensuite calculer la somme globale
     */
    @Easy @Test
    void howMuchToBuyAllItems() {
        List<Shop> shopList = ClassicOnlineStore.getData().getShops();

        LongStream priceStream = null;
        long priceSum = 0;

        assertThat(priceSum).isEqualTo(60930L);
    }
}
