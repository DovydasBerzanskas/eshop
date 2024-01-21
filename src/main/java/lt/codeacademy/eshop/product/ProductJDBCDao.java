package lt.codeacademy.eshop.product;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductJDBCDao implements ProductDao{

    @Override
    public void save (Product product) {}

    @Override
    public void update (Product product) {}

    @Override
    public List<Product> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Product getProductByUUID(UUID id) {
        return null;
    }

    @Override
    public void deleteProductByUUID(UUID id) {}
}