package br.com.magazineluiza.wishlist.client;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public ResponseEntity<ApiResponse> addClientDTO(ClientDTO clientDTO) {
        try {
            clientRepository.save(clientMapper.toClient(clientDTO));
        } catch (RuntimeException e){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Client has been added"), HttpStatus.CREATED);
    }
    
    public Client findBy(Integer clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        return client.get();
    }
<<<<<<< Updated upstream
    public String treatOutput(String output){
        String[] vet = output.split("Detalhe: ");
        return vet[1];
    }


=======
>>>>>>> Stashed changes
}
