package by.clevertec.check_creator.service.utils.api;

import by.clevertec.check_creator.core.dto.ReceiptDTO;

public interface ICheckCreator {

    String createHeader(ReceiptDTO receipt);
    String createBody(ReceiptDTO receipt);
    String createTotal(ReceiptDTO receipt);
}