package acme.features.authenticated.currency;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Currency;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedCurrencyListService implements AbstractListService<Authenticated, Currency> {

	@Autowired
	protected AuthenticatedCurrencyRepository repository;

	@Override
	public boolean authorise(final Request<Currency> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Currency> findMany(final Request<Currency> request) {
		assert request != null;

		Collection<Currency> result;

		result = this.repository.findCurrencies();

		return result;
	}

	@Override
	public void unbind(final Request<Currency> request, final Currency entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "onDefault");
	}

}
