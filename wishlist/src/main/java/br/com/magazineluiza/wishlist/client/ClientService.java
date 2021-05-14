package br.com.magazineluiza.wishlist.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void addClient(ClientDTO clientDTO) {
        Client client = new Client(clientDTO);
        clientRepository.save(client);
    }

    public Optional<Client> findClientByID (Integer clientId ){
        Optional<Client> id = clientRepository.findById(clientId);

    }

}
