package com.paprota.kiteapp.service.opinion;

import com.paprota.kiteapp.entity.Camp;
import com.paprota.kiteapp.entity.Opinion;

import java.util.List;

public interface OpinionService {

    List<Opinion> findAll();
    Opinion findById(int theId);

    void save(Opinion theOpinion);

    void deleteById(int theId);

}
