package extra;

import model.CrustType;
import model.Pizza;
import model.PizzaSize;
import model.Topping;

public class PizzaDirector {
    // 마르게리타 피자 생성
    public Pizza buildMargherita(PizzaSize size) {
        return new ValidatedPizzaBuilder(size, "토마토 소스")
                .crustType(CrustType.THIN)
                .addToppings(Topping.MOZZARELLA, Topping.TOMATO)
                .extraCheese(true)
                .specialInstructions("전통 이탈리안 스타일로 제작")
                .build();
    }

    // 페퍼로니 피자 생성
    public Pizza buildPepperoni(PizzaSize size) {
        return new ValidatedPizzaBuilder(size, "토마토 소스")
                .crustType(CrustType.THICK)
                .addToppings(Topping.MOZZARELLA, Topping.PEPPERONI)
                .extraCheese(false)
                .build();
    }

    // 슈프림 피자 생성
    public Pizza buildSupreme(PizzaSize size) {
        return new ValidatedPizzaBuilder(size, "토마토 소스")
                .crustType(CrustType.THICK)
                .addToppings(
                        Topping.MOZZARELLA, Topping.PEPPERONI, Topping.SAUSAGE,
                        Topping.MUSHROOM, Topping.ONION, Topping.PEPPER
                )
                .extraCheese(true)
                .specialInstructions("모든 토핑을 균등하게 배치")
                .build();
    }

    // 베지테리안 피자 생성
    public Pizza buildVegetarian(PizzaSize size) {
        return new ValidatedPizzaBuilder(size, "토마토 소스")
                .crustType(CrustType.THIN)
                .addToppings(
                        Topping.MOZZARELLA, Topping.MUSHROOM, Topping.ONION,
                        Topping.PEPPER, Topping.TOMATO, Topping.OLIVE
                )
                .extraCheese(false)
                .specialInstructions("신선한 야채만 사용")
                .build();
    }

    // 치킨 바베큐 피자 생성
    public Pizza buildChickenBBQ(PizzaSize size) {
        return new ValidatedPizzaBuilder(size, "바베큐 소스")
                .crustType(CrustType.STUFFED)
                .addToppings(Topping.MOZZARELLA, Topping.CHICKEN, Topping.ONION)
                .extraCheese(true)
                .specialInstructions("바베큐 소스를 넉넉히")
                .build();
    }
}
