package ru.clevertec.check.service;

import ru.clevertec.check.dto.ProductDto;

public interface ProductService {

    ProductDto create(ProductDto productDto);

    ProductDto getById(int id);

    boolean update(ProductDto productDto);

    boolean delete(int id);

    boolean changeQuantityInStock(ProductDto productDto, int quantity);
}
