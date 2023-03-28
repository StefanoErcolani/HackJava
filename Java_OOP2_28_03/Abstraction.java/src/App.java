public class App {
    public static void main(String[] args) throws Exception {
        //metodo 1
        // Jeeg jeeg = new Jeeg(new Gun("sinistro", "fucile"), new Laser("destro", "raggioni"));

        // jeeg.attacco();

        Arms armsx = new Gun("sinistro", "fucile");

        Arms armdx = new Laser("destro", "raggiòn");

        Jeeg jeeg = new Jeeg(armsx, armdx);
        
        jeeg.attacco();

    }
}
