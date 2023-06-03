package com.paprota.kiteapp.service.trainee;

import com.paprota.kiteapp.dao.TraineeRepository;
import com.paprota.kiteapp.entity.Trainee;
import com.paprota.kiteapp.service.trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService {

    TraineeRepository traineeRepository;

    @Autowired
    public TraineeServiceImpl(TraineeRepository theTraineeRepository) {
        traineeRepository = theTraineeRepository;
    }

    @Override
    public List<Trainee> findAll() {
        return traineeRepository.findAll();
    }

    @Override
    public Trainee findById(int theId) {
        Optional<Trainee> result = traineeRepository.findById(theId);

        Trainee theTrainee = null;

        if (result.isPresent()) {
            theTrainee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theTrainee;
    }

    @Override
    public void save(Trainee theTrainee) {
        traineeRepository.save(theTrainee);
    }

    @Override
    public void deleteById(int theId) {
        traineeRepository.deleteById(theId);
    }

    @Override
    public List<Trainee> findTraineesWithoutGroup() {
        return traineeRepository.findTraineesWithoutGroup();
    }
}
