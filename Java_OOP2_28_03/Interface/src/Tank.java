public class Tank extends Legs implements CanAttack{

    @Override
    public void moveBackward() {         
        System.out.println("Rolling out!");       
    }

    @Override
    public void moveForward() {
        System.out.println("Defeated but never show the back to the enemy");
        
    }

    @Override
    public void attacco() { System.out.println("Non sono contento di vederti ma puoi considerarlo un cannone in tasca");}
    
}
