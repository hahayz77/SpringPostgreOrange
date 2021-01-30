package com.postgrebets.postgrebet.repository;

import com.postgrebets.postgrebet.model.Ganbler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class GanblerConfig {

    @Bean
    CommandLineRunner commandLineRunner(GanblerRepository repository){
        return args -> {
            Ganbler danilo = new Ganbler(
                    "d@d.com",
                    "danilo"
            );

            Ganbler alice = new Ganbler(
                    "a@a.com",
                    "alice"
            );

            repository.saveAll(Arrays.asList(danilo, alice));
        };
    }
}
