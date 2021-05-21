package br.com.magazineluiza.wishlist.client;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  Client toClient(ClientDTO clientDTO);

  ClientDTO toClientDTO(Client client);
}
