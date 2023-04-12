package id.aulab.springjpa2.model;

import java.math.BigInteger;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "dish_name", length = 64)
    private String dishName;
    
    @Column(name = "ingredients", length = 1024)
    private String ingredients;

    @Column(name = "price")
    private Integer price;

    //Riconosce per mappare tramite nome campo o tipo di riferimento per questo annotare join
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToMany
    @JoinTable(name = "menu_clients", 
        joinColumns = @JoinColumn(name = "menu_id"), 
        inverseJoinColumns = @JoinColumn(name = "clients_id"))
    private List<Clients> client;


    public Menu(){
    }

    public List<Clients> getClients(){
        return client;
    }

    public void setClients(List<Clients> client) {

        this.client= client;

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurantId(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    
}
