package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Pizza {
    private final PizzaSize size;
    private final CrustType crustType;
    private final String sauce;
    private final Set<Topping> toppings;
    private final boolean extraCheese;
    private final String specialInstructions;
    private final int totalPrice;

    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crustType = builder.crustType;
        this.sauce = builder.sauce;
        this.toppings = new HashSet<>(builder.toppings);
        this.extraCheese = builder.extraCheese;
        this.specialInstructions = builder.specialInstructions;
        this.totalPrice = calculateTotalPrice();
    }

    private int calculateTotalPrice() {
        int price = size.getBasePrice();
        price += crustType.getAdditionalPrice();
        price += toppings.stream().mapToInt(Topping::getPrice).sum();
        if (extraCheese) price += 2000;
        return price;
    }

    public PizzaSize getSize() {return size;}
    public CrustType getCrustType() {return crustType;}
    public String getSauce() {return sauce;}
    public Set<Topping> getToppings() {return new HashSet<>(toppings);}
    public boolean hasExtraCheese() {return extraCheese;}
    public String getSpecialInstructions() {return specialInstructions;}
    public int getTotalPrice() {return totalPrice;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 피자 주문서 ===\n");
        sb.append("크기: ").append(size.getDisplayName()).append("(").append(size.getDiameter()).append("인치)\n");
        sb.append("크러스트: ").append(crustType.getDisplayName()).append("\n");
        sb.append("소스: ").append(sauce).append("\n");
        sb.append("토핑: ");
        if (toppings.isEmpty()) {
            sb.append("없음");
        } else {
            sb.append(toppings.stream()
                    .map(Topping::getDisplayName)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("없음")
            );
        }
        sb.append("\n");
        sb.append("추가 치즈: ").append(extraCheese ? "예" : "아니오").append("\n");
        if (specialInstructions != null && !specialInstructions.trim().isEmpty()) {
            sb.append("특별 요청: ").append(specialInstructions).append("\n");
        }
        sb.append("총 가격: ").append(String.format("%,d원", totalPrice)).append("\n");
        sb.append("==================");
        return sb.toString();
    }

    public static class PizzaBuilder {
        private PizzaSize size;
        private String sauce;

        protected CrustType crustType = CrustType.THIN;
        protected Set<Topping> toppings = new HashSet<>();
        private boolean extraCheese = false;
        private String specialInstructions = "";

        public PizzaBuilder(PizzaSize size, String sauce) {
            this.size = size;
            this.sauce = sauce;
        }

        public PizzaBuilder crustType(CrustType crustType) {
            this.crustType = crustType;
            return this;
        }

        public PizzaBuilder addTopping(Topping topping) {
            this.toppings.add(topping);
            return this;
        }

        public PizzaBuilder addToppings(Topping... toppings) {
            Collections.addAll(this.toppings, toppings);
            return this;
        }

        public PizzaBuilder removeTopping(Topping topping) {
            this.toppings.remove(topping);
            return this;
        }

        public PizzaBuilder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public PizzaBuilder specialInstructions(String instructions) {
            this.specialInstructions = instructions;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
