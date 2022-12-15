package by.clevertec.check_creator.dao.fabrics;

import by.clevertec.check_creator.dao.api.IDiscountCardDAO;
import by.clevertec.check_creator.dao.implementation.DiscountCardMemoryDAO;

public class DiscountCardDAOSingleton {

    private static volatile IDiscountCardDAO instance;

    private DiscountCardDAOSingleton() {
    }

    public static IDiscountCardDAO getInstance() {
        IDiscountCardDAO dao = instance;
        if (dao != null) {
            return dao;
        }
        synchronized (DiscountCardDAOSingleton.class) {
            if (instance == null) {
                instance = new DiscountCardMemoryDAO();
            }
            return instance;
        }
    }
}