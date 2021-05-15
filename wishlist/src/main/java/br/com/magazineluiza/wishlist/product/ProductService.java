package br.com.magazineluiza.wishlist.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public static ProductDTO getDtoFromProduct(Product product) {
        return new ProductDTO(product);
    }

    public void addProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        productRepository.save(product);
    }

    public List<Product> getProducts()  {
        return productRepository.findAll();
    }

    public Product findProduct(Integer productId){
        Optional<Product> product = productRepository.findById(productId);
        return Optional.ofNullable(product).get().get();
    }
}
