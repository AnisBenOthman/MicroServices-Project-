package tn.esprit.spring.firstms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BasedRepository<T,ID> extends JpaRepository<T,ID> {

}
