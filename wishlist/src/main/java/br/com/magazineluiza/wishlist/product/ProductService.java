package br.com.magazineluiza.wishlist.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public void addProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        productRepository.save(product);
    }

    public Iterable<ProductDTO> getProducts()  {
        Iterable<Product> products = productRepository.findAll();
        return productMapper.toProductDTO(products);
    }

    public Product findBy(Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
