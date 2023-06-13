package com.paprota.kiteapp.dao;

import com.paprota.kiteapp.entity.Group;
import com.paprota.kiteapp.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("SELECT COUNT(t) FROM Group g JOIN g.trainees t WHERE g.id = :groupId")
    int getNumberOfTraineesInGroup(@Param("groupId") int groupId);

    @Modifying
    @Query("UPDATE Trainee t SET t.group = null WHERE t.id = :traineeId")
    void removeTraineeFromGroup(@Param("traineeId") int traineeId);

}
