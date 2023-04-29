package it.aulab.springprogetto.dto;

public class CreateLessonDTO {
    
    private String description;

    private String date;

    public CreateLessonDTO() {
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
    

}
