package com.arolla.train.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.domain
 */

@Entity
public class Seat {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    private String ref;

    @ManyToOne
    private Coach coach;

    private String bookingRef;

    public String getRef() {
        return ref;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public String getCoachRef() {
        return coach.getRef();
    }

    public String getTrainRef() {
        return coach.getTrainRef();
    }
}
