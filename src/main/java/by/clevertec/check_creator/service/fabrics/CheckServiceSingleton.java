package by.clevertec.check_creator.service.fabrics;

import by.clevertec.check_creator.service.api.ICheckService;
import by.clevertec.check_creator.service.implementation.CheckService;

public class CheckServiceSingleton {

    private static volatile ICheckService instance;

    private CheckServiceSingleton() {
    }

    public static ICheckService getInstance() {
        ICheckService service = instance;
        if (service != null) {
            return service;
        }
        synchronized (CheckServiceSingleton.class) {
            if (instance == null) {
                instance = new CheckService(
                        DiscountCardServiceSingleton.getInstance(),
                        OutputProductServiceSingleton.getInstance(),
                        InputProductServiceSingleton.getInstance());
            }
            return instance;
        }
    }
}