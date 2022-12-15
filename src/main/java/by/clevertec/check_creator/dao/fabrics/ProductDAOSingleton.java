package by.clevertec.check_creator.dao.fabrics;

import by.clevertec.check_creator.dao.api.IProductDAO;
import by.clevertec.check_creator.dao.implementation.ProductMemoryDAO;

public class ProductDAOSingleton {

    private static volatile IProductDAO instance;

    private ProductDAOSingleton() {
    }

    public static IProductDAO getInstance() {
        IProductDAO dao = instance;
        if (dao != null) {
            return dao;
        }
        synchronized (ProductDAOSingleton.class) {
            if (instance == null) {
                instance = new ProductMemoryDAO();
            }
            return instance;
        }
    }
}