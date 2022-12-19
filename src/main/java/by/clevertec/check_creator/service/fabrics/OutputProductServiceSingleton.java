package by.clevertec.check_creator.service.fabrics;

import by.clevertec.check_creator.controller.utils.implementation.api.IOutputProductService;
import by.clevertec.check_creator.service.implementation.OutputProductService;

public class OutputProductServiceSingleton {

    private static volatile IOutputProductService instance;

    private OutputProductServiceSingleton() {
    }

    public static IOutputProductService getInstance() {
        IOutputProductService service = instance;
        if (service != null) {
            return service;
        }
        synchronized (OutputProductServiceSingleton.class) {
            if (instance == null) {
                instance = new OutputProductService(
                        ProductServiceSingleton.getInstance());
            }
            return instance;
        }
    }
}