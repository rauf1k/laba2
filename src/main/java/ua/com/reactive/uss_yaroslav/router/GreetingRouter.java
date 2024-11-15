package ua.com.reactive.uss_yaroslav.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ua.com.reactive.uss_yaroslav.handler.GreetingHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello)
                .andRoute(RequestPredicates.GET("/").and(accept(MediaType.TEXT_PLAIN)), greetingHandler::home)
                .andRoute(RequestPredicates.GET("/clients").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::getClients)
                .andRoute(RequestPredicates.GET("/drinks").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::getDrinks)
                .andRoute(RequestPredicates.GET("/ingredients").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::getIngredients)
                .andRoute(RequestPredicates.POST("/drinks").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::createDrink)
                .andRoute(RequestPredicates.POST("/ingredients").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::createIngredient);
    }
}
