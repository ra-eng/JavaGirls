package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.Client;
import br.com.magazineluiza.wishlist.product.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "cliente_id")
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "created_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdDate;

    final int maxProducts = 20;

    public Wishlist() {

    }

    public Wishlist(Client client, Product product) {
        this.client = client;
        this.product = product;
        this.createdDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getMaxProducts() {
        return maxProducts;
    }

}
