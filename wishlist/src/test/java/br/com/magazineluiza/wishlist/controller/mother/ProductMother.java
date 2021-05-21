package br.com.magazineluiza.wishlist.controller.mother;

import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.entity.Product;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductMother {

  public static Product getProduct() {

    return new Product(1, "Teste", new BigDecimal(128.90), "teste", "teste", "test");

  }

  public static ProductDTO getProductDto() {

    return new ProductDTO(1, "Teste", new BigDecimal(128.90), "teste", "teste", "test");

  }

  public static List<Product> getProductList() {

    return Arrays.asList(new Product(1, "Teste", new BigDecimal(128.90), "teste", "teste", "test"));

  }

}
