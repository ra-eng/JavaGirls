package br.com.magazineluiza.wishlist.service;

import java.util.Optional;

import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.entity.Product;
import br.com.magazineluiza.wishlist.mapper.ProductMapper;
import br.com.magazineluiza.wishlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductMapper productMapper;

  public Iterable<Product> getAll() {
    return productRepository.findAll();
  }

  public ProductDTO addProduct(ProductDTO productDTO) {
    try {
      return productMapper.toProductDTO(productRepository.save(productMapper.toProduct(productDTO)));
    } catch (RuntimeException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public Product findBy(Integer id) {
    Optional<Product> product = productRepository.findById(id);
    return product.orElse(null);
  }
}
