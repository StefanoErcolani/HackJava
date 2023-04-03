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

        List<FridgeTemp> fridges = new ArrayList<FridgeTemp>(

        List.of(

            new FridgeTemp(25),
            new FridgeTemp(17),
            new FridgeTemp(28),
            new FridgeTemp(29),
            new FridgeTemp(12)

        )

        );

        //Long version with lambdas
        //Al posto di una implementazione dell'interfaccia poter usare una lambda ( => in JS) che fa la stessa cosa, ovvero prende un oggetto e tramite casting restituisce un double

        //Tramite istanziazione
        // GetTemperature thermGetter = (Object obj) -> ((Thermometer) obj).getTherm();
        // GetTemperature sensGetter = (Object obj) -> ((Sensor) obj).getTempsens(); 

        // System.out.println(average(therms, thermGetter));
        // System.out.println(average(sensors, sensGetter));

        //Vantaggio dei Lambda è di poter essere inseriti come inline variables, anche nel corpo di altre funzioni
        //Le classi che implementavano l'interfaccia possono anche essere eliminate come in questo caso

        System.out.println(average(therms, ((Object obj) -> ((Thermometer) obj).getTherm()) ) );

        System.out.println(average(sensors, ((Object obj) -> ((Sensor) obj).getTempsens()) ) );

        System.out.println(average(fridges, ((Object obj) -> ((FridgeTemp)obj).getFridgeTemp()) ) );
    }

    public static <T> double average(List<T> el, GetTemperature tGetter){

        double sum = 0;

        for(T t : el){
            //Accedere a una proprietà non più dall'oggetto stesso ma usando una funzione e in questo caso inserire un generic type parameter per poterla applicare ad ogni data type immesso in input tanto il casting è automatico
            sum += tGetter.getTemperature(t);

        }

        return sum / el.size();

    }


}
