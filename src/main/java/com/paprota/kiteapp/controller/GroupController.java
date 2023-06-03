package com.paprota.kiteapp.controller;

import com.paprota.kiteapp.entity.Group;
import com.paprota.kiteapp.entity.Trainee;
import com.paprota.kiteapp.service.group.GroupService;
import com.paprota.kiteapp.service.trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
