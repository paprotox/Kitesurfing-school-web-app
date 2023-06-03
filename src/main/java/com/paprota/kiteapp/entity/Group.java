package com.paprota.kiteapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


@Entity
@Table(name = "grouptable")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @Column(name = "trainee_number")
    private int traineeNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;

    @OneToMany(mappedBy = "group",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Trainee> trainees;

    @Value("${max.trainee.number}")
    private static int MaxTraineeNumber;


    public Group() {
    }

    public Group(Level level, List<Trainee> trainees) {
        this.traineeNumber = 0;
        this.level = level;
        this.trainees = trainees;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        if (trainees.size() >= MaxTraineeNumber) {
            throw new IllegalArgumentException("Limit of trainees exceeded");
        }
        this.trainees = trainees;
        this.traineeNumber = trainees.size();
        for (Trainee trainee : trainees) {
            trainee.setGroup(this); // Ustawia relację z obiektem Group dla każdego Trainee
        }
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
        trainee.setGroup(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTraineeNumber() {
        return traineeNumber;
    }

    public void setTraineeNumber(int traineeNumber) {
        this.traineeNumber = traineeNumber;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public static int getMaxTraineeNumber() {
        return MaxTraineeNumber;
    }

    public static void setMaxTraineeNumber(int maxTraineeNumber) {
        MaxTraineeNumber = maxTraineeNumber;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", traineeNumber=" + traineeNumber +
                ", level=" + level +
                ", trainees=" + trainees +
                '}';
    }
}
