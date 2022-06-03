package io.focati.java8.streams;

import io.focati.java8.tools.annotation.Easy;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise6Test {

    /**
     * Créer un flux de données avec les lettres "a" "b" "c"
     */
    @Easy @Test
    void streamFromValues() {

        Stream<String> abcStream = null; // A compléter

        List<String> abcList = abcStream.collect(Collectors.toList());
        assertThat(abcList).containsExactly("a", "b", "c");
    }

    /**
     * Créer un flux de données de 10 éléments avec des multiples de 3 en commençant par 0
     */
    @Easy @Test
    void numberStream() {
        Stream<Integer> numbers = null; // A compléter

        List<Integer> numbersList = numbers.collect(Collectors.toList());
        assertThat(numbersList).containsExactly(0, 3, 6, 9, 12, 15, 18, 21, 24, 27);
    }
}
