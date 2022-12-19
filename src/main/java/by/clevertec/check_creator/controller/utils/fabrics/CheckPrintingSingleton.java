package by.clevertec.check_creator.controller.utils.fabrics;

import by.clevertec.check_creator.controller.utils.api.ICheckPrinting;
import by.clevertec.check_creator.controller.utils.implementation.CheckConsolePrinting;

public class CheckPrintingSingleton {

    private static volatile ICheckPrinting instance;

    private CheckPrintingSingleton() {
    }

    public static ICheckPrinting getInstance() {
        ICheckPrinting checkPrinting = instance;
        if (checkPrinting != null) {
            return checkPrinting;
        }
        synchronized (CheckPrintingSingleton.class) {
            if (instance == null) {
                instance = new CheckConsolePrinting();
            }
            return instance;
        }
    }
}