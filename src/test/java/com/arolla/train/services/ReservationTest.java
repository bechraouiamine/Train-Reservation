package com.arolla.train.services;

import com.arolla.train.domain.ReservationRequest;
import com.arolla.train.domain.ReservationResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by aminebechraoui, on 14/02/2021, in com.arolla.train.services
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReservationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReservationService reservationService;

    @Test
    void should_return_reservation_object_with_booking_ref_filled() throws Exception {
        // Given
        ReservationRequest reservationRequest = new ReservationRequest("local_1000", 3);

        // When
        MvcResult result = mockMvc.perform(post("http://localhost:8080/api/v1/reservation")
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(objectMapper.writeValueAsString(reservationRequest))
                                        )
                                    .andReturn();

        ReservationResult reservationResult = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<ReservationResult>(){});

        // Then
        assertNotNull(reservationResult.getBookingRef());
        assertEquals(3, reservationResult.getCoachRefSeatRef().size());
    }

    @Test
    @Transactional
    void should_return_percentage_of_booked_seat_on_express_1000_when_book_2_seats() throws InterruptedException {
        // Given
        ReservationRequest reservation =  new ReservationRequest("express_2000", 2);

        // When
        ReservationResult result = reservationService.book(reservation);
        double bookedPercentage = reservationService.getBookedPercentageOnTrain("express_2000");

        // Then
        assertEquals(12.5, bookedPercentage);
    }

    @Test
    @Transactional
    void should_return_percentage_of_booked_seat_on_express_1000_coachA_and_coachB_when_book_2_seats() throws InterruptedException {
        // Given
        ReservationRequest reservation =  new ReservationRequest("express_2000", 2);

        // When
        ReservationResult result = reservationService.book(reservation);
        double bookedPercentageA = reservationService.getBookedPercentageOnTrainAndCoach("express_2000", "A");
        double bookedPercentageB = reservationService.getBookedPercentageOnTrainAndCoach("express_2000", "B");

        // Then
        assertEquals(25, bookedPercentageA);
        assertEquals(0, bookedPercentageB);
    }

    @Test
    void should_return_possible_train_percentage_if_booked() {
        // Given
        ReservationRequest reservation =  new ReservationRequest("express_2000", 2);

        // When
        double trainPercentageIfBooked = reservationService.getTrainPercentageIfBooked(reservation);

        // Then
        assertEquals(12.5, trainPercentageIfBooked);
    }
}
