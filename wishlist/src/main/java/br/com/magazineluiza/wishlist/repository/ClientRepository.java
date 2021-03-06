package br.com.magazineluiza.wishlist.repository;

import br.com.magazineluiza.wishlist.entity.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Integer> {

  Optional<Client> findById(Integer id);

  Client findByCpf(String cpf);

  Client findByEmail(String email);

  @Modifying
  @Query(value = "delete from wishlist w where w.id_product = :productId", nativeQuery = true)
  void removeProduct(@Param("productId") Integer productId);

}
