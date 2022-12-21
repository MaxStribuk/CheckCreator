package by.clevertec.check_creator.service.implementation;

import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.core.entity.ProductEntity;
import by.clevertec.check_creator.dao.api.IProductDAO;
import by.clevertec.check_creator.service.api.IProductService;

import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private final IProductDAO dao;

    public ProductService(IProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<ProductEntity> get(List<InputProductDTO> products)
            throws IllegalArgumentException {
        List<Integer> inputProductIds = products.stream()
                .map(InputProductDTO::getId)
                .toList();
        List<ProductEntity> productEntities = dao.getAll()
                .entrySet()
                .stream()
                .filter(entry -> inputProductIds.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .toList();
        if (inputProductIds.size() != productEntities.size()) {
            throw new IllegalArgumentException("Product with the entered id" +
                    " out of stock");
        } else {
            return productEntities;
        }
    }
}