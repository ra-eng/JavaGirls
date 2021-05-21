package br.com.magazineluiza.wishlist.controller;

import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.entity.Product;
import br.com.magazineluiza.wishlist.service.ProductService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @ApiOperation(value = "Add new Products", response = ProductDTO.class)
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Object addProduct(@RequestBody @Valid ProductDTO productDTO) {
    return productService.addProduct(productDTO);
  }

  @ApiOperation(value = "Fetch all products", response = ProductDTO.class)
  @GetMapping
  public List<ProductDTO> getAll() {
    return productService.getAll();
  }
}
