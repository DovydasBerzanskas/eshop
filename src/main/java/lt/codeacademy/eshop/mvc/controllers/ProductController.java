package lt.codeacademy.eshop.mvc.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.mvc.HttpEndpoints;
import lt.codeacademy.eshop.common.helper.MessageService;
import lt.codeacademy.eshop.common.product.dto.ProductCategoryDto;
import lt.codeacademy.eshop.common.product.dto.ProductDto;
import lt.codeacademy.eshop.common.product.service.ProductCategoryService;
import lt.codeacademy.eshop.common.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final MessageService messageService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndpoints.PRODUCTS_CREATE)
    public String getFormForCreate(Model model, String message) {
        Set<ProductCategoryDto> categories = productCategoryService.getCategories();

        model.addAttribute("categoriesDto", categories);
        model.addAttribute("productDto", ProductDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));

        return "product/product";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndpoints.PRODUCTS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID productId) {
        log.atInfo().log("Got request for GET /products/{}/update", productId);
        model.addAttribute("productDto", productService.getProductByUUID(productId));

        return "product/product";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/products/create")
    public String createAProduct(Model model, @Valid ProductDto product, BindingResult errors) {
        if (errors.hasErrors()) {
            return "product/product";
        }
        product.setProductId(UUID.randomUUID());
        productService.saveProduct(product);

        return "redirect:/products/create?message=product.create.message.success";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(HttpEndpoints.PRODUCTS_UPDATE)
    public String updateProduct(Model model, Pageable pageable, ProductDto productDto, @PathVariable UUID productId) {
        productService.updateProduct(productDto);

        return getProducts(model, pageable);
    }

    @GetMapping("/products/list")
    public String getProducts(Model model, @PageableDefault(size = 5, sort = {"price"}, direction = Sort.Direction.ASC)
    Pageable pageable) {
        final Page<ProductDto> allProducts = productService.getAllProductsPage(pageable);
        model.addAttribute("productList", allProducts);

        return "product/products";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndpoints.PRODUCTS_DELETE)
    public String deleteProduct(Model model, Pageable pageable, @PathVariable UUID productId) {
        productService.deleteProductByUUID(productId);

        return getProducts(model, pageable);
    }

    @GetMapping(HttpEndpoints.PRODUCTS_GET)
    public String getById(Model model, @PathVariable UUID productId) {
        var product = productService.getProductByUUID(productId);
        model.addAttribute("product", product);

        return "product/productpage";
    }

}
