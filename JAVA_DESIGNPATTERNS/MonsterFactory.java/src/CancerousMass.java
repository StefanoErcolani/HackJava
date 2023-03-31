public class CancerousMass extends Limb implements CanMove,CanAttack {
    
    public CancerousMass(String limb){

        super(limb);

    }

    @Override 
    public void itMoves(){

        System.out.println("It doesn't really move from its " + this.location + " part. It's more like sliding..." );
        System.out.println(" ");
    }

    @Override
    public void dangerous(){

        System.out.println("Think about a mace, made of disgusting evergrowing flesh sprouting rigth there on its " + this.location + " area");
        System.out.println(" ");
    }
}
