package com.paprota.kiteapp.entity.Report;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BosmanReportId implements Serializable {

    @Column(name = "bosman_id")
    private String bosmanId;

    @Column(name = "report_id")
    private String reportId;

    public BosmanReportId() {
    }

    public BosmanReportId(String bosmanId, String reportId) {
        this.bosmanId = bosmanId;
        this.reportId = reportId;
    }

    public String getBosmanId() {
        return bosmanId;
    }

    public void setBosmanId(String bosmanId) {
        this.bosmanId = bosmanId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return "BosmanReportId{" +
                "bosmanId='" + bosmanId + '\'' +
                ", reportId='" + reportId + '\'' +
                '}';
    }
}
