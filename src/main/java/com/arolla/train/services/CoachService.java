package com.arolla.train.services;

import com.arolla.train.domain.Coach;
import com.arolla.train.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.services
 */
@Service
public class CoachService {
    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> getAllCoachs() {
        return coachRepository.findAll();
    }
}
