package lt.codeacademy.eshop.common.product.mappers;

import lt.codeacademy.eshop.common.mapper.Mapper;
import lt.codeacademy.eshop.common.product.dto.ProductDto;
import lt.codeacademy.eshop.jpa.entities.Product;
import lt.codeacademy.eshop.jpa.entities.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class ProductMapper implements Mapper<Product, ProductDto> {

    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .categoryIds(product.getProductCategories().stream().map(ProductCategory::getId).collect(Collectors.toList()))
                .amount(product.getAmount())
                .description(product.getDescription())
                .image(product.getImage())
                .build();
    }

    public Product fromDto(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .price(productDto.getPrice())
                .name(productDto.getName())
                .amount(productDto.getAmount())
                .productCategories(new HashSet<>())
                .description(productDto.getDescription())
                .image(productDto.getImage())
                .build();
    }
}
