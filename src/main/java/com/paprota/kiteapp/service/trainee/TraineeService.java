package com.paprota.kiteapp.service.trainee;

import com.paprota.kiteapp.entity.Trainee;

import java.util.List;

public interface TraineeService {

    List<Trainee> findAll();
    Trainee findById(int theId);

    void save(Trainee theTrainee);

    void deleteById(int theId);

    List<Trainee> findTraineesWithoutGroup();
}
