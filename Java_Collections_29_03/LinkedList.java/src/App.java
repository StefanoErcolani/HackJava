import java.util.LinkedList;
import java.util.List;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        
        // ostruire una linkedlist se deve sfruttare i metodi propri necessita della dichiarazione della lista come Linked, in questo caso poi va specificato il tipo di LinkedList, person.
        LinkedList<Person>people = new LinkedList<Person>();

        people.add(new Person("Caio", "Giulio", "CGL"));
        people.addFirst(new Person("Ciccio", "Franco", "cccfrnc"));
        people.addFirst(new Person("Gabriele", "Vasco", "gbrlvsc"));
        // System.out.println(people.getFirst().getName());
        // System.out.println(people.getLast().getSurname());
        people.removeFirst();
                
        for(Person p : people){
        
            System.out.println(p.getName());

        
        }

    
    }
}
