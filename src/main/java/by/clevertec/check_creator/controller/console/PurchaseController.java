package by.clevertec.check_creator.controller.console;

import by.clevertec.check_creator.controller.utils.api.ICheckPrinting;
import by.clevertec.check_creator.controller.utils.fabrics.CheckPrintingSingleton;
import by.clevertec.check_creator.service.fabrics.CheckServiceSengleton;
import by.clevertec.check_creator.controller.utils.api.IDataConsoleExtractor;
import by.clevertec.check_creator.controller.utils.fabrics.DataConsoleExtractorSingleton;
import by.clevertec.check_creator.core.dto.CheckDTO;
import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;
import by.clevertec.check_creator.service.api.ICheckService;

import java.util.List;

public class PurchaseController {

    private final IDataConsoleExtractor dataExtractor;
    private final ICheckService checkService;
    private final ICheckPrinting checkPrinting;

    public PurchaseController() {
        this.dataExtractor = DataConsoleExtractorSingleton.getInstance();
        this.checkService = CheckServiceSengleton.getInstance();
        this.checkPrinting = CheckPrintingSingleton.getInstance();
    }

    public void createCheck(String[] args) throws IllegalArgumentException {
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