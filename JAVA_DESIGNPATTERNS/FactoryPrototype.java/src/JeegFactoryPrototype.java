public class JeegFactoryPrototype {
    
    
@SuppressWarnings("unchecked")

    public <T> T creatorPrototype(JeegEnumComponents componentType, Class<T> Classtype){

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

        return (T) component;

    }

}
