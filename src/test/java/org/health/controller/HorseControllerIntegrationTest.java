package org.health.controller;

import org.health.entity.Horse;
import org.health.entity.Mare;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;


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
    }

    private Horse createHorse() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Horse horse = prefillHorse();
    }

    private Horse prefillHorse() {
        Horse horse = new Horse();
        horse.setName("Rysak");
        horse.setDescription("Fast");

        Mare mare1 = new Mare();
        mare1.setName("Roash");
        mare1.setDescription("Nasty");


        Mare mare2 = new Mare();
        mare1.setName("Porridge");
        mare1.setDescription("Tasty");

        List<Mare> list = new ArrayList<>();
        list.add(mare1);
        list.add(mare2);

        horse.setMares(list);
        return horse;
    }
}
