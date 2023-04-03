public class SensorTempGetter implements GetTemperature{
    
    public Double getTemperature(Object obj) {
        //semplice casting dato che bisogn prendere un oggetto e restituire un dou        
        Sensor therm = (Sensor) obj;

        return therm.getTempsens();
        
    }


}
