package com.arolla.train.services;

import com.arolla.train.domain.ReservationRequest;
import com.arolla.train.domain.ReservationResult;
import com.arolla.train.domain.Seat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aminebechraoui, on 14/02/2021, in com.arolla.train.services
 */
@Service
public class ReservationService {

    private final SeatService seatService;

    private final BookingRefService bookingRefService;

    public ReservationService(SeatService seatService, BookingRefService bookingRefService) {
        this.seatService = seatService;
        this.bookingRefService = bookingRefService;
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
}
