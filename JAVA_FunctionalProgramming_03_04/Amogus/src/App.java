import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> amogus = List.of("apple", "carrot", "java", "cabbage");

        List<String> intruder = amogus.stream().filter(sus -> sus.equals("java")).toList();
        
        for(String i : intruder){

            System.out.println(i);

        }

    }
}
