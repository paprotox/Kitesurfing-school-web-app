package com.paprota.kiteapp.entity.Report;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "photo_report")
public class PhotoReport extends Report{

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    public PhotoReport() {
    }

    public PhotoReport(String topic, String productionDate, List<BosmanReport> bosmans, String fileName, String filePath) {
        super(topic, productionDate, bosmans);
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "PhotoReport{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
