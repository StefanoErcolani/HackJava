import java.util.Scanner;
// scrivere un programma che chieda all’utente una stringa e ritorni le iniziali di ogni parola con il . Esempio: “Ciao sono una stringa” => c.s.u.s
public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci una frase ");

        String str = sc.nextLine();

        String empty = "";

        for (String element : str.split(" ")) {
        
            empty += (element.charAt(0) + ".");

        }

        System.out.println(empty);
    }

}