import java.util.Scanner;
// scrivere un programma che prenda in input un numero e ritorni l’inverso del numero inserito es. 123 => 321

public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un numero intero");

        int num = Integer.parseInt(sc.nextLine());

        int modulo = num % 10;   

        for(int i = 0; i < String.valueOf(num).length(); i++){

            modulo *= 10;

            num /= 10;

            modulo += num % 10;
            
            System.out.println(modulo);
        }
        
    }

}