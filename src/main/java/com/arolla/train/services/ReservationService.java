package com.arolla.train.services;

import com.arolla.train.domain.ReservationRequest;
import com.arolla.train.domain.ReservationResult;
import com.arolla.train.domain.Seat;
import com.arolla.train.domain.Train;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by aminebechraoui, on 14/02/2021, in com.arolla.train.services
 */
@Service
public class ReservationService {

    private final SeatService seatService;

    private final TrainService trainService;

    private final BookingRefService bookingRefService;

    public ReservationService(SeatService seatService, BookingRefService bookingRefService, TrainService trainService) {
        this.seatService = seatService;
        this.bookingRefService = bookingRefService;
        this.trainService = trainService;
    }

    public ReservationResult book(ReservationRequest request) {
        List<Seat> seats = seatService.findAllByTrainRefAndBookingRefIsNull(request.getTrainRef());
        List<String> seatsBooked = new ArrayList<>();;
        String bookingRef = bookingRefService.generateRef();
        if (seats.size() >= request.getSeatsNumber()) {
            bookAndReturnSeats(request.getSeatsNumber(), seats, seatsBooked, bookingRef);
        }
        return new ReservationResult(request.getTrainRef(), seatsBooked, bookingRef);
    }

    private void bookAndReturnSeats(int seatsNumber, List<Seat> seats, List<String> seatsBooked, String bookingRef) {
        seats.subList(0, seatsNumber)
                .stream()
                .forEach(s -> {
                    s = bookSeat(s, bookingRef);
                    seatsBooked.add(s.getCoachReference() + s.getRef());
                });
    }

    private Seat bookSeat(Seat seat, String bookingRef) {
        seat.setBookingRef(bookingRef);
        return seatService.update(seat);
    }

    public double getBookedPercentageOnTrain(String trainRef) {
        double seatsNumber = seatService.countByTrainRef(trainRef);
        double availableSeat = seatService.countByTrainRefAndBookingRefIsNotNull(trainRef);

        return calculatePercentage(seatsNumber, availableSeat);
    }

    public double getBookedPercentageOnTrainAndCoach(String trainRef, String coachRef) {
        double seatsNumber = seatService.countByTrainRefAndCoachRef(trainRef, coachRef);
        double availableSeat = seatService.countByTrainRefAndCoachRefAndBookingRefIsNotNull(trainRef, coachRef);

        return calculatePercentage(seatsNumber, availableSeat);
    }



    public double getTrainPercentageIfBooked(ReservationRequest reservation) {
        double seatsNumber = seatService.countByTrainRef(reservation.getTrainRef());
        double availableSeat = seatService.countByTrainRefAndBookingRefIsNotNull(reservation.getTrainRef());

        return calculatePercentage(seatsNumber, availableSeat + reservation.getSeatsNumber());
    }

    private double calculatePercentage(double total, double toCalculate) {
        return toCalculate * 100 / total;
    }
}
