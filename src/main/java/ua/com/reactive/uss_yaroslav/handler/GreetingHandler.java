package ua.com.reactive.uss_yaroslav.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.uss_yaroslav.entity.*;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Coffee Machine!")));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Welcome to the Coffee Machine main page!"));
    }

    public Mono<ServerResponse> getClients(ServerRequest request) {
        String start = request.queryParam("start").orElse("0");

        Flux<Client> clients = Flux.just(
                        new Client(1, "Vasya", "Pypkin", 18, new Account(1, 100.0)),
                        new Client(2, "Iva", "Pypkina", 19, new Account(2, 150.0)),
                        new Client(3, "Inna", "Pypkina", 20, new Account(3, 200.0))
                )
                .skip(Long.parseLong(start))
                .take(2);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients, Client.class);
    }

    public Mono<ServerResponse> getDrinks(ServerRequest request) {
        String start = request.queryParam("start").orElse("0");

        Flux<Drink> drinks = Flux.just(
                        new Drink(1, "Cappuccino", 50.0, 10),
                        new Drink(2, "Latte", 55.0, 15),
                        new Drink(3, "Americano", 40.0, 20),
                        new Drink(4, "Espresso", 45.0, 12)
                )
                .skip(Long.parseLong(start))
                .take(2);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(drinks, Drink.class);
    }

    public Mono<ServerResponse> getIngredients(ServerRequest request) {
        Flux<Ingredient> ingredients = Flux.just(
                new Ingredient(1, "Milk", 10.0, 100),
                new Ingredient(2, "Sugar", 5.0, 200),
                new Ingredient(3, "Chocolate", 15.0, 50),
                new Ingredient(4, "Vanilla Syrup", 20.0, 30)
        );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(ingredients, Ingredient.class);
    }

    public Mono<ServerResponse> createDrink(ServerRequest request) {
        Mono<Drink> drinkMono = request.bodyToMono(Drink.class);
        return drinkMono.flatMap(drink ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(drink))
        );
    }

    public Mono<ServerResponse> createIngredient(ServerRequest request) {
        Mono<Ingredient> ingredientMono = request.bodyToMono(Ingredient.class);
        return ingredientMono.flatMap(ingredient ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(ingredient))
        );
    }
}
