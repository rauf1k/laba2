package ua.com.reactive.uss_yaroslav.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Client { // або змінити на Client, якщо треба
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Account account; // Рахунок користувача для покупок
}
