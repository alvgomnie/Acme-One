package acme.features.any.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyItemRepository extends AbstractRepository{

	@Query("select i from Item i where i.type = 1")
	Collection<Item> findAllComponents();
	
	@Query("select i from Item i where i.id=:id")
	Item findItemById(int id);
	
	@Query("select i from Item i where i.type = 0")
	Collection<Item> findAllTools();
	
}
