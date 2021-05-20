package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.ClientDTO;
import br.com.magazineluiza.wishlist.common.ApiResponse;
import br.com.magazineluiza.wishlist.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("{clientId}")
    public ResponseEntity<ClientDTO> getProdutosByIdCliente(@PathVariable(value = "clientId") Integer clientId) {
        ClientDTO client = wishlistService.getProductsBy(clientId);
        return new ResponseEntity<ClientDTO>(client, HttpStatus.CREATED);
    }

    @GetMapping("/{clientId}/product/{name}")
    public ResponseEntity<List<ProductDTO>> getProdutosByName(@PathVariable(value = "clientId") Integer clientId, @PathVariable(value = "name") String productName) {
        List<ProductDTO> products = wishlistService.getProductsByName(productName, clientId);
        return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
    }

    @PostMapping("/{clientId}/{productId}")
    public ResponseEntity<ApiResponse> addProduct(@PathVariable("clientId") Integer clientId, @PathVariable("productId") Integer productId){
        try {
            wishlistService.addProduct(clientId, productId);
        } catch (RuntimeException e){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added to Wishlist"), HttpStatus.CREATED);
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
