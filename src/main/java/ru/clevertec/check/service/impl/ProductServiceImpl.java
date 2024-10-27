package ru.clevertec.check.service.impl;

import ru.clevertec.check.dto.ProductDto;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.mapper.ProductMapper;
import ru.clevertec.check.repository.DB.ProductRepository;
import ru.clevertec.check.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getById(int id) {
        Product product = productRepository.readById(id);
        return ProductMapper.INSTANCE.toProductDto(product);
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Product product = productRepository.create(ProductMapper.INSTANCE.toProduct(productDto));
        return ProductMapper.INSTANCE.toProductDto(product);
    }

    @Override
    public boolean update(ProductDto productDto) {
        return productRepository.update(ProductMapper.INSTANCE.toProduct(productDto));
    }

    @Override
    public boolean delete(int id) {
        return productRepository.remove(id);
    }

    @Override
    public boolean changeQuantityInStock(ProductDto productDto, int quantity) {
        Product product = ProductMapper.INSTANCE.toProduct(productDto);
        return productRepository.changeQuantityInStock(product.getId(),
                (product.getQuantityInStock()) - quantity);
    }
}
