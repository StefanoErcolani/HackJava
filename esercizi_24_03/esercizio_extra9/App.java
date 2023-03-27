import java.util.Scanner;

public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Primo numero ");
        int num1 = Integer.parseInt(sc.nextLine());

        System.out.println("Secondo numero ");
        int num2 = sc.nextInt();

        System.out.println("Terzo numero ");
        int num3 = sc.nextInt();

        if(num3 == (num1 + num2)) System.out.println("Fibonacci?");
        else System.out.println("No Fibonacci.");

    }

}