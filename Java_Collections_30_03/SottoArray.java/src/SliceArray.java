public class SliceArray<T>{
    
    // //costruire array generici
    // T[] array = (T[])new Object[]{};

    // int supIndex;

    // int infIndex;

    // T[] array2 = (T[]) new Object[supIndex - infIndex + 1];

    // public SliceArray(T[] array, int supIndex, int infIndex, T[] array2) {
    //     this.array = array;
    //     this.supIndex = supIndex;
    //     this.infIndex = infIndex;
    //     this.array2 = array2;
    // }


    public void slicer(T[] array, int supIndex, int infIndex){

        T[] array2 = (T[]) new Object[supIndex - infIndex - 1];

        int index = 0;

        for(T item : array){
        
            if((array.length >= infIndex || array.length <= supIndex) && (index < array2.length)){

                array2[index] = item;
                index++;

            }

        }

        for(T el : array2){

            System.out.println(el);

        }

    }
}
