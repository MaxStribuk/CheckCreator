package by.clevertec.check_creator.core.entity;

import java.math.BigDecimal;

public class ProductEntity {

    private final int id;
    private final String title;
    private final BigDecimal price;
    private final boolean isPromotional;

    public ProductEntity(int id, String title, BigDecimal price, boolean isPromotional) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.isPromotional = isPromotional;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isPromotional() {
        return isPromotional;
    }
}