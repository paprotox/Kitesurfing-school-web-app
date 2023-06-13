package com.paprota.kiteapp.service.trainee;

import com.paprota.kiteapp.dao.TraineeRepository;
import com.paprota.kiteapp.entity.Group;
import com.paprota.kiteapp.entity.Opinion;
import com.paprota.kiteapp.entity.Trainee;
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
        Trainee existingTrainee = null;
        if (theTrainee.getId() != 0) {
            existingTrainee = traineeRepository.findById(theTrainee.getId()).orElse(null);
        }

        // Sprawdź, czy trainee jest już przypisany do grupy przed aktualizacją
        Group existingGroup = null;
        if (existingTrainee != null) {
            existingGroup = existingTrainee.getGroup();
        }

        // Zapisz trainee
        traineeRepository.save(theTrainee);

        // Przywróć przypisanie trainee do grupy, jeśli był przypisany przed aktualizacją
        if (existingGroup != null) {
            theTrainee.setGroup(existingGroup);
            traineeRepository.save(theTrainee);
        }
    }

    @Override
    public void deleteById(int theId) {
        Trainee traineeToDelete = traineeRepository.findById(theId).orElse(null);
        if (traineeToDelete != null) {
            Group group = traineeToDelete.getGroup();
            if (group != null) {
                int currentTraineeNumber = group.getTraineeNumber();
                group.setTraineeNumber(currentTraineeNumber - 1);

            }
            traineeRepository.deleteById(theId);
        }
    }

    @Override
    public List<Trainee> findTraineesWithoutGroup() {
        return traineeRepository.findTraineesWithoutGroup();
    }


}
