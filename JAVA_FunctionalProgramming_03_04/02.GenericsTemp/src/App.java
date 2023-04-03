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
        System.out.println(average(sensors, new SensorTempGetter()));

    }

    public static <T> double average(List<T> therms, GetTemperature tGetter){

        double sum = 0;

        for(T t : therms){
            //Accedere a una proprietà non più dall'oggetto stesso ma usando una funzione e in questo caso inserire un generic type parameter per poterla applicare ad ogni data type immesso in input tanto il casting è automatico
            sum += tGetter.getTemperature(t);

        }

        return sum / therms.size();

    }


}
