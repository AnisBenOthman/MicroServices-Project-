package tn.esprit.spring.firstms.Services;

import tn.esprit.spring.firstms.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface IBasedService<T,ID> {
	Optional<T> retrieveById(ID id);
	List<T> retrieveAll();
	T add(T object);
	T update(T object, ID id);
	void delete(ID id);


}
