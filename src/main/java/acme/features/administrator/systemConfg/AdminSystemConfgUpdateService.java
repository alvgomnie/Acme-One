package acme.features.administrator.systemConfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.SystemConfiguration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdminSystemConfgUpdateService implements AbstractUpdateService<Administrator, SystemConfiguration> {

	@Autowired
	protected AdminSystemConfgRepository repository;

	@Override
	public boolean authorise(final Request<SystemConfiguration> request) {
		assert request != null;
			
		return true;
	}

	@Override
	public SystemConfiguration findOne(final Request<SystemConfiguration> request) {
		assert request != null;

		SystemConfiguration result;
		result = this.repository.findSystemConfiguration();

		return result;
	}

	@Override
	public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "systemCurrency", "acceptedCurrencies", "strongSpamTerms",
										"weakSpamTerms", "strongSpamTreshold", "weakSpamTreshold");
	}

	@Override
	public void bind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "systemCurrency", "acceptedCurrencies", "strongSpamTerms",
			"weakSpamTerms", "strongSpamTreshold", "weakSpamTreshold");
		
	}

	@Override
	public void validate(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if(!errors.hasErrors("strongSpamTreshold")) {
			errors.state(request, entity.getStrongSpamTreshold()>0 && entity.getStrongSpamTreshold()<=100, "strongSpamTreshold", "administrator.configData.form.error.strongSpamTreshold");
		}

		if(!errors.hasErrors("weakSpamTreshold")) {
			errors.state(request, entity.getWeakSpamTreshold()>0 && entity.getWeakSpamTreshold()<=100, "weakSpamTreshold", "administrator.configData.form.error.weakSpamTreshold");
		}
	}

	@Override
	public void update(final Request<SystemConfiguration> request, final SystemConfiguration entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}