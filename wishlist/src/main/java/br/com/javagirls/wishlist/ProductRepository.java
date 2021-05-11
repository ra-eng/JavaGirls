package br.com.javagirls.wishlist;

import br.com.javagirls.wishlist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
