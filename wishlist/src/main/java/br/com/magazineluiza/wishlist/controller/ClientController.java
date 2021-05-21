package br.com.magazineluiza.wishlist.controller;

import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.service.ClientService;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ApiOperation(value = "/clients", tags = "Clients Controller")
@RestController
@RequestMapping("/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @ApiOperation(value = "Add new Clients", response = ClientDTO.class)
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClientDTO addClient(@RequestBody @Valid ClientDTO clientDTO) {
    return clientService.addClient(clientDTO);
  }
}
