package esercizio_extra8;
import java.util.Scanner;

public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un numero ");

        int num = Integer.parseInt(sc.nextLine());

        int counter = num;

        int temp = num;

        while(counter > 0){

            counter--;
        
            if(counter > 0) num = num * (counter);
            
        }
        
        System.out.println("Il fattoriale di " + temp + " è " + num);
    }

}