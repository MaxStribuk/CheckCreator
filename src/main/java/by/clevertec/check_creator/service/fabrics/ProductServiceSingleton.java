package by.clevertec.check_creator.service.fabrics;

import by.clevertec.check_creator.dao.fabrics.ProductDAOSingleton;
import by.clevertec.check_creator.controller.utils.implementation.api.IProductService;
import by.clevertec.check_creator.service.implementation.ProductService;

public class ProductServiceSingleton {

    private static volatile IProductService instance;

    private ProductServiceSingleton() {
    }

    public static IProductService getInstance() {
        IProductService service = instance;
        if (service != null) {
            return service;
        }
        synchronized (ProductServiceSingleton.class) {
            if (instance == null) {
                instance = new ProductService(ProductDAOSingleton.getInstance());
            }
            return instance;
        }
    }
}