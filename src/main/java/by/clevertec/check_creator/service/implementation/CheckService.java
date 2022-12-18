package by.clevertec.check_creator.service.implementation;

import by.clevertec.check_creator.core.dto.CheckDTO;
import by.clevertec.check_creator.core.dto.OutputProductDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;
import by.clevertec.check_creator.core.entity.DiscountCardEntity;
import by.clevertec.check_creator.service.api.ICheckService;
import by.clevertec.check_creator.service.api.IDiscountCardService;
import by.clevertec.check_creator.service.api.IInputProductService;
import by.clevertec.check_creator.service.api.IOutputProductService;

import java.time.LocalDateTime;
import java.util.List;

public class CheckService implements ICheckService {

    private final IDiscountCardService discountCardService;
    private final IOutputProductService outputProductService;
    private final IInputProductService inputProductService;

    public CheckService(IDiscountCardService discountCardService,
                        IOutputProductService outputProductService,
                        IInputProductService inputProductService) {
        this.discountCardService = discountCardService;
        this.outputProductService = outputProductService;
        this.inputProductService = inputProductService;
    }

    @Override
    public CheckDTO createCheck(PurchaseDTO purchase)
            throws IllegalArgumentException {
        purchase.setProducts(inputProductService.group(purchase.getProducts()));
        List<OutputProductDTO> outputProducts = outputProductService.get(
                purchase.getProducts());
        DiscountCardEntity discountCard = discountCardService.get(
                purchase.getNumberDiscountCard());
        LocalDateTime purchaseTime = LocalDateTime.now();
        return new CheckDTO(outputProducts, discountCard, purchaseTime);
    }
}