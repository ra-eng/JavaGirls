package br.com.magazineluiza.wishlist.product;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation(value = "/products", tags = "Products Controller")
@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @Autowired
  ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @ApiOperation(value = "Fetch all products", response = ProductDTO.class)
  @GetMapping
  public ResponseEntity<Iterable<Product>> getAll() {
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Add new Products", response = ProductDTO.class)
  @PostMapping
  public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid ProductDTO productDTO) {
    return productService.addProduct(productDTO);
  }
}
