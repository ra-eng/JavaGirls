package br.com.magazineluiza.wishlist.wishlist;



import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WishlistMapper {
    Wishlist toWishlist(WishlistDTO wishlistTDO);
}



