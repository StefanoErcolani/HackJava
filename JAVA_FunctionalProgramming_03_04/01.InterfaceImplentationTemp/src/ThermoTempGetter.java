public class ThermoTempGetter implements GetTemperature{
    
    public Double getTemperature(Object obj) {
        //semplice casting dato che bisogn prendere un oggetto e restituire un dou        
        Thermometer therm = (Thermometer) obj;

        return therm.getTherm();
        
    }

}
