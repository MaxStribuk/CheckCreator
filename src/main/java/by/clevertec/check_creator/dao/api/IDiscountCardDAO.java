package by.clevertec.check_creator.dao.api;

import by.clevertec.check_creator.core.entity.DiscountCardEntity;

public interface IDiscountCardDAO {

    DiscountCardEntity get(int id) throws IllegalArgumentException;
}