package by.clevertec.check_creator.service.fabrics;

import by.clevertec.check_creator.controller.utils.implementation.api.ICheckService;
import by.clevertec.check_creator.service.implementation.CheckService;

public class CheckServiceSengleton {

    private static volatile ICheckService instance;

    private CheckServiceSengleton() {
    }

    public static ICheckService getInstance() {
        ICheckService service = instance;
        if (service != null) {
            return service;
        }
        synchronized (CheckServiceSengleton.class) {
            if (instance == null) {
                instance = new CheckService();
            }
            return instance;
        }
    }
}