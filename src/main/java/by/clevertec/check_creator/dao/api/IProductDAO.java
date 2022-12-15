package by.clevertec.check_creator.dao.api;

import by.clevertec.check_creator.core.entity.ProductEntity;

import java.util.List;

public interface IProductDAO {

    List<ProductEntity> getAll();
}