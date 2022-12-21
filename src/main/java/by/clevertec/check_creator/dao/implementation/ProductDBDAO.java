package by.clevertec.check_creator.dao.implementation;

import by.clevertec.check_creator.core.entity.ProductEntity;
import by.clevertec.check_creator.dao.api.IProductDAO;
import by.clevertec.check_creator.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProductDBDAO implements IProductDAO {

    @Override
    public Map<Integer, ProductEntity> getAll() {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM product",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet products = stmt.executeQuery();
            Map<Integer, ProductEntity> productEntitys = new HashMap<>();
            while (products.next()) {
                productEntitys.put(
                        products.getInt("product_id"),
                        new ProductEntity(products.getInt("product_id"),
                                products.getString("product_title"),
                                products.getBigDecimal("product_price"),
                                products.getBoolean("product_promotional"))
                );
            }
            return productEntitys;
        } catch (SQLException e) {
            throw new IllegalArgumentException("failed connection to database");
        }
    }
}