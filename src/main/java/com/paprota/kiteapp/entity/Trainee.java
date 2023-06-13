package com.paprota.kiteapp.entity;

import com.paprota.kiteapp.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainee")
public class Trainee extends Person{

    @Column(name = "health_status")
    private String healthStatus;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "group_table_id")
    private Group group;

    @OneToMany(mappedBy = "trainee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Opinion> opinions = new ArrayList<>();

    public Trainee(String firstName, String lastName, Gender gender, LocalDate birthDate, String healthStatus, Contact contact) {
        super(firstName, lastName, gender, birthDate,contact);
        this.healthStatus = healthStatus;
    }

    public Trainee() {

    }

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "healthStatus='" + healthStatus + '\'' +
                ", description='" + description + '\'' +
                ", group=" + group +
                '}';
    }
}
