public class Jeeg {

    private Arms armDx;

    private Arms armSx;

    private Legs legs;

    public Jeeg(Arms armDx, Arms armSx, Legs legs) {
        this.armDx = armDx;
        this.armSx = armSx;
        this.legs = legs;
    }
    
    public void attacca(){

        this.legs.forward();

        this.armSx.left();

        this.armDx.right();

        this.legs.backward();
    }

}
