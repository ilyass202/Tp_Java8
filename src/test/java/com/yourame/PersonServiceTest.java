package com.yourame;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import java.util.Arrays;



public class PersonServiceTest {

    private final PersonService personService = new PersonService(); // Déclaration au niveau de la classe

    @Test
    public void testFilterByAddress() {
        // Filtrer les personnes vivant à "123 Rue A"
        List<Person> peopleLivingIn123RueA = personService.filterByAddress("123 Rue A");

        // Liste attendue des personnes vivant à "123 Rue A"
        List<Person> expectedPersonsLivingIn123RueA = Arrays.asList(
            new Person("Alice", "Doe", LocalDate.of(1990, 5, 12), "123 Rue A"),
            new Person("Charlie", "Brown", LocalDate.of(1985, 3, 9), "123 Rue A")
        );

        // Vérifications avec AssertJ
        assertThat(peopleLivingIn123RueA)
                .isNotNull()
                .hasSize(2) // Vérifie qu'il y a 2 personnes
                .containsExactlyInAnyOrderElementsOf(expectedPersonsLivingIn123RueA) // Vérifie le contenu
                .extracting(Person::getAddress)
                .containsOnly("123 Rue A"); // Vérifie que toutes les adresses sont "123 Rue A"
    }
}
