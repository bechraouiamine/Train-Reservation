package com.arolla.train.services;

import com.arolla.train.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aminebechraoui, on 14/02/2021, in com.arolla.train.services
 */
@Service
public class ReservationService {

    private final SeatService seatService;

    private final CoachService coachService;

    private final TrainService trainService;

    private final BookingRefService bookingRefService;

    public ReservationService(SeatService seatService, BookingRefService bookingRefService, TrainService trainService, CoachService coachService) {
        this.seatService = seatService;
        this.bookingRefService = bookingRefService;
        this.trainService = trainService;
        this.coachService = coachService;
    }

    public ReservationResult book(ReservationRequest request) {
        if (getTrainPercentageIfBooked(request) <= 70) {
            ReservationResult result = selectingTheCoach(request);
            if (result != null) return result;
        }
        return new ReservationResult(request.getTrainRef(), null, null);
    }

    private ReservationResult selectingTheCoach(ReservationRequest request) {
        List<Coach> coaches = coachService.findCoachesByTrainRef(request.getTrainRef());
        for(Coach coach : coaches) {
            if (coach.getSeats()
                    .stream()
                    .filter(s -> s.getBookingRef() == null).count() >= request.getSeatsNumber()) {
                return bookingSeats(request, coach);
            }
        }
        return null;
    }

    private ReservationResult bookingSeats(ReservationRequest request, Coach coach) {
        String bookingRef = bookingRefService.generateRef();
        List<Seat> seats = selectingSeats(request, coach);

        bookingSeats(bookingRef, seats);

        List<String> seatsBooked = concatenatingSeatRefAndCoachRef(seats);
        return new ReservationResult(request.getTrainRef(), seatsBooked, bookingRef);
    }

    private void bookingSeats(String bookingRef, List<Seat> seats) {
        seats.forEach(seat -> {
            bookSeat(seat, bookingRef);
        });
    }

    private List<String> concatenatingSeatRefAndCoachRef(List<Seat> seats) {
        List<String> seatsBooked = seats.stream()
                .map(seat -> {
                    return seat.getRef() + seat.getCoachReference();})
                .collect(Collectors.toList());
        return seatsBooked;
    }

    private List<Seat> selectingSeats(ReservationRequest request, Coach coach) {
        List<Seat> seats = coach.getSeats()
                .stream()
                .filter(s -> s.getBookingRef() == null)
                .limit((long) request.getSeatsNumber())
                .collect(Collectors.toList());
        return seats;
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

    public double getTrainAndCoachPercentageIfBooked(ReservationRequest reservation, String coachRef) {
        double seatsNumber = seatService.countByTrainRefAndCoachRef(reservation.getTrainRef(), coachRef);
        double availableSeat = seatService.countByTrainRefAndCoachRefAndBookingRefIsNotNull(reservation.getTrainRef(), coachRef);

        return calculatePercentage(seatsNumber, availableSeat + reservation.getSeatsNumber());
    }

    private double calculatePercentage(double total, double toCalculate) {
        return toCalculate * 100 / total;
    }
}
