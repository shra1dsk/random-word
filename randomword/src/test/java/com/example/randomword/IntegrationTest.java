package com.example.randomword;

import com.example.randomword.controller.RandomWordController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RandomWordController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller, notNullValue());
    }

    @Test
    public void randomWordApiShouldReturnRandomWord() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/dictionary/randomWord",
                String.class), is(not(emptyString())));
    }
}
