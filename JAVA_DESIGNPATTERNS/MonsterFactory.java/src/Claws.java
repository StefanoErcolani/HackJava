public class Claws extends Limb{

    public Claws(String location) {
        super(location);
    }
    
    @Override
    public void itMoves(){

        System.out.println("Now it can climb even walls with its" + this.location + " bone blades. Never less safe than now!");
        System.out.println(" ");
    }

    @Override
    public void dangerous(){

        System.out.println("Sharp razor claws dangling from his" + this.location + " limb.");
        System.out.println(" ");
    }
}
