package acme.features.patron.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Patron;

@Service
public class PatronChimpumDeleteService implements AbstractDeleteService<Patron, Chimpum>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronChimpumRepository repository;

	// AbstractDeleteService<Patron, Chimpum> interface ---------------
	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		
		assert request != null;
		
		boolean result;
		int chimpumId;
		Chimpum chimpum;
		Patron patron;
		
		chimpumId = request.getModel().getInteger("id");
		chimpum = this.repository.findChimpumById(chimpumId);
		patron = chimpum.getPatron();
		result = request.isPrincipal(patron);
		
		return result;
		
	}
	
	@Override
	public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title", "code", "description", "budget", "creationMoment", "finishingDate",  
			"link", "item.type");		
		
	}
	
	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "code", "description", "budget", "creationMoment", "finishingDate",  
			"link", "item.type");	}
	
	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		 
		assert request != null;
		
		Chimpum result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findChimpumById(id);
		
		return result;
		
	}
	
	@Override
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}
	
	@Override
	public void delete(final Request<Chimpum> request, final Chimpum entity) {
		
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
		
	}
	
}
