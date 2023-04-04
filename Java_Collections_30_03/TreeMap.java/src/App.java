import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class App {
    
    public static void main(String[] args){
        
        Triangle t1 = new Triangle(1, 2, 2);
        TriangleKey tk1 = new TriangleKey("b", 2);

        Triangle t2 = new Triangle(2, 3, 3);
        TriangleKey tk2 = new TriangleKey("abba", 1);

        Triangle t3 = new Triangle(3, 4, 4);
        TriangleKey tk3 = new TriangleKey("c", 0);

        //new Comparator vuoto permette di far capire di ordinare secondo questo oggetto.
        Map<TriangleKey, Triangle> triangoli = new TreeMap<TriangleKey, Triangle>(new TriangleKeyComparator());
        
        triangoli.put(tk1, t1);
        
        triangoli.put(tk2, t2);
        
        triangoli.put(tk3, t3);
        //ordinare gli elementi in base al comparator
        for(TriangleKey tk : triangoli.keySet()){
            System.out.println(tk.get().s1);

        }
    }
}
