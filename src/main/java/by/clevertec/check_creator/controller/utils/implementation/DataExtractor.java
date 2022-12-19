package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.IDataExtractor;
import by.clevertec.check_creator.core.dto.InputProductDTO;

import java.util.Arrays;
import java.util.List;

public class DataExtractor implements IDataExtractor {

    private static final String PARAM_CARD = "card";
    private static final String PATTERN = "-";

    @Override
    public List<InputProductDTO> getProducts(String[] args)
            throws IllegalArgumentException {
        try {
            List<InputProductDTO> inputProducts = Arrays.stream(args)
                    .map(arg -> arg.split(PATTERN))
                    .filter(arg -> !arg[0].equalsIgnoreCase(PARAM_CARD))
                    .map(arg -> {
                        if (arg.length > 2) {
                            throw new IllegalArgumentException();
                        } else {
                            return new InputProductDTO(
                                    Integer.parseInt(arg[0]),
                                    Integer.parseInt(arg[1]));
                        }
                    })
                    .toList();
            if (inputProducts.size() == 0) {
                throw new IllegalArgumentException();
            }
            return inputProducts;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("id / number of products" +
                    " were set incorrectly");
        }
    }

    /**
     * Method returns null if no discount card has been entered
     */
    @Override
    public Integer getNumberDiscountCard(String[] args)
            throws IllegalArgumentException {
        try {
            List<Integer> discountCards = Arrays.stream(args)
                    .map(arg -> arg.split(PATTERN))
                    .filter(arg -> arg[0].equalsIgnoreCase(PARAM_CARD))
                    .map(arg -> {
                        if (arg.length > 2) {
                            throw new IllegalArgumentException();
                        } else {
                            return Integer.parseInt(arg[1]);
                        }
                    })
                    .toList();
            if (discountCards.size() > 1) {
                throw new IllegalArgumentException();
            }
            return discountCards.size() == 0 ? null : discountCards.get(0);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("discount card details" +
                    " were set incorrectly");
        }
    }
}