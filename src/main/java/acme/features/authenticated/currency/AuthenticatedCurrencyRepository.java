package acme.features.authenticated.currency;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Currency;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedCurrencyRepository extends AbstractRepository {

	@Query("SELECT c FROM Currency c WHERE c.isAccepted = 1")
	Collection<Currency> findCurrencies();
	
	@Query("SELECT c FROM Currency c WHERE c.id=:id")
	Currency findCurrencyById(int id); 

}