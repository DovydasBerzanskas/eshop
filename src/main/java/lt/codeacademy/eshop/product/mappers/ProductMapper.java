package lt.codeacademy.eshop.product.mappers;

import lt.codeacademy.eshop.common.mapper.Mapper;
import lt.codeacademy.eshop.product.dto.ProductCategoryDto;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.pojo.Product;
import lt.codeacademy.eshop.product.pojo.ProductCategory;
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
                .categoryId(product.getProductCategories().stream().map(ProductCategory::getId).collect(Collectors.toList()))
                .amount(product.getAmount())
                .build();
    }

    public Product fromDto(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .price(productDto.getPrice())
                .name(productDto.getName())
                .amount(productDto.getAmount())
                .productCategories(new HashSet<>())
                .build();
    }
}
