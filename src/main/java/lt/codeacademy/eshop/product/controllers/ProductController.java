package lt.codeacademy.eshop.product.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.eshop.HttpEndpoints;
import lt.codeacademy.eshop.helper.MessageService;
import lt.codeacademy.eshop.product.Product;
import lt.codeacademy.eshop.product.dto.ProductDto;
import lt.codeacademy.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final MessageService messageService;

    @GetMapping(HttpEndpoints.PRODUCTS_CREATE)
    public String getFormForCreate(Model model, String message) {
        log.atInfo().log("-=== GET PRODUCT ON CREATE ===-");
        model.addAttribute("product", ProductDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));

        return "product/product";
    }

    @GetMapping(HttpEndpoints.PRODUCTS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID productId) {
        log.atInfo().log("-=== GET PRODUCT ON UPDATE ===-");
        model.addAttribute("product", productService.getProductByUUID(productId));

        return "product/product";
    }

    @PostMapping("/products/create")
        public String createAProduct(Model model, @Valid ProductDto product) {
        productService.saveProduct(product);

        return "redirect:/products/create?message=product.create.message.success";
        }

    @PostMapping(HttpEndpoints.PRODUCTS_UPDATE)
    public String updateProduct(Model model, Pageable pageable, Product product, @PathVariable UUID productId) {
        productService.updateProduct(product);

        return getProducts(model, pageable);
    }

    @GetMapping(HttpEndpoints.PRODUCTS)
    public String getProducts(Model model, @PageableDefault(size = 5, sort = {"price"}, direction = Sort.Direction.ASC)
    Pageable pageable) {
        final Page<ProductDto> allProducts = productService.getAllProductsPage(pageable);
        model.addAttribute("productList", allProducts);

        return "product/products";
    }

    @GetMapping(HttpEndpoints.PRODUCTS_DELETE)
    public String deleteProduct (Model model, Pageable pageable, @PathVariable UUID productId) {
        productService.deleteProductByUUID(productId);

        return getProducts(model, pageable);
    }
}
