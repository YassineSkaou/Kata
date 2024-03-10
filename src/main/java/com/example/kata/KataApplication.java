package com.example.kata;

import com.example.kata.repository.UserRepository;
import com.example.kata.service.ReservationService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KataApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataApplication.class, args);
    }

    @Bean
    public ApplicationRunner initializeData(ReservationService reservationService, UserRepository userRepository) {
        return (ApplicationArguments args) -> {
/*
            List<User> clients = Arrays.asList(
                    new User(1L, "FirstName 1", "LastName 1", "email1@mail.com"),
                    new User(2L, "FirstName 2", "LastName 2", "email2@mail.com"),
                    new User(3L, "FirstName 3", "LastName 3", "email3@mail.com"));
            clients.forEach(userRepository::save);

            List<ReservationRequest> requests = Arrays.asList(
                    new ReservationRequest(new ClientRequest("FirstName 1", "LastName 1", "email1@mail.com"), LocalDateTime.now(), DeliveryMode.DELIVERY),
                    new ReservationRequest(new ClientRequest("FirstName 2", "LastName 2", "email2@mail.com"), LocalDateTime.now(), DeliveryMode.DELIVERY_ASAP),
                    new ReservationRequest(new ClientRequest("FirstName 3", "LastName 3", "email3@mail.com"), LocalDateTime.now(), DeliveryMode.DELIVERY_TODAY));
            requests.forEach(reservationService::addReservation);
        */
        };
    }

}
