package br.com.magazineluiza.wishlist.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(unique = true)
  private String cpf;

  private String name;

  private String email;

  private String password;


  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "wishlist",
      joinColumns = @JoinColumn(name = "id_client"),
      inverseJoinColumns = @JoinColumn(name = "id_product"))
  @ApiModelProperty(required = false, hidden = true)
  private List<Product> products = new ArrayList<>();

  public Client() {
  }

  public Client(Integer id, String cpf, String name, String email, String password,
      List<Product> products) {
    this.id = id;
    this.cpf = cpf;
    this.name = name;
    this.email = email;
    this.password = password;
    this.products = products;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public void addProduct(Product product) {
    this.getProducts().add(product);
  }
}
