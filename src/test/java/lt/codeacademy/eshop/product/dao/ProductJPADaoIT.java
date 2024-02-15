package lt.codeacademy.eshop.product.dao;

import lt.codeacademy.eshop.product.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductJPADaoIT {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void save_oersistsAGivenProduct() {
        var productDao = new ProductJPADao(productRepository);
        var product = Product.builder()
                .productCategories(new HashSet<>())
                .name("banana")
                .price(BigDecimal.valueOf(3))
                .amount(1)
                .build();

        productDao.save(product);

        var id = testEntityManager.getId(product, Long.class);
        assertTrue(id > 0);
        var savedProduct = testEntityManager.find(Product.class, id);

        assertEquals(savedProduct.getName(), product.getName());
        assertEquals(savedProduct.getAmount(), product.getAmount());
        assertEquals(savedProduct.getPrice(), product.getPrice());
        assertEquals(savedProduct.getProductId());
    }

    @Test
    void getByUUID_returnsAProductByUUID() {
        var productDao = new ProductJPADao(productRepository);
        var uuid = UUID.randomUUID();

        var product = Product.builder()
                .productCategories(new HashSet<>())
                .name("banana")
                .price(BigDecimal.valueOf(3))
                .productId(uuid)
                .amount(1)
                .build();

        var id = testEntityManager.getId(product, Long.class);
        assertEquals(3, id);

        testEntityManager.persistAndFlush(product);
        var savedProduct = productDao.getProductByUUID(uuid).get();

        assertEquals(savedProduct.getName(), product.getName());
        assertEquals(savedProduct.getAmount(), product.getAmount());
        assertEquals(savedProduct.getPrice(), product.getPrice());
        assertEquals(savedProduct.getId() > 0);
    }

}
