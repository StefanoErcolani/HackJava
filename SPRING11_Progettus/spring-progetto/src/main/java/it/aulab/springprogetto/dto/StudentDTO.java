package it.aulab.springprogetto.dto;

import it.aulab.springprogetto.model.Person;

public class StudentDTO {
    
    private Long id;

    private Person data;

    private String email;
    
    public StudentDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    };

    

}
