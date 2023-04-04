import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        //Interfaccia list che estende intefaccia Collection
        //List si implementa in Arraylist e LinkedList
        
        //Arraylist-> costruire ArrayList( solo di un tipo specifico) e poi sfruttare i suoi metodi.
        //Lavorano solo con oggetti, usare wrapper class o istanziare oggetti.
        List<Person> people = new ArrayList<>();
        
        //add()
        people.add(new Person("Ciccio", "Franco", "cccfrnc66"));
        people.add(new Person("Giuseppe", "Garibaldi", "gsppgrb12"));
        people.add(new Person("Karol", "Wojtyla", "krlwtl37"));

        //metodo più apprezzato per ciclare liste di oggetti
        // for(Person p : people){
        //     System.out.println(p.getName() + " , " + p.getSurname() + " , " + p.getCf());

        // }
        // System.out.println("");
        //addAll() -> deve aggiungere collezioni
        people.addAll(people);

        // for(Person p : people){
        //     System.out.println(p.getName());

        // }

        // //toArray()
        // people.toArray();
        // for(Person p : people){
        //     System.out.println(people.getClass().getSimpleName());

        // }

        // //isEmpty()
        // if(people.isEmpty()) System.out.println("MHANZ");
        // else System.out.println("KUCIUMM");

        //clear();
        // people.clear();
        // if(people.isEmpty()) System.out.println("sadge");
        
        //size()
        System.out.println(people.size());

        //remove() -> inserire l'indice
        people.remove(5);
        people.remove(4);
        people.remove(3);

        for(Person p :people){
            System.out.println(p.getName());

        }

    //     people.removeAll(people);
    //     if(people.isEmpty()) System.out.println("grudge");

        //contains()
        // if(people.containsAll(people)) System.out.println("Hello");
        // else System.out.println("Bonjour");

        //get()
        System.out.println(people.get(2).getName());
        System.out.println(people.get(2).getName()); 
        System.out.println(people.get(2).getName()); 
        System.out.println(people.get(2).getName()); 
        people.remove(2);
        if(people.size() < 3) System.out.println("eh eh  Karol's ded");
        for(Person p : people){
            System.out.println(p.getName());

        }
    }
}
