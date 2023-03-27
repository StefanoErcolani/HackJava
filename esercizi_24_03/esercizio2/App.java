import java.util.Scanner;
// scrivere un programma che prenda in input un numero e ritorni la sommatoria delle cifre che lo compongono es: 123 => 6

public class App{

    public static void main(String[] args){

        int singleDigit = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un numero intero maggiore di 0");

        int num = Integer.parseInt(sc.nextLine());

        //Devo dividere un numero nelle sue cifre
        if(num > 0){
            while(num > 0){
            
                singleDigit += (num % 10);
            //Ciclare le varie digits di num con la divisione per arrivare a 0
                num /= 10;
                
            }

            System.out.println(singleDigit);
        } else{

            System.err.println("Errore! Devi inserire un numero intero maggiore di 0");

        }
        
        // System.out.println(((Object)num).getClass().getSimpleName());
    }

}