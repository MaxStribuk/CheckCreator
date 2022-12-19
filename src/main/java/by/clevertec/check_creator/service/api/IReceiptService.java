package by.clevertec.check_creator.service.api;

import by.clevertec.check_creator.core.dto.ReceiptDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;

public interface IReceiptService {

    ReceiptDTO createReceipt(PurchaseDTO purchase);
}