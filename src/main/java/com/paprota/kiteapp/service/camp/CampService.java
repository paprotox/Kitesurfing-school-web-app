package com.paprota.kiteapp.service.camp;

import com.paprota.kiteapp.entity.Camp;
import com.paprota.kiteapp.entity.Opinion;
import com.paprota.kiteapp.entity.Trainee;

import java.util.List;

public interface CampService {

    List<Camp> findAll();
    Camp findById(int theId);

    void save(Camp theCamp);

    void deleteById(int theId);
    void addOpinion(int campId, Opinion opinion);
}
