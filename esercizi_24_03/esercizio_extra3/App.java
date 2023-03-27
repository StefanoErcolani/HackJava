import java.util.Scanner;
// Scrivere un programma che prenda in input dall’utente un numero peso e un numero altezza e calcoli il BMI. Formula BMI => peso / (altezza * altezza) * 703
public class App{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci il tuo peso ");

        float peso = Float.parseFloat(sc.nextLine()); 

        System.out.println("Inserisci la tua altezza ");

        float altezza = Float.parseFloat(sc.nextLine()); 

        float bmi = peso/(altezza * altezza);

        System.out.println("Il tuo BMI è " + bmi);

    }

}