package com.paprota.kiteapp.service.camp;

import com.paprota.kiteapp.dao.CampRepository;
import com.paprota.kiteapp.dao.OpinionRepository;
import com.paprota.kiteapp.dao.TraineeRepository;
import com.paprota.kiteapp.entity.Camp;
import com.paprota.kiteapp.entity.Group;
import com.paprota.kiteapp.entity.Opinion;
import com.paprota.kiteapp.entity.Trainee;
import com.paprota.kiteapp.service.trainee.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CampServiceImpl implements CampService {

    CampRepository campRepository;
    OpinionRepository opinionRepository;

    @Autowired
    public CampServiceImpl(CampRepository theCampRepository, OpinionRepository theOpinionRepository) {
        campRepository = theCampRepository;
        opinionRepository = theOpinionRepository;
    }

    @Override
    public List<Camp> findAll() {
        return campRepository.findAll();
    }

    @Override
    public Camp findById(int theId) {
        Optional<Camp> result = campRepository.findById(theId);

        Camp theCamp= null;

        if (result.isPresent()) {
            theCamp = result.get();
        }
        else {
            // we didn't find the camp
            throw new RuntimeException("Did not find camp id - " + theId);
        }

        return theCamp;
    }


    @Override
    public void save(Camp theCamp) {
        campRepository.save(theCamp);
    }

    @Override
    public void deleteById(int theId) {
        Camp camp = campRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException("Did not find camp id - " + theId));

        List<Opinion> opinionsToDelete = opinionRepository.findByCamp(camp);
        opinionRepository.deleteAll(opinionsToDelete);

        campRepository.deleteById(theId);
    }

    @Override
    public void addOpinion(int campId, Opinion opinion) {
        Camp camp = campRepository.findById(opinion.getCamp().getId())
                .orElseThrow(() -> new RuntimeException("Camp not found with id: " + opinion.getCamp().getId()));
        opinion.setCamp(camp);
        opinionRepository.save(opinion);
    }


}
