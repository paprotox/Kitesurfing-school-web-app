package com.paprota.kiteapp.dao;

import com.paprota.kiteapp.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

    @Query("SELECT t FROM Trainee t WHERE t.group IS NULL ")
    List<Trainee> findTraineesWithoutGroup();

}
