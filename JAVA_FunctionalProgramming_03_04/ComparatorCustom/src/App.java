import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {

        Person[] people = new Person[]{

            new Person("Franco", "Vattelapesca", 22),
            new Person("Paolo", "Limiti", 13),
            new Person("Franchino", "Sambucone", 17)

        }; 


        Arrays.sort(people, MyComparator.reverse((a,b) -> a.getAge() - b.getAge()));
        System.out.println(Arrays.toString(people));
        for(Person p : people){

            System.out.println(p.getAge() + " , " + p.getName() + " , " + p.getSurname());

        // }
        // Arrays.sort(people, Comparator.comparing((a) -> a.getAge()));
        // for(Person p : people){

        //     System.out.println(p.getAge());

        }
    }
}
