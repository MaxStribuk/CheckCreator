package by.clevertec.check_creator.controller.utils.api;

import by.clevertec.check_creator.core.dto.InputProductDTO;

import java.util.List;
import java.util.Map;

public interface IDataServletExtractor {

    List<InputProductDTO> getProducts(Map<String, String[]> parameterMap)
            throws IllegalArgumentException;

    /**
     * Method returns null if no discount card has been entered
     */
    Integer getNumberDiscountCard(String[] discountCardNumbers)
            throws IllegalArgumentException;
}