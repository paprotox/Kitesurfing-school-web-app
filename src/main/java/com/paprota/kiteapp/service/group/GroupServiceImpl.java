package com.paprota.kiteapp.service.group;

import com.paprota.kiteapp.dao.GroupRepository;
import com.paprota.kiteapp.entity.Group;
import com.paprota.kiteapp.entity.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository theGroupRepository) {
        groupRepository = theGroupRepository;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(int theId) {
        Optional<Group> result = groupRepository.findById(theId);

        Group theGroup = null;

        if (result.isPresent()) {
            theGroup = result.get();
        }
        else {
            throw new RuntimeException("Did not find group id - " + theId);
        }

        return theGroup;
    }

    @Override
    public void save(Group theGroup) {
        groupRepository.save(theGroup);
    }

    @Override
    public void deleteById(int theId) {
        groupRepository.deleteById(theId);
    }

}
