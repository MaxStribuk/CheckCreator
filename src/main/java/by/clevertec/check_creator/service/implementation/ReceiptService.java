package by.clevertec.check_creator.service.implementation;

import by.clevertec.check_creator.core.dto.ReceiptDTO;
import by.clevertec.check_creator.core.dto.OutputProductDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;
import by.clevertec.check_creator.core.entity.DiscountCardEntity;
import by.clevertec.check_creator.controller.utils.implementation.api.IReceiptService;
import by.clevertec.check_creator.controller.utils.implementation.api.IDiscountCardService;
import by.clevertec.check_creator.controller.utils.implementation.api.IInputProductService;
import by.clevertec.check_creator.controller.utils.implementation.api.IOutputProductService;

import java.time.LocalDateTime;
import java.util.List;

public class ReceiptService implements IReceiptService {

    private final IDiscountCardService discountCardService;
    private final IOutputProductService outputProductService;
    private final IInputProductService inputProductService;

    public ReceiptService(IDiscountCardService discountCardService,
                          IOutputProductService outputProductService,
                          IInputProductService inputProductService) {
        this.discountCardService = discountCardService;
        this.outputProductService = outputProductService;
        this.inputProductService = inputProductService;
    }

    @Override
    public ReceiptDTO createReceipt(PurchaseDTO purchase)
            throws IllegalArgumentException {
        purchase.setProducts(inputProductService.group(purchase.getProducts()));
        List<OutputProductDTO> outputProducts = outputProductService.get(
                purchase.getProducts());
        DiscountCardEntity discountCard = discountCardService.get(
                purchase.getNumberDiscountCard());
        LocalDateTime purchaseTime = LocalDateTime.now();
        return new ReceiptDTO(outputProducts, discountCard, purchaseTime);
    }
}