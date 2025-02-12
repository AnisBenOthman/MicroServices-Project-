package tn.esprit.spring.firstms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.firstms.Entities.Product;
import tn.esprit.spring.firstms.Entities.Status;

import java.util.Optional;

public interface ProductRepository extends BasedRepository<Product,Integer>{

    Optional<Product> findByCodeAndStatus(String code, Status status);

}
