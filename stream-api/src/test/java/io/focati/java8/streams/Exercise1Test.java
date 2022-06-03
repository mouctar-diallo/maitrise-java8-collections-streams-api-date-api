package io.focati.java8.streams;


import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import io.focati.java8.tools.utils.AssertUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class Exercise1Test {

    /**
     * Créez un flux de données à partir de la liste des clients en incluant uniquement les clients dont le budget est supérieur à 10000.
     * Utilisez les expressions lambda pour les fonctions de {@link Predicate} et de {@link Stream#filter}
     */
    @Easy @Test
    void findRichCustomers() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Predicate<Customer> richCustomerCondition = customer -> customer.getBudget() > 10000;
        Stream<Customer> richCustomerStream = customerList.stream()
                        .filter(richCustomerCondition);

        assertThat(AssertUtils.isLambda(richCustomerCondition)).isTrue();
        List<Customer> richCustomer = richCustomerStream.collect(Collectors.toList());
        assertThat(richCustomer)
            .hasSize(2)
            .contains(customerList.get(3), customerList.get(7));
    }

    /**
     * Créez une fonction {@link Function} pour obtenir à partir d'un client son âge
     * Appliquer ensuite cette fonction sur la variable #customerList afin d'obtenir la variable #ageStream.
     */
    @Easy @Test
    void howOldAreTheCustomers() {
        List<Customer> customerList = ClassicOnlineStore.getData().getCustomers();

        Function<Customer, Integer> getAgeFunction = Customer::getAge;
        Stream<Integer> ageStream = customerList.stream()
                        .map(getAgeFunction);

        assertThat(AssertUtils.isLambda(getAgeFunction)).isTrue();
        List<Integer> ages = ageStream.collect(Collectors.toList());
        assertThat(ages)
            .hasSize(10)
            .containsExactlyInAnyOrder(22, 27, 28, 38, 26, 22, 32, 35, 21, 36);
    }
}
