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

    @Query("Select count(*) from Seat s where s.train.ref = ?1")
    long countByTrainRef(String trainRef);

    @Query("Select count(*) from Seat s where s.train.ref = ?1 and s.bookingRef is not null")
    long countByTrainRefAndBookingRefIsNotNull(String trainRef);

    @Query("Select count(*) from Seat s where s.train.ref = ?1 and s.coach.ref = ?2")
    long countByTrainRefAndCoachRef(String trainRef, String coachRef);

    @Query("Select count(*) from Seat s where s.train.ref = ?1 and s.coach.ref = ?2 and s.bookingRef is not null")
    long countByTrainRefAndCoachRefAndBookingRefIsNotNull(String trainRef, String coachRef);

}
