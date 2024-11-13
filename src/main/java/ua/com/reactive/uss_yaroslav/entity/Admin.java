package ua.com.reactive.uss_yaroslav.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Admin {
    private Long id;
    private String name;

    public Admin(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void refillDrink(Drink drink, int amount) {
        drink.setQuantity(drink.getQuantity() + amount);
    }

    public void refillIngredient(Ingredient ingredient, int amount) {
        ingredient.setQuantity(ingredient.getQuantity() + amount);
    }
}