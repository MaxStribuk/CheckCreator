package by.clevertec.check_creator.service.api;

import by.clevertec.check_creator.core.entity.DiscountCardEntity;

public interface IDiscountCardService {

    /**
     Method returns null if no discount card has been entered
     */
    DiscountCardEntity get(Integer id) throws IllegalArgumentException;
}