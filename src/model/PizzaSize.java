package model;

public enum PizzaSize {
    SMALL("Small", 8, 12000),
    MEDIUM("Medium", 10, 15000),
    LARGE("Large", 12, 18000),
    EXTRA_LARGE("Extra Large", 14, 22000);

    private final String displayName;
    private final int diameter;
    private final int basePrice;

    PizzaSize(String displayName, int diameter, int basePrice) {
        this.displayName = displayName;
        this.diameter = diameter;
        this.basePrice = basePrice;
    }

    public String getDisplayName() {return displayName;}
    public int getDiameter() {return diameter;}
    public int getBasePrice() {return basePrice;}
}
