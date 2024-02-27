package lt.codeacademy.eshop.product.service;

import lt.codeacademy.eshop.common.product.service.ProductService;
import lt.codeacademy.eshop.jpa.repositories.ProductCategoryRepository;
import lt.codeacademy.eshop.common.product.dao.ProductDao;
import lt.codeacademy.eshop.common.product.dto.ProductDto;
import lt.codeacademy.eshop.common.product.mappers.ProductMapper;
import lt.codeacademy.eshop.jpa.entities.Product;
import lt.codeacademy.eshop.jpa.entities.ProductCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductCategoryRepository productCategoryRepository;

    @Mock
    private ProductDao productDao;

    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private ProductService service;

    @Test
    public void saveProduct_savesAProductAndSetsCategory() {
        var productUUID = UUID.randomUUID();
        var categoryId = 123L;

        var productDto = new ProductDto(productUUID, "Meta Quest 2", BigDecimal.valueOf(1.95), 1, List.of(categoryId), "description", null);
        var product = new Product();

        when(productCategoryRepository.getReferenceById(any())).thenReturn(new ProductCategory());
        when(mapper.fromDto(productDto)).thenReturn(product);

        service.saveProduct(productDto);

        verify(mapper).fromDto(eq(productDto));
        verify(productCategoryRepository).getReferenceById(eq(categoryId));
        verify(productDao).save(eq(product));
    }
}
