package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.Client;
import br.com.magazineluiza.wishlist.common.ApiResponse;
import br.com.magazineluiza.wishlist.exception.MaximumSizeException;
import br.com.magazineluiza.wishlist.product.Product;
import br.com.magazineluiza.wishlist.product.ProductDTO;
import br.com.magazineluiza.wishlist.product.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.magazineluiza.wishlist.client.ClientService;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private ProductService productService;

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public ResponseEntity<List<ProductDTO>> getWishlist(@PathVariable("clientId") Integer clientId){
        Client client = clientService.findClient(clientId);

        List<ProductDTO> products = productService.getProducts(client);

        return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
    }
*/
@ApiOperation(value= "Add new Product in a Client Wishlist", response = Wishlist.class)

    @GetMapping("/{clientId}/{name}")
    public ResponseEntity<List<ProductDTO>> getProductByName(@PathVariable("clientId") Integer clientId, @PathVariable("name") String name){
        Client client = clientService.findClient(clientId);

        List<ProductDTO> products = productService.getProductByName(client, name);

        return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
    }


    @PostMapping("/{clientId}/{productId}")
    public ResponseEntity<ApiResponse> addProduct(@PathVariable("clientId") Integer clientId, @PathVariable("productId") Integer productId){
        Client client = clientService.findClient(clientId);
        Product product = productService.findProduct(productId);

        try {
            productService.addProductToWishlist(clientId, productId);
        } catch (MaximumSizeException e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false,
                                                    e.getMessage()), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,
                "Product has been added to Wishlist"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{clientId}/{productId}")
    public ResponseEntity<ApiResponse> deleteWishlist(@PathVariable("clientId") Integer clientId, @PathVariable("productId") Integer productId){
        Client client = clientService.findClient(clientId);
        Product product = productService.findProduct(productId);

        productService.deleteProduct(client, product);

        return new ResponseEntity<ApiResponse>(new ApiResponse(true,
                "Product has been deleted from Wishlist"), HttpStatus.CREATED);
    }

}
