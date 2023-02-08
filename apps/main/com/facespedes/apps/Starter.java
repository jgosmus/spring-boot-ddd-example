package com.facespedes.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = {"com.facespedes.todolist", "com.facespedes.apps" })
@EnableJpaRepositories(basePackages = {"com.facespedes.todolist"})
@EntityScan(basePackages = {"com.facespedes.todolist"})
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
