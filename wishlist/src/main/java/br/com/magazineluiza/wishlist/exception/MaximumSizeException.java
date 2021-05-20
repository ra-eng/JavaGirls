package br.com.magazineluiza.wishlist.exception;

public class MaximumSizeException extends RuntimeException {
    public MaximumSizeException(Integer maximumLimit) {
        super(String.format("Wishlist has reached maximum value of %d products", maximumLimit));
    }
}
