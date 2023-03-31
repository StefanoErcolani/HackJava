public class GalacticDrill extends Arms {
    
    public GalacticDrill(String sideLabel) {
        super(sideLabel);
    }

    @Override
    public void attack(){ 

        System.out.println("With my mighty " + this.sideLabel + ", I will pierce you with my drill!" );

    }
}
