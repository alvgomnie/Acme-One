package inventor.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorChimpumDeleteTest extends TestHarness{
	
	@Test
	@Order(10)
	public void positiveDeleteItem() {
	
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "Chimpum");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		
		super.signOut();
				
	}

}
