package org.health.controller;

import org.health.dto.EmployeeDto;
import org.health.entity.Employee;
import org.health.entity.Car;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class EmployeeControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/employee/";
    private static final String ADD = "add";
    private static final String DELETE = "delete";
    private static final String UPDATE = "update";
    private static final String ALL = "all";
    private static final String GET = "get";

    @Test
    public void testAddAndGet() {
        Employee ivan = createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<EmployeeDto> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                EmployeeDto.class,
                ivan.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        EmployeeDto receivedEmployee = responseEntity.getBody();
        assertNotNull(receivedEmployee);
    }

    private Employee createEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employee = prefillEmployee();

        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);

        RestTemplate template = new RestTemplate();
        Employee createdEmployee = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Employee.class
        ).getBody();

        assertNotNull(createdEmployee);
        assertEquals("Ivan", createdEmployee.getName());
        return createdEmployee;
    }


    private Employee prefillEmployee() {
        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setTitle("Boss");

        Car car1 = new Car();
        car1.setModel("Roash1");
        car1.setYear(LocalDate.of(2001, 01, 04));

        Car car2 = new Car();
        car2.setModel("Roash2");
        car2.setYear(LocalDate.of(2005, 10, 20));


        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);

        employee.setCarList(list);
        return employee;
    }
}
