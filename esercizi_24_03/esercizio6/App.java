import java.util.Scanner;
// scrivere un programma che prenda in input un numero, che crei un array di lunghezza pari al numero inserito, che chieda un numero di elementi pari al numero inserito e ritorni il valore massimo inserito

public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserisci un numero: ");

        int num = Integer.parseInt(sc.nextLine());

        int[] arr = new int[num];

        for(int i = 0; i < arr.length; i++){
            
            System.out.println("Inserisci un nuovo numero ");

            int newNum = Integer.parseInt(sc.nextLine());

            arr[i] = newNum;
            
        }

        int counter = 0;

        int bigChungus = arr[0];

        for(int j = 0; j < arr.length; j++){

            if(arr[j] > bigChungus){

                bigChungus = arr[j];

                counter = j;

            }

        }
        
        System.out.println("Here come that boi! It's " + bigChungus + " and it can be found only in the " + counter + " position!");
    }

}