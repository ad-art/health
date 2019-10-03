package org.health.controller;

import org.health.model.Cat;
import org.health.model.Rabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ImportResource(value = "classpath:ioc.xml")
public class AppController {
    private Cat cat;
    private Rabbit rabbit;

    // @Autowired   before Spring 5
    public AppController(Cat cat) {
        this.cat = cat;
    }

    // http://localhost:8080/
    @RequestMapping("/hello/{name}")

    public String getHelloPage(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";

    }

    @RequestMapping("/")
    public String getName(Model model) {
        model.addAttribute("name", cat.getName());
        //rabbit.setName("Bags");
        model.addAttribute("name2", rabbit.getName());
        return "cat";
    }

    @Autowired
    @Value("Bagzz")
    public void setRabbit(Rabbit rabbit) {
        this.rabbit = rabbit;
    }

    // with setter since 2018
//    @Autowired
//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }
}
