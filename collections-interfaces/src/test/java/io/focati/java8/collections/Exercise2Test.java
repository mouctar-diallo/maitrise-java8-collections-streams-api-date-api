package io.focati.java8.collections;

import io.focati.java8.tools.annotation.Easy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise2Test {

    private final Map<String, Integer> map = new HashMap<>() {{
        put("Joe", 22);
        put("Steven", 27);
        put("Patrick", 28);
        put("Chris", 26);
    }};

    /**
     * Retourner la valeur de la clé "Melissa" depuis la variable #map. Si la clé n'existe pas retourner la valeur par défaut 30
     */
    @Easy @Test
    void getDefaultValue() {
        Map<String, Integer> map = new HashMap<>(this.map);

        // SOLUTION
        Integer defaultVal = map.getOrDefault("Melissa", 30);

        assertThat(defaultVal).isEqualTo(30);
    }

    /**
     * Insérer les entrées suivantes si leurs clés n'existent pas déjà dans la variable #map :
     *  "Melissa" => 32
     *  "Joe" => 35
     */
    @Easy @Test
    void putIfNotExisting() {
        Map<String, Integer> map = new HashMap<>(this.map);

        // Solution
        map.putIfAbsent("Melissa", 32);
        map.putIfAbsent("Joe", 35);

        assertThat(map)
            .containsEntry("Melissa", 32)
            .containsEntry("Joe", 22);
    }

    /**
     * Créer une fonction {@link BiFunction} permettant d'insérer les entrées suivantes à la variable #map mais en utilisant la methode {@link Map#merge} de Map.
     *  "Melissa" => 32
     *  "Joe" => 35
     *
     * Si l'entrée à ajouter existe déjà, additionner leurs valeurs.
     */
    @Easy @Test
    void mergeValues() {
        Map<String, Integer> map = new HashMap<>(this.map);

        // SOLUTION
        BiFunction<Integer, Integer, Integer> remappingFunction = Integer::sum;
        map.merge("Melissa", 32, remappingFunction);
        map.merge("Joe", 35, remappingFunction);


        assertThat(map)
            .containsEntry("Melissa", 32)
            .containsEntry("Joe", 57);
    }

    /**
     * Créer une fonction {@link BiFunction} pour incrémenter de 1 la valeur des clés si elle existe :
     * "Joe"
     * "Steven"
     * "Melissa"
     */
    @Easy @Test
    void ignoringAbsentKeys() {
        Map<String, Integer> map = new HashMap<>(this.map);

        BiFunction<String, Integer, Integer> remappingFunction = (key, value) -> ++value;
        List<String> keys = Arrays.asList("Joe", "Steven", "Melissa");
        // SOLUTION
        keys.forEach(key -> map.computeIfPresent(key, remappingFunction));

        assertThat(map)
            .containsEntry("Joe", 23)
            .containsEntry("Steven", 28)
            .doesNotContainKey("Melissa");

    }
}
