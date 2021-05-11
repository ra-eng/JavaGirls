package br.com.javagirls.wishlist.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TB_PRODUCTS")

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double value;
    private String details;
    private String image;



    public void addProduct(){

    }
}
