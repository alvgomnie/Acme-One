package acme.features.inventor.chimpum;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorChimpumRepository extends AbstractRepository{
	
	@Query("SELECT c FROM Chimpum c WHERE c.id = :id")
	Chimpum findChimpumById(int id);
	
	@Query("SELECT c FROM Chimpum c WHERE c.inventor.id = :id")
	Collection<Chimpum> findChimpumsByInventorId(int id);
	
	@Query("SELECT i FROM Inventor i WHERE i.id=:id")
	Inventor findInventorById(int id);
	
	@Query("SELECT c FROM Chimpum c")
	List<Chimpum> findAllChimpums();
	
	@Query("SELECT i FROM Inventor i")
	List<Inventor> findAllInventors();
	
	@Query("SELECT i FROM Item i")
	List<Item> findAllItems();
	
	@Query("SELECT c FROM Chimpum c where c.creationMoment > :deadline")
	Collection<Chimpum> findRecentChimpum(Date deadline);
	
	@Query("SELECT c.item FROM Chimpum c WHERE c.item is not null AND c.item.type = 0")
	List<Item> findToolWithChimpum();
	
	@Query("SELECT c.item FROM Chimpum c WHERE c.item is not null AND c.item.type = 1")
	List<Item> findComponentWithChimpum();


}
