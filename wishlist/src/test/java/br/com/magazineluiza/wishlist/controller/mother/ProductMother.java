package br.com.magazineluiza.wishlist.controller.mother;

import br.com.magazineluiza.wishlist.product.Product;
import java.math.BigDecimal;

public class ProductMother {

  public static Product getProduct() {

    return new Product(1, "Teste", new BigDecimal(128.90), "teste", "teste", "test");

  }

}
