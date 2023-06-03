package com.paprota.kiteapp.service.group;

import com.paprota.kiteapp.entity.Group;
import com.paprota.kiteapp.entity.Trainee;

import java.util.List;

public interface GroupService {

    List<Group> findAll();
    Group findById(int theId);

    void save(Group theGroup);

    void deleteById(int theId);

}
