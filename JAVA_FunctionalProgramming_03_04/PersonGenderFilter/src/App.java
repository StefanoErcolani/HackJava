import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        List<Person> people = List.of(

            new Person("Giuseppo", Gender.MALE),

            new Person("Francesca", Gender.FEMALE),

            new Person("Paola", Gender.FEMALE),

            new Person("Giovanni", Gender.MALE)

        );

        // //imperativ

        // List<Person> females = new ArrayList();

        // for(Person f : people){

        //     if(Gender.FEMALE.equals(f.gender)) females.add(f);

        // }

        // for(Person f2 : females){

        //     System.out.println(f2.getName());

        // }

        //dichiarativo
        //metodo lungo per gestire le collezioni tramite stream() 
        people.stream().filter(person -> Gender.FEMALE.equals(person.gender)).collect(Collectors.toList()).forEach(person -> System.out.println(person.name));

        //per salvare in memoria il risultato, notare che non necessita di collector. Non dimenticare che serve sempre un punto di riferimento di partenza per invocare e istanziare bestia.
        List<Person> females = people.stream().filter(person -> Gender.FEMALE.equals(person.gender)).toList();
        for(Person p : females){
            System.out.println(p.getName());
        }

    }
}
