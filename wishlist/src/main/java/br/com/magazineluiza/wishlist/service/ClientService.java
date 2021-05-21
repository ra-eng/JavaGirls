package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.entity.Client;
import br.com.magazineluiza.wishlist.mapper.ClientMapper;
import br.com.magazineluiza.wishlist.repository.ClientRepository;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  public Object addClient(ClientDTO clientDTO) {
    Optional<Client> client = Optional.ofNullable(clientRepository.findByCpf(clientDTO.getCpf()));
    if (client.isPresent()) return ResponseEntity.badRequest().body("CPF already exist.");

    client = Optional.ofNullable(clientRepository.findByEmail(clientDTO.getEmail()));
    if (client.isPresent()) return ResponseEntity.badRequest().body("Email already exist.");

    try {
      return clientMapper.toClientDTO(clientRepository.save(clientMapper.toClient(clientDTO)));
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body("Error adding client.");
    }
  }

  public Client findBy(Integer id) {
    Optional<Client> client = clientRepository.findById(id);
    return client.orElse(null);
  }
}
