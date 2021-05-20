package br.com.magazineluiza.wishlist.client;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void addClientDTO(ClientDTO clientDTO) {
        clientRepository.save(clientMapper.toClient(clientDTO));
    }
    
    public Client findBy(Integer clientId){
        Optional<Client> client = clientRepository.findById(clientId);
        return client.get();
    }
    public String treatOutput(String output){
        String[] vet = output.split("Detalhe: ");
        return vet[1];
    }


}
