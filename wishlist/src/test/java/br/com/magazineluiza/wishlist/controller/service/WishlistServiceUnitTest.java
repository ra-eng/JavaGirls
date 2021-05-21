package br.com.magazineluiza.wishlist.controller.service;

import static br.com.magazineluiza.wishlist.controller.mother.ClientMother.getClient;
import static br.com.magazineluiza.wishlist.controller.mother.ProductMother.getProduct;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.entity.Client;
import br.com.magazineluiza.wishlist.entity.Product;
import br.com.magazineluiza.wishlist.mapper.ClientMapper;
import br.com.magazineluiza.wishlist.mapper.ProductMapper;
import br.com.magazineluiza.wishlist.repository.ClientRepository;
import br.com.magazineluiza.wishlist.repository.ProductRepository;
import br.com.magazineluiza.wishlist.service.ClientService;
import br.com.magazineluiza.wishlist.service.ProductService;
import br.com.magazineluiza.wishlist.service.WishlistService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WishlistServiceUnitTest {

  @InjectMocks
  private WishlistService wishlistService;

  @Mock
  private ClientService clientService;

  @Mock
  private ProductService productService;

  @Mock
  private ProductMapper productMapper;

  @Mock
  private ClientMapper clientMapper;

  @Mock
  private ClientRepository clientRepository;

  @Mock
  private Client clientEntity;

  @Mock
  private ProductRepository productRepository;

  @Test
  void givenAValidClientWhenCreateThenReturnEntityClient() throws NotFoundException {
    Client client = getClient();
    Product product = getProduct();

    given(clientService.findBy(client.getId())).willReturn(client);
    given(productService.findBy(product.getId())).willReturn(product);
    given(wishlistService.addProduct(client.getId(),product.getId())).willReturn(clientMapper.toClientDTO(client));
    given(clientService.addClient(client)).willReturn(client);

    ClientDTO clientResponse = wishlistService.addProduct(1, 1);

    then(clientResponse.getCpf()).isEqualTo(client.getCpf());
    then(clientResponse.getId()).isEqualTo(client.getId());
    then(clientResponse.getEmail()).isEqualTo(client.getEmail());
    then(clientResponse.getName()).isEqualTo(client.getName());
    then(clientResponse.getPassword()).isEqualTo(client.getPassword());

    verify(wishlistService, times(1)).addProduct(1, 1);
  }
}
