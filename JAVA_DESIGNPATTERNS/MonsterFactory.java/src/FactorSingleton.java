import java.util.Map;
import java.util.HashMap;

public class FactorSingleton{

    private Map<ComponentEnum, Object> registry = new HashMap<ComponentEnum, Object>();

    @SuppressWarnings("unchecked")


    public <T> T monsterSingleton(ComponentEnum type, Class<T> Classtype){

        switch(type) {

            case Clawsx:

            if(!registry.containsKey(type)) registry.put(type, new Claws(" left "));

            break;

            case Clawdx:

            if(!registry.containsKey(type)) registry.put(type, new Claws(" right "));

            break;

            case Clawtop:

            if(!registry.containsKey(type)) registry.put(type, new Claws(" top "));

            break;

            case Clawdown:

            if(!registry.containsKey(type)) registry.put(type, new Claws(" down "));

            break;

            case CancerousMasssx :

            if(!registry.containsKey(type)) registry.put(type, new CancerousMass(" left "));

            break;

            case CancerousMassdx :

            if(!registry.containsKey(type)) registry.put(type, new CancerousMass(" right "));

            break;

            case CancerousMasstop :

            if(!registry.containsKey(type)) registry.put(type, new CancerousMass(" down "));

            break;

            case CancerousMassdown :

            if(!registry.containsKey(type)) registry.put(type, new CancerousMass(" down "));

            break;

            case Torso :

            if(!registry.containsKey(type)) registry.put(type, new Torso());

            break;

        }
    
        return (T) registry.get(type);
    }

}