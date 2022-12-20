package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.IDataServletExtractor;
import by.clevertec.check_creator.core.dto.InputProductDTO;

import java.util.List;
import java.util.Map;

public class ServletDataExtractor implements IDataServletExtractor {


    @Override
    public List<InputProductDTO> getProducts(Map<String, String[]> parameterMap)
            throws IllegalArgumentException {
        return null;
    }


    /**
     * Method returns null if no discount card has been entered
     */
    @Override
    public Integer getNumberDiscountCard(String[] discountCardNumbers)
            throws IllegalArgumentException {
        if (discountCardNumbers == null) {
            return null;
        }
        if (discountCardNumbers.length > 1) {
            throw new IllegalArgumentException();
        }
        try {
            return Integer.valueOf(discountCardNumbers[0]);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("discount card details" +
                    " were set incorrectly");
        }
    }
}