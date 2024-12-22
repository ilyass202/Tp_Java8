
package com.yourame ;

import org.assertj.core.api.Assertions;

import com.Personne;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PersonneIterationTest {

    @Test
    public void testAjoutPersonneDansSet() {
        // Création d'un ensemble de personnes
        Set<Personne> personnes = new HashSet<>();

        // Ajout d'objets Personne
        personnes.add(new Personne(1 ,"Alice"));
        personnes.add(new Personne(2, "Bob"));

        // Vérification avec AssertJ
        Assertions.assertThat(personnes)
                .isNotEmpty()
                .hasSize(2)
                .extracting("nom")
                .containsExactlyInAnyOrder("Alice", "Bob");
    }

    @Test
    public void testSuppressionPersonneAvecIterator() {
        // Création d'un ensemble de personnes
        Set<Personne> personnes = new HashSet<>();
        personnes.add(new Personne(1, "Alice"));
        personnes.add(new Personne(2, "Bob"));
        personnes.add(new Personne(3, "Charlie"));

        // Suppression sécurisée de 'Bob' avec Iterator
        Iterator<Personne> iterator = personnes.iterator();
        while (iterator.hasNext()) {
            Personne personne = iterator.next();
            if (personne.getNom().equals("Bob")) {
                iterator.remove();
            }
        }

        // Vérification après suppression
        Assertions.assertThat(personnes)
                .hasSize(2)
                .extracting("nom")
                .doesNotContain("Bob");
    }
}

