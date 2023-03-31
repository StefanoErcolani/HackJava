public class App {
    public static void main(String[] args) throws Exception {

        // FactoryPrototype factory1 = new FactoryPrototype();

        // Claws claw1 = factory1.monsterPrototype(ComponentEnum.Clawtop, Claws.class);

        // Claws claw2 = factory1.monsterPrototype(ComponentEnum.Clawdown, Claws.class);

        // Torso torso1 = factory1.monsterPrototype(ComponentEnum.Torso, Torso.class);

        // CancerousMass mass1 = factory1.monsterPrototype(ComponentEnum.CancerousMasssx, CancerousMass.class);

        // CancerousMass mass2 = factory1.monsterPrototype(ComponentEnum.CancerousMassdx, CancerousMass.class);

        // Combine monster1 = new Combine(claw1, mass2, mass2, claw1, torso1);

        // System.out.println("IT'S ALIVE! NOW IT CAN ");
        // System.out.println(" ");
        // monster1.dangers();
        // monster1.moving();

        FactorSingleton factory2 = new FactorSingleton();

        Claws claw3 = factory2.monsterSingleton(ComponentEnum.Clawtop, Claws.class);

        Claws claw4 = factory2.monsterSingleton(ComponentEnum.Clawtop, Claws.class);

        Claws claw5 = factory2.monsterSingleton(ComponentEnum.Clawtop, Claws.class);

        Claws claw6 = factory2.monsterSingleton(ComponentEnum.Clawtop, Claws.class);

        Torso torso2 = factory2.monsterSingleton(ComponentEnum.Torso, Torso.class);

        Combine monster2 = new Combine(claw3, claw4, claw5, claw6, torso2);

        monster2.dangers();
        monster2.dangers();
        monster2.dangers();
    }
}
