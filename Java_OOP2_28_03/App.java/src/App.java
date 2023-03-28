public class App {
    public static void main(String[] args) throws Exception {

        //metodo 1
        // Jeeg jeeg = new Jeeg(new Arms("sinistro"), new Arms("destro"), new Legs());

        //metodo 2
        Arms armsx = new Arms("sinistro");

        Arms armdx = new Arms("destro");

        Legs legs = new Legs();

        Jeeg jeeg = new Jeeg(armdx, armsx, legs);

        jeeg.attacca(); 
    }
}
