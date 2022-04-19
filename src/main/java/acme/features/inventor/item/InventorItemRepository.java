package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemRepository extends AbstractRepository{

	@Query("SELECT i FROM Item i WHERE i.id =:id")
	Item findItemById(int id);
	
	@Query("SELECT i FROM Item i WHERE i.inventor.userAccount.id = :inventorId")
	Collection<Item> findItemsByInventorId (int inventorId);
	
	@Query("SELECT t FROM Toolkit t WHERE t.id = :toolkitId")
	Toolkit findToolkitById(int toolkitId);
	
	@Query("SELECT q.item FROM Quantity q WHERE q.toolkit.id = toolkitId")
	Collection<Item> findItemsByToolkitId(int toolkitId);
	
}