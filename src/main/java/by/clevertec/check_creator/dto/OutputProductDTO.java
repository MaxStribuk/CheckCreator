package by.clevertec.check_creator.dto;

import java.math.BigDecimal;

public class OutputProductDTO {

    private final String title;
    private final int amount;
    private final boolean isPromotional;
    private final BigDecimal price;
    private final BigDecimal cost;

    public OutputProductDTO(String title, int amount, boolean isPromotional,
                            BigDecimal price, BigDecimal cost) {
        this.title = title;
        this.amount = amount;
        this.isPromotional = isPromotional;
        this.price = price;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isPromotional() {
        return isPromotional;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCost() {
        return cost;
    }
}