package com.paprota.kiteapp.dao;

import com.paprota.kiteapp.entity.Report.Report;
import com.paprota.kiteapp.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
