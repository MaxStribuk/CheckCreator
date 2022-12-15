package by.clevertec.check_creator.controller.utils;

import by.clevertec.check_creator.controller.utils.api.IDataExtractor;
import by.clevertec.check_creator.core.dto.InputProductDTO;

import java.util.Arrays;
import java.util.List;

public class DataExtractor implements IDataExtractor {

    @Override
    public List<InputProductDTO> getProducts(String[] args)
            throws IllegalArgumentException {
        try {
            return Arrays.stream(args)
                    .map(arg -> arg.split("-"))
                    .filter(arg -> !arg[0].equalsIgnoreCase("card"))
                    .map(arg -> new InputProductDTO(
                            Integer.parseInt(arg[0]),
                            Integer.parseInt(arg[1])))
                    .toList();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("id / количество продуктов" +
                    " были заданы некорректно");
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
                    .map(arg -> arg.split("-"))
                    .filter(arg -> arg[0].equalsIgnoreCase("card"))
                    .map(arg -> Integer.parseInt(arg[1]))
                    .toList();
            if (discountCards.size() > 1) {
                throw new IllegalArgumentException();
            }
            return discountCards.size() == 0 ? null : discountCards.get(0);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("данные дисконтной карты" +
                    " были заданы некорректно");
        }
    }
}