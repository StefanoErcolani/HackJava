import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        List<Thermometer> therms = new ArrayList<Thermometer>(

            List.of(

                new Thermometer(25),
                new Thermometer(37),
                new Thermometer(22),
                new Thermometer(15),
                new Thermometer(28)

            )

        );

        List<Sensor> sensors = new ArrayList<Sensor>(

        List.of(

            new Sensor(15),
            new Sensor(27),
            new Sensor(18),
            new Sensor(19),
            new Sensor(22)

        )

        );

        System.out.println(average(therms, new ThermoTempGetter()));
        System.out.println(average2(sensors, new SensorTempGetter()));

    }

    public static double average(List<Thermometer> therms, GetTemperature tGetter){

        double sum = 0;

        for(Thermometer t : therms){
            //Accedere a una proprietà non più dall'oggetto stesso ma usando una funzione 
            sum += tGetter.getTemperature(t);

        }

        return sum / therms.size();

    }

    public static double average2(List<Sensor> sensors, GetTemperature tGetter){

        double sum = 0;

        for(Sensor t : sensors){
            //Accedere a una proprietà non più dall'oggetto stesso ma usando una funzione 
            sum += tGetter.getTemperature(t);

        }

        return sum / sensors.size();

    }

}
