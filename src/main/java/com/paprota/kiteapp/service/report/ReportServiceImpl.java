package com.paprota.kiteapp.service.report;

import com.paprota.kiteapp.dao.ReportRepository;
import com.paprota.kiteapp.entity.Report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository theReportRepository) {
        reportRepository = theReportRepository;
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report findById(int theId) {
        Optional<Report> result = reportRepository.findById(theId);

        Report theReport= null;

        if (result.isPresent()) {
            theReport = result.get();
        }
        else {
            throw new RuntimeException("Did not find report id - " + theId);
        }

        return theReport;
    }

    @Override
    public void save(Report theReport) {
        reportRepository.save(theReport);
    }

    @Override
    public void deleteById(int theId) {
        reportRepository.deleteById(theId);
    }


}
