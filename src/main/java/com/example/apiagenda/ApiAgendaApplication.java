
package com.example.apiagenda;

import com.example.apiagenda.service.PasseioService;
import com.example.apiagenda.entity.Passeio;
import com.example.apiagenda.repository.PasseioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;

@SpringBootApplication
public class ApiAgendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAgendaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PasseioService service) {
        return args -> {
            service.salvar(new Passeio("Passeio 1", "Descrição 1", "Local 1", "Categoria 1",
                    LocalDateTime.parse("2025-12-14T10:00:00")));
            service.salvar(new Passeio("Passeio 2", "Descrição 2", "Local 2", "Categoria 2",
                    LocalDateTime.parse("2025-12-15T15:30:00")));
            service.salvar(new Passeio("Passeio 3", "Descrição 3", "Local 3", "Categoria 3",
                    LocalDateTime.parse("2025-12-16T09:00:00")));
        };
    }

}
