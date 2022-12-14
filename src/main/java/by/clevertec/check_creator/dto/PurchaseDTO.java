package by.clevertec.check_creator.dto;

import java.util.List;

public class PurchaseDTO {

    private final List<InputProductDTO> products;

    private int numberDiscountCard;

    public PurchaseDTO(List<InputProductDTO> products, int numberDiscountCard) {
        this.products = products;
        this.numberDiscountCard = numberDiscountCard;
    }

    public PurchaseDTO(List<InputProductDTO> products) {
        this.products = products;
    }

    public List<InputProductDTO> getProducts() {
        return products;
    }

    public int getNumberDiscountCard() {
        return numberDiscountCard;
    }
}