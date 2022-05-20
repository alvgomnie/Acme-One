package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorToolkitRepository extends AbstractRepository{
	
	@Query("SELECT t FROM Toolkit t WHERE t.id =:id")
	Toolkit findToolkitById(int id);
	
	@Query("SELECT t FROM Toolkit t WHERE t.inventor.id=:inventorId")
	Collection<Toolkit> findToolkitsByInventorId (int inventorId);
	
	@Query("SELECT i FROM Inventor i WHERE i.id =:id ")
	Inventor findInventorById(int id);
	
	@Query("SELECT t FROM Toolkit t WHERE t.code = ?1")
	Toolkit findToolkitByCode(String code);
	


}
