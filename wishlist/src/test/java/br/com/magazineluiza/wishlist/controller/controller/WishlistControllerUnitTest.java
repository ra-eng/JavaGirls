package br.com.magazineluiza.wishlist.controller.controller;


import static br.com.magazineluiza.wishlist.controller.mother.ClientMother.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.magazineluiza.wishlist.controller.WishlistController;
import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.service.WishlistService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({
    WishlistController.class,
    WishlistService.class
})
public class WishlistControllerUnitTest {

  private static final String WISHLIST_ENDPOINT = "/wishlist";

  @Autowired
  private MockMvc mockmvc;

  @MockBean
  private WishlistService wishlistService;

  @Test
  public void givenAValidClientIdWhengetProductsByThenReturnProductList() throws Exception {
    List<ProductDTO> productList = getProductListByClientId();
    given(wishlistService.getProductsBy(1)).willReturn(new ResponseEntity<List<ProductDTO>>(productList, HttpStatus.CREATED));

    mockmvc.perform(get(WISHLIST_ENDPOINT + "/" + "1"))
        .andExpect(status().isCreated())
        .andDo(print())
        .andExpect(jsonPath("$[0].id").value(productList.get(0).getId()))
        .andExpect(jsonPath("$[0].name").value(productList.get(0).getName()))
        .andExpect(jsonPath("$[0].category").value(productList.get(0).getCategory()))
        .andExpect(jsonPath("$[0].details").value(productList.get(0).getDetails()))
        .andExpect(jsonPath("$[0].image").value(productList.get(0).getImage()));
  }

  @Test
  public void givenAValidClientIdAndAValidProductIdWhenAddProductThenReturnSucess()
      throws Exception {
    ClientDTO client = getClientDto();
    given(wishlistService.addProduct(1, 1)).willReturn(client);

    mockmvc.perform(post(WISHLIST_ENDPOINT + "/" + "1" + "/" + "1"))
        .andExpect(status().isCreated())
        .andDo(print())
        .andExpect(jsonPath("$.id").value(client.getId()))
        .andExpect(jsonPath("$.name").value(client.getName()))
        .andExpect(jsonPath("$.cpf").value(client.getCpf()))
        .andExpect(jsonPath("$.email").value(client.getEmail()))
        .andExpect(jsonPath("$.password").value(client.getPassword()));
  }
}

