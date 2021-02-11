package com.arolla.train.services;

import com.arolla.train.domain.Coach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

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
public class CoachTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return() throws Exception {
        this.mockMvc
                .perform(get("http://localhost:8080/api/v1/coachs"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("express_2000")))
                .andExpect(content().string(containsString("local_1000")));

    }
}
