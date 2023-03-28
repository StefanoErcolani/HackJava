public class Laser extends Arms{
    
    public String laser;

    public Laser(String side, String laser) {
        super(side);
        this.laser =laser ;
    }

    public void attack() { System.out.println("Folgorato col " + this.laser + " montato sul braccio " + this.side); }
    


}
