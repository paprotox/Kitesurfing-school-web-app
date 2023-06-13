package com.paprota.kiteapp.service.opinion;

import com.paprota.kiteapp.dao.CampRepository;
import com.paprota.kiteapp.dao.OpinionRepository;
import com.paprota.kiteapp.entity.Camp;
import com.paprota.kiteapp.entity.Opinion;
import com.paprota.kiteapp.service.camp.CampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OpinionServiceImpl implements OpinionService {

    OpinionRepository opinionRepository;

    @Autowired
    public OpinionServiceImpl(OpinionRepository theOpinionRepository) {
        opinionRepository = theOpinionRepository;
    }

    @Override
    public List<Opinion> findAll() {
        return opinionRepository.findAll();
    }

    @Override
    public Opinion findById(int theId) {
        Optional<Opinion> result = opinionRepository.findById(theId);

        Opinion theOpinion= null;

        if (result.isPresent()) {
            theOpinion = result.get();
        }
        else {
            // we didn't find the opinion
            throw new RuntimeException("Did not find opinion id - " + theId);
        }

        return theOpinion;
    }


    @Override
    public void save(Opinion theOpinion) {
        opinionRepository.save(theOpinion);
    }

    @Override
    public void deleteById(int theId) {
        opinionRepository.findById(theId).orElseThrow(() -> new RuntimeException("Did not find opinion id - " + theId));

        opinionRepository.deleteById(theId);
    }

}
