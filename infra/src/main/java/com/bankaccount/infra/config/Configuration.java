package com.bankaccount.infra.config;

import com.bankaccount.infra.controller.Controller;
import com.bankaccount.infra.repository.Repository;
import org.springframework.context.annotation.Bean;

public class Configuration {
    @Bean
    public Controller controller(Repository repository) {
        return new Controller(repository);
    }
}
