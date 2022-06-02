package acme.features.inventor.chimpum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.features.inventor.item.InventorItemRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorChimpumUpdateService implements AbstractUpdateService<Inventor, Chimpum> {
	
	@Autowired
	protected InventorChimpumRepository repository;
	
	@Autowired
	protected InventorItemRepository itemRepository;

	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
		boolean result;
		int id;
		Chimpum chimpum;
//		Inventor inventor;

		id = request.getModel().getInteger("id");
		chimpum = this.repository.findChimpumById(id);
//		inventor = chimpum.getInventor();
//		result = !chimpum.getItem().getPublished() && request.isPrincipal(inventor);

		
		result = !chimpum.getItem().getPublished();
			
		return result;
	}

	@Override
	public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		entity.setItem(this.itemRepository.findItemById(Integer.valueOf(request.getModel().getAttribute("itemId").toString())));
		request.bind(entity, errors,  "title", "code", "description", "budget", "creationMoment", "finishingDate", "link");
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model!=null;
		
		Principal principal;

		principal = request.getPrincipal();
		
		//si es tool
		final Collection<Item> li = this.itemRepository.findToolsByInventorId(principal.getActiveRoleId());
		model.setAttribute("items", li);
		
//		//si es component
//		final Collection<Item> li = this.itemRepository.findComponentsByInventorId(principal.getActiveRoleId());
//		model.setAttribute("allItems", li);
		
		
		request.unbind(entity, model,  "title", "code", "description", "budget", "creationMoment", "finishingDate", "link");
	}

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
	public void update(final Request<Chimpum> request, final Chimpum entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}
	
}
