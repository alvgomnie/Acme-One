package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit>{

	@Autowired
	protected InventorToolkitRepository repository;

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request !=null;
		return true;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request !=null;
		
		Toolkit result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findToolkitById(id);
		
		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Collection<Item> items;
		int id;
		
		id = request.getModel().getInteger("id");
		items = this.repository.findItemsByToolkitId(id);
	
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "publish", "link");
		
	}

}
