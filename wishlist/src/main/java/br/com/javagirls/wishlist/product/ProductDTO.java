package br.com.javagirls.wishlist.product;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDTO {

    private @NotNull String name;
    private @NotNull BigDecimal price;
    private @NotNull String details;

    public ProductDTO(Product product) {
        this.name  = product.getName();
        this.price = product.getPrice();
        this.details = product.getDetails();
    }

    public ProductDTO(String name, BigDecimal price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }
}
