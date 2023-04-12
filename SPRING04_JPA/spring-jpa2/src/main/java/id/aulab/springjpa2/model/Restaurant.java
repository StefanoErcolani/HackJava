package id.aulab.springjpa2.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    
    @Column(name = "name", length = 64)
    private String name;

    
    @Column(name = "description", length = 1023)
    private String description;

    
    @Column(name = "number_clients")
    private Integer numberClients;

    @OneToMany(mappedBy = "restaurant")
    List<Menu> menu = new ArrayList<Menu>();


    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public Restaurant(){
    }

    // public List<Menu> getMenu() {
    //     return menu;
    // }

    // public void setMenu(List<Menu> menu) {
    //     this.menu = menu;
    // }

    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getNumber_clients() {
        return numberClients;
    }
    public void setNumber_clients(Integer numberClients) {
        this.numberClients = numberClients;
    }


}
