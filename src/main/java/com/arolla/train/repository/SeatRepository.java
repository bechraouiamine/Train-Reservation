package com.arolla.train.repository;

import com.arolla.train.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.repository
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, UUID> {
    List<Seat> findAllByCoachRefAndTrainRef(String coachRef, String trainRef);
}
