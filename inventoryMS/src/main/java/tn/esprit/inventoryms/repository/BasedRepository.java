package tn.esprit.inventoryms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.yaml.snakeyaml.events.Event;
@NoRepositoryBean
public interface BasedRepository<T, ID> extends MongoRepository<T, ID> {
}
