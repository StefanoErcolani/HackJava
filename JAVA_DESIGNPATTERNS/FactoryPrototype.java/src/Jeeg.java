public class Jeeg {
    
    private Arms armsx;
    
    private Arms armdx;

    private Moveable moveable;

    public Jeeg(Arms armsx, Arms armdx, Moveable moveable) {
        this.setArm(armdx, Side.Dx);
        this.setArm(armsx, Side.Sx);
        this.setMoveable(moveable);
    }

    public void setArm(Arms arm, Side side) {
    
        if(side == Side.Sx){ this.armsx = arm;
    
        } else { 

        this.armdx = arm;

        }
    }

    public Arms getArmsx() {
        return armsx;
    }

    public Arms getArmdx() {
        return armdx;
    }


    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {  
        this.moveable = moveable;

    }



    public void attack(){

        this.armsx.attack();

        this.armdx.attack();

        this.armsx.attack();

        this.armdx.attack();

        if(this.moveable instanceof Tank){ 

            Tank t = (Tank) moveable;
            t.attack();

        }
    }



    public void forward() {

        this.moveable.forward();

    }

    public void backward() { 

        this.moveable.backward();

    }


}
