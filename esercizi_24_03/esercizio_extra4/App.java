import java.util.Scanner;
// scrivere un programma che prenda in input un numero, che crei un array di lunghezza pari al numero inserito, che chieda un numero di elementi pari al numero inserito e stampi solo gli elmenti in posizione pari
public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Insersci un numero ");

        int num = Integer.parseInt(sc.nextLine());

        int[] arr = new int[num];

        int contatore = 0;
        
        for(int i = 0; i < arr.length; i++){

            System.out.println("Inserisci un nuovo numero ");

            int newNum = Integer.parseInt(sc.nextLine());

            if(contatore % 2 == 0 && contatore > 0) System.out.println(newNum);
            else System.out.println("Mhanz!");

            contatore++;

        }

    }

}