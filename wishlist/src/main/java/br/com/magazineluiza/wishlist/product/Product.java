package br.com.magazineluiza.wishlist.product;

import br.com.magazineluiza.wishlist.wishlist.Wishlist;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private @NotNull String name;
    private @NotNull BigDecimal price;
    private @NotNull String details;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Wishlist> wishlistList;

//    private @NotNull String image;

    public Product() {
    }

    public Product(ProductDTO productDTO) {
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.details = productDTO.getDetails();
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
