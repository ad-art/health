package org.health.model.impl;

import org.health.model.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Turtle implements Animal {

    @Override
    public String getInfo() {
        return "Don";
    }
}
