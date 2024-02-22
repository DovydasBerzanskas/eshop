package lt.codeacademy.eshop.jpa.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID productId;
    private String name;
    private BigDecimal price;
    private int amount;
    private String description;
    private String image;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<ProductCategory> productCategories = new HashSet<>();
}
