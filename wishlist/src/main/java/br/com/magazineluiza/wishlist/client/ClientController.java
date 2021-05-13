package br.com.magazineluiza.wishlist.client;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addClient(@RequestBody ClientDTO clientDTO){
        clientService.addClient(clientDTO);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Client has been added"), HttpStatus.CREATED);
    }

}
