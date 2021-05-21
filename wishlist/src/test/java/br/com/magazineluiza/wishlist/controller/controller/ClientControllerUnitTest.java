package br.com.magazineluiza.wishlist.controller.controller;

import static br.com.magazineluiza.wishlist.controller.mother.ClientMother.getClient;
import static br.com.magazineluiza.wishlist.controller.mother.ClientMother.getClientDto;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.magazineluiza.wishlist.controller.ClientController;
import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.entity.Client;
import br.com.magazineluiza.wishlist.service.ClientService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({
    ClientController.class,
    ClientService.class
})
public class ClientControllerUnitTest {

  private static final String CLIENT_ENDPOINT = "/clients";

  @Autowired
  private MockMvc mockmvc;

  @MockBean
  private ClientService clientService;


  @Test
  public void givenAValidClientIdAndAValidProductIdWhenAddProductThenReturnSucess()
      throws Exception {
    Client client = getClient();
    ClientDTO clientDTO = getClientDto();

    given(clientService.addClient(clientDTO)).willReturn(clientDTO);

    Gson gson = new Gson();
    String jsonBody = gson.toJson(clientDTO);

    mockmvc.perform(post(CLIENT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  public void givenAInvalidEmailWhenAddProductThenReturnBadReqeust()
      throws Exception {
    ClientDTO clientDTO = getClientDto();
    clientDTO.setEmail("TESTE");

    given(clientService.addClient(clientDTO)).willReturn(clientDTO);

    Gson gson = new Gson();
    String jsonBody = gson.toJson(clientDTO);

    mockmvc.perform(post(CLIENT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenABlankValueWhenAddProductThenReturnBadReqeust()
      throws Exception {
    ClientDTO clientDTO = getClientDto();
    clientDTO.setName("");

    given(clientService.addClient(clientDTO)).willReturn(clientDTO);

    Gson gson = new Gson();
    String jsonBody = gson.toJson(clientDTO);

    mockmvc.perform(post(CLIENT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void givenANullValueWhenAddProductThenReturnBadRequest()
      throws Exception {
    ClientDTO clientDTO = getClientDto();
    clientDTO.setName(null);

    given(clientService.addClient(clientDTO)).willReturn(clientDTO);

    Gson gson = new Gson();
    String jsonBody = gson.toJson(clientDTO);

    mockmvc.perform(post(CLIENT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }
}
