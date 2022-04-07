package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item>{
	
	@Autowired
	protected InventorItemListMyComponentsService listMyComponentsService;
	
	@Autowired
	protected InventorItemListMyToolsService listMyToolsService;
	
	@Autowired
	protected InventorItemShowService showService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list-my-components", "list", this.listMyComponentsService);
		super.addCommand("list-my-tools", "list", this.listMyToolsService);
		super.addCommand("show", this.showService);
	}
	
}
