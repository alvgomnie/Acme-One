package acme.features.patron.chimpum;

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
public interface PatronChimpumRepository extends AbstractRepository{
	
	@Query("SELECT c FROM Chimpum c WHERE c.id = :id")
	Chimpum findChimpumById(int id);
	
	@Query("SELECT c FROM Chimpum c WHERE c.patron.id = :id")
	Collection<Chimpum> findChimpumsByPatronId(int id);
	
	@Query("SELECT i FROM Patron i WHERE i.id=:id")
	Inventor findPatronById(int id);
	
	@Query("SELECT c FROM Chimpum c")
	List<Chimpum> findAllChimpums();
	
	@Query("SELECT i FROM Patron i")
	List<Inventor> findAllPatrons();
	
	@Query("SELECT i FROM Item i")
	List<Item> findAllItems();
	
	@Query("SELECT c FROM Chimpum c WHERE c.creationMoment > :deadline AND c.item is not null AND c.patron.id = :id")
	Collection<Chimpum> findRecentChimpum(Date deadline, int id);
	
	@Query("SELECT c.item FROM Chimpum c WHERE c.item is not null AND c.item.type = 0")
	List<Item> findToolWithChimpum();
	
	@Query("SELECT c.item FROM Chimpum c WHERE c.item is not null AND c.item.type = 1")
	List<Item> findComponentWithChimpum();

}
