package by.clevertec.check_creator.dao.fabrics;

import by.clevertec.check_creator.dao.api.IProductDAO;
import by.clevertec.check_creator.dao.implementation.ProductDBDAO;

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
                //change the line here to
                //instance = new ProductMemoryDAO();
                //so that the data is read from the application memory
                instance = new ProductDBDAO();
            }
            return instance;
        }
    }
}