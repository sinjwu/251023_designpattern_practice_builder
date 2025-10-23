import extra.PizzaDirector;
import extra.ValidatedPizzaBuilder;
import model.Pizza;
import model.PizzaSize;
import model.Topping;

public class Main {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();

        System.out.println("피자 주문 시스템 \n");

        try {
            System.out.println("1. 마르게리타 피자 (라지)");
            var margherita = director.buildMargherita(PizzaSize.LARGE);
            System.out.println(margherita);
            System.out.println("\n" + "=".repeat(50) + "\n");

            System.out.println("2. 페퍼로니 피자 (미디움)");
            var pepperoni = director.buildPepperoni(PizzaSize.MEDIUM);
            System.out.println(pepperoni);
            System.out.println("\n" + "=".repeat(50) + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        /* Pizza pizza = new Pizza.PizzaBuilder(PizzaSize.LARGE, "토마토 소스")
                .addTopping(Topping.PEPPERONI)
                .addToppings(Topping.MUSHROOM, Topping.CHEDDAR)
                .extraCheese(true)
                .specialInstructions("맛있게 만들어주세요")
                .build();

        System.out.println(pizza);

        try {
            Pizza validatedPizza = new ValidatedPizzaBuilder(PizzaSize.LARGE, "토마토 소스")
                    .addTopping(Topping.PEPPERONI)
                    .addToppings(Topping.MUSHROOM, Topping.CHEDDAR)
                    .extraCheese(true)
                    .specialInstructions("맛있게 만들어주세요")
                    .build();

            System.out.println(validatedPizza);
        } catch (Exception e) {
            System.out.println("오류");
        }

        try {
            Pizza validatedPizza = new ValidatedPizzaBuilder(PizzaSize.LARGE, "토마토 소스")
                    .addTopping(Topping.PEPPERONI)
                    .addToppings(
                            Topping.MUSHROOM,
                            Topping.CHEDDAR,
                            Topping.CHICKEN,
                            Topping.OLIVE,
                            Topping.ONION,
                            Topping.PARMESAN,
                            Topping.PEPPER,
                            Topping.TOMATO,
                            Topping.SAUSAGE
                    )
                    .extraCheese(true)
                    .specialInstructions("맛있게 만들어주세요.")
                    .build();

            System.out.println(validatedPizza);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } */
    }
}