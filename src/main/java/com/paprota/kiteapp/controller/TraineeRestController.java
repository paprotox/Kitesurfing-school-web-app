package com.paprota.kiteapp.controller;

import com.paprota.kiteapp.entity.Trainee;
import com.paprota.kiteapp.service.trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resttrainees")
public class TraineeRestController {

    TraineeService traineeService;

    @Autowired
    public TraineeRestController(TraineeService theTraineeService) {
        traineeService = theTraineeService;
    }

    @GetMapping("/list")
    public List<Trainee> listEmployees(Model theModel) {
        return traineeService.findAll();
    }

}
