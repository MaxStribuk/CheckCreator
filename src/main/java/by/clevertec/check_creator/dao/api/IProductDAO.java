package by.clevertec.check_creator.dao.api;

import by.clevertec.check_creator.core.entity.ProductEntity;

import java.util.Map;

public interface IProductDAO {

    Map<Integer, ProductEntity> getAll();
}