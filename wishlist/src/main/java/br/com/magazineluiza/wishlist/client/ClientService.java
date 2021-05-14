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

    public int findClientByID(Integer clientId){
        Optional<Client> id = clientRepository.findById(clientId);
        return id.get().getId();
    }

    public Client findClient(Integer clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        return Optional.ofNullable(client).get().get();
    }

}
