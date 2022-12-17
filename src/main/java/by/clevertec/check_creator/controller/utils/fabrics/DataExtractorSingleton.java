package by.clevertec.check_creator.controller.utils.fabrics;

import by.clevertec.check_creator.controller.utils.implementation.DataExtractor;
import by.clevertec.check_creator.controller.utils.api.IDataExtractor;

public class DataExtractorSingleton {

    private static volatile IDataExtractor instance;

    private DataExtractorSingleton() {
    }

    public static IDataExtractor getInstance() {
        IDataExtractor dataExtractor = instance;
        if (dataExtractor != null) {
            return dataExtractor;
        }
        synchronized (DataExtractorSingleton.class) {
            if (instance == null) {
                instance = new DataExtractor();
            }
            return instance;
        }
    }
}