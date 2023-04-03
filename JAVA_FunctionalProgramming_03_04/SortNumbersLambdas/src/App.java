import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        
        Integer[] ints = new Integer[]{ 2, 2, 1, 5, 6, 7,8, 4};
        Arrays.sort(ints, (a,b) -> Integer.compare(a, b));

        // for(Integer i : ints){

        //     System.out.println(i);

        // }
        //Alternativeù
        List.of(ints).stream().forEach((Integer el) -> System.out.println(el));

    }
}
