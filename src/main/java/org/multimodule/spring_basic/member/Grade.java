package org.multimodule.spring_basic.member;

public enum Grade {
    BASIC("0")
    ,VIP("1000");

    private final String discountPrice;

    Grade(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }
}
