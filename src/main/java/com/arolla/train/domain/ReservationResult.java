package com.arolla.train.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by aminebechraoui, on 14/02/2021, in com.arolla.train.domain
 */
public class ReservationResult {
    @JsonProperty
    private String trainRef;

    @JsonProperty
    private String bookingRef;

    @JsonProperty
    private List<String> coachRefSeatRef;

    public ReservationResult() {
    }

    public ReservationResult(String trainRef, List<String> coachRefSeatRef, String bookingRef) {
        this.trainRef = trainRef;
        this.coachRefSeatRef = coachRefSeatRef;
        this.bookingRef = bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public String getTrainRef() {
        return trainRef;
    }

    public List<String> getCoachRefSeatRef() {
        return coachRefSeatRef;
    }

    public void setTrainRef(String trainRef) {
        this.trainRef = trainRef;
    }

    public void setCoachRefSeatRef(List<String> coachRefSeatRef) {
        this.coachRefSeatRef = coachRefSeatRef;
    }
}
