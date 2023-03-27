import java.util.Scanner;
// scrivere un programma che prenda in input un numero, che crei un array di lunghezza pari al numero inserito, che chieda un numero di elementi pari al numero inserito e ne faccia la media
public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un numero ");

        int num = Integer.parseInt(sc.nextLine());

        int[] arr = new int[num];
        
        int newNum = 0;

        for(int i = 0; i < arr.length; i++){

            System.out.println("Inserisci un nuovo numero ");

            newNum += Integer.parseInt(sc.nextLine());

        }

        System.out.println("La sommatoria di tutti i numeri è " + newNum + " e la sua media è " + (newNum / arr.length) + " con resto di " + (newNum % arr.length) );
    }

}