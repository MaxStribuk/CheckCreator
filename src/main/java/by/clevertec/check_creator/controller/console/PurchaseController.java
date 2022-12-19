package by.clevertec.check_creator.controller.console;

import by.clevertec.check_creator.controller.utils.api.ICheckPrinting;
import by.clevertec.check_creator.controller.utils.fabrics.CheckPrintingSingleton;
import by.clevertec.check_creator.service.fabrics.CheckServiceSengleton;
import by.clevertec.check_creator.controller.utils.api.IDataExtractor;
import by.clevertec.check_creator.controller.utils.fabrics.DataExtractorSingleton;
import by.clevertec.check_creator.core.dto.CheckDTO;
import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;
import by.clevertec.check_creator.service.api.ICheckService;

import java.util.List;

public class PurchaseController {

    private final IDataExtractor dataExtractor;
    private final ICheckService checkService;
    private final ICheckPrinting checkPrinting;

    public PurchaseController() {
        this.dataExtractor = DataExtractorSingleton.getInstance();
        this.checkService = CheckServiceSengleton.getInstance();
        this.checkPrinting = CheckPrintingSingleton.getInstance();
    }

    public void start(String[] args) throws IllegalArgumentException {
        PurchaseDTO purchase = createPurchase(args);
        CheckDTO check = checkService.createCheck(purchase);
        checkPrinting.print(check);
    }

    private PurchaseDTO createPurchase(String[] args)
            throws IllegalArgumentException {
        Integer numberDiscountCard = dataExtractor.getNumberDiscountCard(args);
        List<InputProductDTO> inputProducts = dataExtractor.getProducts(args);
        return new PurchaseDTO(inputProducts, numberDiscountCard);
    }
}