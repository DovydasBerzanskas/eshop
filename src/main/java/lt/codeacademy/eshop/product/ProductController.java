package lt.codeacademy.eshop.product;

import lombok.extern.log4j.Log4j2;
import lt.codeacademy.eshop.HttpEndpoints;
import lt.codeacademy.eshop.product.Product;
import lt.codeacademy.eshop.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(HttpEndpoints.PRODUCTS_CREATE)
    public String getFormForCreate(Model model) {
        log.atInfo().log("-=== GET PRODUCT ON CREATE ===-");
        model.addAttribute("product", Product.builder().build());

        return "product/product";
    }

    @GetMapping(HttpEndpoints.PRODUCTS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID productId) {
        log.atInfo().log("-=== GET PRODUCT ON UPDATE ===-");
        model.addAttribute("product", productService.getProductByUUID(productId));

        return "product/product";
    }

    @PostMapping("/products/create")
        public String createAProduct(Model model, Product product) {
        productService.saveProduct(product);
        model.addAttribute("message", "Product added successfully!");

        return "product/product";
        }

    @PostMapping(HttpEndpoints.PRODUCTS_UPDATE)
    public String updateProduct(Model model, Product product, @PathVariable UUID productId) {
        productService.updateProduct(product);

        return getProducts(model);
    }

    @GetMapping(HttpEndpoints.PRODUCTS)
    public String getProducts(Model model) {
        final List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("productList", allProducts);

        return "product/products";
    }

    @GetMapping(HttpEndpoints.PRODUCTS_DELETE)
    public String deleteProduct (Model model, @PathVariable UUID productId) {
        productService.deleteProductByUUID(productId);

        return getProducts(model);
    }
}
