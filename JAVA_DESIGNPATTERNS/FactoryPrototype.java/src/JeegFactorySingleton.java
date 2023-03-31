import java.util.Map;
import java.util.HashMap;

public class JeegFactorySingleton {
        
private Map<JeegEnumComponents, Object> registry = new HashMap<JeegEnumComponents, Object>(); 

@SuppressWarnings("unchecked")

public <T> T creatorSingleton(JeegEnumComponents componentType, Class<T> Classtype){

    switch(componentType){

        case GalacticDrillSx : 

        if(!registry.containsKey(componentType)) { registry.put(componentType, new GalacticDrill("left")); }

        break;

        case GalacticDrillDx :

        if(!registry.containsKey(componentType)) { registry.put(componentType, new GalacticDrill("right")); }

        break;

        case MegaPunchDx :

        if(!registry.containsKey(componentType)) { registry.put(componentType, new MegaPunch("right")); }

        break;

        case MegaPunchSx :

        if(!registry.containsKey(componentType)) { registry.put(componentType, new MegaPunch("left")); }

        break;

        case Jet :

        if(!registry.containsKey(componentType)) { registry.put(componentType, new Jet()); }

        break;

        case Tank :

        if(!registry.containsKey(componentType)) { registry.put(componentType, new Tank()); }

        break;

    }

    return (T) registry.get(componentType);

}
}
