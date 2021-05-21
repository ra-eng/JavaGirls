package br.com.magazineluiza.wishlist.repository;

import br.com.magazineluiza.wishlist.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

  @Modifying
  @Query(value = "delete from product_wishlist pw where pw.product_id = :productId", nativeQuery = true)
  void deleteProductById(@Param("productId") Integer productId);

}
