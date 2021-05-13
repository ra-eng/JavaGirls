package br.com.magazineluiza.wishlist.product;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
