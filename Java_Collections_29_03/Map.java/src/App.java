import java.util.HashMap;
import java.util.Map;

public class App {
    
    public static void main(Person[] args){
        
        // Person p1 = new Person("Alfredo", "Capuleti", "cpltlfrd42");

        // Person p2 = new Person("Giuseppe", "DeGiuseppi", "dgsppgspp21");

        // Person p3 = new Person("Alfredo", "Capuleti", "cpltlfrd42");

        // Map<Person, Person> people = new HashMap<Person, Person>();

        // //comportamento normale
        // people.put(p1, p1);
        // people.put(p2, p2);
        // people.put(p3, p3);
    
        // for(Person key: people.keySet()){
        //     System.out.println(people.get(key));
        



        //comportamento sovrascritto 

        Map<TriangleKey, Triangle> triangoli = new HashMap<TriangleKey, Triangle>();

        Triangle t1 = new Triangle(2, 3, 3);
        Triangle t2 = new Triangle(3, 4, 2);
        Triangle t3 = new Triangle(1, 2, 2);
        Triangle t4 = new Triangle(2, 3, 3);
        
        //Generare un hash per elemento della mappa -> remeber reference anche se le chiavi hanno valori uguali
        //Ignorare reference e puntare ai value -> override hashcode() e equals()
        TriangleKey tk1 = new TriangleKey("t1", 20);
        triangoli.put(tk1, t1);
        
        TriangleKey tk2 = new TriangleKey("t2", 19);
        triangoli.put(tk2, t2);
        
        TriangleKey tk3 = new TriangleKey("t3", 18);
        triangoli.put(tk3, t3);
        
        TriangleKey tk4 = new TriangleKey("t4", 20);
        triangoli.put(tk4, t4);
        
        for(TriangleKey key : triangoli.keySet()){
            System.out.println(triangoli.get(key).getS1());
        }
    }
}
