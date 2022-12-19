package by.clevertec.check_creator.controller.utils.implementation.api;

import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.core.dto.OutputProductDTO;

import java.util.List;

public interface IOutputProductService {

    List<OutputProductDTO> get(List<InputProductDTO> inputProducts);
}