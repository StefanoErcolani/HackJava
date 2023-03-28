public class Gun extends Arms{

    private String gun;

    public Gun(String side, String gun) {
        super(side);
        this.gun = gun;
    }


    public void attack(){ System.out.println("Attacca con la " + this.gun + " montat sul braccio " + this.side ); }
}