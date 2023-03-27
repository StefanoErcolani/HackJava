import java.util.Scanner;
// scrivere un programma che controlli se una stringa è palindroma

public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserisci una parola ");

        String txt = sc.nextLine();

        int len = txt.length();

        String reverse = "";

        //Ciclo inverso
        for(int i = len-1; i >= 0; i--){

            reverse += txt.charAt(i);
                
        }

        if(txt.equals(reverse)) {System.out.println("La parola é palindroma");}
        else { System.out.println("La parola NON é palindroma");}
    }

}