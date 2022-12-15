package by.clevertec.check_creator.dao.implementation;

import by.clevertec.check_creator.core.entity.ProductEntity;
import by.clevertec.check_creator.dao.api.IProductDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductMemoryDAO implements IProductDAO {

    List<ProductEntity> products;
    public ProductMemoryDAO() {
        this.products = new ArrayList<>();
        products.add(new ProductEntity(1, "milk", new BigDecimal("1.5"), true));
        products.add(new ProductEntity(2, "rice", new BigDecimal("2.5"), true));
        products.add(new ProductEntity(3, "butter", new BigDecimal("3.5"), true));
        products.add(new ProductEntity(4, "cheese", new BigDecimal("3.0"), false));
        products.add(new ProductEntity(5, "eggs", new BigDecimal("2.5"), true));
        products.add(new ProductEntity(6, "ice cream", new BigDecimal("1.75"), false));
        products.add(new ProductEntity(7, "cake", new BigDecimal("1.25"), true));
        products.add(new ProductEntity(8, "juice", new BigDecimal("1.15"), false));
        products.add(new ProductEntity(9, "tea", new BigDecimal("1.66"), false));
        products.add(new ProductEntity(10, "coffee", new BigDecimal("1.77"), false));

    }

    @Override
    public List<ProductEntity> getAll() {
        return Collections.unmodifiableList(products);
    }
}