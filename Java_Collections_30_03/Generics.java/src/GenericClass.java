public class GenericClass <T extends Number>{
    
    public void filterEven(T[] arr) {

        Integer[] num = (Integer[]) arr;

        for(Integer item : num){

            if(item % 2 == 0) System.out.println("Numero pari " + item);

            if(item % 2 != 0) System.out.println("Numero dispari " + item);

            if(item % 2 != 0 || item == 2){

                if((item % 3 != 0 && item % 5 == 0 && item % 7 == 0) || item == 2){

                    System.out.println("Numero primo " + item);

                }

            }
        }   
    
    }

    // public boolean isPrime(T[] arr){
        
    //     Integer[] num = (Integer[]) arr;

    //     for(Integer item : num){

    //         if(item <= 1){
    //             return false;

    //         }

    //         for (int i = 2; i <= item / i; i++) {

    //             if ((item % i) == 0) {

    //                 return false;

    //             } else {

    //                 return true;

    //             }
    //         }
            
        
    //     }

    // }



}

