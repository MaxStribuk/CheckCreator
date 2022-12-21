package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.IDataConsoleExtractor;
import by.clevertec.check_creator.core.dto.InputProductDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleDataExtractor implements IDataConsoleExtractor {

    private static final String CARD_PARAM_NAME = "card";
    private static final String PATTERN = "-";

    @Override
    public List<InputProductDTO> getProducts(String[] args)
            throws IllegalArgumentException {
        try {
            List<InputProductDTO> inputProducts = Arrays.stream(args)
                    .map(arg -> arg.split(PATTERN))
                    .filter(arg -> {
                        if (arg.length > 2) {
                            throw new IllegalArgumentException();
                        }
                        return !arg[0].equalsIgnoreCase(CARD_PARAM_NAME);})
                    .collect(Collectors.groupingBy(arg-> Integer.parseInt(arg[0]),
                            Collectors.summingInt(arg-> Integer.parseInt(arg[1]))))
                    .entrySet()
                    .stream()
                    .map(entry -> new InputProductDTO(
                                    entry.getKey(),
                                    entry.getValue()))
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
                    .filter(arg -> arg[0].equalsIgnoreCase(CARD_PARAM_NAME))
                    .map(arg -> {
                        if (arg.length > 2) {
                            throw new IllegalArgumentException();
                        } else {
                            return Integer.valueOf(arg[1]);
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