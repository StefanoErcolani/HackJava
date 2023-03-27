public class Cat {
    
    //attributi
    String furColor;

    int whiskersNumber;

    boolean hasTail;

    //costruttore
    public Cat(String fur, int whiskers, boolean tail){
        //this riferimento a ogni oggetto istanziato dalla classe cat
        this.furColor = fur;

        this.whiskersNumber = whiskers;

        this.hasTail = tail;

    }

    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;

        if(obj == null || this.getClass() != obj.getClass()) return false;

        Cat other = (Cat) obj;
        if((this.furColor == other.furColor) && (this.whiskersNumber == other.whiskersNumber) && (this.hasTail == other.hasTail))return true;
        return false;

    }
}
