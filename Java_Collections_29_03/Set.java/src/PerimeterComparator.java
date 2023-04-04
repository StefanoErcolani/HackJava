 import java.util.Comparator;
// public class PerimeterComparator implements Comparator{
    
//     @Override
//     public int compare(Object obj1, Object obj2){
//         Triangle t1 = (Triangle) obj1;
//         Triangle t2 = (Triangle) obj2;

//         return (t1.getS1() + t1.getS2() + t1.getS3()) - (t2.getS1() + t2.getS2() + t2.getS3());
//     }

// }


//factoring per evitare il casting
public class PerimeterComparator implements Comparator<Triangle>{

    @Override
    public int compare(Triangle t1, Triangle t2){

        return (t1.getS1() + t1.getS2() + t1.getS3()) - (t2.getS1() + t2.getS2() + t2.getS3());

    }

}