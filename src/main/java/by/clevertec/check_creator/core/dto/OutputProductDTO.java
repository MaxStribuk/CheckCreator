package by.clevertec.check_creator.core.dto;

import java.math.BigDecimal;

public class OutputProductDTO {

    private final String title;
    private final int amount;
    private final boolean isPromotional;
    private final BigDecimal price;

    public OutputProductDTO(String title, int amount, boolean isPromotional,
                            BigDecimal price) {
        this.title = title;
        this.amount = amount;
        this.isPromotional = isPromotional;
        this.price = price;
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
}