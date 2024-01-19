package lt.codeacademy.eshop.product;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private double price;
    private int amount;
}
