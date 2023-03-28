public class Dish extends MenuItem{

    private Dish[] dish;

    public Dish(String name, String price) {
        super(name, price);

    }

    public Dish[] getDish() {
        return dish;
    }

    public void setDish(Dish[] dish) {
        this.dish = dish;
    }
}
