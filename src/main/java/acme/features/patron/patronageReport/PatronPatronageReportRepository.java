package acme.features.patron.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface PatronPatronageReportRepository extends AbstractRepository {

	@Query("SELECT p FROM PatronageReport p WHERE p.patronage.patron.id = :id")
	Collection<PatronageReport> findPatronageReportsByPatronId(int id);
	
	@Query("SELECT p FROM PatronageReport p WHERE p.id = :id")
	PatronageReport findPatronageReportById(int id);
	
	@Query("SELECT p FROM Patron p WHERE p.userAccount.id = :id")
	Patron findPatronByUserAccountId(int id);
}
