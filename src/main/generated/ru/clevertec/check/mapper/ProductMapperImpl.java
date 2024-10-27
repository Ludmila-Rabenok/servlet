package ru.clevertec.check.mapper;

import javax.annotation.Generated;
import ru.clevertec.check.dto.ProductDto;
import ru.clevertec.check.entity.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-27T19:22:15+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setQuantityInStock( product.getQuantityInStock() );
        productDto.setWholesaleProduct( product.isWholesaleProduct() );

        return productDto;
    }

    @Override
    public Product toProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );
        product.setQuantityInStock( productDto.getQuantityInStock() );
        product.setWholesaleProduct( productDto.isWholesaleProduct() );

        return product;
    }
}
