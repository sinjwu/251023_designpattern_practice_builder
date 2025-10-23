package model;

public enum CrustType {
    THIN("씬 크러스트", 0),
    THICK("두꺼운 크러스트", 2000),
    STUFFED("치즈 크러스트", 3000),
    GLUTEN_FREE("글루텐 프리", 4000);

    private final String displayName;
    private final int additionalPrice;

    CrustType(String displayName, int additionalPrice) {
        this.displayName = displayName;
        this.additionalPrice = additionalPrice;
    }

    public String getDisplayName() {return displayName;}
    public int getAdditionalPrice() {return additionalPrice;}
}
