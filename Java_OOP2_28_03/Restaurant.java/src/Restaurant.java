public class Restaurant {

    public String name;
    
    public Dish[] dish;

    public Drinks[] drink;


    public Restaurant(String name, Dish[] dish, Drinks[] drink) {
        this.name = name;
        this.dish = dish;
        this.drink = drink;  
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dish[] getDish() {
        return dish;
    }

    public void setDish(Dish[] dish) {
        this.dish = dish;
    }

    public Drinks[] getDrink() {
        return drink;
    }

    public void setDrink(Drinks[] drink) {
        this.drink = drink;
    }

    
    public void printMenu(){

        System.out.println("Menù della casa: ");

        for(Dish d : dish){

            System.out.println(d.getName() + " : " + d.getPrice());

        }

        for(Drinks dr : drink){

            System.out.println(dr.getName() + " : " + dr.getPrice());
        }
    
    }

}
