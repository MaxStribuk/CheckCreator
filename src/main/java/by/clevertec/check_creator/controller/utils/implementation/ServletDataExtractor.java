package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.IDataServletExtractor;
import by.clevertec.check_creator.core.dto.InputProductDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ServletDataExtractor implements IDataServletExtractor {

    private static final String CARD_PARAM_NAME = "card";

    @Override
    public List<InputProductDTO> getProducts(Map<String, String[]> parameterMap)
            throws IllegalArgumentException {
        try {
            List<InputProductDTO> products = parameterMap.entrySet()
                    .stream()
                    .filter(entry -> !entry.getKey().equalsIgnoreCase(CARD_PARAM_NAME))
                    .map(entry -> new InputProductDTO(
                            Integer.parseInt(entry.getKey()),
                            Arrays.stream(entry.getValue())
                                    .map(Integer::parseInt)
                                    .reduce(Integer::sum)
                                    .orElse(0)))
                    .toList();
            if (products.size() == 0) {
                throw new IllegalArgumentException();
            }
            return products;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("id / number of products" +
                    " were set incorrectly");
        }
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