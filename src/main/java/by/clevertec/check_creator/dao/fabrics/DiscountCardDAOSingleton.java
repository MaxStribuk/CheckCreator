package by.clevertec.check_creator.dao.fabrics;

import by.clevertec.check_creator.dao.api.IDiscountCardDAO;
import by.clevertec.check_creator.dao.implementation.DiscountCardDBDAO;

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
                //change the line here to
                //instance = new DiscountCardMemoryDAO();
                //so that the data is read from the application memory
                instance = new DiscountCardDBDAO();
            }
            return instance;
        }
    }
}