package com.arolla.train.repository;

import com.arolla.train.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.repository
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat, UUID> {

    List<Seat> findAllByCoachRefAndTrainRef(String coachRef, String trainRef);

    List<Seat> findAllByCoachRefAndTrainRefAndRefIn(String coachRef, String trainRef, List<String> refs);

    List<Seat> findAllByTrainRef(String trainRef);

    List<Seat> findAllByTrainRefAndBookingRefIsNull(String trainRef);

    long countByTrainId(UUID trainId);

    long countByTrainIdAndCoachIdAndBookingRefIsNull(UUID trainId, UUID coachId);

    long countByTrainIdAndCoachId(UUID trainId, UUID coachId);
}
