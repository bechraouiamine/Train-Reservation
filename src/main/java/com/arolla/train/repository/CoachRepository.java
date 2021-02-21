package com.arolla.train.repository;

import com.arolla.train.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.repository
 */
@Repository
public interface CoachRepository extends JpaRepository<Coach, UUID> {

    @Query("Select c From Coach c Where c.train.ref = ?1")
    List<Coach> findByTrainRef(String trainRef);
}
