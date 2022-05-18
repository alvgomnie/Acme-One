package inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorItemPublishTest extends TestHarness{

	@Test
	@Order(10)
	public void positivePublishItem() {
		
		super.signIn("inventor2", "inventor2");
		
		super.clickOnMenu("Inventor", "My tools");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();
		
		super.clickOnMenu("Inventor", "My tools");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkInputBoxHasValue("published", "true");
		
		super.signOut();
		
	}
	
	@Test
	@Order(20)
	public void positivePublishNegativeItem() {
		
		super.signIn("inventor2", "inventor2");
		
		super.clickOnMenu("Inventor", "My tools");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.checkNotSubmitExists("Publish");
		
		super.signOut();
		
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		//El framework no permite actualmente realizar un hackingTest. Manualmente sería:
		//Iniciar sesión con otro inventor (4 por ejemplo)
		//Acceder a la url del item con su id
	}
	
}
