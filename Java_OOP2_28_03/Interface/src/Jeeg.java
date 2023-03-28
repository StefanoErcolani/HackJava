public class Jeeg {
    
    public Arm armsx;

    public Arm armdx;

    public Legs legs;

    public Jeeg(Arm armsx, Arm armdx, Legs legs) {
        this.armsx = armsx;
        this.armdx = armdx;
        this.legs = legs;
    }

    public void attacco(){

        this.legs.moveBackward();

        this.armsx.attack();

        this.armdx.attack();

        this.armsx.attack();

        this.armdx.attack();

        this.legs.moveForward();

        //generics
        Class<? extends Object> classe = legs.getClass();
        // System.out.println(" " + classe);
        if(classe.toString().equals("class Tank")){
        
        //Legs non implementa l'interfaccia, necessario type casting di legs su tank e chiamare la funzione
            Tank t = (Tank) this.legs; 
            t.attacco();
        }

    }

}
