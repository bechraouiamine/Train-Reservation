package com.arolla.train.repository;

import com.arolla.train.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.repository
 */
@Repository
public interface TrainRepository extends JpaRepository<Train, UUID> {

    @Query("SELECT t.id FROM Train t where t.ref = ?1")
    UUID findIdByRef(String ref);
}
