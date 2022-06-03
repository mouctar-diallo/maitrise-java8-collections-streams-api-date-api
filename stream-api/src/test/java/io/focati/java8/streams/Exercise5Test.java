package io.focati.java8.streams;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.annotation.Medium;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise5Test {

    /**
     * Créer une liste de noms des clients
     */
    @Easy @Test
    void nameList() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        List<String> nameList = null; // A compléter

        assertThat(nameList).containsExactlyInAnyOrder("Joe", "Steven", "Patrick", "Diana", "Chris", "Kathy",
            "Alice", "Andrew", "Martin", "Amy");
    }

    /**
     * Créer une liste d'âges distincts des clients
     */
    @Easy @Test
    void ageSet() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Set<Integer> ageSet = null; // A compléter

        assertThat(ageSet)
            .hasSize(9)
            .containsExactlyInAnyOrder(21, 22, 26, 27, 28, 32, 35, 36, 38);
    }

    /**
     * Créer une liste de noms des clients au format csv entourée par des "[]"
     */
    @Medium @Test
    void nameInCsv() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        String string = null; // A compléter

        assertThat(string).isEqualTo("[Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy]");
    }

    /**
     * Trouvez le client le plus âgé en utilisant {@link Collectors#maxBy}.
     */
    @Easy @Test
    void oldestCustomer() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Optional<Customer> oldestCustomer = null; // A compléter

        assertThat(oldestCustomer.get()).isEqualTo(customerList.get(3));
    }

    /**
     * Créer une Map pour grouper les clients par âges
     * Utiliser {@link Collectors#groupingBy} et {@link Collectors#counting}
     */
    @Medium @Test
    void ageDistribution() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Map<Integer, Long> ageDistribution = null; // A compléter

        assertThat(ageDistribution).hasSize(9);
        ageDistribution.forEach((k, v) -> {
            if (k.equals(22)) {
                assertThat(v).isEqualTo(2L);
            } else {
                assertThat(v).isEqualTo(1L);
            }
        });
    }
}
