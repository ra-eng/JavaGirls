package br.com.magazineluiza.wishlist.product;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public Iterable<Product> getAll()  {
        return productRepository.findAll();
    }

    public ResponseEntity<ApiResponse> addProduct(ProductDTO productDTO) {
        try {
            productRepository.save(productMapper.toProduct(productDTO));
        } catch (RuntimeException e){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    public Product findBy(Integer id){
        return productRepository.findById(id).get();
    }
}
