package br.com.magazineluiza.wishlist.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findById(Integer id);

}
