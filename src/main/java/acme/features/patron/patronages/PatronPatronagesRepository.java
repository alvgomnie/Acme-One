package acme.features.patron.patronages;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.entities.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;
import acme.roles.Patron;

@Repository
public interface PatronPatronagesRepository extends AbstractRepository{

	@Query("SELECT p FROM Patronage p WHERE p.patron.id = :id")
	Collection<Patronage> findPatronagesByPatronID(int id);
	
	@Query("SELECT p FROM Patronage p WHERE p.id = :id")
	Patronage findPatronageID(int id);
	
	@Query("SELECT pr FROM PatronageReport pr WHERE pr.patronage.id = :id")
	Collection<PatronageReport> findPatronagesReportsByPatronageId(int id);
	
	@Query("SELECT p FROM Patron p WHERE p.id = :id")
	Patron findPatronById(int id);
	
	@Query("SELECT i FROM Inventor i")
	List<Inventor> findAllInventors();
	
	@Query("SELECT i FROM Inventor i WHERE i.userAccount.username = :username")
	Inventor findInventorByUsername(String username);
}
