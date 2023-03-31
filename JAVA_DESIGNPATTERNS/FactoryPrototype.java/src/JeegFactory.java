public class JeegFactory {
    
    //Oggetti con cui creare Jeeg, necessita di generico obj

    public Object creator(JeegEnumComponents componentType){

        Object component = null;

        switch(componentType){

            case GalacticDrillSx : 

            component =  new GalacticDrill("left");

            break;

            case GalacticDrillDx :

            component = new GalacticDrill("right");

            break;

            case MegaPunchDx :

            component = new MegaPunch("right");

            break;

            case MegaPunchSx :

            component = new MegaPunch("left");

            break;

            case Jet :

            component = new Jet();

            break;

            case Tank :

            component = new Tank();

            break;

        }

        return component;

    }

}
