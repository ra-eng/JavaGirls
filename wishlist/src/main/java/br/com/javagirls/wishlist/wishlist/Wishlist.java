package br.com.javagirls.wishlist.wishlist;

import br.com.javagirls.wishlist.client.Client;
import br.com.javagirls.wishlist.product.Product;
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

    public void addProduct(Product product){

    }

    public void deleteProduct(){

    }

    public void findAllProducts(){

    }

    public void findProduct(){

    }

}
