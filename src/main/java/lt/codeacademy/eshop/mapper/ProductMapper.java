package lt.codeacademy.eshop.mapper;

import lt.codeacademy.eshop.product.Product;
import lt.codeacademy.eshop.product.ProductService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Product.builder()
                .productId(UUID.fromString(rs.getString("product_id")))
                .name(rs.getString("name"))
                .price(rs.getDouble("price"))
                .amount(rs.getInt("amount"))
                .build();
    }
}
