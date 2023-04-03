import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Thermometer> therms = List.of(

            new Thermometer(17),
            new Thermometer(20),
            new Thermometer(21),
            new Thermometer(18)

        );

        System.out.println(averageTemp(therms));

    }

    public static double averageTemp(List<Thermometer> therms){

        double sum = 0;

        for(Thermometer t : therms){

            sum += t.getTemperature();

        }

        return sum;

    }
}
