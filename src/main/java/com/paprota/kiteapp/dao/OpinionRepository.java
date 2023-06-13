package com.paprota.kiteapp.dao;

import com.paprota.kiteapp.entity.Camp;
import com.paprota.kiteapp.entity.Opinion;
import com.paprota.kiteapp.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Integer> {

    List<Opinion> findByCamp(Camp camp);
}
