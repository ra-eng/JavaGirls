package br.com.magazineluiza.wishlist.client;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@ApiOperation(value ="/clients", tags = "Clients Controller" )
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @ApiOperation(value= "Add new Clients", response = ClientDTO.class)
    @PostMapping
    public ResponseEntity<ApiResponse> addClient(@RequestBody @Valid ClientDTO clientDTO){
        return clientService.addClient(clientDTO);
    }
}
