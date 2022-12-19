package by.clevertec.check_creator.service.implementation;

import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.core.dto.OutputProductDTO;
import by.clevertec.check_creator.core.entity.ProductEntity;
import by.clevertec.check_creator.service.api.IOutputProductService;
import by.clevertec.check_creator.service.api.IProductService;

import java.util.ArrayList;
import java.util.List;

public class OutputProductService implements IOutputProductService {

    private final IProductService productService;

    public OutputProductService(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<OutputProductDTO> get(List<InputProductDTO> inputProducts)
            throws IllegalArgumentException {
        List<ProductEntity> productEntities = productService.get(inputProducts);
        List<OutputProductDTO> outputProducts = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            InputProductDTO product = inputProducts.stream()
                    .filter(inputProduct ->
                            inputProduct.getId() == productEntity.getId())
                    .toList()
                    .get(0);
            outputProducts.add(new OutputProductDTO(
                    productEntity.getTitle(),
                    product.getAmount(),
                    productEntity.isPromotional(),
                    productEntity.getPrice()));
        }
        return outputProducts;
    }
}