package org.health.controller;

import org.health.model.Dog;
import org.junit.Assert;
import org.junit.Test;




public class HorseControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/horse/";
    private static final String ADD = "add";
    private static final String DELETE = "delete";
    private static final String UPDATE = "update";
    private static final String ALL = "all";
    private static final String GET = "get";

    @Test
    public void testAdddHorse() {
        Dog dog = new Dog();
        dog.setName("Strelka");
        Assert.assertEquals("Strelka", dog.getName());
    }


}
