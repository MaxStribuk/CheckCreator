package by.clevertec.check_creator.controller.utils.api;

import by.clevertec.check_creator.core.dto.InputProductDTO;

import java.util.List;

public interface IDataExtractor {

    List<InputProductDTO> getProducts(String[] args) throws IllegalArgumentException;
    /**
     Method returns null if no discount card has been entered
     */
    Integer getNumberDiscountCard(String[] args) throws IllegalArgumentException;
}