package it.aulab.springprogetto.dto;

import it.aulab.springprogetto.model.Person;

public class UpdateStudentDTO {
    
    private Long id;

    private Person data;

    public UpdateStudentDTO() {};

    
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


}
