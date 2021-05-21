package br.com.magazineluiza.wishlist.entity;

import br.com.magazineluiza.wishlist.entity.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private BigDecimal price;
  private String details;
  private String category;
  private String image;


  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
  private List<Client> clients = new ArrayList<>();

  public Product() {
  }

  public Product(Integer id, String name, BigDecimal price, String details, String category,
      String image) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.details = details;
    this.category = category;
    this.image = image;
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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @JsonIgnore
  public List<Client> getClients() {
    return clients;
  }

  public void setClients(List<Client> clients) {
    this.clients = clients;
  }
}
