package br.com.magazineluiza.wishlist.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
