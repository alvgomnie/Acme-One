package acme.features.inventor.chimpum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.features.inventor.item.InventorItemRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorChimpumShowService implements AbstractShowService<Inventor, Chimpum>{

	@Autowired
	protected InventorChimpumRepository repository;
	
	@Autowired
	protected InventorItemRepository itemRepository;
	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		
		assert request != null;
		
		return true;
		
	}
	
	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		assert request != null;
	
		Integer id;
		Chimpum item;
		id = request.getModel().getInteger("id");
		item = this.repository.findChimpumById(id);
		
		return item;
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
//		List<Item> items;
//		items = this.repository.findAllItems();
		
		Principal principal;

		principal = request.getPrincipal();
		
		//si es tool
		final Collection<Item> li = this.itemRepository.findToolsByInventorId(principal.getActiveRoleId());
		model.setAttribute("items", li);
				
//		//si es component
//		final Collection<Item> li = this.itemRepository.findComponentsByInventorId(principal.getActiveRoleId());
//		model.setAttribute("allItems", li);
		
		request.unbind(entity, model, "title", "code", "description", "budget", "creationMoment", "finishingDate",  
			"link"//, "item.type"
			);	
		
//		model.setAttribute("items", items);
		//model.setAttribute("itemType", entity.getItem().getType());
		model.setAttribute("itemName", entity.getItem().getName());
	}

	
}
