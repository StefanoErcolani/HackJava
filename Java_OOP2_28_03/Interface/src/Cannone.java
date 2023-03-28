public class Cannone extends Arm{

    public Cannone(String side) {
        super(side);
    }
    
    @Override
    public void attack(){ System.out.println("Esploso col cannone montato sul braccio " + this.side); }

}
