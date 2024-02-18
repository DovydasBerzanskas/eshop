package lt.codeacademy.eshop.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.common.product.dto.ProductDto;
import lt.codeacademy.eshop.common.product.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProductsPage(Pageable.ofSize(100))
                .stream().toList();
    }

    @PostMapping
    public ResponseEntity<ProductDto> createAProduct(@RequestBody @Valid ProductDto productDto) {
        var savedProduct = productService.save(productDto);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedProduct);
    }
}
