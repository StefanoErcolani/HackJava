public class App {

    public static void main(String[] args) throws Exception {

        SliceArray<Integer> num = new SliceArray<Integer>();
        
        Integer[] test = new Integer[]{ 2, 3, 4, 5, 6, 6,};

        num.slicer(test, 5, 1);
    }
}
