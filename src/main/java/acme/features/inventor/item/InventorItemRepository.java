package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository{

	@Query("SELECT a FROM Item a WHERE a.inventor.id = :id AND a.type = 0")
	Collection<Item> findToolsByInventorId(int id);
	
	@Query("SELECT a FROM Item a WHERE a.inventor.id = :id AND a.type = 1")
	Collection<Item> findComponentsByInventorId(int id);
	
	@Query("SELECT a FROM Item a WHERE a.inventor.id = :id")
	Collection<Item> findItemsByInventorId(int id);
	
	@Query("SELECT a FROM Item a WHERE a.id = :id")
	Item findItemById(int id);
	
	@Query("SELECT i FROM Inventor i WHERE i.id=:id")
	Inventor findInventorById(int id);

}
