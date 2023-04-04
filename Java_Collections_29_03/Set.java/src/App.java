import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        
        Person p1 = new Person("Caio", "Caligola", 25);
        Person p2 = new Person("Giuseppe", "Cito", 28);
        Person p3 = new Person("Nunzio", "DiBiase", 45);
        Person p4 = new Person("Giorgio", "Mattarella", 80);
        Person p5 = new Person("Caio", "Caligola", 25);

        // Set<Person> people1 = Set.of(
        //     p1,
        //     p2,
        //     p3
        // );

        // for(Person p : people1){

        //     System.out.println(p.print());
        // }
        // Set<Person> people2 = Set.of(
        //     p1,
        //     p2,
        //     p5
        // );
        HashSet<Person> people3 = new HashSet<Person>(

            Set.of(
            p1,p3,p4

            )
        
        );
        // people3.add(new Person("tizoi", "caio", 13));
        // for(Person p : people3)
        //     System.out.println(p.print());

        // }

        // System.out.println( people3.size());
        Set<Triangle> LotsOfTriangles = new TreeSet<Triangle>( new PerimeterComparator());
        LotsOfTriangles.addAll(Set.of(

        new Triangle(4, 3, 3),
        new Triangle(7, 7, 6),
        new Triangle(3, 2, 3)

        ));
        
        for(Triangle t : LotsOfTriangles){
            System.out.println(t.printTriangle());

        }
    }
}        


