package com.bankaccount.infra.config;

import com.bankaccount.infra.controller.Controller;
import com.bankaccount.infra.repository.InMemoryRepository;
import com.bankaccount.infra.repository.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;

@EnableWebMvc
public class Configuration {
    @Bean
    public Controller controller(Repository repository) {
        return new Controller(repository, LocalDate::now);
    }

    @Bean
    public Repository repository() {
        return new InMemoryRepository();
    }
}
