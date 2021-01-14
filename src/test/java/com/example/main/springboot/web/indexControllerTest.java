package com.example.main.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SuppressWarnings("unchecked")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class indexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void MainPage_Loading() {

        //when
        String body = this.restTemplate.getForObject("/",String.class);

        //then
        assertThat(body).contains("Springboot with web Service Ver2.0");

    }
}
