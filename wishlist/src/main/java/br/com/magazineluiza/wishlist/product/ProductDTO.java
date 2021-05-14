package br.com.magazineluiza.wishlist.product;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDTO {

    private @NotNull Integer id;
    private @NotNull String name;
    private @NotNull BigDecimal price;
    private @NotNull String details;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.details = product.getDetails();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
