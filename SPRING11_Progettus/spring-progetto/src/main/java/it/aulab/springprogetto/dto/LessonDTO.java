package it.aulab.springprogetto.dto;


public class LessonDTO {
    
    private Long id;

    private String description;

    private String date;

    public LessonDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
