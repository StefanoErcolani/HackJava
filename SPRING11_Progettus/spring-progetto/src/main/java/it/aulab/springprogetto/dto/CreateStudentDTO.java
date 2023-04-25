package it.aulab.springprogetto.dto;

import it.aulab.springprogetto.model.Person;

public class CreateStudentDTO {
    
    private Person data;

    private String email;

    public CreateStudentDTO() {}

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
