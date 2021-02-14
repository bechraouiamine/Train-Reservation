package com.arolla.train.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aminebechraoui, on 14/02/2021, in com.arolla.train.domain
 */
public class ReservationRequest {

    @JsonProperty
    private String trainRef;

    @JsonProperty
    private int seatsNumber;

    public ReservationRequest(String trainRef, int seatsNumber) {
        this.trainRef = trainRef;
        this.seatsNumber = seatsNumber;
    }

    public String getTrainRef() {
        return trainRef;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }
}
