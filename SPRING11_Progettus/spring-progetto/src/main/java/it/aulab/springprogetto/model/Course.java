package it.aulab.springprogetto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name  = "courses")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Embedded
    @AttributeOverrides({

        @AttributeOverride(name = "firstname", 
            column = @Column(name = "teacher_firstname", length = 100, nullable = false)),

        @AttributeOverride(name = "lastname", 
            column = @Column(name = "teacher_lastname", length = 100, nullable = false)),
    })
    private Person teacher;

    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons = new ArrayList<Lesson>();

    @ManyToMany
    @JoinTable(name = "courses_students",     
        joinColumns = @JoinColumn(name = "course_id", nullable = false), 
        inverseJoinColumns = @JoinColumn( name = "student_id", nullable = false)
        )
    private List<Student> students;

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

