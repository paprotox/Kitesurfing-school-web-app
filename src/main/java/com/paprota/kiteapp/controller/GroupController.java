package com.paprota.kiteapp.controller;

import com.paprota.kiteapp.entity.Group;
import com.paprota.kiteapp.entity.Trainee;
import com.paprota.kiteapp.service.group.GroupService;
import com.paprota.kiteapp.service.trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {

    GroupService groupService;
    TraineeService traineeService;

    @Autowired
    public GroupController(GroupService theGroupService, TraineeService theTraineeService) {
        groupService = theGroupService;
        traineeService = theTraineeService;
    }

    @GetMapping("/list")
    public String listGroups(Model theModel) {

        List<Group> theGroups = groupService.findAll();

        // add to the spring model
        theModel.addAttribute("groups", theGroups);

        return "groups/list-groups";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("groupId") int theId) {

        groupService.deleteById(theId);

        return "redirect:/groups/list";
    }

    @PostMapping("/save")
    public String saveGroup(@ModelAttribute("group") Group theGroup) {
        groupService.save(theGroup);
        return "redirect:/groups/list";
    }

    @GetMapping("/showFormForUpdateGroup")
    public String showFormForUpdate(@RequestParam("groupId") int theId, Model theModel) {

        Group theGroup = groupService.findById(theId);
        // add to the spring model
        theModel.addAttribute("group", theGroup);

        return "groups/group-form";
    }

    @GetMapping("/showFormForAddGroup")
    public String showFormForAdd(Model theModel) {

        Group theGroup = new Group();
        // add to the spring model
        theModel.addAttribute("group", theGroup);

        return "groups/group-form";
    }

    @GetMapping("/manage/{groupId}")
    public String showFormForManage(@PathVariable("groupId") int theId, Model theModel) {

        Group theGroup = groupService.findById(theId);
        theModel.addAttribute("group", theGroup);

        List<Trainee> traineesInGroup = theGroup.getTrainees();
        theModel.addAttribute("traineesInGroup", traineesInGroup);

        List<Trainee> traineesWithoutGroup = traineeService.findTraineesWithoutGroup();
        theModel.addAttribute("traineesWithoutGroup", traineesWithoutGroup);

        return "groups/group-manage-form";
    }
    @GetMapping("/manage/{groupId}/showFormForAddTraineeToGroup")
    public String showAddTraineeForm(@PathVariable("groupId") int theGroupId, @RequestParam("traineeId") int theTraineeId, Model theModel) {

        Group theGroup = groupService.findById(theGroupId);
        theModel.addAttribute("group", theGroup);

        Trainee theTrainee = traineeService.findById(theTraineeId);
        theModel.addAttribute("trainee", theTrainee);

        return "groups/group-trainee-add";
    }

    @PostMapping("/manage/{groupId}/addTrainee/{traineeId}")
    public String addTraineeToGroup(@PathVariable("groupId") int groupId, @PathVariable("traineeId") int traineeId, @RequestParam("description") String description) {
        Group theGroup = groupService.findById(groupId);
        Trainee theTrainee = traineeService.findById(traineeId);
        theTrainee.setDescription(description);

        traineeService.save(theTrainee);

        theGroup.addTrainee(theTrainee);
        groupService.save(theGroup);

        return "redirect:/groups/manage/{groupId}";
    }

    @GetMapping("/manage/{groupId}/removeTrainee")
    public String removeTraineeFromGroup(@PathVariable("groupId") int theGroupId, @RequestParam("traineeId") int theTraineeId) {
        groupService.removeTraineeFromGroup(theGroupId, theTraineeId);

        return "redirect:/groups/manage/{groupId}";
    }



}
