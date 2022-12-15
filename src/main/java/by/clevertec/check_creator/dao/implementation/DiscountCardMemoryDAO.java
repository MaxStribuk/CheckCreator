package by.clevertec.check_creator.dao.implementation;

import by.clevertec.check_creator.core.entity.DiscountCardEntity;
import by.clevertec.check_creator.dao.api.IDiscountCardDAO;

import java.util.ArrayList;
import java.util.List;

public class DiscountCardMemoryDAO implements IDiscountCardDAO {

    private final List<DiscountCardEntity> discountCards;

    public DiscountCardMemoryDAO() {
        this.discountCards = new ArrayList<>();
        discountCards.add(new DiscountCardEntity(1, true));
        discountCards.add(new DiscountCardEntity(2, true));
        discountCards.add(new DiscountCardEntity(3, true));
        discountCards.add(new DiscountCardEntity(4, true));
        discountCards.add(new DiscountCardEntity(5, true));
        discountCards.add(new DiscountCardEntity(6, false));
        discountCards.add(new DiscountCardEntity(7, false));
        discountCards.add(new DiscountCardEntity(8, false));
        discountCards.add(new DiscountCardEntity(9, false));
        discountCards.add(new DiscountCardEntity(10, false));
    }

    @Override
    public DiscountCardEntity get(int id) throws IllegalArgumentException {
        try {
            return discountCards.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Дисконтная карта с указанным" +
                    " номером не существует");
        }
    }
}