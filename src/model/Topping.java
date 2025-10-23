package model;

public enum Topping {
    // 치즈류
    MOZZARELLA("모짜렐라 치즈", 2000, "CHEESE"),
    CHEDDAR("체다 치즈", 2500, "CHEESE"),
    PARMESAN("파마산 치즈", 3000, "CHEESE"),

    // 고기류
    PEPPERONI("페퍼로니", 3000, "MEAT"),
    SAUSAGE("소시지", 3500, "MEAT"),
    HAM("햄", 3000, "MEAT"),
    CHICKEN("치킨", 4000, "MEAT"),

    // 야채류
    MUSHROOM("버섯", 2000, "VEGETABLE"),
    ONION("양파", 1500, "VEGETABLE"),
    PEPPER("피망", 2000, "VEGETABLE"),
    TOMATO("토마토", 2000, "VEGETABLE"),
    OLIVE("올리브", 2500, "VEGETABLE");

    private final String displayName;
    private final int price;
    private final String category;

    Topping(String displayName, int price, String category) {
        this.displayName = displayName;
        this.price = price;
        this.category = category;
    }

    public String getDisplayName() { return displayName; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }
}