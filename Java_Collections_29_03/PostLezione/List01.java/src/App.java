import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci sei numeri nella liston ");

        List<Integer> liston = new ArrayList<Integer>();

        int i = 1;

        while(i <= 6){
        liston.add(sc.nextInt());
        i++;
        }

        for(int num : liston){
            System.out.println("Hai messo nel listòn " + num);
        }
        System.out.println("Cicciosamente " + liston.size());
        System.out.println("Oh guarda c'è lui proprio " + liston.get(2));
    }
}
