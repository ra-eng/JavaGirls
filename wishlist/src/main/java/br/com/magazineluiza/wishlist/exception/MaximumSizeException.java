package br.com.magazineluiza.wishlist.exception;

public class MaximumSizeException extends Throwable {
    public MaximumSizeException() {
        super("Wishlist has reached maximum value of 20 products");
    }
}
