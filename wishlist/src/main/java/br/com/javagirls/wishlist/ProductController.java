package br.com.javagirls.wishlist;

import br.com.javagirls.wishlist.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ProductController {

    ProductRepository repository;

    @GetMapping("/produto")
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Product getProductById(@PathVariable Long id){
        return repository.getOne(id);
    }

    @DeleteMapping("/produto/{id}")
    public void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }


    @PostMapping("/produto")
    public Product saveProduct(@RequestBody Product product) {
        return repository.save(product);
    }
}
