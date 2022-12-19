package by.clevertec.check_creator.service.fabrics;

import by.clevertec.check_creator.dao.fabrics.DiscountCardDAOSingleton;
import by.clevertec.check_creator.controller.utils.implementation.api.IDiscountCardService;
import by.clevertec.check_creator.service.implementation.DiscountCardService;

public class DiscountCardServiceSingleton {

    private static volatile IDiscountCardService instance;

    private DiscountCardServiceSingleton() {
    }

    public static IDiscountCardService getInstance() {
        IDiscountCardService service = instance;
        if (service != null) {
            return service;
        }
        synchronized (DiscountCardServiceSingleton.class) {
            if (instance == null) {
                instance = new DiscountCardService(DiscountCardDAOSingleton.getInstance());
            }
            return instance;
        }
    }
}