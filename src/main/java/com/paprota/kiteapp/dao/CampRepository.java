package com.paprota.kiteapp.dao;

import com.paprota.kiteapp.entity.Camp;
import com.paprota.kiteapp.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CampRepository extends JpaRepository<Camp, Integer> {


}
