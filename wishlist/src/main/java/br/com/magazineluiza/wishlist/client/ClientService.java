package br.com.magazineluiza.wishlist.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void addClient(ClientDTO clientDTO) {
        Client client = new Client(clientDTO);
        clientRepository.save(client);
    }
}
