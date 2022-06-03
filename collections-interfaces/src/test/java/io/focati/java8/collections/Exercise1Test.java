package io.focati.java8.collections;


import io.focati.java8.tools.annotation.Easy;
import io.focati.java8.tools.datasets.ClassicOnlineStore;
import io.focati.java8.tools.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class Exercise1Test {

    /**
     * 1 - Créer une fonction {@link Consumer} qui représente une opération d'ajout de nom d'un client en utilisant la variable #nameList
     * 2 - Appliquer ensuite cette fonction à la variable #customerIterable via l'opération {@link Iterable#forEach}
     */
    @Easy @Test
    void iterateByForEach() {
        Iterable<Customer> customerIterable = ClassicOnlineStore.getData().getCustomers();
        List<String> nameList = new ArrayList<>();

        Consumer<Customer> consumer = customer -> nameList.add(customer.getName());
        customerIterable.forEach(consumer);

        assertThat(nameList).containsExactlyInAnyOrder("Joe", "Steven", "Patrick", "Diana", "Chris", "Kathy", "Alice", "Andrew", "Martin", "Amy");
    }

    /**
     * Créer une fonction {@link Predicate} qui teste si une chaîne de caractère contient le caractère "e"
     * Utiliser la fonction {@link Predicate} créée pour supprimer les éléments de la collection #nameCollection contenant le caractère "e"
     */
    @Easy @Test
    void whoHaveNoEInYourName() {
        Collection<String> nameCollection = new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        Predicate<String> predicate = chaine -> chaine.contains("e");
        nameCollection.removeIf(predicate);

        assertThat(nameCollection).containsExactlyInAnyOrder("Patrick", "Chris");
    }

    /**
     * Créer une fonction {@link UnaryOperator} qui reçoit une chaîne de caractères et la retourne entourée de "()"
     * Remplacer tous les éléments de la variable #nameList en appliquant cette fonction
     */
    @Easy @Test
    void replaceTheElements() {
        List<String> nameList = new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        UnaryOperator<String> unaryOperator = chaine -> "("+chaine+")";
        nameList.replaceAll(unaryOperator);

        assertThat(nameList).containsExactlyInAnyOrder("(Joe)", "(Steven)", "(Patrick)", "(Chris)");
    }

    /**
     * Créer une fonction de comparaison {@link Comparator} pour trier les valeurs de la liste #nameList suivant leur longueur et de manière acsendante.
     */
    @Easy @Test
    void sortByNameLength() {
        List<String> nameList = new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        Comparator<String> comparator = Comparator.comparing(String::length);
        nameList.sort(comparator);

        assertThat(nameList).containsExactly("Joe", "Chris", "Steven", "Patrick");
    }

    /**
     * Créer un flux série de données en utilisant {@link Collection#stream}
     */
    @Easy @Test
    void createStream() {
        Collection<String> nameList = new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        Stream<String> nameStream = nameList.stream();

        assertThat(nameStream.count()).isEqualTo(4L);
        assertThat(nameStream.isParallel()).isFalse();
    }

    /**
     * Créer un flux parallèle de données en utilisant {@link Collection#stream}
     */
    @Easy @Test
    void createParallelStream() {
        Collection<String> nameList = new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        Stream<String> nameParallelStream = nameList.parallelStream();

        assertThat(nameParallelStream.count()).isEqualTo(4L);
        assertThat(nameParallelStream.isParallel()).isTrue();
    }
}
