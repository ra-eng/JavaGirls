package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.Client;
import br.com.magazineluiza.wishlist.common.ApiResponse;
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
    private WishlistService wishlistService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

/*
    @GetMapping("/{clientId}")
    public ResponseEntity<List<ProductDTO>> getWishlist(@PathVariable("clientId") Integer clientId){
        Client client = clientService.findClient(clientId);
        List<Wishlist> body = wishlistService.readWishList(client);
        List<ProductDTO> products = new ArrayList<>();
        for (Wishlist wishlist : body) {
            products.add(ProductService.getDtoFromProduct(wishlist.getProduct()));
        }
        return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
    }
*/
@ApiOperation(value= "Add new Product in a Client Wishlist", response = Wishlist.class)
    @PostMapping("/{clientId}/{productId}")
    public ResponseEntity<ApiResponse> addProduct(@PathVariable("clientId") Integer clientId, @PathVariable("productId") Integer productId){
        Client client = clientService.findClient(clientId);
        Product product = productService.findProduct(productId);

        productService.addProductToWishlist(product, client);


        return new ResponseEntity<ApiResponse>(new ApiResponse(true,
                "Product has been added to Wishlist"), HttpStatus.CREATED);
    }
}
