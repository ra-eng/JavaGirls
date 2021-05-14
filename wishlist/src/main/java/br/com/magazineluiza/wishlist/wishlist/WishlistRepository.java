package br.com.magazineluiza.wishlist.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findAllByUserIdOrderByCreatedDateDesc(Integer clientId );



}
