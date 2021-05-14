package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.product.ProductDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void createWishlist(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }

    public List<Wishlist>  readWishlist(Integer clientId) {
        return wishlistRepository.findAllByUserIdOrderByCreatedDateDesc(clientId);
    }





}
