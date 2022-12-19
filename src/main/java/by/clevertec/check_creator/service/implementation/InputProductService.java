package by.clevertec.check_creator.service.implementation;

import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.controller.utils.implementation.api.IInputProductService;

import java.util.List;
import java.util.stream.Collectors;

public class InputProductService implements IInputProductService {

    @Override
    public List<InputProductDTO> group(List<InputProductDTO> inputProducts) {
        return inputProducts.stream()
                .collect(Collectors.toMap(
                        InputProductDTO::getId,
                        InputProductDTO::getAmount,
                        Integer::sum
                ))
                .entrySet()
                .stream()
                .map(entry -> new InputProductDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}