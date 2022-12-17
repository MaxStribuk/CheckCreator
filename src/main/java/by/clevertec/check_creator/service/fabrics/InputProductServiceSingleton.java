package by.clevertec.check_creator.service.fabrics;

import by.clevertec.check_creator.service.api.IInputProductService;
import by.clevertec.check_creator.service.implementation.InputProductService;

public class InputProductServiceSingleton {

    private static volatile IInputProductService instance;

    private InputProductServiceSingleton() {
    }

    public static IInputProductService getInstance() {
        IInputProductService service = instance;
        if (service != null) {
            return service;
        }
        synchronized (InputProductServiceSingleton.class) {
            if (instance == null) {
                instance = new InputProductService();
            }
            return instance;
        }
    }
}