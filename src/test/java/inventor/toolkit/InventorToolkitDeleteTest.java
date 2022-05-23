package inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorToolkitDeleteTest extends TestHarness{
	
	@Test
	@Order(10)
	public void positiveDeleteToolkit() {
	
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		
		super.signOut();
				
	}
	
//	@Test
//	@Order(20)
//	public void negativeDeleteToolkit() {
//	
//		super.signIn("inventor1", "inventor1");
//		
//		super.clickOnMenu("Inventor", "Toolkits");
//		super.checkListingExists();
//		super.sortListing(0, "asc");
//		super.clickOnListingRecord(0);
//		
//		super.checkFormExists();
//		super.checkNotSubmitExists("Delete");
//		
//		super.signOut();
//				
//	}
	
}
