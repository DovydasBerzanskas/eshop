package lt.codeacademy.eshop.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.common.product.dto.ProductDto;
import lt.codeacademy.eshop.common.product.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        productService.deleteProductByUUID(id);
        return ResponseEntity.status(204).build();
    }
}
