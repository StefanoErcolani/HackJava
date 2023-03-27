import java.lang.Exception;

public class CarBuilder {

    private String owner;
    
    private String name;

    private int wheels;
    
    private String colors;

    private String[] avaiableColors = {"blue", "black"};

    private boolean hasEngine;


    public CarBuilder(String owner, String name, int wheels, String colors, boolean engine){

        this.owner = owner;

        this.name = name;

        this.wheels = wheels;

        this.colors = colors;

        this.hasEngine = engine;

    }

    public String getOwner(){       
        
        if(this.owner == null){

            return this.owner = "NO_VALUE";

        } else{

            return this.owner;

        }

    }


    public String getName(){

        if(this.name == null){

            this.name = "NO_VALUE";

        }

        return this.name;
    
    }


    public void setWheels(int wheels){ 

        if(owner != null && (wheels <= 4)) { 

        this.wheels = wheels; 

        }
        else
        { 
            System.out.println("Error! Somethind's wrong"); 
        } 

    }

    public void setColors(String colors){

        for(String c : avaiableColors){

            if(colors.equals(c)){

                this.colors = c;

            }

        }
    
        System.out.println("Colore non disponibile.");

    }

    public void setEngine(boolean engine){

        if(engine == true) { this.hasEngine = engine;
        }
        else
        { System.out.println("Error!"); }


    }
}
