package by.clevertec.check_creator.controller.console;

import by.clevertec.check_creator.controller.utils.DataExtractor;
import by.clevertec.check_creator.controller.utils.api.IDataExtractor;
import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;

import java.util.List;

public class PurchaseController {

    private final IDataExtractor dataExtractor;

    public PurchaseController() {
        this.dataExtractor = new DataExtractor();
    }

    public void start(String[] args) {
        PurchaseDTO purchase = createPurchaseDTO(args);
    }

    private PurchaseDTO createPurchaseDTO(String[] args) throws IllegalArgumentException {
        Integer numberDiscountCard = dataExtractor.getNumberDiscountCard(args);
        List<InputProductDTO> inputProducts = dataExtractor.getProducts(args);
        return new PurchaseDTO(inputProducts, numberDiscountCard);
    }
}