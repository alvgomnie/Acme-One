package patron.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class PatronChimpumDeleteTest extends TestHarness{
	
	@Test
	@Order(10)
	public void positiveDeleteItem() {
	
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "Chimpum");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		
		super.signOut();
				
	}


}
