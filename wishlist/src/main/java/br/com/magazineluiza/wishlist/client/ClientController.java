package br.com.magazineluiza.wishlist.client;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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

    @ApiOperation(value= "Add new Clients", response = Client.class)
    @PostMapping
    public ResponseEntity<ApiResponse> addClient(@RequestBody @Valid ClientDTO clientDTO){
        try {
            clientService.addClientDTO(clientDTO);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Client has been added"), HttpStatus.CREATED);
        }
        catch(DataIntegrityViolationException e){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, clientService.treatOutput(e.getCause().getCause().getMessage())), HttpStatus.NOT_ACCEPTABLE);
        }

    }



}
