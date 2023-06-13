package com.paprota.kiteapp.service.report;

import com.paprota.kiteapp.entity.Report.Report;

import java.util.List;

public interface ReportService {

    List<Report> findAll();
    Report findById(int theId);

    void save(Report theReport);

    void deleteById(int theId);



}
