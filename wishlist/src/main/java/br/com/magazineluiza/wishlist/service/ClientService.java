package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.entity.Client;
import java.util.Optional;

import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.mapper.ClientMapper;
import br.com.magazineluiza.wishlist.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private ClientMapper clientMapper;

  public Client addClient(Client client) {
    return clientRepository.save(client);
  }

  public ClientDTO addClient(ClientDTO clientDTO) {
    try {
      return clientMapper.toClientDTO(clientRepository.save(clientMapper.toClient(clientDTO)));
    } catch (RuntimeException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public Client findBy(Integer id) {
    Optional<Client> client = clientRepository.findById(id);
    return client.orElse(null);
  }
}
