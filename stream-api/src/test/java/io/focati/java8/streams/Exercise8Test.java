package io.focati.java8.streams;


import io.focati.java8.tools.annotation.Difficult;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import io.focati.java8.tools.entity.CustomerItem;
import io.focati.java8.tools.entity.Shop;
import io.focati.java8.tools.entity.ShopItem;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise8Test {

    /**
     * Créer une liste de noms d'articles distincts des clients n'existant dans aucune boutique
     */
    @Difficult @Test
    void itemsNotOnSale() {
        Stream<Customer> customerStream = ClassicOnlineStore.getData().getCustomers().stream();
        Stream<Shop> shopStream = ClassicOnlineStore.getData().getShops().stream();

        List<String> itemListOnSale = shopStream.flatMap(shop -> shop.getItems()
                .stream().map(ShopItem::getName))
                .collect(Collectors.toList());

        Set<String> itemSetNotOnSale = customerStream.flatMap(customer -> customer.getItems().stream()
                .filter(customerItem -> !itemListOnSale.contains(customerItem.getName())))
                .map(CustomerItem::getName)
                .collect(Collectors.toSet());


        assertThat(itemSetNotOnSale).hasSize(3)
                .containsExactlyInAnyOrder("bag", "pants", "coat");
    }

    /**
     * Créer une liste de noms de clients ayant assez d'argent pour payer tous les articles qu'ils désirent et qui sont en vente.
     * Attention les articles des boutiques ayant un montant à 0 ne sont pas en vente.
     * Si un article en boutique à plusieurs prix, le client choisira le moins cher.
     */
    @Difficult @Test
    void havingEnoughMoney() {
        Stream<Customer> customerStream = ClassicOnlineStore.getData().getCustomers().stream();
        Stream<Shop> shopStream = ClassicOnlineStore.getData().getShops().stream();

        List<ShopItem> onSale = shopStream.flatMap(shop -> shop.getItems()
                .stream().filter(shopItem -> shopItem.getPrice() > 0))
                .collect(Collectors.toList());

        Predicate<Customer> havingEnoughMoney = customer -> customer.getBudget() >= customer.getItems()
                .stream()
                .mapToInt(customerItem -> onSale.stream()
                .filter(shopItem -> shopItem.getName().equals(customerItem.getName()))
                        .min(Comparator.comparing(ShopItem::getPrice))
                        .map(ShopItem::getPrice).orElse(0))
                .sum();

        List<String> customerNameList = customerStream
                .filter(havingEnoughMoney)
                .map(Customer::getName)
                .collect(Collectors.toList());

        assertThat(customerNameList).hasSize(7)
            .containsExactlyInAnyOrder("Joe", "Patrick", "Chris", "Kathy", "Alice", "Andrew", "Amy");
    }
}
