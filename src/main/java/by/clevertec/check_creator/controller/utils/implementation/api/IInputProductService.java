package by.clevertec.check_creator.controller.utils.implementation.api;

import by.clevertec.check_creator.core.dto.InputProductDTO;

import java.util.List;

public interface IInputProductService {

    List<InputProductDTO> group(List<InputProductDTO> inputProducts);
}