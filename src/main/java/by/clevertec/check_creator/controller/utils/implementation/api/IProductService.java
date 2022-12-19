package by.clevertec.check_creator.controller.utils.implementation.api;

import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.core.entity.ProductEntity;

import java.util.List;

public interface IProductService {

    List<ProductEntity> get(List<InputProductDTO> products)
            throws IllegalArgumentException;
}