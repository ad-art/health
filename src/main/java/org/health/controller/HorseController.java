package org.health.controller;

import org.health.entity.Horse;
import org.health.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// without springboot-starter need  libs  for convert Json to Java object: jackson-core,  databind, datatype-jsr
@Controller
@RequestMapping("/horse")
public class HorseController {  // url, method, request type
    private HorseService horseService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody //  transform object to json request
    public Horse addHorse(@RequestBody Horse horse) {
        return horseService.addHorse(horse);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Horse updateHorse(@RequestBody Horse horse) {
        return horseService.updateHorse(horse);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Horse getHorseById(@PathVariable("id") long id) {
        return horseService.getHorse(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Horse> getAllHorses() {
        return horseService.getAllHorses();
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Horse deleteHorseById(@PathVariable("id") long id) {
        return horseService.deleteHorse(id);
    }


    @Autowired
    public void setHorseService(HorseService horseService) {
        this.horseService = horseService;
    }
}
