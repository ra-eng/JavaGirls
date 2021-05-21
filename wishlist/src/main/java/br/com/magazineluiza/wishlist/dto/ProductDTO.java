package br.com.magazineluiza.wishlist.dto;

import br.com.magazineluiza.wishlist.entity.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(description = "Details about the products")

public class ProductDTO {

  @ApiModelProperty(notes = "The unique id  of the product", required = false, hidden = true)
  private Integer id;

  @ApiModelProperty(notes = "The product´s name", example = "Sabre de Luz")
  @NotBlank(message = "{value.not.blank}")
  @NotNull
  private String name;

  @ApiModelProperty(notes = "The product´s price", example = "9000")
  @NotNull(message = "{value.not.null}")
  @NotNull
  private BigDecimal price;

  @ApiModelProperty(notes = "The product´s details", example = "Vermelho")
  @NotBlank(message = "{value.not.blank}")
  @NotNull
  private String details;

  @ApiModelProperty(notes = "The product´s category", example = "Armas")
  @NotBlank(message = "{value.not.blank}")
  @NotNull
  private String category;

  @ApiModelProperty(notes = "The product image", required = false, hidden = true)
  private String image;

  public ProductDTO() {
  }

  public ProductDTO(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.price = product.getPrice();
    this.details = product.getDetails();
    this.category = product.getCategory();
    this.image = product.getImage();
  }

  public ProductDTO(Integer id, String name, BigDecimal price, String details, String category,
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
}
