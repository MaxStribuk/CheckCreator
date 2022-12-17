package by.clevertec.check_creator.dao.implementation;

import by.clevertec.check_creator.core.entity.ProductEntity;
import by.clevertec.check_creator.dao.api.IProductDAO;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductMemoryDAO implements IProductDAO {

    private final Map<Integer, ProductEntity> products;

    public ProductMemoryDAO() {
        this.products = new HashMap<>();
        products.put(1, new ProductEntity(1, "milk", new BigDecimal("1.5"), true));
        products.put(2, new ProductEntity(2, "rice", new BigDecimal("2.5"), true));
        products.put(3, new ProductEntity(3, "butter", new BigDecimal("3.5"), true));
        products.put(4, new ProductEntity(4, "cheese", new BigDecimal("3.0"), false));
        products.put(5, new ProductEntity(5, "eggs", new BigDecimal("2.5"), true));
        products.put(6, new ProductEntity(6, "ice cream", new BigDecimal("1.75"), false));
        products.put(7, new ProductEntity(7, "cake", new BigDecimal("1.25"), true));
        products.put(8, new ProductEntity(8, "juice", new BigDecimal("1.15"), false));
        products.put(9, new ProductEntity(9, "tea", new BigDecimal("1.66"), false));
        products.put(10, new ProductEntity(10, "coffee", new BigDecimal("1.77"), false));
    }

    @Override
    public Map<Integer, ProductEntity> getAll() {
        return Collections.unmodifiableMap(products);
    }
}