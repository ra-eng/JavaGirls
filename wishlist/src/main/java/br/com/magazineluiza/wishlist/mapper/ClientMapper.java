package br.com.magazineluiza.wishlist.mapper;

import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  Client toClient(ClientDTO clientDTO);

  ClientDTO toClientDTO(Client client);
}
