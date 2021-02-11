package com.arolla.train.services;

import com.arolla.train.domain.Coach;
import com.arolla.train.domain.Seat;
import com.arolla.train.domain.Train;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Created by aminebechraoui, on 11/02/2021, in com.arolla.train.services
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrainTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_return_list_of_train_and_assert_list_size_is_2_and_assert_express2000_and_local1000_exist() throws JsonProcessingException {
        // Given
        List<Train> trains;

        // When
        trains = objectMapper.readValue(restTemplate.getForObject("http://localhost:8080/api/v1/trains",
                String.class), new TypeReference<List<Train>>(){});

        // Then
        assertNotNull(trains);
        assertEquals(2, trains.size());
        assertTrue(trains.contains(new Train("express_2000")));
        assertTrue(trains.contains(new Train("local_1000")));
    }
}
