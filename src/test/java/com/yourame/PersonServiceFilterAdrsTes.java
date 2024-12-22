package com.yourame;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import java.util.Arrays;



public class PersonServiceFilterAdrsTes {

    private final PersonService personService = new PersonService(); // Déclaration au niveau de la classe

    @Test
    public void testFilterAdults() {
        // Appeler la méthode pour filtrer les adultes
        List<Person> adults = personService.filterAdults();

        // Liste attendue des adultes
        List<Person> expectedAdults = Arrays.asList(
            new Person("Alice", "Doe", LocalDate.of(1990, 5, 12), "123 Rue A"),
            new Person("Charlie", "Brown", LocalDate.of(1985, 3, 9), "789 Rue C")
        );

        // Vérifications avec AssertJ
        assertThat(adults)
            .isNotNull()
            .hasSize(2) // Vérifie qu'il y a 2 adultes
            .containsExactlyInAnyOrderElementsOf(expectedAdults); // Vérifie que le contenu est exact et peu importe l'ordre
    }
}
