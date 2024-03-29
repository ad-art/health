package org.health.config;

import org.health.dao.EmployeeDao;
import org.health.dao.HorseDao;
import org.health.dao.impl.EmployeeDaoImpl;
import org.health.dao.impl.HorseDaoImpl;
import org.health.entity.Employee;
import org.health.entity.Horse;
import org.health.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public Dog dog() {
        return new Dog("Strelka", "sweet");
    }

    @Bean
    public HorseDao horseDao() {
        return new HorseDaoImpl(Horse.class);
    }

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }
}

