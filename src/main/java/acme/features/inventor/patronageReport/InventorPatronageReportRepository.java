package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {

	@Query("SELECT p FROM PatronageReport p WHERE p.inventor.id = :inventorId")
	Collection<PatronageReport> findPatronagesReportByInventorId(int inventorId);

	@Query("SELECT p FROM PatronageReport p WHERE p.id = id")
	PatronageReport findPatronageReportById(int id);

}
