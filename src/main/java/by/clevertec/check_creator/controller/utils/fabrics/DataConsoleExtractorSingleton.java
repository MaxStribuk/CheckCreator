package by.clevertec.check_creator.controller.utils.fabrics;

import by.clevertec.check_creator.controller.utils.implementation.ConsoleDataExtractor;
import by.clevertec.check_creator.controller.utils.api.IDataConsoleExtractor;

public class DataConsoleExtractorSingleton {

    private static volatile IDataConsoleExtractor instance;

    private DataConsoleExtractorSingleton() {
    }

    public static IDataConsoleExtractor getInstance() {
        IDataConsoleExtractor dataExtractor = instance;
        if (dataExtractor != null) {
            return dataExtractor;
        }
        synchronized (DataConsoleExtractorSingleton.class) {
            if (instance == null) {
                instance = new ConsoleDataExtractor();
            }
            return instance;
        }
    }
}