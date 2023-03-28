public class Jeeg {
    
    public Arms armsx;

    public Arms armdx;


    public Jeeg(Arms armsx, Arms armdx) {
        this.armsx = armsx;
        this.armdx = armdx;
    }

    public void attacco(){ 
        
        armsx.attack(); 

        armdx.attack();
    
    }

}
