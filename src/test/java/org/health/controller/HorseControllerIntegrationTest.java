package org.health.controller;

import org.health.entity.Horse;
import org.health.entity.Mare;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class HorseControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/horse/";
    private static final String ADD = "add";
    private static final String DELETE = "delete";
    private static final String UPDATE = "update";
    private static final String ALL = "all";
    private static final String GET = "get";

    @Test
    public void testAddAndGet() {
        Horse rysak = createHorse();

        RestTemplate template= new RestTemplate();
        ResponseEntity<Horse> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,  // request body
                Horse.class,  // class to cast
                rysak.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // status code == 200
        Horse receivedHorse =responseEntity.getBody();
        assertNotNull(receivedHorse);
    }

    private Horse createHorse() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Horse horse = prefillHorse();

        HttpEntity<Horse> entity = new HttpEntity<>(horse, headers);

        RestTemplate template = new RestTemplate();
        Horse createdHorse = template.exchange(
                ROOT +ADD,
                HttpMethod.POST,
                entity,
                Horse.class
        ).getBody();
        assertNotNull(createdHorse);
        assertEquals("Rysak", createdHorse.getName());
        return createdHorse;
    }

    private Horse prefillHorse() {
        Horse horse = new Horse();
        horse.setName("Rysak");
        horse.setDescription("Fast");

        Mare mare1 = new Mare();
        mare1.setName("Roash");
        mare1.setDescription("Nasty");


        Mare mare2 = new Mare();
        mare2.setName("Porridge");
        mare2.setDescription("Tasty");

        List<Mare> list = new ArrayList<>();
        list.add(mare1);
        list.add(mare2);

        horse.setMares(list);
        return horse;
    }
}
