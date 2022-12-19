package by.clevertec.check_creator.service.utils.fabrics;

import by.clevertec.check_creator.service.utils.api.ICheckCreator;
import by.clevertec.check_creator.service.utils.implementation.CheckCreator;

public class CheckCreatorSingleton {

    private static volatile ICheckCreator instance;

    private CheckCreatorSingleton() {
    }

    public static ICheckCreator getInstance() {
        ICheckCreator checkPrinting = instance;
        if (checkPrinting != null) {
            return checkPrinting;
        }
        synchronized (CheckCreatorSingleton.class) {
            if (instance == null) {
                instance = new CheckCreator();
            }
            return instance;
        }
    }
}