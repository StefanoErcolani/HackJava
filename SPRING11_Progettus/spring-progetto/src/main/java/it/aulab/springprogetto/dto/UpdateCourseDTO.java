package it.aulab.springprogetto.dto;

import java.util.List;

public class UpdateCourseDTO {
    
    private String name;

    private String description;

    private String date;

    //Qua bisogna riconoscere se gli id degli studenti dovranno essere rimossi o aggiunti
    //Nel caso serve vera logica codice, non un mapping
    private List<Long> addStudentsIds;

    private List<Long> removeStudentsIds;

    public UpdateCourseDTO() {}

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Long> getAddStudentsIds() {
        return addStudentsIds;
    }

    public void setAddStudentsIds(List<Long> addStudentsIds) {
        this.addStudentsIds = addStudentsIds;
    }

    public List<Long> getRemoveStudentsIds() {
        return removeStudentsIds;
    }

    public void setRemoveStudentsIds(List<Long> removeStudentsIds) {
        this.removeStudentsIds = removeStudentsIds;
    }

}
