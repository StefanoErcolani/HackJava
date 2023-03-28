public class App {
    public static void main(String[] args) throws Exception {

        Arm armsx = new Forcone("sinistro");

        Arm armdx = new Cannone("destro");

        Legs legs = new GambeForti();

        Jeeg jeeg = new Jeeg(armsx, armdx, legs);

        System.out.println("");

        jeeg.attacco();

        System.out.println("");

        // Jeeg jeeg2 = new Jeeg(new Forcone("destro"), new Cannone("sinistro"), new Propulsori());

        // jeeg2.attacco();

        Jeeg jeeg2 = new Jeeg(new Forcone("destro"), new Cannone("sinistro"), new Tank());

        jeeg2.attacco();
        
    }
}
