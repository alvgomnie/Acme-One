package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolkitRepository extends AbstractRepository{
	
	@Query("SELECT t FROM Toolkit t WHERE t.id =:id")
	Toolkit findToolkitById(int id);
	
	@Query("SELECT t FROM Toolkit t WHERE t.inventor.userAccount.id = :inventorId")
	Collection<Toolkit> findToolkitsByInventorId (int inventorId);
	
	@Query("SELECT q.item FROM Quantity q WHERE q.toolkit.id= :id")
	Collection<Item> findItemsByToolkitId(int id);

}
