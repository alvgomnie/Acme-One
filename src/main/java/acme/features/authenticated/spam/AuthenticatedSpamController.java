package acme.features.authenticated.spam;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Spam;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

@Controller
public class AuthenticatedSpamController extends AbstractController<Authenticated, Spam> {

	@Autowired
	protected AuthenticatedSpamListService	listService;

	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
	}

}