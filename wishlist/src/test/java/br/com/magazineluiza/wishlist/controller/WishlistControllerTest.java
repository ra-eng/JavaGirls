package br.com.magazineluiza.wishlist.controller;


import br.com.magazineluiza.wishlist.client.ClientDTO;
import br.com.magazineluiza.wishlist.wishlist.WishlistService;
//import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WishlistControllerTest {
    @Autowired
    private MockMvc mockmvc;

    private static final String WISHLIST_ENDPOINT = "/wishlist";

    @MockBean
    private WishlistService wishlistService;

    @Test
    public void testeGetController_Sucesso() throws Exception {

        ClientDTO clientDTO = new ClientDTO(1, "067.945.456-40", "teste", "teste", "teste", Collections.emptyList());
        given(wishlistService.getProductsBy(1)).willReturn(clientDTO);

        mockmvc.perform(get(WISHLIST_ENDPOINT + "/" + clientDTO.getId()))
                .andExpect(status().isOk());

    }


}

