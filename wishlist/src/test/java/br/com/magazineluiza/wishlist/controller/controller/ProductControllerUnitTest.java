package br.com.magazineluiza.wishlist.controller.controller;

import static br.com.magazineluiza.wishlist.controller.mother.ProductMother.getProductDto;
import static br.com.magazineluiza.wishlist.controller.mother.ProductMother.getProductList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.magazineluiza.wishlist.controller.ProductController;
import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.entity.Product;
import br.com.magazineluiza.wishlist.service.ProductService;
import com.google.gson.Gson;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({
    ProductController.class,
    ProductService.class
})
public class ProductControllerUnitTest {


  private static final String PRODUCT_ENDPOINT = "/products";

  @Autowired
  private MockMvc mockmvc;

  @MockBean
  private ProductService productService;

  @Test
  public void givenAValidClientIdAndAValidProductIdWhenAddProductThenReturnSucess()
      throws Exception {
    ProductDTO productDTO = getProductDto();

    given(productService.addProduct(productDTO)).willReturn(productDTO);

    Gson gson = new Gson();
    String jsonBody = gson.toJson(productDTO);

    mockmvc.perform(post(PRODUCT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  public void givenANullFieldWhenAddProductThenReturnSucess()
      throws Exception {
    ProductDTO productDTO = getProductDto();

    productDTO.setCategory(null);

    Gson gson = new Gson();
    String jsonBody = gson.toJson(productDTO);

    mockmvc.perform(post(PRODUCT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenAEmptyieldWhenAddProductThenReturnSucess()
      throws Exception {
    ProductDTO productDTO = getProductDto();

    productDTO.setCategory("");

    Gson gson = new Gson();
    String jsonBody = gson.toJson(productDTO);

    mockmvc.perform(post(PRODUCT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void WhenGetAllThenReturnSucess()
      throws Exception {
    List<Product> productList = getProductList();

    given(productService.getAll()).willReturn(productList);

    mockmvc.perform(get(PRODUCT_ENDPOINT))
        .andExpect(status().isOk());
  }
}
