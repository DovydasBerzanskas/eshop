package lt.codeacademy.eshop.common.cart.dto;

import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.eshop.common.cart.calculator.CartItemCalculator;
import lt.codeacademy.eshop.common.product.dto.ProductDto;

import java.math.BigDecimal;

@Builder
@Getter
public class CartItemDto {

    private final ProductDto productDto;
    private int quantity;

    public void incrementQuantity() {
        quantity++;
    }

    public BigDecimal getTotalItemPrice() {
        return CartItemCalculator.calculateTotal(this);
    }

}
