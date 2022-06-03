package io.focati.java8.streams;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise4Test {

    /**
     * Trouvez le premier client inscrit
     */
    @Easy @Test
    void firstRegistrant() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Optional<Customer> firstCustomer = null; // A compléter

        assertThat(firstCustomer.get()).isEqualTo(customerList.get(0));
    }

    /**
     * Vérifier s'il existe parmi les clients une personne ayant plus de 40 ans
     */
    @Easy @Test
    void isThereAnyoneOlderThan40() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        boolean olderThan40Exists = true; // A modifier

        assertThat(olderThan40Exists).isFalse();
    }

    /**
     * Vérifier si tous les clients on plus de 20 ans
     */
    @Easy @Test
    void isEverybodyOlderThan20() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        boolean allOlderThan20 = false; // A modifier

        assertThat(allOlderThan20).isTrue();
    }

    /**
     * Confirmer qu'aucun client n'a de panier vide
     */
    @Easy @Test
    void everyoneWantsSomething() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        boolean everyoneHaveSomeItems = false; // A modifier

        assertThat(everyoneHaveSomeItems).isTrue();
    }
}
