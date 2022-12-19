package by.clevertec.check_creator.core.dto;

import by.clevertec.check_creator.core.entity.DiscountCardEntity;

import java.time.LocalDateTime;
import java.util.List;

public class ReceiptDTO {

    private final List<OutputProductDTO> products;
    private final DiscountCardEntity discountCard;
    private final LocalDateTime purchaseTime;

    public ReceiptDTO(List<OutputProductDTO> products,
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