package br.com.magazineluiza.wishlist.controller;

import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.entity.Product;
import br.com.magazineluiza.wishlist.service.ProductService;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Iterable<Product>> getAll() {
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Add new Products", response = ProductDTO.class)
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Object addProduct(@RequestBody @Valid ProductDTO productDTO) {
    return productService.addProduct(productDTO);
  }
}
