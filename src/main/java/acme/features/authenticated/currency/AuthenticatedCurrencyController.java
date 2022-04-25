package acme.features.authenticated.currency;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Currency;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedCurrencyController extends AbstractController<Authenticated, Currency> {

	@Autowired
	protected AuthenticatedCurrencyListService listService;
	
	@Autowired
	protected AuthenticatedCurrencyShowService showService;

	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}

}
