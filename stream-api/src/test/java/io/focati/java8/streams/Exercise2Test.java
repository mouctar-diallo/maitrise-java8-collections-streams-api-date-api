package io.focati.java8.streams;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import io.focati.java8.tools.entity.CustomerItem;
import io.focati.java8.tools.utils.AssertUtils;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise2Test {

    /**
     * Créer un flux de données avec les âges des clients trié de manière ascendante.
     */
    @Easy @Test
    void sortByAge() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Stream<Integer> sortedAgeStream = null; // A compléter

        List<Integer> sortedAgeList = sortedAgeStream.collect(Collectors.toList());
        assertThat(sortedAgeList).containsExactly(21, 22, 22, 26, 27, 28, 32, 35, 36, 38);
    }

    /**
     * Créer un flux de données avec les âges des clients trié de manière descendante.
     */
    @Easy @Test
    void descSortByAge() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Comparator<Integer> descOrder = null; // A compléter
        Stream<Integer> sortedAgeStream = null; // A compléter

        assertThat(AssertUtils.isLambda(descOrder));
        List<Integer> sortedAgeList = sortedAgeStream.collect(Collectors.toList());
        assertThat(sortedAgeList).containsExactly(38, 36, 35, 32, 28, 27, 26, 22, 22, 21);
    }

    /**
     * Créez un flux avec les 3 premiers clients riches.
     * Astuce : utiliser {@link Stream#limit} pour limiter la taille du flux.
     */
    @Easy @Test
    void top3RichCustomer() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Stream<String> top3RichCustomerStream = null; // A compléter

        List<String> top3RichCustomerList = top3RichCustomerStream.collect(Collectors.toList());
        assertThat(top3RichCustomerList).containsExactlyInAnyOrder("Diana", "Andrew", "Chris");
    }

    /**
     * Créez un flux d'âges distincts des clients.
     */
    @Easy @Test
    void distinctAge() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Stream<Integer> distinctAgeStream = null; // A compléter

        List<Integer> distinctAgeList = distinctAgeStream.collect(Collectors.toList());
        assertThat(distinctAgeList).containsExactlyInAnyOrder(22, 27, 28, 38, 26, 32, 35, 21, 36);
    }

    /**
     * Créez un flux avec les noms des articles (CustomerItem) des clients
     */
    @Easy @Test
    void itemsCustomersWantToBuy() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Function<Customer, Stream<CustomerItem>> getItemStream = null; // A compléter
        Stream<String> itemStream = null; // A compléter

        assertThat(AssertUtils.isLambda(getItemStream)).isTrue();
        List<String> itemList = itemStream.collect(Collectors.toList());
        assertThat(itemList).contains("small table", "plate", "fork", "ice cream", "screwdriver", "cable", "earphone", "onion",
                            "ice cream", "crisps", "chopsticks", "cable", "speaker", "headphone", "saw", "bond",
                            "plane", "bag", "cold medicine", "chair", "desk", "pants", "coat", "cup", "plate", "fork",
                            "spoon", "ointment", "poultice", "spinach", "ginseng", "onion");
    }
}
