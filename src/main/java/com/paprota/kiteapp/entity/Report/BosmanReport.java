package com.paprota.kiteapp.entity.Report;

import com.paprota.kiteapp.entity.Employee;
import jakarta.persistence.*;

@Entity
public class BosmanReport {

    @EmbeddedId
    private BosmanReportId id;

    @Column(name = "reports_made")
    private int reportsMade;

    @ManyToOne
    @MapsId("bosmanId")
    private Employee bosman;

    @ManyToOne
    @MapsId("reportId")
    private Report report;

    public BosmanReport() {
    }

    public BosmanReport(int reportsMade, Employee bosman, Report report) {
        this.reportsMade = reportsMade;
        this.bosman = bosman;
        this.report = report;
    }

    public int getReportsMade() {
        return reportsMade;
    }

    public void setReportsMade(int reportsMade) {
        this.reportsMade = reportsMade;
    }

    public BosmanReportId getId() {
        return id;
    }

    public void setId(BosmanReportId id) {
        this.id = id;
    }

    public Employee getBosman() {
        return bosman;
    }

    public void setBosman(Employee bosman) {
        this.bosman = bosman;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "BosmanReport{" +
                "id=" + id +
                ", bosman=" + bosman +
                ", report=" + report +
                '}';
    }
}
