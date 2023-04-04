public class App{
    public static void main(String[] args) throws Exception {

        GenericClass test1 = new GenericClass();

        Integer[] i = new Integer[]{1, 2, 4, 7, 8};

        System.out.println("Sono pari o dispari?");
        test1.<Integer>filterEven(i);

    }
}
