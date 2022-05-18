package inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorToolkitPublishTest extends TestHarness{
	
	@Test
	@Order(10)
	public void positivePublishToolkit() {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();
		
		super.clickOnMenu("Inventor", "Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkInputBoxHasValue("publish", "true");
		
		super.signOut();
		
	}
	
	@Test
	@Order(20)
	public void positivePublishNegativeToolkit() {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "Toolkits");
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


