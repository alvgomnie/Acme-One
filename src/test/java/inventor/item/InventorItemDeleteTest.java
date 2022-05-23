package inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorItemDeleteTest extends TestHarness{

	@Test
	@Order(10)
	public void positiveDeleteItem() {
	
		super.signIn("inventor2", "inventor2");
		
		super.clickOnMenu("Inventor", "My tools");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
				
	}
	
	@Test
	@Order(20)
	public void negativeDeleteItem() {
	
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My components");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.checkNotSubmitExists("Delete");
		
		super.signOut();
				
	}
		
}