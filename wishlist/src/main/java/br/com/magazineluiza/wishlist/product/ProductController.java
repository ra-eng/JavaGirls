package br.com.magazineluiza.wishlist.product;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@Api(value = "Product")
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    ProductService productService;

    private ProductRepository productRepository;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }

   // @ApiOperation(value = "Adicionar Produto")
    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid ProductDTO productDTO){
        productService.addProduct(productDTO);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }
}
