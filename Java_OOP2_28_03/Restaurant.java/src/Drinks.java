public class Drinks extends MenuItem{

    private Dish[] dish;

    public Drinks(String name, String price) {
        super(name, price);

    }

    public Dish[] getDish() {
        return dish;
    }

    public void setDish(Dish[] dish) {
        this.dish = dish;
    }

    public void printDish(){

        for(Dish d : dish){

            System.out.println(d.getName() + " : " + d.getPrice());

        }

    }
}
