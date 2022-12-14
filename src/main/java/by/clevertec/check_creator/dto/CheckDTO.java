package by.clevertec.check_creator.dto;

import by.clevertec.check_creator.entity.DiscountCardEntity;

import java.time.LocalDateTime;
import java.util.List;

public class CheckDTO {

    private final List<OutputProductDTO> products;
    private final DiscountCardEntity discountCard;
    private final LocalDateTime purchaseTime;

    public CheckDTO(List<OutputProductDTO> products,
                    DiscountCardEntity discountCard, LocalDateTime purchaseTime) {
        this.products = products;
        this.discountCard = discountCard;
        this.purchaseTime = purchaseTime;
    }

    public List<OutputProductDTO> getProducts() {
        return products;
    }

    public DiscountCardEntity getDiscountCard() {
        return discountCard;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }
}