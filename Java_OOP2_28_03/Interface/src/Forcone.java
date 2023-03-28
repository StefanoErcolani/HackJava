public class Forcone extends Arm{

    public Forcone(String side){

        super(side);

    }

    @Override
    public void attack(){ System.out.println("Infilzato col forcone montato sul braccio " + this.side ); }
    
}
