package br.com.magazineluiza.wishlist.exception;

public class IdAlreadyAddedException extends RuntimeException {

  public IdAlreadyAddedException(Integer productId) {
    super(String.format("Id %d already added to the Wishlist.", productId));
  }
}
