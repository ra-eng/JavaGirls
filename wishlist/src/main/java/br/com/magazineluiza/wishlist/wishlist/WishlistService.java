package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public void addProductTo(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }

    public void createWishlist(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }

    public List<Wishlist> readWishList(Client client) {
        return wishlistRepository.findAllByClientOrderByCreatedDateDesc(client);
    }
}
