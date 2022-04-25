package acme.features.authenticated.spam;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Spam;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedSpamRepository extends AbstractRepository {

	@Query("select s from Spam s")
	Collection<Spam> findSpams();

}