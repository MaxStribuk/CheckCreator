package by.clevertec.check_creator.core.dto;

import java.util.List;

public class PurchaseDTO {

    private final List<InputProductDTO> products;

    private final Integer numberDiscountCard;

    public PurchaseDTO(List<InputProductDTO> products, Integer numberDiscountCard) {
        this.products = products;
        this.numberDiscountCard = numberDiscountCard;
    }

    public List<InputProductDTO> getProducts() {
        return products;
    }

    public Integer getNumberDiscountCard() {
        return numberDiscountCard;
    }
}