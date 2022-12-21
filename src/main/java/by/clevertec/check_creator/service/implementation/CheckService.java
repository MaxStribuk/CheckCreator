package by.clevertec.check_creator.service.implementation;

import by.clevertec.check_creator.core.dto.CheckDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;
import by.clevertec.check_creator.core.dto.ReceiptDTO;
import by.clevertec.check_creator.service.api.ICheckService;
import by.clevertec.check_creator.service.api.IReceiptService;
import by.clevertec.check_creator.service.fabrics.ReceiptServiceSingleton;
import by.clevertec.check_creator.service.utils.api.ICheckCreator;
import by.clevertec.check_creator.service.utils.implementation.CheckCreator;

public class CheckService implements ICheckService {

    private final IReceiptService receiptService;

    public CheckService() {
        this.receiptService = ReceiptServiceSingleton.getInstance();
    }

    @Override
    public CheckDTO createCheck(PurchaseDTO purchase)
            throws IllegalArgumentException {
        ReceiptDTO receipt = receiptService.createReceipt(purchase);
        ICheckCreator checkCreator = new CheckCreator();
        return new CheckDTO(checkCreator.createHeader(receipt),
                checkCreator.createBody(receipt),
                checkCreator.createTotal(receipt));
    }
}