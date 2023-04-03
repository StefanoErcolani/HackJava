import java.util.Comparator;

public class MyComparator{

    public static <T> Comparator<T> reverse(Comparator<T> comparator){
        //invertire la lunghezza -> invertire il sort in custom mode
        return (a,b) -> -1*comparator.compare(a,b);
    }
    
}