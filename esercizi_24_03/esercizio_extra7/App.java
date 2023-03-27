import java.util.Scanner;

public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un numero ");

        int num1 = Integer.parseInt(sc.nextLine());

        System.out.println("Inserisci un secondo numero ");

        int num2 = Integer.parseInt(sc.nextLine());

        int temp = 0;

        temp = num1;

        System.out.println("Swapperoni : " + (num1 = num2));

        System.out.println("Swapperoni : " + (num2 = temp)); 


    }

}