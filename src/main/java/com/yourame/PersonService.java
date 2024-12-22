package com.yourame;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PersonService {

    // Liste pour stocker les personnes (simulation d'une base de données)


    // Filtrer les personnes par adresse
    public List<Person> filterByAddress(String address) {
        List<Person> adresses = Arrays.asList(
            new Person("Alice", "Doe", LocalDate.of(1990, 5, 12), "123 Rue A"),
            new Person("Charlie", "Brown", LocalDate.of(1985, 3, 9), "123 Rue A"),
            new Person("Bob", "Smith", LocalDate.of(2005, 10, 15), "456 Rue B")
        );
        Predicate<Person> hasAddress = person -> person.getAddress().equals(address);
        return adresses.stream()
                             .filter(hasAddress)
                             .collect(Collectors.toList());
    }


    public List<Person> filterAdults(){
        List<Person> adults =  Arrays.asList( new Person("Alice" , "Doe" ,LocalDate.of(1990,5, 12), "123 Rue A"), new Person("Bob", "Smith", LocalDate.of(2005, 10, 15), "456 Rue B"),
      new Person("Charlie", "Brows", LocalDate.of(1985 , 3 , 9), "789 Rue C"));
     Predicate<Person>  isAdulte = Person -> Person.calculateAge() >= 18 ;
     return adults.stream().filter(isAdulte).collect(Collectors.toList());
    }

}
