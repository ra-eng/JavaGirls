package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.common.ApiResponse;
import br.com.magazineluiza.wishlist.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping Mapping("/list")
    public ResponseEntity<List<ProductDTO>> getWishlist(@PathVariable("br.com.magazineluiza.wishlist") {

        List<WishList> body = wishListService.readWishList(user_id);
        List<ProductDTO> products = new ArrayList<>();
        for (Wishlist wishlist : body) {
            products.add(ProductService.getDtoFromProduct(wishlist.getProduct()));
        }
        return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
    }

        @PostMapping ("/add")
        public ResponseEntity<ApiResponse> addProduct (@RequestBody ProductDTO productDTO){
            WishlistService.addProduct(productDTO);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);


        }
    }