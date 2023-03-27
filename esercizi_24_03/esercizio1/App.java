import java.util.Scanner;
// - scrivere un programma che prenda dal prompt una password e controlli la sua validità. La pwd è valida se:
// - ha almeno 8 caratteri
// - ha almento un numero
// - ha almeno un carattere in stampatello
// - extra: contiene un carattere speciale “!”, “£”, “$”, “%”, “&”
public class App{

    // public boolean checkNumAndUpperCase(String str){

    // }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci la tua password ");

        String str = sc.nextLine();

        boolean firstRule = false;
        
        //First rule
        if(str.length() >= 8) firstRule = true;

        //Controllo password
        if(firstRule && otherRules(str)) {
            System.out.println("La password è corretta");
        } else{
            System.out.println("La password non è corretta");
        }

    }

    public static boolean otherRules(String str){

        boolean secondRule = false;

        boolean thirdRule = false;

        boolean extraRule = false;

        for(int i = 0; i < str.length(); i++){

            char letter = str.charAt(i);
            
            if(Character.isDigit(letter))  secondRule = true;

            if(Character.isUpperCase(letter)) thirdRule = true;

            // if(Character.isDigit(letter) == false && Character.isUpperCase(letter) == false && Character.isLetter(letter) == false) extraRule = true;

            if(letter == '!' && letter == '£' && letter == '$' && letter == '%' && letter == '&') extraRule = true;

        }

        return secondRule && thirdRule && extraRule;
    }


}