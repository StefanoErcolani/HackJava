import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        //Dish
        System.out.println("Inserisci nome del piatto ");

        String dishName = sc.nextLine();

        System.out.println("Inserisci prezzo del piatto ");

        String dishPrice = sc.nextLine();

        Dish dish = new Dish(dishName, dishPrice);

        //Drink
        System.out.println("Inserisci nome della bevanda ");

        String drinkName = sc.nextLine();

        System.out.println("Inserisci prezzo della bevanda ");

        String drinkPrice = sc.nextLine();

        Drinks drink = new Drinks(drinkName, drinkPrice);
        
        //Dish[] and Drink[]
        Dish[] menuDish = new Dish[]{dish};

        Drinks[] menuDrink = new Drinks[]{drink};

        //Restaurant
        Restaurant r = new Restaurant("Da Pino", menuDish, menuDrink);
         r.printMenu();
    }
}
