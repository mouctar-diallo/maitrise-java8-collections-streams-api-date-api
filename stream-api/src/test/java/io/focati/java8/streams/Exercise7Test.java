package io.focati.java8.streams;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.annotation.Medium;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import io.focati.java8.tools.entity.Shop;
import io.focati.java8.tools.entity.ShopItem;
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

        IntStream ageStream = customerList.stream()
                .mapToInt(Customer::getAge);
        OptionalDouble average = ageStream.average();

        assertThat(average.getAsDouble()).isEqualTo(28.7);
    }

    /**
     * Créer un flux de nombres avec les prix des articles des boutiques
     * Ensuite calculer la somme globale
     */
    @Easy @Test
    void howMuchToBuyAllItems() {
        List<Shop> shopList = ClassicOnlineStore.getData().getShops();

        LongStream priceStream = shopList.stream()
                .flatMapToLong(shop -> shop.getItems().stream()
                .mapToLong(ShopItem::getPrice));
        long priceSum = priceStream.sum();

        assertThat(priceSum).isEqualTo(60930L);
    }
}
