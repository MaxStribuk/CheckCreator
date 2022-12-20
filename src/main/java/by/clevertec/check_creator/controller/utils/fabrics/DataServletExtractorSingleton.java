package by.clevertec.check_creator.controller.utils.fabrics;

import by.clevertec.check_creator.controller.utils.api.IDataServletExtractor;
import by.clevertec.check_creator.controller.utils.implementation.ServletDataExtractor;

public class DataServletExtractorSingleton {

    private static volatile IDataServletExtractor instance;

    private DataServletExtractorSingleton() {
    }

    public static IDataServletExtractor getInstance() {
        IDataServletExtractor dataExtractor = instance;
        if (dataExtractor != null) {
            return dataExtractor;
        }
        synchronized (DataServletExtractorSingleton.class) {
            if (instance == null) {
                instance = new ServletDataExtractor();
            }
            return instance;
        }
    }
}