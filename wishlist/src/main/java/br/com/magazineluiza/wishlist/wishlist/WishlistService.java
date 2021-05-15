package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public void addProductTo(Wishlist wishlist) {
        wishlistRepository.save(wishlist);
    }

    public Integer createWishlist(Wishlist wishlist) {
        Wishlist wishlistCreated = wishlistRepository.save(wishlist);
        return wishlistCreated.getId();

    }

    public List<Wishlist> readWishList(Client client) {
        return wishlistRepository.findAllByClientOrderByCreatedDateDesc(client);
    }
}
