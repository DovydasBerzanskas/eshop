package lt.codeacademy.eshop.mappers;

import lt.codeacademy.eshop.product.pojo.Product;
import lt.codeacademy.eshop.product.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class ProductMapper {

    public ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getAmount()
        );
    }

    public Product fromProductDto(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .price(productDto.getPrice())
                .name(productDto.getName())
                .amount(productDto.getAmount())
                .productCategories(new HashSet<>())
                .build();
    }
}
