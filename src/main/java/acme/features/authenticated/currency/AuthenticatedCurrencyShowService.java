package acme.features.authenticated.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Currency;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedCurrencyShowService implements AbstractShowService<Authenticated, Currency>{

	@Autowired
	protected AuthenticatedCurrencyRepository repository;
	
	@Override
	public boolean authorise(final Request<Currency> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public Currency findOne(final Request<Currency> request) {
		assert request != null;
		
		Currency result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findCurrencyById(id);
	
		return result;
	}
	
	@Override
	public void unbind(final Request<Currency> request, final Currency entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "isDefault", "isAccepted");

	}
	
}
