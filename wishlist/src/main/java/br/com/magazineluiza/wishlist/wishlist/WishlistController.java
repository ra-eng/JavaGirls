package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import br.com.magazineluiza.wishlist.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/{clientId}/{productId}")
    public ResponseEntity<ApiResponse> addProduct(@PathVariable("clientId") Integer clientId, @PathVariable("productId") Integer productId){
        try {
            wishlistService.addProduct(clientId, productId);
        } catch (RuntimeException e){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added to Wishlist"), HttpStatus.CREATED);
    }

    @GetMapping("{clientId}")
    public ResponseEntity<Set<ProductDTO>> GetProdutosByIdCliente(@PathVariable(value = "clientId") Integer clientId) {
            Set<ProductDTO> products = wishlistService.getProductsBy(clientId);
        return new ResponseEntity<Set<ProductDTO>>(products, HttpStatus.CREATED);
    }

    @DeleteMapping("/{clientId}/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("clientId") Integer clientId, @PathVariable("productId") Integer productId){
        try {
            wishlistService.deleteProduct(clientId, productId);
        } catch (RuntimeException e){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been deleted from Wishlist"), HttpStatus.CREATED);
    }

}
