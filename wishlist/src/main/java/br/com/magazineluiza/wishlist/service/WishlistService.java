package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.entity.Client;
import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.mapper.ClientMapper;
import br.com.magazineluiza.wishlist.repository.ClientRepository;

import br.com.magazineluiza.wishlist.exception.IdAlreadyAddedException;
import br.com.magazineluiza.wishlist.exception.MaximumSizeException;
import br.com.magazineluiza.wishlist.entity.Product;
import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.mapper.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

  @Autowired
  private ClientService clientService;

  @Autowired
  private ProductService productService;

  @Autowired
  private ProductMapper productMapper;

  @Autowired
  private ClientMapper clientMapper;

  @Autowired
  private ClientRepository clientRepository;

  public Client addProduct(Integer clientId, Integer productId) {
    int maximumProducts = 20;
    Client client = null;
    Product product = null;

    try {
      client = clientService.findBy(clientId);
      if (client == null) throw new NotFoundException("Client not found.");
      product = productService.findBy(productId);
      if (product == null) throw new NotFoundException("Product not found.");

      for (Product p : client.getProducts()) {
        if (p.getId().equals(productId)) {
          throw new IdAlreadyAddedException(productId);
        }
      }

      if (client.getProducts().size() == maximumProducts) {
        throw new MaximumSizeException(maximumProducts);
      }

      client.addProduct(product);
      return clientService.addClient(client);
    } catch (RuntimeException | NotFoundException ignored){

    }
    return client;
  }

  public List<Product> getProductsBy(Integer clientId) {
    ClientDTO client = clientMapper.toClientDTO(clientService.findBy(clientId));
    return client.getProducts();
  }

  public ResponseEntity<?> deleteProduct(Integer clientId, Integer productId) {
    Client client = null;
    List<Product> products;

    try {
      client = clientService.findBy(clientId);
      products = client.getProducts();
      if (products.size() == 0) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      for (Product product : products) {
        if (product.getId().equals(productId)) {
          clientRepository.removeProduct(productId);
          return new ResponseEntity<>(HttpStatus.OK);
        }
      }
    } catch (RuntimeException e) {
      if (client == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<List<ProductDTO>> getProductsByName(String productName, Integer clientId) {
    ClientDTO clientDTO = clientMapper.toClientDTO(clientService.findBy(clientId));
    List<ProductDTO> products = productMapper.toProductDTO(clientDTO.getProducts());
    List<ProductDTO> collect = products.stream().filter(p -> p.getName()
            .toLowerCase().contains(productName.toLowerCase())).collect(Collectors.toList());

    return new ResponseEntity<>(collect, HttpStatus.OK);
  }
}