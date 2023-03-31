public class FactoryPrototype {
    
    @SuppressWarnings("unchecked")

    public <T> T monsterPrototype(ComponentEnum type, Class<T> Classtype){

        Object component = null;

        switch(type) {

            case Clawsx:

            component = new Claws("left");

            break;

            case Clawdx:

            component = new Claws(" right ");

            break;

            case Clawtop:

            component = new Claws(" top" );

            break;

            case Clawdown:

            component = new Claws(" down ");

            break;

            case CancerousMasssx :

            component = new CancerousMass(" left ");

            break;

            case CancerousMassdx :

            component = new CancerousMass(" right ");

            break;

            case CancerousMasstop :
 
            component = new CancerousMass(" top ");

            break;

            case CancerousMassdown :

            component = new CancerousMass(" down ");

            break;

            case Torso :

            component = new Torso();

            break;

        }
    
        return (T) component;
    }

}
