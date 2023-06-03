package com.paprota.kiteapp.controller;

import com.paprota.kiteapp.entity.Trainee;
import com.paprota.kiteapp.service.trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trainees")
public class TraineeController {

    TraineeService traineeService;

    @Autowired
    public TraineeController(TraineeService theTraineeService) {
        traineeService = theTraineeService;
    }

    @GetMapping("/list")
    public String listTrainees(Model theModel) {

        List<Trainee> theTrainees = traineeService.findAll();

        // add to the spring model
        theModel.addAttribute("trainees", theTrainees);

        return "trainees/list-trainees";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("traineeId") int theId) {

        traineeService.deleteById(theId);

        return "redirect:/trainees/list";
    }

    @PostMapping("/save")
    public String saveTrainee(@ModelAttribute("trainee") Trainee theTrainee) {
        traineeService.save(theTrainee);
        return "redirect:/trainees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("traineeId") int theId, Model theModel) {

        Trainee theTrainee = traineeService.findById(theId);
        // add to the spring model
        theModel.addAttribute("trainee", theTrainee);

        return "trainees/trainee-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Trainee theTrainee = new Trainee();
        // add to the spring model
        theModel.addAttribute("trainee", theTrainee);

        return "trainees/trainee-form";
    }

}
