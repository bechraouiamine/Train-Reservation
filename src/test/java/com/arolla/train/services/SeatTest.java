package com.arolla.train.services;

import com.arolla.train.domain.Seat;
import com.arolla.train.domain.Train;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.services
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SeatTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_return_list_of_seats_and_expect_number_of_seats_32() throws Exception {
        MvcResult result = mockMvc.perform(get("http://localhost:8080/api/v1/seats"))
        .andExpect(status().isOk())
        .andReturn();

        List<Seat> seats = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Seat>>(){});

        assertNotNull(seats);
        assertEquals(32, seats.size());

    }

    @Test
    void should_return_seats_on_express_2000_and_coachA_assert_8_assert_not_reserved() throws Exception {
        MvcResult result = mockMvc.perform(get("http://localhost:8080/api/v1/seats/A/express_2000"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("express_2000")))
                .andReturn();

        List<Seat> seats = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Seat>>(){});

        assertEquals(8, seats.size());
        seats.forEach(s -> {
            assertTrue(s.getBookingRef() == null);
        });
     }
}
