package by.clevertec.check_creator.dao.implementation;

import by.clevertec.check_creator.core.entity.DiscountCardEntity;
import by.clevertec.check_creator.dao.api.IDiscountCardDAO;
import by.clevertec.check_creator.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountCardDBDAO implements IDiscountCardDAO {

    @Override
    public DiscountCardEntity get(int id) throws IllegalArgumentException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM discount_card" +
                            " WHERE discount_card_id = ?",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet discountCard = stmt.executeQuery();
            if (discountCard.first()) {
                return new DiscountCardEntity(
                        discountCard.getInt("discount_card_id"),
                        discountCard.getBoolean("discount_card_active"));
            } else {
                throw new IllegalArgumentException("Discount card with the" +
                        " specified number does not exist");
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("failed connection to database");
        }
    }
}