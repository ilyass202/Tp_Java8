package com.yourame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

   public  class SortPersonsExampleTest {

    @Test
  public void testSortPeople() {
        // Préparation des données
        List<Personne> people = new ArrayList<>();
        people.add(new Personne("Hamid", "Jamila"));
        people.add(new Personne("Martin", "Bob"));
        people.add(new Personne("Hamid", "Charles"));
        people.add(new Personne("Bernard", "Jamila"));

        // Action : trier les personnes
        Collections.sort(people);

        // Vérification
        assertThat(people).containsExactly(
            new Personne("Bernard", "Jamila"),
            new Personne("Hamid", "Charles"),
            new Personne("Hamid", "Jamila"),
            new Personne("Martin", "Bob")
        );
    }
}
