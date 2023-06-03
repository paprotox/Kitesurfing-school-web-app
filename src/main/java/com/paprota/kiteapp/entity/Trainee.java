package com.paprota.kiteapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "trainee")
public class Trainee extends Person{

    @Column(name = "health_status")
    private String healthStatus;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "group_table_id")
    private Group group;

    public Trainee(String firstName, String lastName, Gender gender, LocalDate birthDate, String healthStatus, Contact contact) {
        super(firstName, lastName, gender, birthDate,contact);
        this.healthStatus = healthStatus;
    }

    public Trainee() {

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "healthStatus='" + healthStatus + '\'' +
                ", group=" + group +
                '}';
    }
}
