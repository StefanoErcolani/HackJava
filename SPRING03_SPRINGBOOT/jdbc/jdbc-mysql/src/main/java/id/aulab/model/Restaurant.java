package id.aulab.model;

import java.math.BigInteger;

public class Restaurant {
    
    private BigInteger id;
    private String name;
    private String description;
    private Integer number_clients;

    public Restaurant(){
    }

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
        return number_clients;
    }
    public void setNumber_clients(Integer number_clients) {
        this.number_clients = number_clients;
    }

    

}
