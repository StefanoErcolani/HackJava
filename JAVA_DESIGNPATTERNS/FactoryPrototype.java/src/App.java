public class App {
    public static void main(String[] args) throws Exception {


        //FACTORY CON PROTOTYPE CHIEDO UN OGGETTO DI UN TIPO E SENZA AUTO-CASTING
        // JeegFactory factory = new JeegFactory();

        // MegaPunch pugnone1 = (MegaPunch) factory.creator(JeegEnumComponents.MegaPunchSx);

        // GalacticDrill drillone1 = (GalacticDrill) factory.creator(JeegEnumComponents.GalacticDrillDx);

        // Jet jet1 = (Jet) factory.creator(JeegEnumComponents.Jet);

        // Jeeg j1 = new Jeeg(pugnone1, drillone1, jet1);

        // j1.attack();

        // j1.forward();

        // j1.attack();

        // JeegFactoryPrototype factory = new JeegFactoryPrototype();

        // MegaPunch pugnone1 =  factory.creatorPrototype(JeegEnumComponents.MegaPunchSx, MegaPunch.class);

        // GalacticDrill drillone1 = factory.creatorPrototype(JeegEnumComponents.GalacticDrillDx, GalacticDrill.class);

        // Jet jet1 =  factory.creatorPrototype(JeegEnumComponents.Jet, Jet.class);

        // Jeeg j1 = new Jeeg(pugnone1, drillone1, jet1);

        // j1.attack();

        // j1.forward();

        // j1.attack();

        //FACTORY CON SINGLETON 

        JeegFactorySingleton factory = new JeegFactorySingleton();

        MegaPunch pugno1 = factory.creatorSingleton(JeegEnumComponents.MegaPunchDx, MegaPunch.class);

        MegaPunch pugno2 = factory.creatorSingleton(JeegEnumComponents.MegaPunchDx, MegaPunch.class);
        
        Jet jet2 = factory.creatorSingleton(JeegEnumComponents.Jet, Jet.class);
        // System.out.println(pugno1 + " " + pugno2);
        Jeeg j3 = new Jeeg(pugno1, pugno2, jet2);

        j3.attack();
        j3.forward();
    }
}
