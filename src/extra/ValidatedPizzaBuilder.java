package extra;

import model.CrustType;
import model.Pizza;
import model.PizzaSize;
import model.Topping;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ValidatedPizzaBuilder extends Pizza.PizzaBuilder {
    private static final int MAX_TOPPINGS = 8;
    private static final int MAX_MEAT_TOPPINGS = 3;

    public ValidatedPizzaBuilder(PizzaSize size, String sauce) {
        super(size, sauce);
        validateBasicRequirements(size, sauce);
    }

    private void validateBasicRequirements(PizzaSize size, String sauce) {
        if (size == null) {
            throw new IllegalArgumentException("피자 크기는 필수입니다");
        }
        if (sauce == null || sauce.trim().isEmpty()) {
            throw new IllegalArgumentException("소스는 필수입니다");
        }
    }

    @Override
    public ValidatedPizzaBuilder addTopping(Topping topping) {
        if (topping == null) {
            throw new IllegalArgumentException("토핑이 null일 수 없습니다");
        }

        Set<Topping> currentToppings = new HashSet<>(super.toppings);
        currentToppings.add(topping);

        validateToppings(currentToppings);
        return (ValidatedPizzaBuilder) super.addTopping(topping);
    }

    @Override
    public ValidatedPizzaBuilder addToppings(Topping... toppings) {
        if (toppings == null) {
            throw new IllegalArgumentException("토핑 배열이 null일 수 없습니다");
        }

        Set<Topping> currentToppings = new HashSet<>(super.toppings);
        Collections.addAll(currentToppings, toppings);

        validateToppings(currentToppings);
        return (ValidatedPizzaBuilder) super.addToppings(toppings);
    }

    private void validateToppings(Set<Topping> toppings) {
        // 최대 토핑 수 검증
        if (toppings.size() > MAX_TOPPINGS) {
            throw new IllegalArgumentException(
                    String.format("토핑은 최대 %d개까지만 가능합니다. 현재: %d개",
                            MAX_TOPPINGS, toppings.size())
            );
        }

        // 고기 토핑 수 검증
        long meatCount = toppings.stream()
                .filter(t -> "MEAT".equals(t.getCategory()))
                .count();

        if (meatCount > MAX_MEAT_TOPPINGS) {
            throw new IllegalArgumentException(
                    String.format("고기 토핑은 최대 %d개까지만 가능합니다. 현재: %d개",
                            MAX_MEAT_TOPPINGS, meatCount)
            );
        }
    }

    @Override
    public Pizza build() {
        // 최종 검증
        validateFinalPizza();
        return super.build();
    }

    private void validateFinalPizza() {
        // 특별한 조합 검증
        if (super.crustType == CrustType.GLUTEN_FREE && super.toppings.size() > 5) {
            throw new IllegalStateException("글루텐 프리 크러스트는 토핑을 5개 이하로 제한합니다");
        }

        // 가격 검증
        Pizza tempPizza = super.build();
        if (tempPizza.getTotalPrice() > 50000) {
            throw new IllegalStateException("피자 가격이 50,000원을 초과할 수 없습니다");
        }
    }
}
