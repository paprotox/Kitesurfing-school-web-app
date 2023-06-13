package com.paprota.kiteapp.entity.Report;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "descriptive_report")
public class DescriptiveReport extends Report{

    @Column(name = "description")
    private String description;

    public DescriptiveReport(String topic, String productionDate, List<BosmanReport> bosmans, String description) {
        super(topic, productionDate, bosmans);
        this.description = setDescription(description);
    }

    public DescriptiveReport() {
    }


    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        if (description.length() > 300) {
            throw new IllegalArgumentException("The description cannot exceed 300 characters.");
        }

        this.description = description;
        return description;
    }

    @Override
    public String toString() {
        return "DescriptiveReport{" +
                "description='" + description + '\'' +
                '}';
    }
}
