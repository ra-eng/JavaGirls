package br.com.magazineluiza.wishlist.controller.mother;

import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.entity.Client;
import br.com.magazineluiza.wishlist.entity.Product;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClientMother {

  public static List<Product> getProductListByClientId() {

    return Arrays.asList(new Product(1, "Teste", new BigDecimal(128.90), "teste", "teste", "test"));

  }

  public static Client getClient() {
    return new Client(1, "Teste", "Teste", "Teste", "Teste", Collections.emptyList());
  }

  public static ClientDTO getClientDto() {
    return new ClientDTO(1, "Teste", "Teste", "Teste@Teste.com", "Teste", Collections.emptyList());
  }

}
