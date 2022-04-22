package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {

	@Query("SELECT p FROM PatronageReport p WHERE p.inventor.id = :inventorId")
	Collection<PatronageReport> findPatronagesReportByInventorId(int inventorId);

	@Query("SELECT p FROM PatronageReport p WHERE p.id = id")
	PatronageReport findPatronageReportById(int id);
	
	@Query("SELECT i FROM Inventor i WHERE i.userAccount.id = :id")
	Inventor findInventorByUserAccountId(int id);

}
