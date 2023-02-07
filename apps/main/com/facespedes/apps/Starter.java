package com.facespedes.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan( value = {"com.facespedes.todo", "com.facespedes.apps" })
@EnableJpaRepositories(basePackages = {"com.facespedes.todo" })
@EntityScan(basePackages = {"com.facespedes.todo"})
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
