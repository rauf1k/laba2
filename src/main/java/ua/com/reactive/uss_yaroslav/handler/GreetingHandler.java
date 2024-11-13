package ua.com.reactive.uss_yaroslav.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.uss_yaroslav.entity.Account;
import ua.com.reactive.uss_yaroslav.entity.Client;
import ua.com.reactive.uss_yaroslav.entity.Greeting;
import ua.com.reactive.uss_yaroslav.entity.Drink;
import ua.com.reactive.uss_yaroslav.entity.Ingredient;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring")));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Main page!"));
    }

    public Mono<ServerResponse> getClients(ServerRequest request) {
        String start = request
                .queryParam("start")
                .orElse("0");

        Flux<Client> clients = Flux.just(
                        new Client(1L, "Vasya", "Pypkin", 18, new Account(1L, 100.0)),
                        new Client(2L, "Iva", "Pypkina", 19, new Account(2L, 150.0)),
                        new Client(3L, "Inna", "Pypkina", 20, new Account(3L, 200.0))
                )
                .skip(Long.valueOf(start))
                .take(2);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients, Client.class);
    }

    public Mono<ServerResponse> getDrinks(ServerRequest request) {
        Flux<Drink> drinks = Flux.just(
                new Drink(1L, "Cappuccino", 50.0, 10),
                new Drink(2L, "Latte", 55.0, 15),
                new Drink(3L, "Americano", 40.0, 20),
                new Drink(4L, "Espresso", 45.0, 12)
        );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(drinks, Drink.class);
    }

    public Mono<ServerResponse> getIngredients(ServerRequest request) {
        Flux<Ingredient> ingredients = Flux.just(
                new Ingredient(1L, "Milk", 10.0, 100),
                new Ingredient(2L, "Sugar", 5.0, 200),
                new Ingredient(3L, "Chocolate", 15.0, 50),
                new Ingredient(4L, "Vanilla Syrup", 20.0, 30)
        );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(ingredients, Ingredient.class);
    }
}
