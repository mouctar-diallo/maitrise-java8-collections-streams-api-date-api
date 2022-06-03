package io.focati.java8.streams;

import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise3Test {

    /**
     * Comptez le nombre d'articles total des clients
     */
    @Easy @Test
    void howManyItems() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        long sum = customerList.stream()
                .flatMap(customer -> customer.getItems().stream()).count();

        assertThat(sum).isEqualTo(32L);
    }

    /**
     * Trouvez le client le plus riche en utilisant {@link Stream#max} et {@link Comparator#naturalOrder}
     * Interdit d'utiliser {@link Stream#sorted}
     */
    @Easy @Test
    void richestCustomer() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Comparator<Integer> comparator = Comparator.naturalOrder();
        Optional<Integer> richestCustomer = customerList.stream()
                .map(Customer::getBudget)
                .max(comparator);

        assertThat(comparator.getClass().getSimpleName()).isEqualTo("NaturalOrderComparator");
        assertThat(richestCustomer.get()).isEqualTo(12000);
    }

    /**
     * Trouvez le client le plus jeune en utilisant {@link Stream#min}
     * Interdit d'utiliser {@link Stream#sorted}
     */
    @Easy @Test
    void youngestCustomer() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Comparator<Customer> comparator = Comparator.comparing(Customer::getAge);
        Optional<Customer> youngestCustomer = customerList.stream()
                        .min(comparator);

        assertThat(youngestCustomer.get()).isEqualTo(customerList.get(8));
    }
}
