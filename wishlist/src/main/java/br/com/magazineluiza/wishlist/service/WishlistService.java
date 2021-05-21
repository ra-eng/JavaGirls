package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.dto.ClientDTO;
import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.entity.Client;
import br.com.magazineluiza.wishlist.entity.Product;
import br.com.magazineluiza.wishlist.exception.IdAlreadyAddedException;
import br.com.magazineluiza.wishlist.exception.MaximumSizeException;
import br.com.magazineluiza.wishlist.mapper.ClientMapper;
import br.com.magazineluiza.wishlist.mapper.ProductMapper;
import br.com.magazineluiza.wishlist.repository.ClientRepository;
import java.util.List;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

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

  public ResponseEntity<List<ProductDTO>> getProductsBy(Integer clientId) {
    ClientDTO client = clientMapper.toClientDTO(clientService.findBy(clientId));
    if (client == null) throw new NullPointerException("Client not found.");
    return new ResponseEntity<List<ProductDTO>>(productMapper.toProductDTO(client.getProducts()),
            HttpStatus.OK);
  }

  public ResponseEntity<List<ProductDTO>> getProductsByName(String productName, Integer clientId) {
    ClientDTO client = clientMapper.toClientDTO(clientService.findBy(clientId));
    if (client == null) throw new NullPointerException("Client not found.");

    List<ProductDTO> products = productMapper.toProductDTO(client.getProducts());
    if (products.size() == 0) throw new NoResultException("Empty Wishlist.");

    products = products.stream().filter(p -> p.getName()
            .toLowerCase().contains(productName.toLowerCase())).collect(Collectors.toList());

    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  public ClientDTO addProduct(Integer clientId, Integer productId) throws NotFoundException {
    int maximumProducts = 20;
    Client client = null;
    Product product = null;

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
      return clientMapper.toClientDTO(clientService.addClient(client));
  }

  public ResponseEntity<?> deleteProduct(Integer clientId, Integer productId) throws NotFoundException {
    Client client = clientService.findBy(clientId);
    if (client == null) throw new NotFoundException("Client not found.");

    List<Product> products = client.getProducts();
    if (products.size() == 0) throw new NotFoundException("Empty wishlist.");

    for (Product product : products) {
      if (product.getId().equals(productId)) {
        clientRepository.removeProduct(productId);
        return ResponseEntity.ok().body("Product removed.");
      }
    }
    return ResponseEntity.badRequest().body("Product not found.");
  }
}
