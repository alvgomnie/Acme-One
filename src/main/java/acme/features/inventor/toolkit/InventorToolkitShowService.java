package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Toolkit;
import acme.features.inventor.item.InventorItemRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit>{

	@Autowired
	protected InventorToolkitRepository repository;
	

	@Autowired
	protected InventorItemRepository itemRepository;

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
		model.setAttribute("toolkitId", entity.getId());
		model.setAttribute("items", this.itemRepository.findAllItem());
		//model.setAttribute("itemId", entity.getItem().getId());
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "publish", "link");
		
	}

}
