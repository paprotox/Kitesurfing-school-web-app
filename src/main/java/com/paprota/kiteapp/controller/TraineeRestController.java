package com.paprota.kiteapp.controller;

import ch.qos.logback.core.model.Model;
import com.paprota.kiteapp.entity.Camp;
import com.paprota.kiteapp.entity.Opinion;
import com.paprota.kiteapp.entity.Trainee;
import com.paprota.kiteapp.service.trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TraineeRestController {

    TraineeService traineeService;

    @Autowired
    public TraineeRestController(TraineeService theTraineeService) {
        traineeService = theTraineeService;
    }

    @GetMapping("/list")
    public List<Trainee> listEmployees() {
        return traineeService.findAll();
    }

    @PostMapping("/opinion/{traineeId}")
    public void addOpinion(@PathVariable int traineeId, @RequestBody Opinion opinion) {
        Trainee trainee = traineeService.findById(traineeId);
        trainee.getOpinions().add(opinion);
        traineeService.save(trainee);
    }



}
