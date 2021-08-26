package com.example.catsservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class CatControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CatRepository repository;

    @Test
    void getCatWithNameShouldReturnCat() throws Exception {
        Cat toby = new Cat("Toby");
        BDDMockito.given(repository.findByName("Toby")).willReturn(toby);
        String expectedValue = this.objectMapper.writeValueAsString(new Cat("Toby"));
        this.mockMvc.perform(get("/cats/{name}", "Toby")).andExpect(status().isOk()).andExpect(content().string(expectedValue));
    }
}
