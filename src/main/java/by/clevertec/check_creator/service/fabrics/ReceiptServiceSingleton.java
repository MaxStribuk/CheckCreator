package by.clevertec.check_creator.service.fabrics;

import by.clevertec.check_creator.service.api.IReceiptService;
import by.clevertec.check_creator.service.implementation.ReceiptService;

public class ReceiptServiceSingleton {

    private static volatile IReceiptService instance;

    private ReceiptServiceSingleton() {
    }

    public static IReceiptService getInstance() {
        IReceiptService service = instance;
        if (service != null) {
            return service;
        }
        synchronized (ReceiptServiceSingleton.class) {
            if (instance == null) {
                instance = new ReceiptService(
                        DiscountCardServiceSingleton.getInstance(),
                        OutputProductServiceSingleton.getInstance(),
                        InputProductServiceSingleton.getInstance());
            }
            return instance;
        }
    }
}