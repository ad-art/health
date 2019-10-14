package org.health.service.impl;

import org.health.service.KnightService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("knightService")
public class KnightServiceImp implements KnightService {

    @Override
    public String getAchievments(String enemy) {
        if (enemy.equalsIgnoreCase("dragon")) {
            throw new IllegalArgumentException("I cant slay a" + enemy);
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "I am slay the " + enemy;
    }
}
