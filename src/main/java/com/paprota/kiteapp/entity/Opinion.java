package com.paprota.kiteapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "opinion")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @Column(name = "insertion_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate insertionDate;

    @Column(name = "text")
    private String text;

    @Column(name = "grade")
    private int grade;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Trainee trainee;

    @ManyToOne
    @JoinColumn(name = "camp_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Camp camp;

    public Opinion() {
        this.insertionDate = LocalDate.now();
    }

    public Opinion(String text, int grade, Trainee trainee, Camp camp) {
        this.insertionDate = LocalDate.now();
        setText(text);
        setGrade(grade);
        this.trainee = trainee;
        this.camp = camp;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(LocalDate insertionDate) {
        this.insertionDate = insertionDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(text.isEmpty()) {
            this.text = null;
        } else {
            this.text = text;
        }
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if(grade < 1 || grade > 10) {
            throw new IllegalArgumentException("The grade has to be in range of 1 to 10");
        } else {
            this.grade = grade;
        }
    }

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }
}
