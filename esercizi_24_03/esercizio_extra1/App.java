import java.util.Scanner;
// Scrivere un programma che prenda in input un numero e ritorni se il numero è pari o dispari
public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un numero ");

        int num = Integer.parseInt(sc.nextLine());

        if(num % 2 == 0){

            System.out.println("Il numero " + num + " è pari.");

        } else{

            System.out.println("Il numero " + num + " è dispari.");

        }

    }

}