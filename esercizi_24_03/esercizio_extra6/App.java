//FizzBuzz

public class App{

    public static void main(String[] args){

    for(int i = 0; i <= 100; i++){

        if(i % 3 == 0 && i % 5 == 0){

            System.out.println("FIZZBUZZ!");

        } else if(i % 3 == 0){

            System.out.println("FIZZ!");

        } else if(i % 5 == 0){

            System.out.println("BUZZ!");

        } else{

            System.out.println(i);

        }

    }

    }
}