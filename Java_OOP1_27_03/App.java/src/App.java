public class App {
    public static void main(String[] args) throws Exception {
        Cat cat1 = new Cat("black", 14, true);

        Cat cat2 = new Cat("black", 14, true);

        Cat cat3 = new Cat("blue", 7, false);
        System.out.println(cat1.equals(cat2));
        System.out.println(cat1.equals(cat3));
    }
}
