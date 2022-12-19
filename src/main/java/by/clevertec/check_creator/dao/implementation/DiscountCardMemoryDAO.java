package by.clevertec.check_creator.dao.implementation;

import by.clevertec.check_creator.core.entity.DiscountCardEntity;
import by.clevertec.check_creator.dao.api.IDiscountCardDAO;

import java.util.HashMap;
import java.util.Map;

public class DiscountCardMemoryDAO implements IDiscountCardDAO {

    private final Map<Integer, DiscountCardEntity> discountCards;

    public DiscountCardMemoryDAO() {
        this.discountCards = new HashMap<>();
        discountCards.put(1, new DiscountCardEntity(1, true));
        discountCards.put(2, new DiscountCardEntity(2, true));
        discountCards.put(3, new DiscountCardEntity(3, true));
        discountCards.put(4, new DiscountCardEntity(4, true));
        discountCards.put(5, new DiscountCardEntity(5, true));
        discountCards.put(6, new DiscountCardEntity(6, false));
        discountCards.put(7, new DiscountCardEntity(7, false));
        discountCards.put(8, new DiscountCardEntity(8, false));
        discountCards.put(9, new DiscountCardEntity(9, true));
        discountCards.put(10, new DiscountCardEntity(10, true));
    }

    @Override
    public DiscountCardEntity get(int id) throws IllegalArgumentException {
        try {
            return discountCards.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Discount card with the specified" +
                    " number does not exist");
        }
    }
}