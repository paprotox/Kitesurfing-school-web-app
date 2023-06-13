package com.paprota.kiteapp.dao;

import com.paprota.kiteapp.entity.Opinion;
import com.paprota.kiteapp.entity.Trainee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

    @Query("SELECT t FROM Trainee t WHERE t.group IS NULL ")
    List<Trainee> findTraineesWithoutGroup();
    @Query("SELECT o FROM Opinion o WHERE o.trainee.id = :traineeId AND o.camp.id = :campId")
    Opinion findByTraineeIdAndCampId(@Param("traineeId") int traineeId, @Param("campId") int campId);



}
