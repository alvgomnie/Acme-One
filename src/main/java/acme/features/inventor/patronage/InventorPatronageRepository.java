package acme.features.inventor.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.Patronage;
import acme.framework.repositories.AbstractRepository;

public interface InventorPatronageRepository extends AbstractRepository{
	
	@Query("SELECT p FROM Patronage p WHERE p.inventor.id = :inventorId")
	Collection<Patronage> findPatronagesByInventorId(int inventorId);
	
	@Query("SELECT p FROM Patronage p WHERE p.id = :id")
	Patronage findPatronageById(int id);

}
