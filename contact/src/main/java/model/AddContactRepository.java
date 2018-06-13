package model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface  AddContactRepository extends CrudRepository<AddContact, Long> {
	
	List<AddContact> findByNom(String nom);	
	Optional<AddContact> findById(long id);

}
