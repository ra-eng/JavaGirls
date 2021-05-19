package br.com.magazineluiza.wishlist.product;

import br.com.magazineluiza.wishlist.client.Client;
import br.com.magazineluiza.wishlist.common.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@ApiOperation(value ="/products", tags = "Products Controller" )
@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value= "Fetch all products", response = Product.class)
    @GetMapping
    public Iterable<ProductDTO> getProducts(){
        return productService.getProducts();
    }

    @ApiOperation(value= "Add new Products", response = Product.class)
    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid ProductDTO productDTO){
        productService.addProduct(productDTO);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }
}
