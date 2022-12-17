package by.clevertec.check_creator.core.dto;

import java.util.List;

public class PurchaseDTO {

    private List<InputProductDTO> products;

    private final Integer numberDiscountCard;

    public PurchaseDTO(List<InputProductDTO> products, Integer numberDiscountCard) {
        this.products = products;
        this.numberDiscountCard = numberDiscountCard;
    }

    public List<InputProductDTO> getProducts() {
        return products;
    }

    public int getNumberDiscountCard() {
        return numberDiscountCard;
    }

    public void setProducts(List<InputProductDTO> products) {
        this.products = products;
    }
}