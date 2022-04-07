package acme.features.patron.patronages;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class PatronPatronagesListService implements AbstractListService<Patron, Patronage>{

	@Autowired
	protected PatronPatronagesRepository patronPatronagesRepository;
	
	@Override
	public boolean authorise(final Request<Patronage> request){
	assert request != null;
	return true;
	}
	
	@Override
	public Collection<Patronage> findMany(final Request<Patronage> request){
		assert request !=null;
		
		Collection<Patronage> patronages;
		Principal principal;
		int patronID;
		
		principal = request.getPrincipal();
		patronID = principal.getActiveRoleId();
		patronages = this.patronPatronagesRepository.findPatronagesByPatronID(patronID);
		
		return patronages;
	}
	
	@Override
	public void unbind(final Request<Patronage> request, final Patronage patronage, final Model model) {
		assert request != null;
		assert patronage != null;
		assert model != null;
		
		request.unbind(patronage, model, "status", "code");
	}
}
