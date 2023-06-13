package com.paprota.kiteapp.entity.Report;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    @Column(name = "topic")
    private String topic;

    @Column(name = "production_date")
    private String productionDate;
    @OneToMany(mappedBy = "report",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BosmanReport> bosmans = new ArrayList<>();

    public Report(String topic, String productionDate, List<BosmanReport> bosmans) {
        this.topic = topic;
        this.productionDate = productionDate;
        this.bosmans = bosmans;
    }

    public Report() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public List<BosmanReport> getBosmans() {
        return bosmans;
    }

    public void setBosmans(List<BosmanReport> bosmans) {
        this.bosmans = bosmans;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", bosmans=" + bosmans +
                '}';
    }
}
