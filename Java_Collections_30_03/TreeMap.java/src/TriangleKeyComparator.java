import java.util.Comparator;

//Specificare su che oggetti deve lavorare rendendo non necessario il casting degli oggetti specifici nella comparazione invece dei generici.
public class TriangleKeyComparator implements Comparator<TriangleKey>{

    @Override
    public int compare(TriangleKey p1, TriangleKey p2) {

        return p1.progressivo - p2.progressivo;
    }

}