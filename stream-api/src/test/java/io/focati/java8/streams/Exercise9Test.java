package io.focati.java8.streams;

import io.focati.java8.tools.annotation.Difficult;
import io.focati.java8.tools.annotation.Medium;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import io.focati.java8.tools.entity.CustomerItem;
import io.focati.java8.tools.utils.CollectorImpl;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise9Test {

    /**
     * Implémenter un nouvel opérateur {@link Collector} qui permet de créer une chaîne de caractère au format csv à partir d'une liste
     * Ce nouveau opérateur sera utiliser en mode itératif et non parallèle.
     */
    @Medium @Test
    void simplestStringJoin() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Supplier<StringJoiner> supplier = () -> new StringJoiner(",");
        BiConsumer<StringJoiner, String> accumulator = StringJoiner::add;
        BinaryOperator<StringJoiner> combiner = null; // A compléter
        Function<StringJoiner, String> finisher = StringJoiner::toString;

        Collector<String, ?, String> toCsv =
            new CollectorImpl<>(supplier, accumulator, combiner, finisher, Collections.emptySet());
        String nameAsCsv = customerList.stream().map(Customer::getName).collect(toCsv);
        assertThat(nameAsCsv).isEqualTo("Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy");
    }

    /**
     * Implémenter un nouvel opérateur {@link Collector} qui permet de créer une Map avec comme clé le nom d'article
     * et comme valeur une liste distincte des clients voulant acheté cet article
     * Ce nouveau opérateur sera utiliser en mode parallèle.
     */
    @Difficult @Test
    void mapKeyedByItems() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Supplier<Map<String, Set<String>>> supplier = HashMap::new;
        BiConsumer<Map<String, Set<String>>, Customer> accumulator = (mapper, custumer) -> {
            //recuperons les articles a vendre
            List<String> itemsOnSale = custumer.getItems().stream()
                    .map(CustomerItem::getName)
                    .collect(Collectors.toList());
            //ajoutons a chaque article le nombre des clients voulant l'acheter
            itemsOnSale.forEach((itemName) -> {
                Set<String> customersWantToBuyItemName = customerList.stream()
                        .filter(customer -> customer.getItems().stream()
                        .anyMatch(customerItem -> customerItem.getName().equals(itemName)))
                        .map(Customer::getName)
                        .collect(Collectors.toSet());

                mapper.put(itemName, customersWantToBuyItemName);

            });

        };
        //Fusion des elements dans le mapper1
        BinaryOperator<Map<String, Set<String>>> combiner = (mapper1, mapper2) -> {
            mapper1.putAll(mapper2);
            return mapper1;
        };

        Function<Map<String, Set<String>>, Map<String, Set<String>>> finisher = stringSetMap -> stringSetMap;

        Collector<Customer, ?, Map<String, Set<String>>> toItemAsKey =
            new CollectorImpl<>(supplier, accumulator, combiner, finisher, EnumSet.of(
                Collector.Characteristics.CONCURRENT,
                Collector.Characteristics.IDENTITY_FINISH));
        Map<String, Set<String>> itemMap = customerList.stream().parallel().collect(toItemAsKey);
        assertThat(itemMap.get("plane")).contains("Chris");
        assertThat(itemMap.get("onion")).contains("Patrick", "Amy");
        assertThat(itemMap.get("ice cream")).contains("Patrick", "Steven");
        assertThat(itemMap.get("earphone")).contains("Steven");
        assertThat(itemMap.get("plate")).contains("Joe", "Martin");
        assertThat(itemMap.get("fork")).contains("Joe", "Martin");
        assertThat(itemMap.get("cable")).contains("Diana", "Steven");
        assertThat(itemMap.get("desk")).contains("Alice");
    }

}
