package acme.features.patron.patronages;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronagesRepository extends AbstractRepository{

	@Query("SELECT p FROM Patronage p WHERE p.patron.id = :id")
	Collection<Patronage> findPatronagesByPatronID(int id);
	
	@Query("SELECT p FROM Patronage p WHERE p.id = :id")
	Patronage findPatronageID(int id);
}
