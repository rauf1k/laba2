package ua.com.reactive.uss_yaroslav.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.reactive.uss_yaroslav.entity.Client;
import ua.com.reactive.uss_yaroslav.entity.Account;

@RestController
public class MyController {

    @GetMapping("/clients")
    public Flux<Client> getClients() {
        Flux<Client> clients = Flux.just(
                        new Client(1, "Vasya", "Pypkin", 18, new Account(1, 100.0)),
                        new Client(2, "Iva", "Pypkina", 19, new Account(2, 150.0)),
                        new Client(3, "Inna", "Pypkina", 20, new Account(3, 200.0))
                )
                .skip(0)
                .take(2);

        return clients;
    }
}
