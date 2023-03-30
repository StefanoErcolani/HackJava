import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        List<Person> listona = new ArrayList<Person>();

        listona.add(new Person("Giuseppe", "Garibaldi"));
        listona.add(new Person("Franco", "Ingrassia"));
        listona.add(new Person("Francesco", "Totti"));
        listona.add(new Person("Paolo", "Paoloni"));

        Scanner sc = new Scanner(System.in);

        System.out.println("Vuoi cercare una persona? Dammi un numero ");     
        int i = sc.nextInt();

        listona.set(2, new Person("Pino", "Giuseppino"));

        

    }
}
