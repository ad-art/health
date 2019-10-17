package org.health.config;

import org.health.dao.HorseDao;
import org.health.dao.impl.HorseDaoImpl;
import org.health.entity.Horse;
import org.health.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Dog dog() {
        return new Dog("Strelka", "sweet");
    }

    @Bean
    public HorseDao horseDao() {
        return new HorseDaoImpl(Horse.class);
    }
}

