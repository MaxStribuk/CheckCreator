package by.clevertec.check_creator.service.implementation;

import by.clevertec.check_creator.core.entity.DiscountCardEntity;
import by.clevertec.check_creator.dao.api.IDiscountCardDAO;
import by.clevertec.check_creator.service.api.IDiscountCardService;

public class DiscountCardService implements IDiscountCardService {

    private final IDiscountCardDAO dao;

    public DiscountCardService(IDiscountCardDAO dao) {
        this.dao = dao;
    }

    /**
     Method returns null if no discount card has been entered
     */
    @Override
    public DiscountCardEntity get(Integer id) throws IllegalArgumentException {
        if (id == null) {
            return null;
        }
        if (id <= 0) {
            throw new IllegalArgumentException("Discount card with the specified" +
                    " number does not exist");
        }
        return dao.get(id);
    }
}