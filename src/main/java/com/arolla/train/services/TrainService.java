package com.arolla.train.services;

import com.arolla.train.domain.Train;
import com.arolla.train.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.services
 */
@Service
public class TrainService {
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }
}
